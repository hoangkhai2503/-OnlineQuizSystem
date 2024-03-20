package com.manager.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.News;
import com.manager.service.NewsService;
import com.manager.service.VariableService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping({"user"})
public class NewsController {
	@Autowired
	private NewsService newsService;
	@RequestMapping(value = { "news", "" }, method = RequestMethod.GET)
	public String news(ModelMap modelMap,HttpServletRequest request) {
		News newses = new News();
		modelMap.put("newses", newsService.findAllNewsPublicity());
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		return "user/home/news";
	}
	@RequestMapping(value = { "newsdetail", "" }, method = RequestMethod.GET)
	public String newsdetail(HttpServletRequest request, ModelMap modelMap) {
		String value = (String) request.getSession().getAttribute("studentName");
		modelMap.put("studentName", value);
		return "user/home/newsdetail";
	}
}
