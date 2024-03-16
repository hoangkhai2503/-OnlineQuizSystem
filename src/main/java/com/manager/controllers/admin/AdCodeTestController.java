package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.Codetest;
import com.manager.entities.Teacher;
import com.manager.service.CodeTestService;
import com.manager.service.EnumListService;

@Controller
@RequestMapping({ "admin" })
public class AdCodeTestController {
	@Autowired
	private CodeTestService codeTestService;
	@Autowired
	private EnumListService enumListService;
	// getList
		@RequestMapping(value = { "codetest" }, method = RequestMethod.GET)
		public String TableCodeTest(ModelMap modelMap) {
			modelMap.put("codetests", codeTestService.findAll());
			return "admin/table/codetest";
		}

		// Add
			@RequestMapping(value = { "addCodeTest" }, method = RequestMethod.GET)
			public String addCodeTest(ModelMap modelMap) {
				Codetest codetest = new Codetest();
				modelMap.put("codetest", codetest);
				return "admin/addForm/codetest";
			}

			@RequestMapping(value = { "addCodeTest" }, method = RequestMethod.POST)
			public String AddTeacher(ModelMap modelMap, @ModelAttribute("codetest") Codetest codetest) {
				codetest.setEnumList(enumListService.findById(2));
				codeTestService.save(codetest);
				return "redirect:codetest";
			}
			// Edit
			@RequestMapping(value = { "editCodeTest/{id}" }, method = RequestMethod.GET)
			public String EditTeacher(ModelMap modelMap, @PathVariable("id") int id) {
				modelMap.put("codetest", codeTestService.findById(id));
				modelMap.put("enumListes", enumListService.findTypeStatusOfCodeTest());
				return "admin/editForm/codetest";
			}

			@RequestMapping(value = { "editCodeTest" }, method = RequestMethod.POST)
			public String EditContact(ModelMap modelMap, @ModelAttribute("codetest") Codetest codetest) {
				Codetest currentCodeTest = codeTestService.findById(codetest.getId_codetest());
				codeTestService.save(codetest);
				return "redirect:codetest";
			}

}
	