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
import com.manager.entities.Teacher;
import com.manager.service.EnumListService;
import com.manager.service.RoleService;
import com.manager.service.TeacherService;

@Controller
@RequestMapping({ "admin" })
public class AdTeacherController {
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private EnumListService enumListService;
	
	@Autowired
	private RoleService roleService;
	// getList
	@RequestMapping(value = { "teacher" }, method = RequestMethod.GET)
	public String TableTeacher(ModelMap modelMap) {
		modelMap.put("teachers", teacherService.findAllTeacherActive());
		modelMap.put("enumListes", enumListService.findTypeStatusOfTeacher());
		return "admin/table/teacher";
	}
	
	@RequestMapping(value = { "searchTeacherByKeyword" }, method = RequestMethod.GET)
	public String searchTeacherByKeyword(@RequestParam("keyword") String keyword, ModelMap modelMap) {
		modelMap.put("teachers", teacherService.searchTeacherByKeyword(keyword));
		System.out.println(keyword);
		modelMap.put("keyword", keyword);
		return "admin/table/teacher";
	}
	
	@RequestMapping(value = { "teacher-inactive" }, method = RequestMethod.GET)
	public String TableTeacherInactive(ModelMap modelMap) {
		modelMap.put("teachers", teacherService.findAllTeacherInactive());
		return "admin/table/inactiveteacher";
	}
	// Add
	@RequestMapping(value = { "addTeacher" }, method = RequestMethod.GET)
	public String AddTeacher(ModelMap modelMap) {
		Teacher teacher = new Teacher();
		modelMap.put("teacher", teacher);
		return "admin/addForm/teacher";
	}

	@RequestMapping(value = { "addTeacher" }, method = RequestMethod.POST)
	public String AddTeacher(ModelMap modelMap, @ModelAttribute("teacher") Teacher teacher) {
		teacher.setCreated_teacher(new Date());
		teacher.setModified_teacher(new Date());
		teacher.setEnumlist(enumListService.findById(4));
		teacher.setRole(roleService.findById(2));
		teacherService.save(teacher);
		return "redirect:teacher";
	}
	
	// Edit
	@RequestMapping(value = { "editTeacher/{id}" }, method = RequestMethod.GET)
	public String EditTeacher(ModelMap modelMap, @PathVariable("id") int id) {
		modelMap.put("teacher", teacherService.findById(id));
		modelMap.put("enumListes", enumListService.findTypeStatusOfTeacher());
		return "admin/editForm/teacher";
	}
	
	@RequestMapping(value = { "editTeacher" }, method = RequestMethod.POST)
	public String EditContact(ModelMap modelMap, @ModelAttribute("teacher") Teacher teacher) {
		Teacher currentTeacher = teacherService.findById(teacher.getId_teacher());
		teacher.setCreated_teacher(currentTeacher.getCreated_teacher());
		teacher.setRole(currentTeacher.getRole());
		teacher.setModified_teacher(new Date());
		teacherService.save(teacher);
		return "redirect:teacher";
	}
	
}