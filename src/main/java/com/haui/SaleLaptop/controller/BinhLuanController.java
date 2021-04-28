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
import com.haui.SaleLaptop.entities.BinhLuanEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.BinhLuanRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.services.BinhLuanService;

@Controller
public class BinhLuanController {
	@Autowired
	private BinhLuanRepository binhLuanRepo;
	@Autowired
	private SanPhamRepository sanPhamRepo;
	@Autowired
	private BinhLuanService binhLuanService;

	@RequestMapping(value = { "/admin1/binhluan" }, method = RequestMethod.GET)
	public String binhLuan(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO dto=new BaseDTO();
		dto.buildPaging(request);
		List<BinhLuanEntity> listBinhLuan = binhLuanService.phanTrang(dto);
		model.addAttribute("listBinhLuan", listBinhLuan);
		model.addAttribute("page", dto);
		
		return "admin/BinhLuan";
	}

	// xoas binh luan
	@RequestMapping(value = { "/admin1/xoabinhluan/{id}" }, method = RequestMethod.GET)
	public String delBinhLuan(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		BinhLuanEntity binhLuanEntity = binhLuanRepo.findById(id).get();
		binhLuanRepo.delete(binhLuanEntity);
		List<BinhLuanEntity> listBinhLuan = binhLuanRepo.findAll();
		model.addAttribute("listBinhLuan", listBinhLuan);
		return "admin/BinhLuan";
	}

	// them binh luan
	@RequestMapping(value = { "/binhluansp/{idsp}" }, method = RequestMethod.POST)
	public String addBinhLuan(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response, @PathVariable("idsp") int id,
			@ModelAttribute("binhluan") BinhLuanEntity cmt) throws Exception {

		ThanhVienEntity tvht = (ThanhVienEntity) request.getSession().getAttribute("user");

		System.out.println("aa" + tvht.getId());
		cmt.setCreateBy(tvht.getId());
		cmt.setCreateDate(new Date());
		cmt.setSanPhams(sanPhamRepo.findById(id).get());
		cmt.setThanhViens(tvht);
		cmt.setThoiGian(new Date());
		binhLuanRepo.save(cmt);
		return "redirect:/sanphamchitiet/" + id + "";
	}

}
