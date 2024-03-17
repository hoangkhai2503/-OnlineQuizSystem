package com.manager.controllers.admin;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.manager.entities.Superadmin;
import com.manager.service.EnumListService;
import com.manager.service.RoleService;
import com.manager.service.SuperAdminService;

import jakarta.servlet.http.HttpSession;
@Controller
@RequestMapping({ "admin" })
public class AdSuperAdminController {
	@Autowired
	private SuperAdminService superAdminService;
	
	@Autowired
	private RoleService roleService;

	@Autowired
	private EnumListService enumlistService;
	
	 @Autowired 
	 private BCryptPasswordEncoder encoder;

	// getList
	@RequestMapping(value = { "superadmin" }, method = RequestMethod.GET)
	public String TableSuperadmin(ModelMap modelMap) {
		modelMap.put("superadmins", superAdminService.findAll());
		return "admin/table/superadmin";
	}
	@RequestMapping(value = { "createdAdmin" }, method = RequestMethod.GET)
	public String AddAdmin(ModelMap modelMap) {
		Superadmin superadmin = new Superadmin();
		modelMap.put("roles", roleService.findAll());
		modelMap.put("enumlists", enumlistService.findAll());
		modelMap.put("superadmin", superadmin);
		return "admin/addForm/superadmin";
	}
	
	@RequestMapping(value = { "createdAdmin" }, method = RequestMethod.POST)
	public String register(@ModelAttribute("superadmin") Superadmin superadmin, RedirectAttributes redirectAttributes) {
		superadmin.setPassword_superadmin(encoder.encode(superadmin.getPassword_superadmin()));
		if (superAdminService.save(superadmin)) {
			return "redirect:/admin/login";
		} else {
			return "redirect:/admin/createdAdmin";
		}

	}

}
