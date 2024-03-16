package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.Teacher;
import com.manager.entities.Term;
import com.manager.service.EnumListService;
import com.manager.service.TermService;

@Controller
@RequestMapping({ "admin" })
public class AdTermController {
	@Autowired
	private TermService termService;
	@Autowired
	private EnumListService enumListService;

	// getList
	@RequestMapping(value = { "term" }, method = RequestMethod.GET)
	public String TableTerm(ModelMap modelMap) {
		modelMap.put("terms", termService.findAll());
		return "admin/table/term";
	}

	@RequestMapping(value = { "addTerm" }, method = RequestMethod.GET)
	public String AddTerm( ModelMap modelMap ) {
		Term term = new Term();
		modelMap.put("term", term);
		return "admin/addForm/term";
	}
	@RequestMapping(value = { "addTerm" }, method = RequestMethod.POST)
	public String addTerm(ModelMap modelMap, @ModelAttribute("term") Term term) {
		term.setCreated_term(new Date());
		term.setModified_term(new Date());
		term.setEnumlist(enumListService.findById(4));
		termService.save(term);
		return "redirect:term";
	}
	//Edit
	@RequestMapping(value = { "editTerm/{id}" }, method = RequestMethod.GET)
	public String EditTerm(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("term", termService.findById(id));
		modelMap.put("enumListes", enumListService.findTypeStatusOfTerm());
		return "admin/editForm/term";
	}
	
	@RequestMapping(value = { "editTerm" }, method = RequestMethod.POST)
	public String EditContact(ModelMap modelMap, @ModelAttribute("term") Term term) {
		Term currentTerm = termService.findById(term.getId_term());
		term.setCreated_term(currentTerm.getCreated_term());
		term.setModified_term(new Date());
		termService.save(term);
		return "redirect:term";
	}
}
