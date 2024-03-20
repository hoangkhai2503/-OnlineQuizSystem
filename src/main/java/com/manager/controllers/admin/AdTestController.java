package com.manager.controllers.admin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.print.attribute.standard.DateTimeAtCompleted;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Superadmin;
import com.manager.entities.Teacher;
import com.manager.entities.Test;
import com.manager.entities.Typetest;
import com.manager.entities._Class;
import com.manager.service.ClassService;
import com.manager.service.CodeTestService;
import com.manager.service.EnumListService;
import com.manager.service.SubjectService;
import com.manager.service.SuperAdminService;
import com.manager.service.TeacherService;
import com.manager.service.TermService;
import com.manager.service.TestService;
import com.manager.service.TypetestService;

import jakarta.persistence.Convert;

@Controller
@RequestMapping({ "admin" })
public class AdTestController {
	@Autowired
	private TestService testService;
	
	@Autowired
	private ClassService classService;

	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private TermService termService;
	
	@Autowired
	private TypetestService typeTestService;
	
	@Autowired
	private CodeTestService codeTestService;
	
	@Autowired
	private EnumListService enumListService;
	
	@Autowired
	private TeacherService teacherService;
	
	@Autowired
	private SuperAdminService superAdminService;
	
	// getList
	@RequestMapping(value = { "test" }, method = RequestMethod.GET)
	public String TableTestdetail(ModelMap modelMap,Authentication authentication) {
		modelMap.put("tests", testService.findAll());
		modelMap.put("status", -1);
		modelMap.put("keyword", "");
		String username = authentication.getName();
		Teacher teacher = teacherService.findTeacherByEmail(username);
		if(teacher == null) {
			Superadmin superadmin = superAdminService.findByUsernameAdmin(username);
			if(superadmin.getRole().getId_role() == 1) {
				modelMap.put("role", "superAdmin");
			}else {
				modelMap.put("role", "admin");
			}
		}else {
			modelMap.put("role", "teacher");
			modelMap.put("idTeacher", teacher.getId_teacher());
		}
		return "admin/table/test";
	}
	// Add
	@RequestMapping(value = { "addTest" }, method = RequestMethod.GET)
		public String addTest(ModelMap modelMap) {
		Test test = new Test();
		LocalDateTime currentDateTime = LocalDateTime.now();        
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String nowTime = currentDateTime.format(formatter);
		test.setStarttime_test(nowTime);
		test.setOngoing_test(nowTime);
		test.setEndtime_test(nowTime);
		modelMap.put("test", test);
		modelMap.put("classs", classService.findAll());
		modelMap.put("subjects", subjectService.findAll());
		modelMap.put("terms", termService.findAll());
		modelMap.put("typeTests", typeTestService.findAll());
		modelMap.put("codeTests", codeTestService.findAll());
		return "admin/addForm/test";
	}
	@RequestMapping(value = "addTest", method = RequestMethod.POST)	
	public String addTest(@ModelAttribute("test") Test test,
			@RequestParam("dateTime") String dateTimeString,
			RedirectAttributes redirectAttributes) 
	{
		test.setCreated_test(new Date());
		test.setModified_test(new Date());
		test.setEnumlist(enumListService.find(13));
		
		// Chuyển đổi chuỗi ngày và giờ thành LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        // Định dạng lại thành chuỗi "yyyy-MM-dd HH:mm:ss"
        String starttime_test = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
        test.setStarttime_test(starttime_test);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        
        LocalDateTime initialDateTime = LocalDateTime.parse(test.getStarttime_test(), formatter); 
        Typetest typetest = typeTestService.findById(test.getTypetest().getId_typetest());
        LocalDateTime futureDateTime = initialDateTime.plusMinutes(typetest.getTime_typetest());
        String endtime_test = futureDateTime.format(formatter);
        test.setOngoing_test(endtime_test);
        test.setEndtime_test(endtime_test);
        
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  
		if (testService.save(test)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/admin/test";
		
	}
	
	// EDIT
	@RequestMapping(value = { "editTest/{id_test}" }, method = RequestMethod.GET)
		public String editTest(@PathVariable("id_test") int id_test, ModelMap modelMap,RedirectAttributes redirectAttributes) {
		Test test = testService.findId(id_test);
		modelMap.put("test", test);
		modelMap.put("classs", classService.findAll());
		modelMap.put("subjects", subjectService.findAll());
		modelMap.put("terms", termService.findAll());
		modelMap.put("typeTests", typeTestService.findAll());
		modelMap.put("codeTests", codeTestService.findAll());
		return "admin/editForm/test";
	}
	@RequestMapping(value = "editTest", method = RequestMethod.POST)	
	public String editTest(@ModelAttribute("test") Test test,
			@RequestParam("dateTime") String dateTimeString,
			RedirectAttributes redirectAttributes) 
	{
		test.setCreated_test(new Date());
		test.setModified_test(new Date());
		test.setEnumlist(enumListService.find(13));
		
		// Chuyển đổi chuỗi ngày và giờ thành LocalDateTime
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeString, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm"));

        // Định dạng lại thành chuỗi "yyyy-MM-dd HH:mm:ss"
        String starttime_test = dateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		
        test.setStarttime_test(starttime_test);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");        
        LocalDateTime initialDateTime = LocalDateTime.parse(test.getStarttime_test(), formatter); 
        Typetest typetest = typeTestService.findById(test.getTypetest().getId_typetest());
        LocalDateTime futureDateTime = initialDateTime.plusMinutes(typetest.getTime_typetest());
        String endtime_test = futureDateTime.format(formatter);
        test.setOngoing_test(endtime_test);
        test.setEndtime_test(endtime_test);
        
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
  
		if (testService.save(test)) {
			redirectAttributes.addFlashAttribute("msg", "Success");
		} else {
			redirectAttributes.addFlashAttribute("msg", "Failed");
		}
		return "redirect:/admin/test";
		
	}
	@RequestMapping(value = { "selectTest" }, method = RequestMethod.GET)
	public String selectTest(@RequestParam("status") int status,
            @RequestParam("keyword") String keyword,ModelMap modelMap,Authentication authentication) {
		modelMap.put("tests", testService.findAll());
		modelMap.put("status", status);
		modelMap.put("keyword", keyword);
		String username = authentication.getName();
		Teacher teacher = teacherService.findTeacherByEmail(username);
		if(teacher == null) {
			Superadmin superadmin = superAdminService.findByUsernameAdmin(username);
			if(superadmin.getRole().getId_role() == 1) {
				modelMap.put("role", "superAdmin");
			}else {
				modelMap.put("role", "admin");
			}
		}else {
			modelMap.put("role", "teacher");
			modelMap.put("idTeacher", teacher.getId_teacher());
		}
		return "admin/table/test";
	}
	

	
}
