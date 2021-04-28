package com.haui.SaleLaptop.controller.user;

import java.util.List;

import org.checkerframework.checker.units.qual.mol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.services.DanhMucServices;
import com.haui.SaleLaptop.services.SanPhamService;



public abstract class BaseController {
	@Autowired
	private DanhMucServices danhMucService;
	@Autowired
	SanPhamService sanPhamService;
	
	private String buildMenu() {
		StringBuilder menu = new StringBuilder();

		List<DanhMucEntity> danhMucs = danhMucService.getAllParents();
		for (DanhMucEntity c : danhMucs) {
			menu.append("<li class=\"right-menu\"><a href=\"/categoryparent/" + c.getTenDanhMuc() + "\">" + c.getTenDanhMuc() + "</a>");
			if (c.getChilds() != null && !c.getChilds().isEmpty()) {
				recursiveMenu(menu, c.getChilds());
			}
			menu.append("</li>");
		}

		return menu.toString();
	}

	private void recursiveMenu(StringBuilder menu, List<DanhMucEntity> childs) {
		menu.append(" <ul class=\"cat-mega-menu cat-mega-menu-2\">");
		for (DanhMucEntity c : childs) {
			menu.append(" <li class=\"right-menu cat-mega-title\"> <a href=\"/category/" + c.getTenDanhMuc() + "\">"
					+ c.getTenDanhMuc() + "</a>");
			if (c.getChilds() != null && !c.getChilds().isEmpty()) {
				recursiveMenu(menu, c.getChilds());
				menu.append("</li>");
			} else {
				menu.append("</li>");
			}
		}
		menu.append("</ul>");
	}
	@ModelAttribute("menu")
	public String getCategories() {
		return this.buildMenu();
	}	
}
