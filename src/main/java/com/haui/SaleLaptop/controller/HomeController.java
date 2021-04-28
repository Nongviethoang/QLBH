package com.haui.SaleLaptop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.reponsitory.ThanhVienRepository;
import com.haui.SaleLaptop.services.AnhService;
import com.haui.SaleLaptop.services.DonHangService;
import com.haui.SaleLaptop.services.SanPhamService;
import com.ibm.icu.math.BigDecimal;

@Controller
public class HomeController {
	@Autowired
	SanPhamRepository sanPhamRepo;
	@Autowired
	DonHangRepository donHangRepo;
	@Autowired
	ThanhVienRepository thanhVienRepo;
	@Autowired
	DonHangService donHangService;
	@Autowired
	SanPhamService sanPhamService;
	@Autowired
	AnhService anhService;

	@RequestMapping(value = { "/admin1" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		
		int thanhVien = 0;
		int donHang = 0;
		double doanhThu = 0;
		int soLuongSp = 0;
		List<SanPhamEntity> sanPhamEntity = sanPhamRepo.findAll();
		for (SanPhamEntity sp : sanPhamEntity) {
			soLuongSp += sp.getSoLuong();
		}
		List<DonHangEntity> donHangs = donHangRepo.findAll();
		for (DonHangEntity dh : donHangs) {
			if (dh.getTrangThai() == 4) {
				doanhThu += dh.getTongTien().doubleValue();
				donHang++;
			}
		}
		model.addAttribute("thanhVien", thanhVienRepo.findAll().size());
		model.addAttribute("donHang", donHang);
		model.addAttribute("soLuongSp", soLuongSp);
		model.addAttribute("doanhThu", doanhThu);
		
		return "admin/TrangChu";
	}
	@RequestMapping(value = { "/admin1/thongke" }, method = RequestMethod.GET)
	public String thongKe(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		
		int thanhVien = 0;
		int donHang = 0;
		double doanhThu = 0;
		int soLuongSp = 0;
		List<SanPhamEntity> sanPhamEntity = sanPhamRepo.findAll();
		for (SanPhamEntity sp : sanPhamEntity) {
			soLuongSp += sp.getSoLuong();
		}
		List<DonHangEntity> donHangs = donHangRepo.findAll();
		for (DonHangEntity dh : donHangs) {
			if (dh.getTrangThai() == 4) {
				doanhThu += dh.getTongTien().doubleValue();
				donHang++;
			}
		}
		model.addAttribute("thanhVien", thanhVienRepo.findAll().size());
		model.addAttribute("donHang", donHang);
		model.addAttribute("soLuongSp", soLuongSp);
		model.addAttribute("doanhThu", doanhThu);
		List<DonHangEntity> dhThangNay = donHangService.layDonHangThangHienTai();
		int donGiao = 0;
		int tongDon = 0;
		double doanhThuThang = 0;
		int donHuy = 0;
		int spTon = 0;
		int spBan = 0;
		String spHot = "";
		for (DonHangEntity donHangEntity : dhThangNay) {
			if (donHangEntity.getTrangThai() == 5) {
				donHuy++;
			}
			if (donHangEntity.getTrangThai() == 4) {
				donGiao++;
				doanhThuThang += donHangEntity.getTongTien().doubleValue();
			}
			tongDon++;

		}
		List<SanPhamEntity> spThang = sanPhamService.laySanPhamThangHienTai();

		int max = 0;
		for (SanPhamEntity sp : spThang) {
			spTon += sp.getSoLuong();
			spBan += sp.getSoLuongBan();
			if (sp.getSoLanMua() > max) {
				max = sp.getSoLanMua();
			}
		}
		for (SanPhamEntity spMax : spThang) {
			if (spMax.getSoLanMua() == max) {
				spHot = spMax.getTenSanPham();
			}
		}

		model.addAttribute("tongdon", tongDon);
		model.addAttribute("dongiao", donGiao);
		model.addAttribute("donhuy", donHuy);
		model.addAttribute("doanhthuthang", doanhThuThang);
		model.addAttribute("hangton", spTon);
		model.addAttribute("hangban", spBan);
		model.addAttribute("hanghot", spHot);
		String spHotTime = "";
		 int donGiaoTime=0;
		 int tongDonTime=0;
		 double doanhThuThangTime=0d;
		 int donHuyTime=0;
		 int spTonTime=0;
		 int spBanTime=0;
		 int maxTime=0;
		if (request.getParameter("start") != null && request.getParameter("end") != null) {
			String start = request.getParameter("start");
			String end = request.getParameter("end");
			if (!start.isEmpty() && !end.isEmpty()) {
				List<DonHangEntity> dhTime = donHangService.layDonHangTheoThoiGian(start, end);
				List<SanPhamEntity> spTime = sanPhamService.laySanPhamTheoThoiGian(start, end);
				for (DonHangEntity dht : dhTime) {
					if (dht.getTrangThai() == 5) {
						donHuyTime++;
					}
					if (dht.getTrangThai() == 4) {
						donGiaoTime++;
						doanhThuThangTime += dht.getTongTien().doubleValue();
					}
					tongDonTime++;
				}
				if(spTime.size()>0)
				{
					for (SanPhamEntity sp : spTime) {
						spTonTime += sp.getSoLuong();
						spBanTime += sp.getSoLuongBan();
						if (sp.getSoLanMua() > maxTime) {
							maxTime = sp.getSoLanMua();
						}
					}
					for (SanPhamEntity spMax : spTime) {
						if (spMax.getSoLanMua() == maxTime) {
							spHotTime = spMax.getTenSanPham();
							
						}
						
					}
				}
				model.addAttribute("tongdont", tongDonTime);
				model.addAttribute("dongiaot", donGiaoTime);
				model.addAttribute("donhuyt", donHuyTime);
				model.addAttribute("doanhthuthangt", doanhThuThangTime);
				model.addAttribute("hangtont", spTonTime);
				model.addAttribute("hangbant", spBanTime);
				model.addAttribute("hanghott", spHotTime);
			}
			model.addAttribute("tongdon", tongDon);
			model.addAttribute("dongiao", donGiao);
			model.addAttribute("donhuy", donHuy);
			model.addAttribute("doanhthuthang", doanhThuThang);
			model.addAttribute("hangton", spTon);
			model.addAttribute("hangban", spBan);
			model.addAttribute("hanghot", spHot);
			
			model.addAttribute("start", start);
			model.addAttribute("end", end);
		}
		return "admin/thongke";
	}
	@RequestMapping(value = { "/admin1/sanphamhot/{name}" }, method = RequestMethod.GET)
	public String hotProduct(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@PathVariable("name") String name)
			throws Exception {
		SanPhamEntity sanPhamHot=sanPhamService.findProductByName(name);
		model.addAttribute("sanpham", sanPhamHot);
		model.addAttribute("listImage",anhService.anhSp(sanPhamHot.getId()));
		return "admin/ChiTietSanPham";
	}
	@RequestMapping(value = { "/admin1/donhang/donhangthang/{status}" }, method = RequestMethod.GET)
	public String orderMonth(final ModelMap model,@PathVariable("status") int status, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO donHangDto=new BaseDTO();
		donHangDto.buildPaging(request);
		donHangDto.setStatus(status);
		List<DonHangEntity> donHang=donHangService.trangThaiThangHienTai(donHangDto);
		model.addAttribute("page", donHangDto);
		model.addAttribute("donHangs",donHang);
		return "admin/DonHang";
	}
	@RequestMapping(value = { "/admin1/donhangthangnay" }, method = RequestMethod.GET)
	public String orderSuccessOnMonth(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO donHang=new BaseDTO();
		donHang.buildPaging(request);
		List<DonHangEntity> dhHuy=donHangService.layDonHangThangHienTai(donHang);
		model.addAttribute("page", donHang);
		model.addAttribute("donHangs",dhHuy);
		System.out.println("Đon hàng huy tháng này"+dhHuy.size());
		
		return "admin/DonHang";
	}
	@RequestMapping(value = { "/admin1/donhangthangloc/{start}/{end}" }, method = RequestMethod.GET)
	public String orderSuccessOnMonthFilter(final ModelMap model,
			@PathVariable("start") String start,@PathVariable("end") String end,final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO donHang=new BaseDTO();
		donHang.buildPaging(request);
		donHang.setStartTime(start);
		donHang.setEndTime(end);
		System.out.println(start+" s"+end);
		List<DonHangEntity> dhHuy=donHangService.layDonHangThangLoc(donHang);
		model.addAttribute("page", donHang);
		model.addAttribute("donHangs",dhHuy);
		return "admin/DonHang";
	}
	@RequestMapping(value = { "/admin1/donhang/donhangthangloc/{status}/{start}/{end}" }, method = RequestMethod.GET)
	public String orderFilter(final ModelMap model,@PathVariable("status") int status,
			@PathVariable("start") String start,@PathVariable("end") String end, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO donHangDto=new BaseDTO();
		donHangDto.buildPaging(request);
		donHangDto.setStatus(status);
		donHangDto.setStartTime(start);
		donHangDto.setEndTime(end);
		System.out.println("thời tian"+start+" = "+end);
		List<DonHangEntity> donHang=donHangService.trangThaiDonHangLoc(donHangDto);
		model.addAttribute("page", donHangDto);
		model.addAttribute("donHangs",donHang);
		return "admin/DonHang";
	}
}
