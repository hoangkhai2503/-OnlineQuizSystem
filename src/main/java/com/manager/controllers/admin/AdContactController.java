package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.ContactService;

@Controller
@RequestMapping({ "admin" })
public class AdContactController {
	@Autowired
	private ContactService contactService;
	// getList
	@RequestMapping(value = { "contact" }, method = RequestMethod.GET)
	public String TableContact(ModelMap modelMap) {
		modelMap.put("contacts", contactService.findAll());
		return "admin/table/contact";
	}

}
