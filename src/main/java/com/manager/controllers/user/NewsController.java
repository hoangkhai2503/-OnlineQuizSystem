package com.manager.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.News;
import com.manager.service.NewsService;
import com.manager.service.VariableService;

@Controller
@RequestMapping({"user"})
public class NewsController {
	@Autowired
	private NewsService newsService;
	@RequestMapping(value = { "news", "" }, method = RequestMethod.GET)
	public String news(ModelMap modelMap) {
		modelMap.put("newses", newsService.findAllNewsPublicity());
		return "user/home/news";
	}
	@RequestMapping(value = { "newsdetail", "" }, method = RequestMethod.GET)
	public String newsdetail() {
		
		return "user/home/newsdetail";
	}
}
