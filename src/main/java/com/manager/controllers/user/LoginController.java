package com.manager.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Student;
import com.manager.service.StudentService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"user"})
public class LoginController {
	@Autowired
	private StudentService studentService;
	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login() {
		return "user/home/login";
	}
	
//	@RequestMapping(value = { "login" }, method = RequestMethod.POST)
//	public String Login(@RequestParam("email_student") String email_student,
//			RedirectAttributes redirectAttributes, HttpSession session) {
//		Student student = studentService.loginStudent(email_student);
//		if(student != null) {
//			return "user/index";
//		}else {
//			redirectAttributes.addFlashAttribute("msg", "Login Fail");
//			return "redirect:/user/login";
//		}
//		
//	}
}
