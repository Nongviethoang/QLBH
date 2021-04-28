package com.haui.SaleLaptop.controller.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.checkerframework.checker.units.qual.mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.entities.ThuongHieuEntity;
import com.haui.SaleLaptop.reponsitory.DanhMucRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.reponsitory.ThuongHieuRepository;
import com.haui.SaleLaptop.services.DanhMucServices;
import com.haui.SaleLaptop.services.SanPhamService;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;

@Controller
public class HomeUserController extends BaseController {
	@Autowired
	DanhMucRepository danhMucRepo;
	@Autowired
	SanPhamRepository sanPhamRepo;
	@Autowired
	SanPhamService sanPhamSer;
	@Autowired
	DanhMucServices danhMucService;
	@Autowired
	ThuongHieuRepository thuongHieuRepo;
	@RequestMapping(value = { "/", "/trangchu" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			ThanhVienEntity user = (ThanhVienEntity) principal;
			request.getSession().setAttribute("user", user);
//			
		}
		// List<DanhMucEntity> listDanhMuc=danhMucRepo.findAll();
		//model.addAttribute("menu", buildMenu(model));
		List<SanPhamEntity> spMoi = sanPhamSer.productNew();
		model.addAttribute("spMoi", spMoi);
		List<SanPhamEntity> spHot = sanPhamSer.productHot();
		model.addAttribute("spHot", spHot);
		List<SanPhamEntity> spVp = sanPhamSer.productVP(45);
		model.addAttribute("spvp", spVp);
		List<SanPhamEntity> pc = sanPhamSer.productVP(46);
		model.addAttribute("pc", pc);
		request.getSession().removeAttribute("errorlogin");
		List<ThuongHieuEntity> thuongHieus=thuongHieuRepo.findAll();
		model.addAttribute("thuongHieus",thuongHieus);
		
		return "user/index";
	}

	@RequestMapping(value = { "/all-product" }, method = RequestMethod.GET)
	public String allProduct(final ModelMap model, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		BaseDTO sanPham=new BaseDTO();
		sanPham.buildPaging(request);
		List<SanPhamEntity> allProduct=sanPhamService.search(sanPham);
		if(request.getParameter("sort")!=null)
		{
			int sortValue=Integer.parseInt(request.getParameter("sort"));
			danhMucService.sort(allProduct, sortValue);
		}
		model.addAttribute("list", allProduct);
		model.addAttribute("page", sanPham);
		return "user/sanpham";
	}

	@RequestMapping(value = { "/category/{seo}" }, method = RequestMethod.GET)
	public String category(final ModelMap model, @PathVariable("seo") String seo, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		// DanhMucEntity danhMuc=danhMucRepo.findById(id).get();
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setCategorySeo(seo);
		List<SanPhamEntity> listSp = sanPhamSer.search(productSearch);
		// model.addAttribute("danhmuc", danhMuc);
		String value=request.getParameter("sort");
		System.out.println("Value"+value);
		model.addAttribute("list", listSp);
		model.addAttribute("productSearch", productSearch);
		System.out.println(productSearch.toString());
		if(request.getParameter("sort")!=null)
		{
			int sortValue=Integer.parseInt(request.getParameter("sort"));
			danhMucService.sort(listSp, sortValue);
		}
		System.out.println(listSp.size());
		model.addAttribute("seo",seo);
		return "user/DanhMuc";
	}
	@RequestMapping(value = { "/categoryparent/{seo}" }, method = RequestMethod.GET)
	public String categoryParent(final ModelMap model, @PathVariable("seo") String seo, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		
		
		DanhMucEntity danhMucCha=new DanhMucEntity();
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		List<DanhMucEntity> listDm=danhMucService.searchCategory(seo);
		if(listDm.size()>0)
		{
			danhMucCha=listDm.get(0);
		}
		productSearch.setCategoryId(danhMucCha.getId());
		List<SanPhamEntity> listSp=sanPhamService.categoryParent(productSearch);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("seo",seo);
		if(request.getParameter("sort")!=null)
		{
			int sortValue=Integer.parseInt(request.getParameter("sort"));
			danhMucService.sort(listSp, sortValue);
		}
		
		model.addAttribute("list", listSp);
		return "user/DanhMuc";
	}

