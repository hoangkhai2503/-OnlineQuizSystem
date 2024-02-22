package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.ClassDetailService;

@Controller
@RequestMapping({ "admin" })
public class AdClassDetailController {
	@Autowired
	private ClassDetailService classDetailService;
	// getList
	@RequestMapping(value = { "classdetail" }, method = RequestMethod.GET)
	public String TableClassDetail(ModelMap modelMap) {
		modelMap.put("classdetails", classDetailService.findAll());
		return "admin/table/classdetail";
	}

}
