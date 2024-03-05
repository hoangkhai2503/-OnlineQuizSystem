package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin/home" })
public class HomeController {
	// dashboard
	@GetMapping(value = { "index", "" })
	public String login() {
		System.out.print(" vvvvvv");
		return "admin/home/index2";
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
