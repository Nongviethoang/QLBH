package com.haui.SaleLaptop.controller.user;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.haui.SaleLaptop.dto.AjaxResponse;
import com.haui.SaleLaptop.dto.GioHang;
import com.haui.SaleLaptop.dto.Hang;
import com.haui.SaleLaptop.entities.ChiTietEntity;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.ChiTietDonHangRepository;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.services.SanPhamService;
import com.ibm.icu.text.DecimalFormat;


@Controller
public class GioHangController {
	@Autowired
	private SanPhamRepository sanPhamRepo;
	@Autowired
	private DonHangRepository donHangRepo;
	@Autowired
	private ChiTietDonHangRepository chiTietDonHangRepo;
	@Autowired
	SanPhamService sanPhamService;
	private int layTongSoHang(final HttpServletRequest request) {
		HttpSession httpSession = request.getSession();
		
		if (httpSession.getAttribute("cart") == null) {
			return 0;
		}
		GioHang cart = (GioHang) httpSession.getAttribute("cart");
		List<Hang> cartItems = cart.getListHang();
		int total = 0;
		for (Hang item : cartItems) {
			total += item.getSoLuong();
		}
		return total;
	}
	
	@RequestMapping(value = { "/cart/add" }, method = RequestMethod.POST)
	public ResponseEntity<AjaxResponse> index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response,
			@RequestBody Hang cartItem)
			throws Exception {
		//lấy session hiện tại

	
		//int soLuongDat=Integer.parseInt(request.getParameter("soLuong"));
//		if(soLuongDat>0)
//		{
//			cartItem.setSoLuong(soLuongDat);
//		}
		//cartItem.setSoLuong(1);
		double tongTien=0;
		HttpSession httpSession=request.getSession();
		GioHang cart=null;
		if (httpSession.getAttribute("cart") != null) {
			cart = (GioHang) httpSession.getAttribute("cart");
		} else {
			cart = new GioHang();
			httpSession.setAttribute("cart", cart);
		}
		System.out.println(cartItem.getSoLuong());
		List<Hang> cartItems = cart.getListHang();
		for (Hang cartItem2 : cartItems) {
			System.out.println(cartItem2.getSoLuong());
		}
		boolean isExists = false;
		int i=0;
		for (Hang item : cartItems) {
			if (item.getIdSp() == cartItem.getIdSp()) {
				isExists = true;
				item.setSoLuong(item.getSoLuong()+cartItem.getSoLuong());
			}
		}
		if (!isExists) {
			SanPhamEntity productInDb = sanPhamRepo.getOne(cartItem.getIdSp());
			cartItem.setTenSp(productInDb.getTenSanPham());
			cartItem.setGia(productInDb.getGia());
			cart.getListHang().add(cartItem);
		}
		for (Hang hang : cartItems) {
			tongTien+=(hang.getSoLuong()*hang.getGia().doubleValue());
		}
		System.out.println(new DecimalFormat("#").format(tongTien));
		httpSession.setAttribute("totalitem", layTongSoHang(request));
		httpSession.setAttribute("tongTien",new BigDecimal(new DecimalFormat("#").format(tongTien)));
		return ResponseEntity.ok(new AjaxResponse(200,layTongSoHang(request)));
		}
	@RequestMapping(value = { "/cart/views"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("donHang", new DonHangEntity());
		return "user/GioHang";
		
	}
	
	@RequestMapping(value = { "/giohang/dathang"}, method = RequestMethod.POST)
	public String payment(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		
		String hoTen = request.getParameter("hoTen");
		String soDienThoai = request.getParameter("soDienThoai");
		String diaChi = request.getParameter("diaChi");
		String thanhToan=request.getParameter("thanhToan");
		HttpSession httpSession = request.getSession();
		GioHang gioHang = (GioHang) httpSession.getAttribute("cart");
		if(httpSession.getAttribute("cart")==null||gioHang.getListHang().size()==0)
		{
			model.addAttribute("thongbao", "Giỏ hàng trống!");
			
			return "redirect:/cart/views";
		}
		else
		{
		ThanhVienEntity thanhVien=(ThanhVienEntity)httpSession.getAttribute("user");
		List<Hang> hang = gioHang.getListHang();
		DonHangEntity donHang = new DonHangEntity();
		donHang.setSeo("ORDER-"+System.currentTimeMillis());
		donHang.setNgayLap(new Date());
		donHang.setTenKhachHang(hoTen);
		donHang.setDiaChi(diaChi);
		donHang.setTongTien((BigDecimal)httpSession.getAttribute("tongTien"));
		donHang.setSoDienThoai(soDienThoai);
		donHang.setThanhToan(thanhToan);
		donHang.setThanhViens(thanhVien);
		int check=0;
		for(Hang item : hang) {
			
			
			if(item.getSoLuong()>sanPhamRepo.findById(item.getIdSp()).get().getSoLuong())
			{
				String thongBao="Không đủ số lượng sản phẩm "+sanPhamRepo.findById(item.getIdSp()).get().getTenSanPham();
				model.addAttribute("thongbao", thongBao);
				check++;
			}
		}
		if(check==0)
		{
			for(Hang item : hang)
			{
				ChiTietEntity chiTietDonHang = new ChiTietEntity();
				//SanPhamEntity sanPham=sanPhamRepo.findById(item.getIdSp()).get();
				SanPhamEntity sanPham=sanPhamRepo.getOne(item.getIdSp());
				sanPham.setSoLuong(sanPham.getSoLuong()-item.getSoLuong());
				sanPham.setSoLanMua(sanPham.getSoLanMua()+1);
				sanPham.setSoLuongBan(sanPham.getSoLuongBan()+item.getSoLuong());
				//sanPhamService.updateSanPham(sanPham, item.getSoLuong());
				//sanPhamRepo.update(item.getIdSp(), item.getSoLuong());
				chiTietDonHang.setSoLuong(item.getSoLuong());
				chiTietDonHang.setThanhTien(new BigDecimal(item.getSoLuong()*item.getGia().doubleValue()));
				//saleOrderProducts.set(productRepo.getOne(item.getProductId()));
				chiTietDonHang.setDonHangs(donHang);
				chiTietDonHang.setSanPhams(sanPham);
				chiTietDonHangRepo.save(chiTietDonHang);
				}
			donHang.setTrangThai(1);
			donHangRepo.save(donHang);
			httpSession.removeAttribute("tongTien");
			httpSession.setAttribute("cart", new GioHang());
			httpSession.setAttribute("totalitem", 0);
			return "redirect:/donmua/" + thanhVien.getId() + "";
		}
		else
		{
			 return "user/GioHang";
		}
		}

}
	@RequestMapping(value = { "/giohang/xoa/{index}"}, method = RequestMethod.GET)
	public String delItem(final ModelMap model,@PathVariable("index") int index, final HttpServletRequest request, final HttpServletResponse response)
	throws Exception {
	HttpSession session=request.getSession();
	GioHang cart=(GioHang)session.getAttribute("cart");
	cart.getListHang().remove(index);
	session.removeAttribute("tongTien");
	double tongTien=0;
	List<Hang> listHang=cart.getListHang();
	for (Hang hang : listHang) {
			tongTien+=(hang.getSoLuong()*hang.getGia().doubleValue());
	}
	session.setAttribute("tongTien",new BigDecimal(new DecimalFormat("#").format(tongTien)));
	session.removeAttribute("cart");
	session.setAttribute("cart", cart);
	return "redirect:/cart/views";
	
	}		
}
