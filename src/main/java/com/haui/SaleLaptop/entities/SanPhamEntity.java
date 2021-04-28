package com.haui.SaleLaptop.entities;

import java.math.BigDecimal;
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
@Table(name = "tbl_san_pham")
public class SanPhamEntity  extends BaseEntity{
@Column(name = "ten_san_pham",length = 100,nullable = false)
private String tenSanPham;
@Column(name = "Gia",precision = 13,scale = 2,nullable = false)
private BigDecimal gia;
@Column(name = "gia_goc",precision = 13,scale = 2,nullable = true)
private BigDecimal giaGoc;
@Column(name = "cau_hinh",nullable = false,columnDefinition = "LONGTEXT")
private String cauHinh;
@Column(name = "seo", length = 1000, nullable = true)
private String seo;
@Column(name = "gioi_thieu",nullable = true,columnDefinition = "LONGTEXT")
private String gioiThieu;
@Column(name = "bao_hanh",nullable = true,length = 50)
private String baoHanh;
@Column(name = "so_luong",nullable = false)
private int soLuong;
@Column(name = "phan_tram_giam",nullable = true)
private int phanTramGiam;
@Column(name = "so_lan_mua",nullable = true)
private int soLanMua;
@Column(name = "so_luong_ban",nullable = true)
private int soLuongBan;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_danh_muc")
private DanhMucEntity danhMucs;
@ManyToOne(fetch = FetchType.LAZY)
@JoinColumn(name = "id_thuong_hieu")
private ThuongHieuEntity thuongHieus;
@OneToMany(fetch = FetchType.LAZY,mappedBy = "sanPhams")
private List<BinhLuanEntity> binhLuans=new ArrayList<BinhLuanEntity>();
@OneToMany(cascade = CascadeType.ALL,mappedBy = "sanPhams",fetch = FetchType.LAZY)
private List<ChiTietEntity> chiTiets=new ArrayList<ChiTietEntity>();
@OneToMany(cascade = CascadeType.PERSIST,mappedBy = "sanPhams",fetch = FetchType.LAZY)
private List<AnhSanPhamEntity> anhs=new ArrayList<AnhSanPhamEntity>();

public List<AnhSanPhamEntity> getAnhs() {
	return anhs;
}
public void setAnhs(List<AnhSanPhamEntity> anhs) {
	this.anhs = anhs;
}
public List<BinhLuanEntity> getBinhLuans() {
	return binhLuans;
}
public void setBinhLuans(List<BinhLuanEntity> binhLuans) {
	this.binhLuans = binhLuans;
}
public String getTenSanPham() {
	return tenSanPham;
}
public void setTenSanPham(String tenSanPham) {
	this.tenSanPham = tenSanPham;
}
public BigDecimal getGia() {
	return gia;
}
public void setGia(BigDecimal gia) {
	this.gia = gia;
}
public String getCauHinh() {
	return cauHinh;
}
public void setCauHinh(String cauHinh) {
	this.cauHinh = cauHinh;
}
public String getSeo() {
	return seo;
}
public void setSeo(String seo) {
	this.seo = seo;
}
public DanhMucEntity getDanhMucs() {
	return danhMucs;
}
public void setDanhMucs(DanhMucEntity danhMucs) {
	this.danhMucs = danhMucs;
}
public List<ChiTietEntity> getChiTiets() {
	return chiTiets;
}
public void setChiTiets(List<ChiTietEntity> chiTiets) {
	this.chiTiets = chiTiets;
}
public String getGioiThieu() {
	return gioiThieu;
}
public void setGioiThieu(String gioiThieu) {
	this.gioiThieu = gioiThieu;
}
public String getBaoHanh() {
	return baoHanh;
}
public void setBaoHanh(String baoHanh) {
	this.baoHanh = baoHanh;
}
public int getSoLuong() {
	return soLuong;
}
public void setSoLuong(int soLuong) {
	this.soLuong = soLuong;
}
public BigDecimal getGiaGoc() {
	return giaGoc;
}
public void setGiaGoc(BigDecimal giaGoc) {
	this.giaGoc = giaGoc;
}

public int getPhanTramGiam() {
	return phanTramGiam;
}
public void setPhanTramGiam(int phanTramGiam) {
	this.phanTramGiam = phanTramGiam;
}

public int getSoLanMua() {
	return soLanMua;
}
public void setSoLanMua(int soLanMua) {
	this.soLanMua = soLanMua;
}
public int getSoLuongBan() {
	return soLuongBan;
}
public void setSoLuongBan(int soLuongBan) {
	this.soLuongBan = soLuongBan;
}
public ThuongHieuEntity getThuongHieus() {
	return thuongHieus;
}
public void setThuongHieus(ThuongHieuEntity thuongHieus) {
	this.thuongHieus = thuongHieus;
}

@Override
public String toString() {
	return "SanPhamEntity [tenSanPham=" + tenSanPham + ", gia=" + gia + ", cauHinh=" + cauHinh
			+ ", seo=" + seo + ", gioiThieu=" + gioiThieu + ", baoHanh=" + baoHanh + ", soLuong=" + soLuong
			+ ", danhMucs=" + danhMucs + ", binhLuans=" + binhLuans + ", chiTiets=" + chiTiets + "]";
}
}
