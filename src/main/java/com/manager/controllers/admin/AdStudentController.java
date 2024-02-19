package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AdStudentController {
	// getList
	@RequestMapping(value = { "student" }, method = RequestMethod.GET)
	public String TableStudent() {
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
