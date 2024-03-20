package com.manager.controllers.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.ClassService;
import com.manager.service.StudentService;
import com.manager.service.SubjectService;
import com.manager.service.TestService;
import com.manager.service.VariableService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"user"})

public class Home1Controller {
	
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index(HttpServletRequest request, ModelMap modelMap) {
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		return "user/home/index";
	}

	@RequestMapping(value = { "profile", "" }, method = RequestMethod.GET)
	public String profile(HttpServletRequest request, ModelMap modelMap) {
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		int id_student = (int) request.getSession().getAttribute("studentId");
		
		modelMap.put("studentEmail", studentService.findId(id_student).getEmail_student());
		modelMap.put("studentAddress", studentService.findId(id_student).getAddress_student());
		modelMap.put("studentPhone", studentService.findId(id_student).getPhone_student());
		modelMap.put("class", studentService.findId(id_student).getGbclass().getName_class());
		modelMap.put("teacher", studentService.findId(id_student).getGbclass().getTeacher().getFullname_teacher());
		return "user/home/profile";
	}
	
}
