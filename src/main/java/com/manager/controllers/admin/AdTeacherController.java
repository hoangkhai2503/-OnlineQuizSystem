package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.TeacherService;

@Controller
@RequestMapping({ "admin" })
public class AdTeacherController {
	@Autowired
	private TeacherService teacherService;
	// getList
	@RequestMapping(value = { "teacher" }, method = RequestMethod.GET)
	public String TableTeacher(ModelMap modelMap) {
		modelMap.put("teachers", teacherService.findAll());
		return "admin/table/teacher";
	}
	// Add
	@RequestMapping(value = { "addTeacher" }, method = RequestMethod.GET)
	public String AddTeacher() {
		return "admin/addForm/teacher";
	}

	// Edit
	@RequestMapping(value = { "editTeacher" }, method = RequestMethod.GET)
	public String EditTeacher() {
		return "admin/editForm/teacher";
	}
}
