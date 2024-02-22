package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.service.AnswerService;

@Controller
@RequestMapping({ "admin" })
public class AdAnswerController {
	@Autowired
	private AnswerService answerService;
	// getList
	@RequestMapping(value = { "answer" }, method = RequestMethod.GET)
	public String TableAnswer(ModelMap modelMap) {
		modelMap.put("answers", answerService.findAll());
		return "admin/table/answer";
	}

	
}
