package com.haui.SaleLaptop.controller.user;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.dto.DangNhapDTO;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.ThanhVienRepository;

@Controller
public class DangNhapUserController {
	@Autowired
	ThanhVienRepository thanhVienRepo;
	@RequestMapping(value = {"/login" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
//		model.addAttribute("dangnhap", new DangNhapDTO());
//		String error=(String)request.getSession().getAttribute("error");
//		if (error!=null) {
//			request.getSession().removeAttribute("error");
//		}
		
	return "user/DangNhap";
	}
	//xu lis dang nhap
//	@RequestMapping(value = {"/login1" }, method = RequestMethod.POST)
//	public String login(final ModelMap model,@ModelAttribute("dangnhap") DangNhapDTO dangNhap, final HttpServletRequest request, final HttpServletResponse response)
//			throws Exception {
//		
//		List<ThanhVienEntity> listTv=thanhVienRepo.findAll();
//		for (ThanhVienEntity tv : listTv) {
//			if(dangNhap.getUserName().equals(tv.getEmail())&&dangNhap.getPassword().equals(tv.getPassword()))
//			{
//				if(tv.getQuyens().getId()==2)
//				{
//					HttpSession session=request.getSession();
//					session.setAttribute("user", tv);
//					return "redirect:/";
//				}
//			}
//		}
//		String error="Sai tài khoản hoặc mật khẩu";
//		model.addAttribute("errorlogin",error);
//		//request.getSession().setAttribute("errorlogin", error); 
//		model.addAttribute("dangnhap", new DangNhapDTO());
//		return "user/DangNhap";
//	}
//	@RequestMapping(value = {"/dangxuat" }, method = RequestMethod.GET)
//	public String logout(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
//			throws Exception {
//		request.getSession().removeAttribute("user");
//		request.getSession().removeAttribute("admin");
//	return "redirect:/";
//	}
}
