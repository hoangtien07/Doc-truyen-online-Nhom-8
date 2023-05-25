package com.web.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.AccountDao;
import com.web.entity.Account;

@Controller
public class UserController {

	@Autowired
	private AccountDao accountDao;
	
	@RequestMapping(value = {"/admin/dsuser" }, method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/dsuser");
		model.addAttribute("dsUser", accountDao.findAll());
		return modelAndView;
	}
	
	@RequestMapping(value = {"/admin/active" }, method = RequestMethod.GET)
	public String actived(@RequestParam("id") String id) {
		Account account = accountDao.findById(Long.valueOf(id));
		if(account.getActived() == 1) {
			account.setActived(0);
		}
		else {
			account.setActived(1);
		}
		accountDao.update(account);
		return "redirect:dsuser";
	}
}
