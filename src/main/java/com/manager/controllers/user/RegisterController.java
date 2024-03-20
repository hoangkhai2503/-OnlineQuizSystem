package com.manager.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.entities.Student;
import com.manager.entities.Test;
import com.manager.service.StudentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping({"user"})
public class RegisterController {
	@Autowired
	private StudentService studentService;
	
	
	@RequestMapping(value = { "register", "" }, method = RequestMethod.GET)
	public String register(HttpServletRequest request, ModelMap modelMap) {
		String value = (String) request.getSession().getAttribute("studentName");
		int idStudent = (int) request.getSession().getAttribute("studentId");
		
		modelMap.put("student", studentService.findId(idStudent));
		modelMap.put("studentName", value);
		return "user/home/register";
	}
	@RequestMapping(value = { "updateProfile" }, method = RequestMethod.POST)
	public String updateProfile(HttpServletRequest request, ModelMap modelMap,
			@ModelAttribute("student") Student student,
			@RequestParam("password") String password,
			@RequestParam("rePassword") String rePassword) {
		
		Student oldStudent = studentService.findId(student.getId_student());
		oldStudent.setAddress_student(student.getAddress_student());
		oldStudent.setFullname_student(student.getFullname_student());
		oldStudent.setEmail_student(student.getEmail_student());
		
		if(!password.equals("")) {
			if(password.equals(rePassword)) {
				oldStudent.setPassword_student(password);
			}
		}
		studentService.save(oldStudent);
		HttpSession session = request.getSession(false);
	        if (session != null) {
	            session.invalidate();
	        }
		
		return "redirect:/user/login";
	}
	
}
