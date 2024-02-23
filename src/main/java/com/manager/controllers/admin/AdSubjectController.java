package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.EnumList;
import com.manager.entities.Subject;
import com.manager.service.SubjectService;

@Controller
@RequestMapping({ "admin" })
public class AdSubjectController {
	@Autowired
	private SubjectService subjectService;
	// getList
	@RequestMapping(value = { "subject" }, method = RequestMethod.GET)
	public String TableSubject(ModelMap modelMap) {
		modelMap.put("subjects", subjectService.findAll());
		return "admin/table/subject";
	}

	// Add get
	@RequestMapping(value = { "addSubject" }, method = RequestMethod.GET)
	public String AddSubject(ModelMap modelMap) {
		Subject subject = new Subject();
		modelMap.put("subject", subject);
		return "admin/addForm/subject";
	}

	// add post
	@RequestMapping(value = { "addSubject" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("subject") Subject subject,
			RedirectAttributes redirectAttributes) {
		//subject.setFullname("Null");
		 // Lấy ngày hiện tại
	    Date currentDate = new Date();
	    subject.setCreated_subject(currentDate); // Thiết lập ngày hiện tại
	    subject.setModified_subject(currentDate); 
	 // Tạo một đối tượng EnumList với id là 4
	    EnumList enumList = new EnumList();
	    enumList.setId(4);
	    // Gán đối tượng EnumList vào trường enumList của đối tượng Subject
	    subject.setEnumList(enumList);
		if(subjectService.save(subject)) {
			return "redirect:/admin/subject";
		}else {
			return "redirect:/admin/addSubject";
		}
		
	}
	// Edit
	@RequestMapping(value = { "editSubject" }, method = RequestMethod.GET)
	public String EditSubject() {
		return "admin/editForm/subject";
	}
}
