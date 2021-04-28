package com.haui.SaleLaptop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.checkerframework.checker.units.qual.m;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.LienHeEntity;
import com.haui.SaleLaptop.reponsitory.LienHeRepository;
import com.haui.SaleLaptop.services.LienHeService;

@Controller
public class LienHeController {
	@Autowired
	LienHeRepository lienHeRepo;
	@Autowired
	LienHeService lienHeService;
	@RequestMapping(value = {"/admin1/lienhe"}, method = RequestMethod.GET)
	public String contact(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO dto=new BaseDTO();
		dto.buildPaging(request);
		
		List<LienHeEntity> list=lienHeService.phanTrang(dto);
		model.addAttribute("page", dto);
		model.addAttribute("lienhe", list);
	return "admin/CauHoi";
	}
	//xoa
	@RequestMapping(value = {"/admin1/xoalienhe/{id}"}, method = RequestMethod.GET)
	public String delete(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("id") int id)
			throws Exception {
		LienHeEntity lienHeEntity=lienHeRepo.findById(id).get();
		lienHeRepo.delete(lienHeEntity);
	return "redirect:/admin1/lienhe";
	}
	
}
