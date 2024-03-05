package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({ "demo" })
public class DemoController {
	// dashboard
	@RequestMapping(value = { "index", "" }, method = RequestMethod.GET)
	public String index() {
		System.out.print("Co chay controller demo");
		return "demo/index";
	}
}
