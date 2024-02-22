package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.SubjectService;

@Controller
@RequestMapping({ "admin" })
public class AdSubjectController {
	@Autowired
	private SubjectService subjectService;
	// getList
	@RequestMapping(value = { "subject" }, method = RequestMethod.GET)
	public String TableSubject(ModelMap modelMap) {
		modelMap.put("subjects", subjectService.findAll());
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
