package com.haui.SaleLaptop.controller;

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

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.QuyenEntity;
import com.haui.SaleLaptop.reponsitory.QuyenRepository;
import com.haui.SaleLaptop.services.QuyenService;

@Controller
public class QuyenController {
	@Autowired 
	QuyenRepository quyenRepo;
	@Autowired
	QuyenService quyenService;
	@RequestMapping(value = {"/admin1/quyen"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO dto=new BaseDTO();
		dto.buildPaging(request);
		List<QuyenEntity>quyens=quyenService.phanTrang(dto);
		model.addAttribute("page", dto);
		model.addAttribute("quyens", quyens);
	return "admin/Quyen";
	}
	//them quyen
	@RequestMapping(value = {"/admin1/quyen/themquyen"}, method = RequestMethod.GET)
	public String addQuyenGet(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("quyen", new QuyenEntity());
		List<QuyenEntity> quyens=quyenRepo.findAll();
		model.addAttribute("quyens", quyens);
	return "admin/ThemQuyen";
	}
	
	@RequestMapping(value = {"/admin1/quyen/themquyen"}, method = RequestMethod.POST)
	public String addQuyenPost(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("quyen") QuyenEntity quyen)
			throws Exception {
		quyenRepo.save(quyen);
		List<QuyenEntity> quyens=quyenRepo.findAll();
		model.addAttribute("quyens", quyens);
	return "redirect:/admin1/quyen";
	}
	//suawr quyen
	@RequestMapping(value = {"/admin1/quyen/suaquyen/{id}"}, method = RequestMethod.GET)
	public String suaQuyen(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("id") int id)
			throws Exception {
		QuyenEntity quyenEntity=quyenRepo.findById(id).get();
		model.addAttribute("quyen", quyenEntity);
		List<QuyenEntity> quyens=quyenRepo.findAll();
		model.addAttribute("quyens", quyens);
	return "admin/ThemQuyen";
	}
	//xoa quyen
		@RequestMapping(value = {"/admin1/quyen/xoaquyen/{id}"}, method = RequestMethod.GET)
		public String xoaQuyen(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
				@PathVariable("id") int id)
				throws Exception {
			QuyenEntity quyenEntity=quyenRepo.findById(id).get();
			quyenRepo.delete(quyenEntity);
			List<QuyenEntity> quyens=quyenRepo.findAll();
			model.addAttribute("quyens", quyens);
		return "redirect:/admin1/quyen";
		}
	
}
