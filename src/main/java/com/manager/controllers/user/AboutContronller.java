package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class AboutContronller {
	@RequestMapping(value = { "about", "" }, method = RequestMethod.GET)
	public String about() {
		return "user/home/about";
	}
}