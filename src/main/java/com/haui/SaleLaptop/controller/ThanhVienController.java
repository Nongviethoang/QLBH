package com.haui.SaleLaptop.controller;

import java.util.ArrayList;
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
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.entities.QuyenEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.ChiTietDonHangRepository;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;
import com.haui.SaleLaptop.reponsitory.QuyenRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.reponsitory.ThanhVienRepository;
import com.haui.SaleLaptop.services.ChiTietHoaDonServices;
import com.haui.SaleLaptop.services.DonHangService;
import com.haui.SaleLaptop.services.ThanhVienService;

@Controller
public class ThanhVienController {
	@Autowired
	ThanhVienRepository thanhVienRepo;
	@Autowired
	QuyenRepository quyenRepo;
	@Autowired
	DonHangRepository donHangRepo;
	@Autowired
	ChiTietDonHangRepository ctRepo;
	@Autowired
	DonHangService donHangService;
	@Autowired
	ChiTietHoaDonServices chiTietSer;
	@Autowired
	ThanhVienService thanhVienService;
	@Autowired
	SanPhamRepository sanPhamRepo;
	@RequestMapping(value = { "/admin1/thanhvien" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO dto = new BaseDTO();
		dto.buildPaging(request);
		List<ThanhVienEntity> thanhViens = thanhVienService.phanTrang(dto);
		model.addAttribute("page", dto);
		model.addAttribute("thanhvien", thanhViens);
		return "admin/ThanhVien";
	}

	@RequestMapping(value = { "/admin1/xoathanhvien/{id}" }, method = RequestMethod.GET)
	public String del(final ModelMap model, @PathVariable("id") int id, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		List<QuyenEntity> listQuyen = quyenRepo.findAll();
		ThanhVienEntity thanhVien = thanhVienRepo.getOne(id);
		for (int i = 0; i < thanhVien.getQuyens().size(); i++) {
			if (thanhVien.getQuyens().get(i).getTenQuyen().equalsIgnoreCase("ADMIN")) {
				return "redirect:/admin1/thanhvien";
			}
		}
		thanhVienRepo.delete(thanhVien);
		List<ThanhVienEntity> thanhVienEntities = thanhVienRepo.findAll();
		model.addAttribute("thanhvien", thanhVienEntities);
		return "redirect:/admin1/thanhvien";
	}

	// Sửa quyền
	@RequestMapping(value = { "/admin1/thanhvien/sua/{id}" }, method = RequestMethod.GET)
	public String edit(final ModelMap model, @PathVariable("id") int id, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		ThanhVienEntity thanhVien = thanhVienRepo.findById(id).get();
		model.addAttribute("user", thanhVien);
		List<QuyenEntity> quyens = quyenRepo.findAll();
		model.addAttribute("quyen", quyens);
		return "admin/suaquyen";
	}

	// Sửa quyền
	@RequestMapping(value = { "/admin1/thanhvien/sua" }, method = RequestMethod.POST)
	public String editRole(final ModelMap model, @ModelAttribute("user") ThanhVienEntity user,
			final HttpServletRequest request, final HttpServletResponse response) throws Exception {

		user.setUpdateDate(new Date());
		thanhVienRepo.save(user);
		return "redirect:/admin1/thanhvien";
	}

	// sửa thông tin
	@RequestMapping(value = { "/chinhsua/{id}" }, method = RequestMethod.GET)
	public String suaThongTin(final ModelMap model, @PathVariable("id") int id, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		System.out.println(id);
		ThanhVienEntity thanhVienEntity = thanhVienRepo.findById(id).get();
		model.addAttribute("tv", thanhVienEntity);
		return "user/ChinhSuaThongTin";
	}

	@RequestMapping(value = { "/suathongtin" }, method = RequestMethod.POST)
	public String suaThongTin(final ModelMap model, @ModelAttribute("tv") ThanhVienEntity tv,
			final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		tv.setUpdateDate(new Date());
//		List<QuyenEntity> quyens=quyenRepo.findAll();
//		List<QuyenEntity> quyenUser=new ArrayList<QuyenEntity>();
//		List<QuyenEntity> quyenAdmin=new ArrayList<QuyenEntity>();
//		for (QuyenEntity quyenEntity : quyens) {
//			if(quyenEntity.getTenQuyen().equalsIgnoreCase("User"))
//			{	
//				quyenUser.add(quyenEntity);
//			}
//			else
//			{
//				quyenAdmin.add(quyenEntity);
//			}
//		}
		System.out.println("Taapj quyen"+tv.getQuyens().size());
		thanhVienRepo.save(tv);
		model.addAttribute("user", tv);
		return "redirect:/";
	}
	@RequestMapping(value = { "/luuQuyen/{id}" }, method = RequestMethod.GET)
	public String luuQuyen(final ModelMap model, @PathVariable("id") int id,
			final HttpServletRequest request, final HttpServletResponse response) throws Exception {
		List<QuyenEntity> quyens=quyenRepo.findAll();
		List<QuyenEntity> quyenUser=new ArrayList<QuyenEntity>();
		List<QuyenEntity> quyenAdmin=new ArrayList<QuyenEntity>();
		for (QuyenEntity quyenEntity : quyens) {
			if(quyenEntity.getTenQuyen().equalsIgnoreCase("User"))
			{	
				quyenUser.add(quyenEntity);
			}
			else
			{
				quyenAdmin.add(quyenEntity);
			}
		}
		ThanhVienEntity tv=thanhVienRepo.getOne(id);
//		if(tv.getQuyens().size()==0)
//		{
//			tv.setQuyens(quyenUser);
//		}
		thanhVienRepo.save(tv);
	return "redirect:/";
	}
	// Thông tin đơn hàng
	@RequestMapping(value = { "/donmua/{id}" }, method = RequestMethod.GET)
	public String donMua(final ModelMap model, @PathVariable("id") int id, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		ThanhVienEntity thanhVien = thanhVienRepo.findById(id).get();
		List<DonHangEntity> listDon = donHangService.layDonHangCuaKhach(id);
		List<DonHangEntity> lichSuMua = new ArrayList<>();
		for (int i = listDon.size()-1; i >=0; i--) {
			lichSuMua.add(listDon.get(i));
		}
		model.addAttribute("donhang", lichSuMua);
		return "user/DonMua";
	}

	// khách hàng nhận được hàng
	@RequestMapping(value = { "/donhang/dagiao/{id}" }, method = RequestMethod.GET)
	public String shipped(final ModelMap model, @PathVariable("id") int id, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		DonHangEntity dh = donHangRepo.getOne(id);
		dh.setTrangThai(4);
		donHangRepo.save(dh);
		System.out.println(dh.toString());
		ThanhVienEntity tv = (ThanhVienEntity) request.getSession().getAttribute("user");
		return "redirect:/donmua/" + tv.getId() + "";
	}
	
	@RequestMapping(value = { "/thongtin" }, method = RequestMethod.GET)
	public String infor(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		return "user/ThongTin";
	}
	//Hủy don hang
		@RequestMapping(value = {"/huydonhang/{id}"}, method = RequestMethod.GET)
		public String delBill(final ModelMap model,@PathVariable("id") int id, final HttpServletRequest request, final HttpServletResponse response)
				throws Exception {
			DonHangEntity donHangEntity=donHangRepo.getOne(id);
			donHangEntity.setTrangThai(5);
			List<ChiTietEntity> listChiTiet=chiTietSer.getAllById(id);
			for (ChiTietEntity chiTietEntity : listChiTiet) {
				SanPhamEntity sp=sanPhamRepo.getOne(chiTietEntity.getSanPhams().getId());
				sp.setSoLuong(chiTietEntity.getSoLuong()+sp.getSoLuong());
				sp.setSoLanMua(sp.getSoLanMua()-1);
				if(sp.getSoLanMua()<0)
				{
					sp.setSoLanMua(0);
				}
				sp.setSoLuongBan(sp.getSoLuongBan()-chiTietEntity.getSoLuong());
				
				if(sp.getSoLuongBan()<0)
				{
					sp.setSoLuongBan(0);
				}
				
				sanPhamRepo.save(sp);
				
			}
			
		
			ThanhVienEntity tv=(ThanhVienEntity)request.getSession().getAttribute("user");
			donHangRepo.save(donHangEntity);
			return "redirect:/donmua/" + tv.getId() + "";
		}
}
