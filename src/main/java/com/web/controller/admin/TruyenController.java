package com.web.controller.admin;

import java.io.IOException;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.web.cloud.FileUpload;
import com.web.dao.LoaiTruyenDao;
import com.web.dao.TruyenDao;
import com.web.entity.LoaiTruyen;
import com.web.entity.Truyen;

@Controller
public class TruyenController {

	@Autowired
	private LoaiTruyenDao loaiTruyenDao;

	@Autowired
	private TruyenDao truyenDao;

	@RequestMapping(value = { "/admin", "/admin/trang-chu" }, method = RequestMethod.GET)
	public ModelAndView home(Model model) {
		ModelAndView modelAndView = new ModelAndView("admin/index");
		model.addAttribute("listTruyen", truyenDao.findAll());
		return modelAndView;
	}

	@RequestMapping(value = { "/admin/addtruyen" }, method = RequestMethod.GET)
	public ModelAndView addView(Model model, @RequestParam(value="id", required = false) String id) {
		ModelAndView modelAndView = new ModelAndView("admin/addtruyen");
		model.addAttribute("listLoaiTruyen", loaiTruyenDao.findAll());
		model.addAttribute("truyen", new Truyen());
		if (id != null) {
			model.addAttribute("truyen", truyenDao.findById(Long.valueOf(id)));
		}
		return modelAndView;
	}

	@RequestMapping(value = { "/admin/posttruyen" }, method = RequestMethod.POST)
	public String post(@ModelAttribute Truyen truyen, @RequestParam("loaitruyen") String loaiTruyen,
			@RequestPart(value = "file") MultipartFile filePart) throws IOException {
		String image ="";
		if(filePart.isEmpty() == false) {
			image = FileUpload.upload(filePart);
		}
		LoaiTruyen loaiTruyen2 = loaiTruyenDao.findById(Long.valueOf(loaiTruyen));
		truyen.setLoaiTruyen(loaiTruyen2);
		if(truyen.getId() == null) {
			truyen.setCreatedDate(new Date(System.currentTimeMillis()));
			truyen.setAnh(image);
			truyenDao.save(truyen);
		}
		else {
			Truyen truyen2 = truyenDao.findById(truyen.getId());
			truyen.setCreatedDate(truyen2.getCreatedDate());
			if(image.equals("")) {
				truyen.setAnh(truyen2.getAnh());
			}
			else {
				truyen.setAnh(image);
			}
			truyenDao.update(truyen);
		}
		
		return "redirect: trang-chu";
	}
	
	@RequestMapping(value = { "/admin/deleteTruyen" }, method = RequestMethod.GET)
	public String delete(@RequestParam(value="id") String id) {
		Truyen truyen2 = truyenDao.findById(Long.valueOf(id));
		truyenDao.delete(truyen2);
		return "redirect: trang-chu";
	}
}
