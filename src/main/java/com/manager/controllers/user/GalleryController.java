package com.manager.controllers.user;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping({"user"})
public class GalleryController {
	@RequestMapping(value = { "gallery", "" }, method = RequestMethod.GET)
	public String gallery() {
		return "user/home/gallery";
	}
}
