package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class Home1Controller {
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index() {
		return "user/home/index";
	}
}
