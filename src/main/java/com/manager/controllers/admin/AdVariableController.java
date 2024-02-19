package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.EnumListService;

@Controller
@RequestMapping({ "admin" })
public class AdVariableController {
	@Autowired
	private EnumListService enumlistService;
	// getList
	@RequestMapping(value = { "variable" }, method = RequestMethod.GET)
	public String TableVariable() {
		return "admin/table/variable";
	}

	// Add
	@RequestMapping(value = { "addVariable" }, method = RequestMethod.GET)
	public String AddVariable() {
		return "admin/addForm/variable";
	}

	// Edit
	@RequestMapping(value = { "editVariable" }, method = RequestMethod.GET)
	public String EditVariable() {
		return "admin/editForm/variable";
	}

	//EnumList --> là các biến status
	// getList
	@RequestMapping(value = { "enumlist" }, method = RequestMethod.GET)
	public String Tableenumlist(ModelMap modelMap) {
		modelMap.put("enumlist", enumlistService.findAll());
		return "admin/table/enumlist";
	}

	// Add
	@RequestMapping(value = { "addEnumlist" }, method = RequestMethod.GET)
	public String Addenumlist() {
		return "admin/addForm/enumlist";
	}

	// Edit
	@RequestMapping(value = { "editEnumlist" }, method = RequestMethod.GET)
	public String Editenumlist() {
		return "admin/editForm/enumlist";
	}
}
