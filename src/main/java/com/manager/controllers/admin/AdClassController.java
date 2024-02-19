package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AdClassController {
	// getList
	@RequestMapping(value = { "class" }, method = RequestMethod.GET)
	public String TableClass() {
		return "admin/table/class";
	}

	// Add
	@RequestMapping(value = { "addClass" }, method = RequestMethod.GET)
	public String AddClass() {
		return "admin/addForm/class";
	}

	// Edit
	@RequestMapping(value = { "editClass" }, method = RequestMethod.GET)
	public String EditClass() {
		return "admin/editForm/class";
	}
}
