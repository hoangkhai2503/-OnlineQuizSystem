package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.ResultTestService;

@Controller
@RequestMapping({ "admin" })
public class AdResultTestController {
	@Autowired
	private ResultTestService resultTestService;
	// getList
	@RequestMapping(value = { "resulttest" }, method = RequestMethod.GET)
	public String TableResultTest(ModelMap modelMap) {
		modelMap.put("resulttests", resultTestService.findAll());
		return "admin/table/resulttest";
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
