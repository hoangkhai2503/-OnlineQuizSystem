package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class HomeController {
	// dashboard
	@RequestMapping(value = { "home", "" }, method = RequestMethod.GET)
	public String login() {
		return "admin/home/index";
	}
	
	// material
	@RequestMapping(value = { "material" }, method = RequestMethod.GET)
	public String material() {
		return "admin/icons/fontawesomeIcons";
	}

	// mailService
	@RequestMapping(value = { "mail" }, method = RequestMethod.GET)
	public String mailService() {
		return "admin/apps/mailService";
	}
}
