package com.haui.SaleLaptop.dto;

import java.math.BigDecimal;

public class Hang {
	private int idSp;
	private int soLuong;
	private BigDecimal gia;
	private String tenSp;
	public int getIdSp() {
		return idSp;
	}
	public void setIdSp(int idSp) {
		this.idSp = idSp;
	}
	public int getSoLuong() {
		return soLuong;
	}
	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}
	public BigDecimal getGia() {
		return gia;
	}
	public void setGia(BigDecimal gia) {
		this.gia = gia;
	}
	public String getTenSp() {
		return tenSp;
	}
	public void setTenSp(String tenSp) {
		this.tenSp = tenSp;
	}
	
}
