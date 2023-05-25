package com.web.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.AccountDao;
import com.web.entity.Account;
import com.web.entity.UserRole;

@Controller
@MultipartConfig
public class RegisController {

	@Autowired
	private AccountDao accountDao;

	@RequestMapping(value = { "confirm" }, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("confirm");

		return modelAndView;
	}

	@RequestMapping(value = { "/regis" }, method = RequestMethod.POST)
	public String loginAndSignOut(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
		String username = req.getParameter("username");
		String fullname = req.getParameter("fullname");
		String email = req.getParameter("email");
		String password = req.getParameter("password");

		Account account = new Account(fullname, null, username, password, email, 1, null,
				new Timestamp(System.currentTimeMillis()));
		try {
			Account acc = accountDao.save(account);
			UserRole userRole = new UserRole();
			userRole.setAccount(acc);
			userRole.setUserRole("USER");
			accountDao.saveRole(userRole);
		} catch (Exception e) {
			return "redirect:regis?error=1";
		}

		return "redirect:login";
	}

}
