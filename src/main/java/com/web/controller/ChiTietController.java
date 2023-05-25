package com.web.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.dao.LoaiTruyenDao;
import com.web.dao.TruyenDao;
import com.web.entity.Truyen;

@Controller
public class ChiTietController {

	@Autowired
	private LoaiTruyenDao loaiTruyenDao;

	@Autowired
	private TruyenDao truyenDao;

	@RequestMapping(value = {"chitiet" }, method = RequestMethod.GET)
	public ModelAndView homeChiTiet(Model model, @RequestParam(value = "id") String id) {
		Truyen truyen = truyenDao.findById(Long.valueOf(id));
		ModelAndView modelAndView = new ModelAndView("chitiet");
		
		model.addAttribute("listLoaiTruyen", loaiTruyenDao.findAll());
		model.addAttribute("truyen", truyen);
		
		List<Truyen> list = truyenDao.findByName(truyen.getTen());
		Set<Truyen> set = truyenDao.findByLoaiTruyen(truyen.getLoaiTruyen().getId());
		if(list.size() == 0) {
			model.addAttribute("listTruyen", set);
		}
		else {
			model.addAttribute("listTruyen", list);
		}
		return modelAndView;
	}
}
