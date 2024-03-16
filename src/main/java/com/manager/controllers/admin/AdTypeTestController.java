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
import com.manager.entities.Typetest;
import com.manager.service.EnumListService;
import com.manager.service.TypetestService;

@Controller
@RequestMapping({ "admin" })
public class AdTypeTestController {
	@Autowired
	private TypetestService typetestService;
	@Autowired
	private EnumListService enumListService;

	// getList
	@RequestMapping(value = { "typetest" }, method = RequestMethod.GET)
	public String TableTypetest(ModelMap modelMap) {
		modelMap.put("typetests", typetestService.findAll());
		return "admin/table/typetest";
	}

	// Add
	@RequestMapping(value = { "addTypeTest" }, method = RequestMethod.GET)
	public String addTypeTest(ModelMap modelMap) {
		Typetest typeTest = new Typetest();
		modelMap.put("typetest", typeTest);
		return "admin/addForm/typetest";
	}

	@RequestMapping(value = { "addTypetest" }, method = RequestMethod.POST)
	public String AddTeacher(ModelMap modelMap, @ModelAttribute("typetest") Typetest typetest) {
		typetest.setEnumList(enumListService.findById(4));
		typetestService.save(typetest);
		return "redirect:typetest";
	}

	// Edit
	@RequestMapping(value = { "editTypetest/{id}" }, method = RequestMethod.GET)
	public String EditTeacher(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("typetest", typetestService.findById(id));
		modelMap.put("enumListes", enumListService.findTypeStatusOfTeacher());
		return "admin/editForm/typetest";
	}

	@RequestMapping(value = { "editTypetest" }, method = RequestMethod.POST)
	public String editTypetest(ModelMap modelMap, @ModelAttribute("typetest") Typetest typetest) {
		typetestService.save(typetest);
		return "redirect:typetest";
	}

}
