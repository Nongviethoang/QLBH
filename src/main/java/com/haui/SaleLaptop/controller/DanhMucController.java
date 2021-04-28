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
import org.springframework.web.bind.annotation.RequestParam;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.reponsitory.DanhMucRepository;
import com.haui.SaleLaptop.services.DanhMucServices;

@Controller
public class DanhMucController {
	@Autowired
	private DanhMucRepository danhMucRepo;
	@Autowired
	private DanhMucServices danhMucService;
	@RequestMapping(value = {"/admin1/danhmuc"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO page=new BaseDTO();
		page.buildPaging(request);
		List<DanhMucEntity> list=danhMucService.phanTrang(page);
		model.addAttribute("listDanhMuc", list);
		model.addAttribute("page", page);
	return "admin/DanhMuc";
	}
	//Thêm danh mục
	@RequestMapping(value = {"/admin1/danhmuc/themdanhmuc"}, method = RequestMethod.GET)
	public String addDanhMucGet(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("danhmuc", new DanhMucEntity());
		List<DanhMucEntity> listDanhMuc=danhMucRepo.findAll();
		model.addAttribute("listDanhMuc", listDanhMuc);
		
	return "admin/ThemDanhMuc";
	}
	@RequestMapping(value = {"/admin1/danhmuc/themdanhmuc"}, method = RequestMethod.POST)
	public String addDanhMucPost(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("danhmuc") DanhMucEntity danhMuc)
			throws Exception {
		danhMuc.setSeo("DM-"+System.currentTimeMillis());
		danhMucRepo.save(danhMuc);
		List<DanhMucEntity> listDanhMuc=danhMucRepo.findAll();
		model.addAttribute("listDanhMuc", listDanhMuc);
		
	return "redirect:/admin1/danhmuc";
	}
	//Sửa danh  mục
		@RequestMapping(value = { "/admin1/danhmuc/edit/{id}" }, method = RequestMethod.GET)
		public String edit(final ModelMap model, final HttpServletRequest request,
				final HttpServletResponse response, @PathVariable("id") int productId) throws Exception {
			model.addAttribute("danhmuc", danhMucRepo.findById(productId).get());
			model.addAttribute("listDanhMuc", danhMucRepo.findAll());
			return "admin/ThemDanhMuc";
		}
		//Xóa
		@RequestMapping(value = { "/admin1/danhmuc/delete/{id}" }, method = RequestMethod.GET)
		public String delete(final ModelMap model, final HttpServletRequest request,
				final HttpServletResponse response, @PathVariable("id") int id) throws Exception {
			DanhMucEntity  danhMucXoa= danhMucRepo.findById(id).get();
			danhMucRepo.delete(danhMucXoa);
			return "redirect:/admin1/danhmuc";

		}
}
