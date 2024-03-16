package com.manager.controllers.admin;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.manager.entities.Contact;
import com.manager.entities.News;
import com.manager.service.EnumListService;
import com.manager.service.NewsService;

@Controller
@RequestMapping({ "admin" })
public class AdNewController {
	@Autowired
	private NewsService newsService;
	
	@Autowired
	private EnumListService enumListService;
	// getList
	@RequestMapping(value = { "new" }, method = RequestMethod.GET)
	public String TableNew(ModelMap modelMap) {
		modelMap.put("news", newsService.findAll());
		return "admin/table/new";
	}

	// Add
		@RequestMapping(value = { "addNew" }, method = RequestMethod.GET)
		public String AddNew(ModelMap modelMap) {
			News news = new News();
			modelMap.put("news", news);
			return "admin/addForm/new";
		}

		@RequestMapping(value = { "addNew" }, method = RequestMethod.POST)
		public String AddNew(ModelMap modelMap, @ModelAttribute("news") News news) {
			news.setCreated_news(new Date());
			news.setModified_news(new Date());
			news.setEnumList(enumListService.findById(6));
			newsService.save(news);
			return "redirect:new";
		}

		// Edit
		@RequestMapping(value = { "editNews/{id}" }, method = RequestMethod.GET)
		public String EditNew( ModelMap modelMap, @PathVariable("id") int id ) {
			modelMap.put("news", newsService.findById(id));
			modelMap.put("enumListes", enumListService.findTypeStatusOfNews());
			return "admin/editForm/new";
		}

		@RequestMapping(value = { "editNews" }, method = RequestMethod.POST)
		public String EditNew( ModelMap modelMap,@ModelAttribute("news") News news ) {
			News currentNews = newsService.findById(news.getId_news());
			news.setCreated_news(currentNews.getCreated_news());
			news.setModified_news(new Date());
			newsService.save(news);
			return "redirect:new";
		}

		//Delete
		@RequestMapping(value = { "deleteNews/{id}" }, method = RequestMethod.GET)
		public String DeleteNews(@PathVariable("id") int id,ModelMap modelMap) {
			newsService.delete(id);
			return "redirect:/admin/new";
		}
}
