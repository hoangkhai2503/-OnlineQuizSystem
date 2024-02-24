package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.TestService;

@Controller
@RequestMapping({ "admin" })
public class AdTestController {
	@Autowired
	private TestService testService;
	
	// getList
	@RequestMapping(value = { "test" }, method = RequestMethod.GET)
	public String TableTestdetail(ModelMap modelMap) {
		modelMap.put("tests", testService.findAll());
		return "admin/table/test";
	}

	
}
