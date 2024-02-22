package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.SuperAdminService;

@Controller
@RequestMapping({ "admin" })
public class AdSuperAdminController {
	@Autowired
	private SuperAdminService superAdminService;
	// getList
	@RequestMapping(value = { "superadmin" }, method = RequestMethod.GET)
	public String TableSuperadmin(ModelMap modelMap) {
		modelMap.put("superadmins", superAdminService.findAll());
		return "admin/table/superadmin";
	}
	// Add
	/*
	 * @RequestMapping(value = { "addTeacher" }, method = RequestMethod.GET) public
	 * String AddTeacher() { return "admin/addForm/teacher"; }
	 */

	// Edit
	/*
	 * @RequestMapping(value = { "editTeacher" }, method = RequestMethod.GET) public
	 * String EditTeacher() { return "admin/editForm/teacher"; }
	 */
}
