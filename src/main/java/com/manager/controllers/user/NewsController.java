package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class NewsController {
	@RequestMapping(value = { "news", "" }, method = RequestMethod.GET)
	public String news() {
		return "user/home/news";
	}
}
