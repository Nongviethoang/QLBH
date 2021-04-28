package com.haui.SaleLaptop.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_anh_san_pham")
public class AnhSanPhamEntity extends BaseEntity {
@Column(name = "tieu_de",length = 200, nullable = false)
private String tieuDe;
@Column(name = "path",length = 200, nullable = false)
private String path;
@ManyToOne(fetch = FetchType.EAGER)
@JoinColumn(name = "id_san_pham")
private SanPhamEntity sanPhams;
public String getTieuDe() {
	return tieuDe;
}
public void setTieuDe(String tieuDe) {
	this.tieuDe = tieuDe;
}
public String getPath() {
	return path;
}
public void setPath(String path) {
	this.path = path;
}
public SanPhamEntity getSanPhams() {
	return sanPhams;
}
public void setSanPhams(SanPhamEntity sanPhams) {
	this.sanPhams = sanPhams;
}
}
