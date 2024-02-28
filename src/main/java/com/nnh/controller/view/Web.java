package com.nnh.controller.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nnh.dal.reposiroty.CityRepository;
import com.nnh.dal.service.IBookingService;
import com.nnh.dal.service.ICityService;
import com.nnh.dal.service.ICommentService;
import com.nnh.dal.service.IDepartmentService;
import com.nnh.dal.service.IUserService;
import com.nnh.model.convert.UserConvert;
import com.nnh.model.dto.BookingDTO;
import com.nnh.model.dto.CommentDTO;
import com.nnh.model.dto.DepartmentDTO;
import com.nnh.model.dto.UserDTO;
import com.nnh.model.entity.CityEntity;
import com.nnh.model.entity.UserEntity;
import java.util.Map;

import javax.servlet.http.HttpSession;

@Controller
public class Web {
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private ICityService cityService;
	
	@Autowired
	private CityRepository cityRep;
	
	@Autowired
	private IBookingService bookingService;
	
	@Autowired
	private ICommentService commentService;
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("/trang-chu")
	public String getView(Model model) {
		model.addAttribute("department", new DepartmentDTO());
		model.addAttribute("departmentsVietnam", departmentService.findAllInVietNam());
		model.addAttribute("departmentsForeign", departmentService.findAllInForeign());
		return "web/home";
	}
	
	@PostMapping("/tim-kiem")
	public String getSearch(Model model, @ModelAttribute("department") DepartmentDTO departmentDTO) {
		model.addAttribute("booking", new BookingDTO());
		List<DepartmentDTO> departments = departmentService.findAllByCityName(departmentDTO.getCityName());
		model.addAttribute("departments", departments);
		
		return "web/searchPage";
	}
	
	@GetMapping("/can-ho")
	public String getRoomPage(Model model, @Param("id") Long id) {
		model.addAttribute("booking", new BookingDTO());
		model.addAttribute("comment", new CommentDTO());
		model.addAttribute("comments", commentService.findAllByDepartment(id));
		model.addAttribute("commentCount", commentService.findAllByDepartment(id).size());
		DepartmentDTO departmentDTO = departmentService.findOneById(id);
		CityEntity cities = cityRep.findOneByName(departmentDTO.getCityName());
		model.addAttribute("department", departmentDTO);
		model.addAttribute("country", cityService.findCountryByCity(cities));
		model.addAttribute("categoriesCount", departmentService.getUniqueCategories());
		return "web/roomPage";
	}
	
	@PostMapping("/booking")
	private String createBooking(@ModelAttribute("booking") BookingDTO bookingDTO,	HttpSession session, @Param("id") Long id) {
		bookingDTO.setUser((UserEntity) session.getAttribute("USERMODEL"));
		bookingDTO.setDepartmentId(id);
		if(bookingDTO.getUser() == null) {
			return "redirect:/login";
		}else {
			bookingService.save(bookingDTO);
			return "redirect:/trang-chu";
		}
	}
	
	@PostMapping("/comment")
	private String createComment(@ModelAttribute("comment") CommentDTO commentDTO, HttpSession session, @Param("id") Long id) {
		if(session.getAttribute("USERMODEL") != null) {
			commentDTO.setUsername(((UserEntity) session.getAttribute("USERMODEL")).getUsername());
			commentDTO.setDepartmentId(id);
			commentService.save(commentDTO);
			return "redirect:/can-ho?id=" + id;
		}else {
			return "redirect:/login";
		}
	}
	
	@GetMapping("/deleteComment")
	private String deleteComment(@Param("commentId") Long commentId, @Param("id") Long id) {
		commentService.delete(commentId);
		return "redirect:/can-ho?id=" + id;
	}

	
	@GetMapping("/user")
	public String getUserPage(HttpSession session, Model model) {
		UserDTO user = UserConvert.toDto((UserEntity) session.getAttribute("USERMODEL"));
		model.addAttribute("user", user);
		model.addAttribute("bookings", bookingService.findByUser(userService.findOne(user)));
		
		return "web/userPage";
	}
         @GetMapping("/roomlist")
	public String test(Model model) {	
                List<DepartmentDTO> departments = departmentService.findAllDepartments();
                model.addAttribute("findAllDepartments",departments);
		return "web/roomlist";
	}
}
