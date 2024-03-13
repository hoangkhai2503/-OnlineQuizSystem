package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class RegisterController {
	@RequestMapping(value = { "register", "" }, method = RequestMethod.GET)
	public String register() {
		return "user/home/register";
	}
}
