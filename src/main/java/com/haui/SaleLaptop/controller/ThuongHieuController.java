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

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.ThuongHieuEntity;
import com.haui.SaleLaptop.reponsitory.ThuongHieuRepository;
import com.haui.SaleLaptop.services.ThuongHieuService;

@Controller
public class ThuongHieuController {
@Autowired
ThuongHieuRepository thuongHieuRepo;
@Autowired
ThuongHieuService thuongHieuService;
@RequestMapping(value = {"/admin1/thuonghieu"}, method = RequestMethod.GET)
public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
		throws Exception {
	BaseDTO page=new BaseDTO();
	page.buildPaging(request);
	List<ThuongHieuEntity> list=thuongHieuService.phanTrang(page);
	model.addAttribute("listThuongHieu", list);
	model.addAttribute("page", page);
return "admin/ThuongHieu";
}
//Thêm thương hiệu
@RequestMapping(value = {"/admin1/thuonghieu/themthuonghieu"}, method = RequestMethod.GET)
public String addDanhMucGet(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
		throws Exception {
	model.addAttribute("thuonghieu", new ThuongHieuEntity());
	
return "admin/ThemThuongHieu";
}
@RequestMapping(value = {"/admin1/thuonghieu/themthuonghieu"}, method = RequestMethod.POST)
public String addDanhMucPost(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
		@ModelAttribute("thuonghieu") ThuongHieuEntity thuongHieu)
		throws Exception {
	thuongHieu.setCreateDate(new Date());
	thuongHieuRepo.save(thuongHieu);
	List<ThuongHieuEntity> listThuongHieu=thuongHieuRepo.findAll();
	model.addAttribute("listThuongHieu", listThuongHieu);
	
return "redirect:/admin1/thuonghieu";
}
//Sửa thương hiệu
	@RequestMapping(value = { "/admin1/thuonghieu/edit/{id}" }, method = RequestMethod.GET)
	public String edit(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		model.addAttribute("thuonghieu", thuongHieuRepo.findById(id).get());
		model.addAttribute("listThuongHieu", thuongHieuRepo.findAll());
		return "admin/ThemThuongHieu";
	}
	//Xóa
	@RequestMapping(value = { "/admin1/thuonghieu/delete/{id}" }, method = RequestMethod.GET)
	public String delete(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		thuongHieuRepo.delete(thuongHieuRepo.findById(id).get());
		return "redirect:/admin1/thuonghieu";

	}
	
}
