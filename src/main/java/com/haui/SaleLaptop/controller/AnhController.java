package com.haui.SaleLaptop.controller;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.aspectj.apache.bcel.classfile.Field;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.haui.SaleLaptop.Constaint;
import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.AnhRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.services.AnhService;
import com.haui.SaleLaptop.services.SanPhamService;
@Controller
public class AnhController implements Constaint {
	@Autowired
	AnhRepository anhRepository;
	@Autowired
	AnhService anhService;
	@Autowired
	SanPhamRepository sanPhamRepository;
	@Autowired
	SanPhamService sanPhamService;

	@RequestMapping(value = { "/admin1/anhsanpham" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productImage = new BaseDTO();
		productImage.buildPaging(request);
		List<AnhSanPhamEntity> list = anhService.phanTrang(productImage);
		model.addAttribute("listAnh", list);
		model.addAttribute("productSearch", productImage);
		return "admin/AnhSanPham";
	}

//thêm ảnh sản phẩm
	@RequestMapping(value = { "/admin1/anhsanpham/themanh" }, method = RequestMethod.GET)
	public String addImage(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("anh", new AnhSanPhamEntity());
		List<SanPhamEntity> listSanPham = sanPhamRepository.findAll();
		model.addAttribute("listSP", listSanPham);
		return "admin/ThemAnh";
	}

	@RequestMapping(value = { "/admin1/anhsanpham/themanh" }, method = RequestMethod.POST)
	public String add(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("anh") AnhSanPhamEntity anh, @RequestParam("productAvatar") MultipartFile productAvatar)
			throws Exception {
		anhService.saveOrUpdate(anh, productAvatar);
		List<SanPhamEntity> listSanPham = sanPhamRepository.findAll();
		model.addAttribute("listSP", listSanPham);
		return "redirect:/admin1/anhsanpham";
	}

//sửa ảnh
	@RequestMapping(value = { "/admin1/anhsanpham/edit/{id}" }, method = RequestMethod.GET)
	public String editProduct_Get(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response, @PathVariable("id") int id) throws Exception {
		AnhSanPhamEntity anh = anhRepository.getOne(id);
		ThanhVienEntity admin = (ThanhVienEntity) request.getSession().getAttribute("user");
		anh.setUpdateBy(admin.getId());
		model.addAttribute("anh", anh);
		model.addAttribute("listSP", sanPhamRepository.findAll());
		return "admin/ThemAnh";
	}

//xóa ảnh sản phẩm
	@RequestMapping(value = { "/admin1/anhsanpham/delete/{id}" }, method = RequestMethod.GET)
	public String delete(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("id") int id) throws Exception {
		AnhSanPhamEntity anh = anhRepository.getOne(id);
		new File(ROOT_UPDATE_PATH+anh.getPath()).delete();
		anhRepository.delete(anh);
		return "redirect:/admin1/anhsanpham";
	}
	
}
