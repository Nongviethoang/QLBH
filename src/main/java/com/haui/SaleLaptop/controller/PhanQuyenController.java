package com.haui.SaleLaptop.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.haui.SaleLaptop.entities.QuyenEntity;
import com.haui.SaleLaptop.reponsitory.QuyenRepository;

@Controller
public class PhanQuyenController {
	@Autowired 
	QuyenRepository quyenRepo;
	@RequestMapping(value = {"/admin/phanquyen"}, method = RequestMethod.GET)
	public String index(final ModelMap model, final HttpServletRequest request, final HttpServletResponse response)
			throws Exception {
		
	return "admin/PhanQuyen";
	}
}
