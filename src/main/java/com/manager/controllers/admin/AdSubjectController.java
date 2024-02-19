package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AdSubjectController {
	// getList
	@RequestMapping(value = { "subject" }, method = RequestMethod.GET)
	public String TableSubject() {
		return "admin/table/subject";
	}

	// Add
	@RequestMapping(value = { "addSubject" }, method = RequestMethod.GET)
	public String AddSubject() {
		return "admin/addForm/subject";
	}

	// Edit
	@RequestMapping(value = { "editSubject" }, method = RequestMethod.GET)
	public String EditSubject() {
		return "admin/editForm/subject";
	}
}
