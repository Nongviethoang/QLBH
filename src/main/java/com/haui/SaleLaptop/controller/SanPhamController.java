package com.haui.SaleLaptop.controller;

import java.io.File;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.haui.SaleLaptop.Constaint;
import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.AnhRepository;
import com.haui.SaleLaptop.reponsitory.DanhMucRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.reponsitory.ThuongHieuRepository;
import com.haui.SaleLaptop.services.AnhService;
import com.haui.SaleLaptop.services.SanPhamService;

@Controller
public class SanPhamController implements Constaint {
	@Autowired
	private SanPhamRepository sanPhamRepo;
	@Autowired
	private DanhMucRepository danhMucRepo;
	@Autowired
	private SanPhamService sanPhamService;
	@Autowired
	ThuongHieuRepository thuongHieuRepo;
	@Autowired
	AnhService anhService;
	@Autowired
	AnhRepository anhRepo;
	@RequestMapping(value = {"/admin1/sanpham"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch=new BaseDTO();
		productSearch.buildPaging(request);
		List<SanPhamEntity> list=sanPhamService.search(productSearch);
		int tongSanPham=0;
	//List<SanPhamEntity> listSanPham=sanPhamRepo.findAll();
	for (SanPhamEntity sanPhamEntity : list) {
		tongSanPham+=sanPhamEntity.getSoLuong();
	}
	model.addAttribute("tongSP", tongSanPham);
	model.addAttribute("listSP", list);
	model.addAttribute("productSearch", productSearch);
	return "admin/SanPham";
	}
	
	//thêm sản phẩm
	@RequestMapping(value = {"/admin1/sanpham/themsanpham"}, method = RequestMethod.GET)
	public String add1(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("sanpham", new SanPhamEntity());
		List<DanhMucEntity> listDanhMuc=danhMucRepo.findAll();
		model.addAttribute("listDanhMuc", listDanhMuc);
		model.addAttribute("listThuongHieu", thuongHieuRepo.findAll());
	return "admin/ThemSanPham";
	}
	@RequestMapping(value = {"/admin1/sanpham/themsanpham"}, method = RequestMethod.POST)
	public String add(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@ModelAttribute("sanpham") SanPhamEntity sanPham
			)
			throws Exception {
		sanPham.setSeo("MT-" + System.currentTimeMillis());
		sanPham.setCreateDate(new Date());
		float giamGia=100 - (float)(sanPham.getGia().intValue())/(sanPham.getGiaGoc().intValue()/100);
		sanPham.setPhanTramGiam((int)giamGia);
		sanPhamRepo.save(sanPham);
		List<DanhMucEntity> listDanhMuc=danhMucRepo.findAll();//lấy danh sách tất cả các categories
		model.addAttribute("listDanhMuc",listDanhMuc);
		model.addAttribute("listThuongHieu", thuongHieuRepo.findAll());
	return "redirect:/admin1/sanpham";
	}
	//sửa
		@RequestMapping(value = { "/admin1/sanpham/edit/{id}" }, method = RequestMethod.GET)
		public String editProduct_Get(final ModelMap model, final HttpServletRequest request,
				final HttpServletResponse response, @PathVariable("id") int productId) throws Exception {
			SanPhamEntity product=sanPhamRepo.getOne(productId);
			ThanhVienEntity admin=(ThanhVienEntity)request.getSession().getAttribute("user");
			product.setUpdateBy(admin.getId());
			product.setUpdateDate(new Date());
			model.addAttribute("sanpham",product);
			model.addAttribute("listThuongHieu", thuongHieuRepo.findAll());
			model.addAttribute("listDanhMuc", danhMucRepo.findAll());
			return "admin/ThemSanPham";
		}
	//xóa sản phẩm
	@RequestMapping(value = {"/admin1/sanpham/delete/{id}"}, method = RequestMethod.GET)
	public String delete(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("id") int id)
			throws Exception {
		SanPhamEntity sanPhamXoa=sanPhamRepo.findById(id).get();
		for (AnhSanPhamEntity	anh:sanPhamXoa.getAnhs()) {
			new File(ROOT_UPDATE_PATH+anh.getPath()).delete();
		}
		sanPhamRepo.delete(sanPhamXoa);
	return "redirect:/admin1/sanpham";
	}
	//Xem chi tiet
			@RequestMapping(value = { "/admin1/sanpham/xemchitiet/{id}" }, method = RequestMethod.GET)
			public String viewProduct(final ModelMap model, final HttpServletRequest request,
					final HttpServletResponse response, @PathVariable("id") int productId) throws Exception {
				model.addAttribute("sanpham", sanPhamRepo.findById(productId).get());
				model.addAttribute("listImage",anhService.anhSp(productId) );
				return "admin/ChiTietSanPham";
			}
}
