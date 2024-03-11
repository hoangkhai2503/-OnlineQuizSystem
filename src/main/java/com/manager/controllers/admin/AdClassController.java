package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Class;
import com.manager.entities.EnumList;
import com.manager.entities.Subject;
import com.manager.service.ClassService;
import com.manager.service.EnumListService;
import com.manager.service.TeacherService;

@Controller
@RequestMapping({ "admin" })
public class AdClassController {
	@Autowired
	private ClassService classService;

	@Autowired
	private EnumListService enumlistService;
	
	@Autowired
	private TeacherService teacherService;
	// getList
	@RequestMapping(value = { "class" }, method = RequestMethod.GET)
	public String TableClass(ModelMap modelMap) {
		modelMap.put("gbclass", classService.findAll());
		return "admin/table/class";
	}

	// Add
	@RequestMapping(value = { "addClass" }, method = RequestMethod.GET)
	public String AddClass(ModelMap modelMap) {
		modelMap.put("enumlists", enumlistService.findAll());
		modelMap.put("teachers", teacherService.findAll());
		Class gbclass = new Class();
		modelMap.put("gbclass", gbclass);
		return "admin/addForm/class";
	}

	// add post
	@RequestMapping(value = { "addClass" }, method = RequestMethod.POST)
	public String AddClass(@ModelAttribute("gbclass") Class gbclass, RedirectAttributes redirectAttributes) {
		// subject.setFullname("Null");
		// Lấy ngày hiện tại
		Date currentDate = new Date();
		gbclass.setCreated_class(currentDate); 
		gbclass.setModified_class(currentDate);
		if (classService.save(gbclass)) {
			return "redirect:/admin/class";
		} else {
			return "redirect:/admin/addClass";
		}

	}

	// Edit
	@RequestMapping(value = { "editClass" }, method = RequestMethod.GET)
	public String EditClass() {
		return "admin/editForm/class";
	}
}
