package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.TermService;

@Controller
@RequestMapping({ "admin" })
public class AdTermController {
	@Autowired
	private TermService termService;
	// getList
	@RequestMapping(value = { "term" }, method = RequestMethod.GET)
	public String TableTerm(ModelMap modelMap) {
		modelMap.put("terms", termService.findAll());
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
