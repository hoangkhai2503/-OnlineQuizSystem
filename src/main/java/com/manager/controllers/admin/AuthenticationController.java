package com.manager.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Superadmin;
import com.manager.service.EnumListService;
import com.manager.service.RoleService;
import com.manager.service.SuperAdminService;


@Controller
@RequestMapping({ "admin" })
public class AuthenticationController {
	@Autowired
	private SuperAdminService superAdminService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EnumListService enumlistService;

	
	 @Autowired 
	 private BCryptPasswordEncoder encoder;
	// login
	@RequestMapping(value = { "login" }, method = RequestMethod.GET)
	public String login() {
		return "admin/page/login";

	}

	// regsiter
	@RequestMapping(value = { "register" }, method = RequestMethod.GET)
	public String register() {
		return "admin/page/register";

	}

	// 404 page
	@RequestMapping(value = { "error" }, method = RequestMethod.GET)
	public String error() {
		return "admin/page/error";
	}

	// project
	@RequestMapping(value = { "profile" }, method = RequestMethod.GET)
	public String profile() {
		return "admin/page/profile";
	}
}
