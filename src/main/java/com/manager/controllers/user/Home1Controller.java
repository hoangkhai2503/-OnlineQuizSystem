package com.manager.controllers.user;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.VariableService;

@Controller
@RequestMapping({"user"})

public class Home1Controller {
	@Autowired
	private VariableService variableService;

	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index() {
		return "user/home/index";
	}

	@RequestMapping(value = { "profile", "" }, method = RequestMethod.GET)
	public String profile() {
		return "user/home/profile";
	}
	
}
