package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"user"})
public class UserVariableController {
	@RequestMapping(value = { "variable" }, method = RequestMethod.GET)
	public String TableVariable(ModelMap modelMap,HttpServletRequest request) {
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		return "admin/table/variable";
	}

}
