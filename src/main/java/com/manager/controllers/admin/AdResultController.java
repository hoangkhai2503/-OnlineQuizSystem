package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.ResultService;

@Controller
@RequestMapping({ "admin" })
public class AdResultController {
	@Autowired
	private ResultService resultService;
	// getList
	@RequestMapping(value = { "result" }, method = RequestMethod.GET)
	public String TableResult(ModelMap modelMap) {
		modelMap.put("results", resultService.findAll());
		return "admin/table/result";
	}
	// Add
	/*
	 * @RequestMapping(value = { "addStudent" }, method = RequestMethod.GET) public
	 * String AddStudent() { return "admin/addForm/student"; }
	 */

	// Edit
	/*
	 * @RequestMapping(value = { "editStudent" }, method = RequestMethod.GET) public
	 * String EditStudent() { return "admin/editForm/student"; }
	 */
}
