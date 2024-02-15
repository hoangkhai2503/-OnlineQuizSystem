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

	// form
	@RequestMapping(value = { "form" }, method = RequestMethod.GET)
	public String form() {
		return "admin/addForm/index";
	}

	// table
	@RequestMapping(value = { "table" }, method = RequestMethod.GET)
	public String table() {
		return "admin/table/index";
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
