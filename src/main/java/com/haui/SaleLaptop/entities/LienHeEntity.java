package com.haui.SaleLaptop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_lien_he")
public class LienHeEntity extends BaseEntity {
@Column(name = "ho_ten",length = 45,nullable = false)
private String hoTen;
@Column(name = "email",length = 45,nullable = false)
private String email;
@Column(name = "so_dien_thoai",length = 45,nullable = false)
private String soDienThoai;
@Column(name = "noi_dung",length = 1000,nullable = false)
private String noiDung;
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public String getNoiDung() {
	return noiDung;
}
public void setNoiDung(String noiDung) {
	this.noiDung = noiDung;
}

}
