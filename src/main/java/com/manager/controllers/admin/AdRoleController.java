package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.RoleService;

@Controller
@RequestMapping({ "admin" })
public class AdRoleController {
	@Autowired
	private RoleService roleService;
	// getList
	@RequestMapping(value = { "role" }, method = RequestMethod.GET)
	public String TableRole(ModelMap modelMap) {
		modelMap.put("roles", roleService.findAll());
		return "admin/table/role";
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
