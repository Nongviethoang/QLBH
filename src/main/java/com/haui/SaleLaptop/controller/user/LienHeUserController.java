package com.haui.SaleLaptop.controller.user;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.entities.LienHeEntity;
import com.haui.SaleLaptop.reponsitory.LienHeRepository;

@Controller
public class LienHeUserController {
	@Autowired
	LienHeRepository lienHeRepo;
	@RequestMapping(value = {"/userlienhe" }, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		model.addAttribute("lienhe", new LienHeEntity());
	return "user/LienHe";
	}
	
	//gửi liên hệ
		@RequestMapping(value = {"/gui-lienhe"}, method = RequestMethod.POST)
		public String guiLienHe(final ModelMap model,@ModelAttribute("lienhe") LienHeEntity lienHe, final HttpServletRequest request, final HttpServletResponse response)
				throws Exception {
			lienHe.setCreateDate(new Date());
			lienHeRepo.save(lienHe);
		return "redirect:/userlienhe";
		}
}
