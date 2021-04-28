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
import com.haui.SaleLaptop.entities.ChiTietEntity;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.ChiTietDonHangRepository;
import com.haui.SaleLaptop.reponsitory.DanhMucRepository;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.services.ChiTietHoaDonServices;
import com.haui.SaleLaptop.services.DonHangService;

@Controller
public class DonHangController {
	@Autowired
	DonHangRepository donHangRepo;
	@Autowired
	ChiTietDonHangRepository chiTietRepo;
	@Autowired
	ChiTietHoaDonServices chiTietSer;
	@Autowired
	DanhMucRepository danhMucRepo;
	@Autowired
	DonHangService donHangService;
	@Autowired
	SanPhamRepository sanPhamRepo;
	@RequestMapping(value = {"/admin1/donhang"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO dto=new BaseDTO();
		dto.buildPaging(request);
		List<DonHangEntity> donHangs=donHangService.phanTrang(dto);
		model.addAttribute("page", dto);
		model.addAttribute("donHangs",donHangs);
	return "admin/DonHang";
	}
	@RequestMapping(value = {"/admin1/donhang/trangthai/{status}"}, method = RequestMethod.GET)
	public String statusOrder(final ModelMap model,@PathVariable("status") int status, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO dto=new BaseDTO();
		dto.buildPaging(request);
		dto.setStatus(status);
		List<DonHangEntity> donHangs=donHangService.trangThai(dto);
		model.addAttribute("page", dto);
		model.addAttribute("donHangs",donHangs);
	return "admin/DonHang";
	}
	//Xem chi tieets
		@RequestMapping(value = {"/admin1/donhang/chitiet/{id}"}, method = RequestMethod.GET)
		public String viewBill(final ModelMap model,@PathVariable("id") int id, final HttpServletRequest request, final HttpServletResponse response)
				throws Exception {
			DonHangEntity donHang=donHangRepo.getOne(id);
			List<ChiTietEntity> listChiTiet=chiTietSer.getAllById(id);
			model.addAttribute("donHang", donHang);
			model.addAttribute("chitiet",listChiTiet);
			model.addAttribute("tinhTrang", donHang.getTrangThai());
		return "admin/ChiTietDonHang";
		}
		
		@RequestMapping(value = {"/admin1/donhang/duyet/{id}"}, method = RequestMethod.GET)
		public String duyet(final ModelMap model,@PathVariable("id") int id, final HttpServletRequest request, final HttpServletResponse response)
				throws Exception {
			DonHangEntity dh=donHangRepo.getOne(id);
			if(request.getParameter("tinhTrang")!=null)
			{
				dh.setTrangThai(Integer.parseInt(request.getParameter("tinhTrang")));
				donHangRepo.save(dh);
			}
			return "redirect:/admin1/donhang/chitiet/"+dh.getId();
		}
		//Hủy don hang
				@RequestMapping(value = {"/admin1/huydonhangadmin/{id}"}, method = RequestMethod.GET)
				public String delBill(final ModelMap model,@PathVariable("id") int id, final HttpServletRequest request, final HttpServletResponse response)
						throws Exception {
					DonHangEntity donHangEntity=donHangRepo.getOne(id);
					donHangEntity.setTrangThai(5);
					List<ChiTietEntity> listChiTiet=chiTietSer.getAllById(id);
					for (ChiTietEntity chiTietEntity : listChiTiet) {
						SanPhamEntity sp=sanPhamRepo.getOne(chiTietEntity.getSanPhams().getId());
						System.out.println("sol"+sp.getSoLuong());
						sp.setSoLuong(chiTietEntity.getSoLuong()+sp.getSoLuong());
						sp.setSoLanMua(sp.getSoLanMua()-1);
						sp.setSoLuongBan(sp.getSoLuongBan()-chiTietEntity.getSoLuong());
						sanPhamRepo.save(sp);
						System.out.println("sos"+sp.getSoLuong());
					}
					System.out.println("Hủy đơn hàng thành công");
					System.out.println(donHangEntity.getTrangThai());
					donHangRepo.save(donHangEntity);
					return "redirect:/admin1/donhang";
				}
}
