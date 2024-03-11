package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.SuperAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

@Controller
@RequestMapping({ "admin" })
public class HomeController {
	@Autowired
	private SuperAdminService superAdminService;
	// dashboard
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String login(Authentication authentication) {
		//System.out.println("username: " + authentication.getName());
		//modelMap.put("superadmin", superAdminService.findAll());
		return "admin/home/index";
	}
	
	// material
	@RequestMapping(value = { "material" }, method = RequestMethod.GET)
	public String material() {
		return "admin/icons/fontawesomeIcons";
	}

	
}
