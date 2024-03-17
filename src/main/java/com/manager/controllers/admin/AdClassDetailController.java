package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.ClassDetail;
import com.manager.entities.Teacher;
import com.manager.entities._Class;
import com.manager.service.ClassDetailService;
import com.manager.service.ClassService;
import com.manager.service.EnumListService;
import com.manager.service.TeacherService;

@Controller
@RequestMapping({ "admin" })
public class AdClassDetailController {
	@Autowired
	private ClassDetailService classDetailService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private EnumListService enumListService;
	// getList
	@RequestMapping(value = { "classdetail" }, method = RequestMethod.GET)
	public String TableClassDetail(ModelMap modelMap) {
		modelMap.put("classdetails", classDetailService.findAll());
		return "admin/table/classdetail";
	}
	
	@RequestMapping(value = "addClassDetail", method = RequestMethod.POST)
	public String addClassDetail(@ModelAttribute("class") _Class _class,
			RedirectAttributes redirectAttributes) 
	{
		ClassDetail classDetail = new ClassDetail();
		classDetail.setEnumList(enumListService.find(4));
		classDetail.setGbclass(classService.findId(_class.getId_class()));
		classDetail.setTeacher(teacherService.findById(_class.getTeacher().getId_teacher()));
		
		if (classDetailService.save(classDetail)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/admin/editClass/"+ _class.getId_class();
	}

}