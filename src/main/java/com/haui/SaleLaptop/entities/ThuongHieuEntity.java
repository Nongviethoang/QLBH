package com.haui.SaleLaptop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_thuong_hieu")
public class ThuongHieuEntity extends BaseEntity {
@Column(name = "ten_thuong_hieu",length = 100,nullable = false)
private String tenThuongHieu;
@Column(name = "mo_ta",length = 200,nullable = true)
private String moTa;
@OneToMany(mappedBy = "thuongHieus",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
private List<SanPhamEntity> sanPhams=new ArrayList<SanPhamEntity>();
public String getTenThuongHieu() {
	return tenThuongHieu;
}
public void setTenThuongHieu(String tenThuongHieu) {
	this.tenThuongHieu = tenThuongHieu;
}
public String getMoTa() {
	return moTa;
}
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
public List<SanPhamEntity> getSanPhams() {
	return sanPhams;
}
public void setSanPhams(List<SanPhamEntity> sanPhams) {
	this.sanPhams = sanPhams;
}

}
