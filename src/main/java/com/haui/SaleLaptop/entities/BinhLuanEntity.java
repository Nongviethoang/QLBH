package com.haui.SaleLaptop.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_binh_luan")
public class BinhLuanEntity extends BaseEntity{
@Column(name = "noi_dung",nullable = false,length = 1000)
private String noiDung;
@Column(name = "thoi_gian",nullable = false)
private Date thoiGian;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_thanhvien")
private ThanhVienEntity thanhViens;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_san_pham")
private SanPhamEntity sanPhams;

public ThanhVienEntity getThanhViens() {
	return thanhViens;
}
public void setThanhViens(ThanhVienEntity thanhViens) {
	this.thanhViens = thanhViens;
}
public SanPhamEntity getSanPhams() {
	return sanPhams;
}
public void setSanPhams(SanPhamEntity sanPhams) {
	this.sanPhams = sanPhams;
}
public String getNoiDung() {
	return noiDung;
}
public void setNoiDung(String noiDung) {
	this.noiDung = noiDung;
}
public Date getThoiGian() {
	return thoiGian;
}
public void setThoiGian(Date thoiGian) {
	this.thoiGian = thoiGian;
}

}
