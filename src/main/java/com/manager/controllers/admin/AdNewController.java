package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AdNewController {
	// getList
	@RequestMapping(value = { "new" }, method = RequestMethod.GET)
	public String TableNew() {
		return "admin/table/new";
	}

	// Add
	@RequestMapping(value = { "addNew" }, method = RequestMethod.GET)
	public String AddNew() {
		return "admin/addForm/new";
	}

	// Edit
	@RequestMapping(value = { "editNew" }, method = RequestMethod.GET)
	public String EditNew() {
		return "admin/editForm/new";
	}
}
