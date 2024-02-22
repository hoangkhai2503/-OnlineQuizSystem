package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.StudentService;

@Controller
@RequestMapping({ "admin" })
public class AdStudentController {
	@Autowired
	private StudentService studentService;
	// getList
	@RequestMapping(value = { "student" }, method = RequestMethod.GET)
	public String TableStudent(ModelMap modelMap) {
		modelMap.put("students", studentService.findAll());
		return "admin/table/student";
	}
	// Add
	@RequestMapping(value = { "addStudent" }, method = RequestMethod.GET)
	public String AddStudent() {
		return "admin/addForm/student";
	}

	// Edit
	@RequestMapping(value = { "editStudent" }, method = RequestMethod.GET)
	public String EditStudent() {
		return "admin/editForm/student";
	}
}