	@RequestMapping(value = { "/timkiem" }, method = RequestMethod.GET)
	public String timKiem(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		String tenSP = request.getParameter("timKiem");
		productSearch.setSearchText(tenSP);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("textSearch", tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("spTim", spTim);
		return "user/TimKiem";
	}
	@RequestMapping(value = { "/price1" }, method = RequestMethod.GET)
	public String sortPrice1(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setPrice1(5000000);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("list", spTim);
		model.addAttribute("seo","Giá dưới 5 triệu");
		return "user/DanhMuc";
	}
	@RequestMapping(value = { "/price2" }, method = RequestMethod.GET)
	public String sortPrice2(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setPrice1(5000000);
		productSearch.setPrice2(10000000);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("list", spTim);
		model.addAttribute("seo","Giá 5 triệu - 10 triệu");
		return "user/DanhMuc";
	}
	@RequestMapping(value = { "/price3" }, method = RequestMethod.GET)
	public String sortPrice3(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setPrice1(10000000);
		productSearch.setPrice2(15000000);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("list", spTim);
		model.addAttribute("seo","Giá 10 triệu - 15 triệu");
		return "user/DanhMuc";
	}@RequestMapping(value = { "/price4" }, method = RequestMethod.GET)
	public String sortPrice4(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setPrice1(15000000);
		productSearch.setPrice2(20000000);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("list", spTim);
		model.addAttribute("seo","Giá 15 triệu - 20 triệu");
		return "user/DanhMuc";
	}
	@RequestMapping(value = { "/price5" }, method = RequestMethod.GET)
	public String sortPrice5(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setPrice1(20000000);
		productSearch.setPrice2(30000000);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("list", spTim);
		model.addAttribute("seo","Giá 20 triệu - 30 triệu");
		return "user/DanhMuc";
	}
	@RequestMapping(value = { "/price6" }, method = RequestMethod.GET)
	public String sortPrice6(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		BaseDTO productSearch = new BaseDTO();
		productSearch.buildPaging(request);
		productSearch.setPrice1(30000000);
		productSearch.setPrice2(200000000);
		List<SanPhamEntity> spTim = sanPhamSer.search(productSearch);
		// List<SanPhamEntity> spTim=sanPhamSer.searchName(tenSP);
		model.addAttribute("productSearch", productSearch);
		model.addAttribute("list", spTim);
		model.addAttribute("seo","Giá trên 30 triệu");
		return "user/DanhMuc";
	}
	//Tìm sản phẩm theo thương hiệu
			@RequestMapping(value = { "/thuonghieu/{tenThuongHieu}" }, method = RequestMethod.GET)
			public String productInBranch(final ModelMap model, final HttpServletRequest request,
					final HttpServletResponse response, @PathVariable("tenThuongHieu") String tenThuongHieu) throws Exception {
				BaseDTO sp=new BaseDTO();
				sp.buildPaging(request);
				sp.setNameBranch(tenThuongHieu);
				List<SanPhamEntity> list=sanPhamSer.search(sp);
				model.addAttribute("productSearch", sp);
				model.addAttribute("list", list);
				model.addAttribute("seo", "Thương hiệu <b> / </b> "+ tenThuongHieu);
				return "user/DanhMuc";

			}
//	private String buildMenu(ModelMap model) {
//		StringBuilder menu = new StringBuilder();
//
//		List<DanhMucEntity> danhMucs = danhMucService.getAllParents();
//		for (DanhMucEntity c : danhMucs) {
//			menu.append("<li class=\"right-menu\"><a href=\"/category/" + c.getSeo() + "\">" + c.getTenDanhMuc() + "</a>");
//			if (c.getChilds() != null && !c.getChilds().isEmpty()) {
//				recursiveMenu(menu, c.getChilds());
//			}
//			menu.append("</li>");
//		}
//
//		return menu.toString();
//	}
//
//	private void recursiveMenu(StringBuilder menu, List<DanhMucEntity> childs) {
//		menu.append(" <ul class=\"cat-mega-menu cat-mega-menu-2\">");
//		for (DanhMucEntity c : childs) {
//			menu.append(" <li class=\"right-menu cat-mega-title\"> <a href=\"/category/" + c.getSeo() + "\">"
//					+ c.getTenDanhMuc() + "</a>");
//			if (c.getChilds() != null && !c.getChilds().isEmpty()) {
//				recursiveMenu(menu, c.getChilds());
//				menu.append("</li>");
//			} else {
//				menu.append("</li>");
//			}
//		}
//		menu.append("</ul>");
//	}

}
