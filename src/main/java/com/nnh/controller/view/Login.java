package com.nnh.controller.view;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nnh.dal.reposiroty.RoleRepository;
import com.nnh.dal.service.IUserService;
import com.nnh.model.dto.UserDTO;
import com.nnh.model.entity.RoleEntity;
import com.nnh.model.entity.UserEntity;

@Controller
public class Login {
	@Autowired
	private IUserService userService;
	
	@Autowired
	private RoleRepository roleRep;
	
	@GetMapping("/login")
	public String getView(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		
		return "web/login";
	}
	
	@PostMapping("/login")
	public String webLogin(@ModelAttribute("user") UserDTO userDTO, HttpSession session, Model model) {
		UserEntity userEntity = userService.findOne(userDTO);
		if(userEntity != null) {
			RoleEntity roleEntity = roleRep.findById(userEntity.getRoles().get(0).getId()).get();
			session.setAttribute("USERMODEL", userEntity);
			if(roleEntity.getCode().equals("ADMIN")) {
				return "redirect:/admin";
			} else if(roleEntity.getCode().equals("USER")) {
				return "redirect:/trang-chu";
			}
		}
		
		
		return "web/login";
	}
	
	@GetMapping("/logout")
	public String webLogout(HttpSession session) {
		session.removeAttribute("USERMODEL");
		
		return "redirect:/trang-chu";
	}
	
}

