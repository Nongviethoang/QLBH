package com.haui.SaleLaptop.controller.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.entities.QuyenEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.QuyenRepository;
import com.haui.SaleLaptop.reponsitory.ThanhVienRepository;

@Controller
public class DangKiController {
	@Autowired
	ThanhVienRepository thanhVienRepo;
	@Autowired
	QuyenRepository quyenRepo;
	@RequestMapping(value = {"/dangki" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("thanhvien", new ThanhVienEntity());
	return "user/DangKi";
	}

	@RequestMapping(value = {"/register" }, method = RequestMethod.POST)
	public String register(final ModelMap model,@ModelAttribute("thanhvien") ThanhVienEntity thanhVien, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		List<ThanhVienEntity> list=thanhVienRepo.findAll();
		for (ThanhVienEntity thanhVienEntity : list) {
			if(thanhVien.getEmail().equals(thanhVienEntity.getEmail()))
			{
				String error="Email đã tồn tại";
				model.addAttribute("error",error);
				//request.getSession().setAttribute("error", error); 
				return "redirect:/dangki";
			}
		}
		List<QuyenEntity> quyens=quyenRepo.findAll();
		List<QuyenEntity> quyenUser=new ArrayList<QuyenEntity>();
		for (QuyenEntity quyenEntity : quyens) {
			if(quyenEntity.getTenQuyen().equalsIgnoreCase("User"))
			{
				quyenUser.add(quyenEntity);
			}
		}
		thanhVien.setCreateDate(new Date());
		thanhVien.setQuyens(quyenUser);
//		thanhVien.setQuyens(quyenRepo.findById(2).get());
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder(4);
		thanhVien.setPassword(encoder.encode(thanhVien.getPassword()));
		System.out.println("â"+encoder.matches("Anhyeuem@123",thanhVien.getPassword()));
		thanhVienRepo.save(thanhVien);
	return "redirect:/login";
	}
	
}
