package com.manager.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.VariableService;

@Controller
@RequestMapping({"user"})
public class StaffController {
//	@RequestMapping(value = { "staff", "" }, method = RequestMethod.GET)
//	public String staff() {
//		return "user/home/staff";
//	}
	@Autowired
	private VariableService variableService;
	@RequestMapping(value = { "staff", "" }, method = RequestMethod.GET)
	public String staff(ModelMap modelMap) {
		modelMap.put("txt_HaQ", variableService.findByCode_variable("txt_HaQ"));
		modelMap.put("txt_Phone", variableService.findByCode_variable("txt_Phone"));
		modelMap.put("txt_Mail", variableService.findByCode_variable("txt_Mail"));
		return "user/home/staff";
	}
}
