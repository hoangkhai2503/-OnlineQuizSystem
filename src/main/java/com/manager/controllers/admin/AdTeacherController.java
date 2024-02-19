package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AdTeacherController {
	// getList
	@RequestMapping(value = { "teacher" }, method = RequestMethod.GET)
	public String TableTeacher() {
		return "admin/table/teacher";
	}
	// Add
	@RequestMapping(value = { "addTeacher" }, method = RequestMethod.GET)
	public String AddTeacher() {
		return "admin/addForm/teacher";
	}

	// Edit
	@RequestMapping(value = { "editTeacher" }, method = RequestMethod.GET)
	public String EditTeacher() {
		return "admin/editForm/teacher";
	}
}
