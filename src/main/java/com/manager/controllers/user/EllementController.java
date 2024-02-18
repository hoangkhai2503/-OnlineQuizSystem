package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class EllementController {
	@RequestMapping(value = { "elements", "" }, method = RequestMethod.GET)
	public String elements() {
		return "user/home/elements";
	}
}
