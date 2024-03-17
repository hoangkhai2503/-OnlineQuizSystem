package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class UserVariableController {
	@RequestMapping(value = { "variable" }, method = RequestMethod.GET)
	public String TableVariable(ModelMap modelMap) {
		return "admin/table/variable";
	}

}
