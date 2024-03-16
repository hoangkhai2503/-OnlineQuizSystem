package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.entities.Contact;
import com.manager.service.ContactService;
import com.manager.service.EnumListService;

@Controller
@RequestMapping({ "admin" })
public class AdContactController {
	@Autowired
	private ContactService contactService;
	@Autowired
	private EnumListService enumListService;
	// getList
	@RequestMapping(value = { "contact" }, method = RequestMethod.GET)
	public String TableContact(ModelMap modelMap) {
		modelMap.put("contacts", contactService.findAll());
		return "admin/table/contact";
	}
	
	@RequestMapping(value = { "addForm/contact" }, method = RequestMethod.GET)
	public String AddContact(ModelMap modelMap) {
		Contact contact = new Contact();
		modelMap.put("contact", contact);
		return "admin/addForm/contact";
	}
	
	@RequestMapping(value = { "addContact" }, method = RequestMethod.POST)
	public String AddContact(ModelMap modelMap, @ModelAttribute("contact") Contact contact) {
		contact.setCreated_contact(new Date());
		contact.setModified_contact(new Date());
		contact.setEnumList(enumListService.findById(8));
		contactService.save(contact);
		return "redirect:contact";
	}
	
	@RequestMapping(value = { "editForm/contact/{id}" }, method = RequestMethod.GET)
	public String EditContact(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("contact", contactService.findById(id));
		modelMap.put("enumListes", enumListService.findTypeStatusOfContact());
		return "admin/editForm/contact";
	}
	
	@RequestMapping(value = { "editContact" }, method = RequestMethod.POST)
	public String EditContact(ModelMap modelMap, @ModelAttribute("contact") Contact contact) {
		Contact currenrContact = contactService.findById(contact.getId_contact());
		contact.setCreated_contact(currenrContact.getCreated_contact());
		contact.setModified_contact(new Date());
		contactService.save(contact);
		return "redirect:contact";
	}
	
	@RequestMapping(value = { "deleteContact/{id}" }, method = RequestMethod.GET)
	public String DeleteContact(@PathVariable("id") int id,ModelMap modelMap) {
		contactService.delete(id);
		return "redirect:/admin/contact";
	}

	@RequestMapping(value = { "searchContactByKeyword" }, method = RequestMethod.GET)
	public String searchTeacherByKeyword(@RequestParam("keyword") String keyword, ModelMap modelMap) {
		modelMap.put("contacts", contactService.searchContactByKeyword(keyword));
		modelMap.put("keyword", keyword);
		return "admin/table/contact";
	}
	
}