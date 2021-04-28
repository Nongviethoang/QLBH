package com.haui.SaleLaptop.dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class GioHang {
private List<Hang> listHang=new ArrayList<Hang>();
private BigDecimal tongTien=BigDecimal.ZERO;
public List<Hang> getListHang() {
	return listHang;
}
public void setListHang(List<Hang> listHang) {
	this.listHang = listHang;
}
public BigDecimal getTongTien() {
	return tongTien;
}
public void setTongTien(BigDecimal tongTien) {
	this.tongTien = tongTien;
}

}
