package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.QuestionService;

@Controller
@RequestMapping({ "admin" })
public class AdQuestionController {
	@Autowired
	private QuestionService questionService;
	// getList
	@RequestMapping(value = { "question" }, method = RequestMethod.GET)
	public String TableQuestion(ModelMap modelMap) {
		modelMap.put("questions", questionService.findAll());
		return "admin/table/question";
	}
	// Add
	/*
	 * @RequestMapping(value = { "addStudent" }, method = RequestMethod.GET) public
	 * String AddStudent() { return "admin/addForm/student"; }
	 */

	// Edit
	/*
	 * @RequestMapping(value = { "editStudent" }, method = RequestMethod.GET) public
	 * String EditStudent() { return "admin/editForm/student"; }
	 */
}
