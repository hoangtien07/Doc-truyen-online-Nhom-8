package com.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.AccountDao;
import com.web.dao.LoaiTruyenDao;
import com.web.dao.LuuTruyenDao;
import com.web.dao.TruyenDao;
import com.web.entity.Account;
import com.web.entity.LuuTruyen;
import com.web.entity.Truyen;

@Controller
public class LuuTruyenController {

	@Autowired
	private LoaiTruyenDao loaiTruyenDao;

	@Autowired
	private TruyenDao truyenDao;

	@Autowired
	private AccountDao accountDao;

	@Autowired
	private LuuTruyenDao luuTruyenDao;

	@RequestMapping(value = { "truyendaluu" }, method = RequestMethod.GET)
	public ModelAndView home(Model model, @RequestParam(value = "id", required = false) String id) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Account account = accountDao.findByUsername(currentPrincipalName);
		ModelAndView modelAndView = new ModelAndView("truyendaluu");
		model.addAttribute("listLoaiTruyen", loaiTruyenDao.findAll());
		model.addAttribute("listTruyenDaLuu", luuTruyenDao.findByUser(account.getId()));
		return modelAndView;
	}

	@RequestMapping(value = { "luuTruyen" }, method = RequestMethod.GET)
	public String luuTruyen(@RequestParam(value = "id") String id, HttpServletRequest request) {
		Truyen truyen = truyenDao.findById(Long.valueOf(id));
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String currentPrincipalName = authentication.getName();
		Account account = accountDao.findByUsername(currentPrincipalName);
		LuuTruyen luuTruyen = new LuuTruyen();
		luuTruyen.setAccount(account);
		luuTruyen.setTruyen(truyen);
		luuTruyenDao.save(luuTruyen);
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
	
	@RequestMapping(value = { "huyluuTruyen" }, method = RequestMethod.GET)
	public String huyLuuTruyen(@RequestParam(value = "id") String id, HttpServletRequest request) {
		luuTruyenDao.delete(luuTruyenDao.findById(Long.valueOf(id)));
		String referer = request.getHeader("Referer");
		return "redirect:" + referer;
	}
}
