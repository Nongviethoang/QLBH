package com.haui.SaleLaptop.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
import com.haui.SaleLaptop.entities.BinhLuanEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.reponsitory.BinhLuanRepository;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.services.AnhService;
import com.haui.SaleLaptop.services.BinhLuanService;
import com.haui.SaleLaptop.services.SanPhamService;

@Controller
public class ChiTietSanPhamController {
	@Autowired
	SanPhamRepository spre;
	@Autowired
	SanPhamService sanPhamSer;
	@Autowired
	BinhLuanRepository binhLuanRepo;
	@Autowired
	BinhLuanService binhLuanSer;
	@Autowired
	AnhService anhService;
	@RequestMapping(value = {"/sanphamchitiet/{id}" }, method = RequestMethod.GET)
	public String index(final ModelMap model,@PathVariable("id") int id, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<BinhLuanEntity> listBinhLuan=binhLuanSer.getCmtByIdPro(id);
		model.addAttribute("binhluans", listBinhLuan);
		model.addAttribute("countCmt", listBinhLuan.size());
		SanPhamEntity sanPham=spre.findById(id).get();
		model.addAttribute("sp", sanPham);
		int idDanhMuc=sanPham.getDanhMucs().getId();
		BaseDTO productSearch=new BaseDTO();
		productSearch.setCategoryId(idDanhMuc);
		List<AnhSanPhamEntity> listAnh=anhService.anhSp(id);
		System.out.println("so anh"+listAnh.size());
		model.addAttribute("listAnh", listAnh);
		//List<SanPhamEntity> listSp=sanPhamSer.search(productSearch);
		List<SanPhamEntity> listSp=sanPhamSer.sameCategory(idDanhMuc);
		int index=0;
		for (int i = 0; i < listSp.size(); i++) {
			if(listSp.get(i).getId()==id)
				index=i;
		}
		listSp.remove(index);
		//System.out.println("Cùng dm:"+listSp.size());
		model.addAttribute("sanPham", listSp);
		model.addAttribute("binhluan", new BinhLuanEntity());
	return "user/ChiTietSp";
	}
}
