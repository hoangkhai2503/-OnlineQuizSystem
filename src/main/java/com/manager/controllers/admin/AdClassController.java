package com.manager.controllers.admin;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Answer;
import com.manager.entities.ClassDetail;
import com.manager.entities.Question;
import com.manager.entities.SchoolYear;
import com.manager.entities._Class;
import com.manager.helpers.FileHelper;
import com.manager.service.ClassDetailService;
import com.manager.service.ClassService;
import com.manager.service.EnumListService;
import com.manager.service.SchoolYearService;
import com.manager.service.StudentService;
import com.manager.service.TeacherService;

@Controller
@RequestMapping({ "admin" })
public class AdClassController {
	@Autowired
	private ClassService classService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SchoolYearService schoolYearService;
	
	@Autowired
	private EnumListService enumListService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ClassDetailService classDetailService;
	
	
	// getList
	@RequestMapping(value = { "class" }, method = RequestMethod.GET)
	public String TableClass(ModelMap modelMap) {
		modelMap.put("gbclass", classService.findAll());
		return "admin/table/class";
	}

	// Add
	@RequestMapping(value = { "addClass" }, method = RequestMethod.GET)
	public String addClass(ModelMap modelMap) {
		_Class _class = new _Class();
		modelMap.put("class", _class);
		modelMap.put("teachers", teacherService.findAll());
		modelMap.put("schoolYears", schoolYearService.findAll());
		return "admin/addForm/class";
	}
	@RequestMapping(value = "addClass", method = RequestMethod.POST)
	public String add(@ModelAttribute("class") _Class _class,
			RedirectAttributes redirectAttributes) 
	{
		_class.setCreated_class(new Date());
		_class.setModified_class(new Date());
		_class.setEnumList(enumListService.find(4));
		
		
		if (classService.save(_class)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		ClassDetail classDetail = new ClassDetail();
		classDetail.setEnumList(enumListService.find(4));
		classDetail.setGbclass(classService.findId(classService.findIdLatest()));
		classDetail.setTeacher(_class.getTeacher());
		
		if (classDetailService.save(classDetail)) {
			redirectAttributes.addFlashAttribute("msg", "Success - thanhf coong");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/admin/class";
	}
	//EDIT
	@RequestMapping(value = "editClass/{id_class}", method = RequestMethod.GET)
	public String editClass(@PathVariable("id_class") int id_class, ModelMap modelMap,RedirectAttributes redirectAttributes) {
		
		modelMap.put("teachers", teacherService.findAll());
		modelMap.put("schoolYears", schoolYearService.findAll());
		modelMap.put("students", studentService.findAll());
		modelMap.put("class", classService.findId(id_class));
		modelMap.put("classdetails", classDetailService.findAll());
		
		return "admin/editForm/class";
	}
	
	@RequestMapping(value = "editClass", method = RequestMethod.POST)
	public String editClass(@ModelAttribute("class") _Class _class,
			RedirectAttributes redirectAttributes) 
	{
		_Class oldClass = classService.findId(_class.getId_class());
		oldClass.setModified_class(new Date());
		oldClass.setName_class(_class.getName_class());
		oldClass.setSchoolYear(_class.getSchoolYear());
		oldClass.setTeacher(_class.getTeacher());
		if (classService.save(oldClass)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/admin/class";
	}
}