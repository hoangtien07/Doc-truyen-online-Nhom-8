package com.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.LoaiTruyenDao;
import com.web.dao.TruyenDao;

@Controller
public class HomeController {
	
	@Autowired
	private LoaiTruyenDao loaiTruyenDao;

	@Autowired
	private TruyenDao truyenDao;
	
    @RequestMapping(value = {"/","trang-chu"},method = RequestMethod.GET)
    public ModelAndView home(Model model,@RequestParam(value = "q", required = false) String param, @RequestParam(value = "id", required = false) String id){
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("listLoaiTruyen", loaiTruyenDao.findAll());
        model.addAttribute("listTruyen", truyenDao.findAllSet());
        if(id != null) {
        	model.addAttribute("listTruyen", truyenDao.findByLoaiTruyen(Long.valueOf(id)));
        }
        if(param != null) {
        	model.addAttribute("listTruyen", truyenDao.search(param));
        }
        return modelAndView;
    }
}
