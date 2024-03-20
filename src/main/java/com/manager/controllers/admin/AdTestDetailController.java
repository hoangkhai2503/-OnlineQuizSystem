package com.manager.controllers.admin;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Test;
import com.manager.entities.TestDetail;
import com.manager.entities.Typetest;
import com.manager.service.ClassService;
import com.manager.service.SubjectService;
import com.manager.service.TestDetailService;

@Controller
@RequestMapping({ "admin" })
public class AdTestDetailController {
	@Autowired
	private TestDetailService testDetailService;
	
	@Autowired
	private ClassService classService;
	
	@Autowired
	private SubjectService subjectService;
	
	// getList
	@RequestMapping(value = { "testdetail" }, method = RequestMethod.GET)
	public String TableTestdetail(ModelMap modelMap) {
		modelMap.put("testdetails", testDetailService.findAll());
		return "admin/table/testdetail";
	}
	
	// getList 
	@RequestMapping(value = { "testdetail/{id_test}" }, method = RequestMethod.GET)
		public String editTest(@PathVariable("id_test") int id_test, ModelMap modelMap,RedirectAttributes redirectAttributes) {
		
		int selectClass = -1;
		modelMap.put("testdetails", testDetailService.findAll());
		modelMap.put("classs", classService.findAll());
		modelMap.put("id_test", id_test);
		modelMap.put("selectClass", selectClass);
		return "admin/table/testdetail";
	}
	
	// getList 
	@RequestMapping(value = { "testStudent/{id_student}" }, method = RequestMethod.GET)
		public String testStudent(@PathVariable("id_student") int id_student, ModelMap modelMap,RedirectAttributes redirectAttributes) {			
			int selectClass = -1;
			modelMap.put("testdetails", testDetailService.findAll());
			modelMap.put("subjects", subjectService.findAll());
			modelMap.put("id_student", id_student);
			modelMap.put("selectClass", selectClass);
			return "admin/table/testStudent";
	}
	@RequestMapping(value = "selectClassTestDetail", method = RequestMethod.GET)    
	public String selectClassTestDetail(ModelMap modelMap,
	                                    @RequestParam("id_test") int id_test,
	                                    @RequestParam("selectClass") int selectClass,
	                                    RedirectAttributes redirectAttributes) {
		modelMap.put("testdetails", testDetailService.findAll());
		modelMap.put("classs", classService.findAll());
		modelMap.put("id_test", id_test);
		modelMap.put("selectClass", selectClass);
		
		return "admin/table/testdetail";
		
	}
	
	@RequestMapping(value = "selectClassTestStudent", method = RequestMethod.GET)    
	public String selectClassTestStudent(ModelMap modelMap,
	                                    @RequestParam("id_student") int id_student,
	                                    @RequestParam("selectClass") int selectClass,
	                                    RedirectAttributes redirectAttributes) {
		modelMap.put("testdetails", testDetailService.findAll());
		modelMap.put("subjects", subjectService.findAll());
		modelMap.put("id_student", id_student);
		modelMap.put("selectClass", selectClass);
		
		return "admin/table/testStudent";
		
	}

	
}
