package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AdTermController {
	// getList
	@RequestMapping(value = { "term" }, method = RequestMethod.GET)
	public String TableTerm() {
		return "admin/table/term";
	}

	// Add
	@RequestMapping(value = { "addTerm" }, method = RequestMethod.GET)
	public String AddTerm() {
		return "admin/addForm/term";
	}

	// Edit
	@RequestMapping(value = { "editTerm" }, method = RequestMethod.GET)
	public String EditTerm() {
		return "admin/editForm/term";
	}
}
