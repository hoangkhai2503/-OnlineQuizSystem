package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.NewsService;

@Controller
@RequestMapping({ "admin" })
public class AdNewController {
	@Autowired
	private NewsService newsService;
	// getList
	@RequestMapping(value = { "new" }, method = RequestMethod.GET)
	public String TableNew(ModelMap modelMap) {
		modelMap.put("news", newsService.findAll());
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
