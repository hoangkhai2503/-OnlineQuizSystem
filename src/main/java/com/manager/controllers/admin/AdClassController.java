package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.ClassService;

@Controller
@RequestMapping({ "admin" })
public class AdClassController {
	@Autowired
	private ClassService classService;
	// getList
	@RequestMapping(value = { "class" }, method = RequestMethod.GET)
	public String TableClass(ModelMap modelMap) {
		modelMap.put("gbclass", classService.findAll());
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
