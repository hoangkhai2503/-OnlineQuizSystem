package com.manager.controllers.user;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Student;
import com.manager.entities.Test;
import com.manager.entities.Typetest;
import com.manager.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"user"})
public class LoginController {
	
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(value = { "login", "" }, method = RequestMethod.GET)
	public String login(HttpServletRequest request) {
		return "user/home/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)	
	public String login(
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			RedirectAttributes redirectAttributes,
			ModelMap modelMap,
			HttpServletRequest request) 
	{
		
		Student student = studentService.login(email);
		if(student != null) {
			if(student.getPassword_student() == null) {
				modelMap.put("msgNullPass", "Update Password Before Login");
				request.getSession().setAttribute("studentId", student.getId_student());
				return "redirect:/user/register";
			}else {
				if(student.getPassword_student().equals(password)) {
					System.out.print("Dang nhap thanh cong");
					request.getSession().setAttribute("studentName", student.getFullname_student());
					request.getSession().setAttribute("studentId", student.getId_student());
					modelMap.put("studentName", student.getFullname_student());
					redirectAttributes.addFlashAttribute("msg", "Success");
				}else {
					modelMap.put("msgPass", "Wrong Pass");
					return "user/home/login";
				}
			}
		}else {
			modelMap.put("msgEmail", "Email Not Exist");
			return "user/home/login";
		}
		return "redirect:/user/index";
	}
	@RequestMapping(value = "logout", method = RequestMethod.GET)	
	public String logout(HttpServletRequest request) {
		System.out.print("Co chay");
		HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
		return "redirect:/user/index";
		
	}
	
	
}
