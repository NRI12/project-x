package com.nnh.controller.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nnh.dal.service.ICityService;
import com.nnh.dal.service.IUserService;
import com.nnh.model.dto.UserDTO;

@Controller
public class Register {
	@Autowired
	private ICityService cityService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/register")
	public String getView(Model model) {
		UserDTO user = new UserDTO();
		model.addAttribute("user", user);
		model.addAttribute("cities", cityService.findAll());
		
		return "web/register";
	}
	
	@PostMapping("/register")
	public String createModel(@ModelAttribute("user") UserDTO userDTO, Model model) {
		userDTO = userService.save(userDTO);
		if(userDTO.getMessage() == "") {
			return "redirect:/login";
		} else {
			UserDTO user = new UserDTO();
			model.addAttribute("user", user);
			model.addAttribute("message", userDTO.getMessage());
			model.addAttribute("cities", cityService.findAll());
			return "web/register";
		}
	}
}
