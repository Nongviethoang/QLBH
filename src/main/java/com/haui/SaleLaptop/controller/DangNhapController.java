package com.haui.SaleLaptop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.ThanhVienRepository;

@Controller
public class DangNhapController {
	@Autowired
	private ThanhVienRepository thanhVienRepo;
	@RequestMapping(value = {"/login-admin"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
//		List<ThanhVienEntity> thanhViens=thanhVienRepo.findAll();
//		String email=request.getParameter("email");
//		String pass=request.getParameter("password");
//		System.out.println("em"+email+"pas"+pass);
//		for (ThanhVienEntity thanhVienEntity : thanhViens) {
//			if(email.equalsIgnoreCase(thanhVienEntity.getEmail())&&pass.equalsIgnoreCase(thanhVienEntity.getMatKhau()))
//			{
//				if(thanhVienEntity.getQuyens().getId()==1)
//				{
//					request.getSession().setAttribute("admin", thanhVienEntity);
//					return "redirect:/homeadmin";
//				}
//				
//				
//			}
//			model.addAttribute("message", "Sai tên đăng nhập hoặc mật khẩu");
		//}
		return "admin/DangNhap";
		
	}
//	@RequestMapping(value = {"/logout-admin"}, method = RequestMethod.GET)
//	public String dangXuat(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
//			throws Exception {
//		request.getSession().removeAttribute("admin");
//		return "redirect:/";
//	}
}
