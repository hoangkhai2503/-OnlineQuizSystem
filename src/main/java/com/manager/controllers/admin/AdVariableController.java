package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.Teacher;
import com.manager.entities.Variable;
import com.manager.service.EnumListService;
import com.manager.service.VariableService;

@Controller
@RequestMapping({ "admin" })
public class AdVariableController {
	@Autowired
	private EnumListService enumlistService;

	@Autowired
	private VariableService variableService;

	// getList
	@RequestMapping(value = { "variable" }, method = RequestMethod.GET)
	public String TableVariable(ModelMap modelMap) {
		modelMap.put("variables", variableService.findAll());
		return "admin/table/variable";
	}

	// Add
	@RequestMapping(value = { "addVariable" }, method = RequestMethod.GET)
	public String AddVariable(ModelMap modelMap) {
		Variable variable = new Variable();
		modelMap.put("variable", variable);
		return "admin/addForm/variable";
	}

	@RequestMapping(value = { "addVariable" }, method = RequestMethod.POST)
	public String addVariable(ModelMap modelMap, @ModelAttribute("variable") Variable variable) {
		if (variable.getImage_variable().isEmpty()) {
			variable.setImage_variable("");
		} else if (variable.getCode_variable().isEmpty()) {
			variable.setCode_variable("");
		}
		variableService.save(variable);
		return "redirect:variable";
	}

	// Edit
	@RequestMapping(value = { "editVariable/{id}" }, method = RequestMethod.GET)
	public String EditVariable(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("variable", variableService.findById(id));
		return "admin/editForm/variable";
	}

	@RequestMapping(value = { "editVariable" }, method = RequestMethod.POST)
	public String EditContact(ModelMap modelMap, @ModelAttribute("variable") Variable variable) {
		Variable currentTeacher = variableService.findById(variable.getId_variable());
		if (variable.getImage_variable().isEmpty()) {
			variable.setImage_variable("");
		} else if (variable.getCode_variable().isEmpty()) {
			variable.setCode_variable("");
		}
		variableService.save(variable);
		return "redirect:variable";
	}

	// Edit
	@RequestMapping(value = { "deleteVariable/{id}" }, method = RequestMethod.GET)
	public String deleteVariable(@PathVariable("id") int id, ModelMap modelMap) {
		variableService.delete(id);
		return "redirect:/admin/variable";
	}

	// EnumList --> là các biến status
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
