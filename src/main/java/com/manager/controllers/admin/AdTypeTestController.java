package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.TypetestService;

@Controller
@RequestMapping({ "admin" })
public class AdTypeTestController {
	@Autowired
	private TypetestService typetestService;
	
	// getList
	@RequestMapping(value = { "typetest" }, method = RequestMethod.GET)
	public String TableTypetest(ModelMap modelMap) {
		modelMap.put("typetests", typetestService.findAll());
		return "admin/table/typetest";
	}

	
}
