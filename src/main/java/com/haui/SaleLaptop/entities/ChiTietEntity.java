package com.haui.SaleLaptop.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_chi_tiet_don_hang")
public class ChiTietEntity extends BaseEntity{
@Column(name = "so_luong",nullable = false)
private int soLuong;
@Column(name = "thanh_tien",precision = 13,scale = 2,nullable = false)
private BigDecimal thanhTien;
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinColumn(name = "id_don_hang")
private DonHangEntity donHangs;
@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
@JoinColumn(name = "id_san_pham")
private SanPhamEntity sanPhams;
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public BigDecimal getThanhTien() {
	return thanhTien;
}
public void setThanhTien(BigDecimal thanhTien) {
	this.thanhTien = thanhTien;
}
public DonHangEntity getDonHangs() {
	return donHangs;
}
public void setDonHangs(DonHangEntity donHangs) {
	this.donHangs = donHangs;
}
public SanPhamEntity getSanPhams() {
	return sanPhams;
}
public void setSanPhams(SanPhamEntity sanPhams) {
	this.sanPhams = sanPhams;
}

}
