package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class LoginController {
	@RequestMapping(value = { "login", "" }, method = RequestMethod.GET)
	public String login() {
		return "user/home/login";
	}
}
