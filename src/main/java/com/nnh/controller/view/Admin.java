package com.nnh.controller.view;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.nnh.dal.service.ICityService;
import com.nnh.dal.service.IDepartmentService;
import com.nnh.model.dto.DepartmentDTO;

@Controller
public class Admin {
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private ICityService cityService;
	
	ResourceBundle rb = ResourceBundle.getBundle("message");
	
	@GetMapping("admin")
	public String getAdminView(Model model) {
		return "admin/home";
	}	
	@GetMapping("admin/list")
	public String getListView(Model model, @ModelAttribute("pageController") DepartmentDTO pageController) {
		DepartmentDTO departmentDTO = new DepartmentDTO();
		departmentDTO.setcPage(pageController.getcPage());
		Pageable pageAble = PageRequest.of(pageController.getcPage() - 1, departmentDTO.getdPage());
		departmentDTO.setModelList(departmentService.findAllToDTO(departmentService.departmentPages(pageAble)));
		departmentDTO.settPage(departmentService.departmentPages(pageAble).getTotalPages());
		model.addAttribute("departmentList", departmentDTO.getModelList());
		model.addAttribute("departmentPage", departmentDTO);
		
		return "admin/list";
	}	
	@GetMapping("admin/edit")
	public String getEditView(Model model, @RequestParam Long id, @RequestParam String message, @RequestParam String alert) {
		model.addAttribute("cities", cityService.findAll());
		model.addAttribute("department", departmentService.findOneById(id));
		if(message != "") {
			model.addAttribute("message", rb.getString(message));
			model.addAttribute("alert", alert);
		}
		
		return "admin/edit";
	}	
	@GetMapping("admin/add")
	public String getEditView(Model model, @RequestParam String message, @RequestParam String alert) {
		model.addAttribute("cities", cityService.findAll());
		DepartmentDTO department = new DepartmentDTO();
		model.addAttribute("department", department);
		if(message != "") {
			model.addAttribute("message", rb.getString(message));
			model.addAttribute("alert", alert);
		}
		return "admin/edit";		
	}
}
