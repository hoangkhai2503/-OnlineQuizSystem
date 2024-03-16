package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class ExamController {
	@RequestMapping(value = { "exam", "" }, method = RequestMethod.GET)
	public String exam() {
		return "user/home/exam";
	}
	@RequestMapping(value = { "myExam", "" }, method = RequestMethod.GET)
	public String myExam() {
		return "user/home/myExam";
	}
}
