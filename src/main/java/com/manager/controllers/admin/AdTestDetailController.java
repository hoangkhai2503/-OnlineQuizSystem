package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.TestDetailService;

@Controller
@RequestMapping({ "admin" })
public class AdTestDetailController {
	@Autowired
	private TestDetailService testDetailService;
	
	// getList
	@RequestMapping(value = { "testdetail" }, method = RequestMethod.GET)
	public String TableTestdetail(ModelMap modelMap) {
		modelMap.put("testdetails", testDetailService.findAll());
		return "admin/table/testdetail";
	}

	
}
