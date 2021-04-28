package com.haui.SaleLaptop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.entities.LienHeEntity;

@Controller
public class LogoutController {
@RequestMapping(value = {"/logoutadmin"},method = RequestMethod.GET)
public String contact(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
		throws Exception {
	HttpSession httpSession=request.getSession();
	httpSession.removeAttribute("admin");
return "admin/CauHoi";
}
}
