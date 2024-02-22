package com.manager.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "admin" })
public class AuthenticationController {
	// login
	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login() {
		return "admin/page/login";

	}

	// regsiter
	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register() {
		return "admin/page/register";

	}

	// 404 page
	@RequestMapping(value = { "error" }, method = RequestMethod.GET)
	public String error() {
		return "admin/page/error";
	}

	// project
	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String profile() {
		return "admin/page/profile";
	}
}
