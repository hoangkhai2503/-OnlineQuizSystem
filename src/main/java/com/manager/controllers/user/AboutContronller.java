package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"user"})
public class AboutContronller {
	@RequestMapping(value = { "about", "" }, method = RequestMethod.GET)
	public String about(HttpServletRequest request, ModelMap modelMap) {
		 String value = (String) request.getSession().getAttribute("studentName");
			modelMap.put("studentName", value);
		return "user/home/about";
	}
}
