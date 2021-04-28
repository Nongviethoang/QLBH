package com.haui.SaleLaptop.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.entities.ChiTietEntity;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.reponsitory.ChiTietDonHangRepository;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;

@Controller
public class ChiTietDonHangController {
	@Autowired
	private ChiTietDonHangRepository chiTietRepo;
	@Autowired
	private DonHangRepository donHangRepo;
	@RequestMapping(value = {"/admin1/chitetdonhang/{id}"}, method = RequestMethod.GET)
	public String index(final ModelMap model,@PathVariable("id") int id, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<ChiTietEntity> listChiTiet=chiTietRepo.findAll();
		model.addAttribute("listChiTiet", listChiTiet);
	return "admin/ChiTietDonHang";
	}
	
}
