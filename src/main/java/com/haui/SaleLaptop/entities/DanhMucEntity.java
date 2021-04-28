package com.haui.SaleLaptop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_danh_muc")
public class DanhMucEntity extends BaseEntity {
@Column(name = "ten_danh_muc",length = 50,nullable = false)
private String tenDanhMuc;
@Column(name = "mo_ta",columnDefinition = "LONGTEXT",nullable = false)
private String moTa;
@Column(name = "seo", length = 1000, nullable = true)
private String seo;
@OneToMany(fetch = FetchType.EAGER)
@JoinColumn(name = "id_cha")
private List<DanhMucEntity> childs=new ArrayList<DanhMucEntity>();
//@ManyToOne(fetch = FetchType.LAZY)
//@JoinColumn(name = "id_cha")
//private DanhMucEntity childs;
@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "danhMucs")
private List<SanPhamEntity> sanPhams=new ArrayList<SanPhamEntity>();
public String getTenDanhMuc() {
	return tenDanhMuc;
}
public void setTenDanhMuc(String tenDanhMuc) {
	this.tenDanhMuc = tenDanhMuc;
}
public String getMoTa() {
	return moTa;
}
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
public List<DanhMucEntity> getChilds() {
	return childs;
}
public void setChilds(List<DanhMucEntity> childs) {
	this.childs = childs;
}

public List<SanPhamEntity> getSanPhams() {
	return sanPhams;
}
//public DanhMucEntity getChilds() {
//	return childs;
//}
//public void setChilds(DanhMucEntity childs) {
//	this.childs = childs;
//}
public void setSanPhams(List<SanPhamEntity> sanPhams) {
	this.sanPhams = sanPhams;
}
public String getSeo() {
	return seo;
}
public void setSeo(String seo) {
	this.seo = seo;
}

}
