package com.manager.controllers.user;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.Contact;
import com.manager.service.ContactService;
import com.manager.service.EnumListService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"user"})
public class ContactController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private EnumListService enumListService;
	
	
	@RequestMapping(value = { "contact", "" }, method = RequestMethod.GET)
	public String contact(ModelMap modelMap,HttpServletRequest request) {
		Contact contact = new Contact();
		modelMap.put("contact", contact);
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		return "user/home/contact";
	}
	
	@RequestMapping(value = { "addContact" }, method = RequestMethod.POST)
	public String AddContact(ModelMap modelMap, @ModelAttribute("contact") Contact contact,HttpServletRequest request) {
		contact.setCreated_contact(new Date());
		contact.setModified_contact(new Date());
		contact.setEnumList(enumListService.findById(8));
		contactService.save(contact);
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		return "redirect:contact";
	}
}
