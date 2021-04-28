package com.haui.SaleLaptop.entities;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.ibm.icu.text.SimpleDateFormat;



@Entity
@Table(name = "tbl_don_hang")
public class DonHangEntity extends BaseEntity{
@Column(name = "ngay_lap")

private Date ngayLap;
@Column(name = "tong_tien",scale = 2,precision = 13,nullable = false)
private BigDecimal tongTien;
@Column(name = "ten_khach_hang",length = 45,nullable = false
)
private String tenKhachHang;
@Column(name = "dia_chi",length = 100,nullable = false
)
private String diaChi;
@Column(name = "so_dien_thoai",length = 45,nullable = false
)
private String soDienThoai;
@Column(name = "thanh_toan",length = 50,nullable = false
)
private String thanhToan;
@Column(name = "seo", length = 1000, nullable = true)
private String seo;
public String getSeo() {
	return seo;
}

public void setSeo(String seo) {
	this.seo = seo;
}

@ManyToOne
@JoinColumn(name = "id_thanhvien")
private ThanhVienEntity thanhViens;
@OneToMany(mappedBy = "donHangs",fetch = FetchType.LAZY)
private List<ChiTietEntity> chiTiets=new ArrayList<ChiTietEntity>();
public void themSanPhamVaoGio(ChiTietEntity chitiet) {
	chiTiets.add(chitiet);
	chitiet.setDonHangs(this);
}

public Date getNgayLap() {
	return ngayLap;
}
public void setNgayLap(Date ngayLap) {
	this.ngayLap = ngayLap;
}
public BigDecimal getTongTien() {
	return tongTien;
}
public void setTongTien(BigDecimal tongTien) {
	this.tongTien = tongTien;
}
public String getTenKhachHang() {
	return tenKhachHang;
}
public void setTenKhachHang(String tenKhachHang) {
	this.tenKhachHang = tenKhachHang;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaCHi) {
	this.diaChi = diaCHi;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public String getThanhToan() {
	return thanhToan;
}
public void setThanhToan(String thanhToan) {
	this.thanhToan = thanhToan;
}
public ThanhVienEntity getThanhViens() {
	return thanhViens;
}
public void setThanhViens(ThanhVienEntity thanhViens) {
	this.thanhViens = thanhViens;
}
public List<ChiTietEntity> getChiTiets() {
	return chiTiets;
}
public void setChiTiets(List<ChiTietEntity> chiTiets) {
	this.chiTiets = chiTiets;
}
public void themChiTiet(ChiTietEntity saleOrderProduct) {
	chiTiets.add(saleOrderProduct);
	saleOrderProduct.setDonHangs(this);
}

public void xoaChiTiet(ChiTietEntity saleOrderProduct) {
	chiTiets.add(saleOrderProduct);
	saleOrderProduct.setDonHangs(this);
}

@Override
public String toString() {
	return "DonHangEntity [ngayLap=" + ngayLap + ", tongTien=" + tongTien + ", tenKhachHang=" + tenKhachHang
			+ ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", thanhToan=" + thanhToan + ", seo=" + seo
			+ ", thanhViens=" + thanhViens + ", chiTiets=" + chiTiets + "]";
}
public String fomatDate(Date day) {
	SimpleDateFormat fomat=new SimpleDateFormat("dd/MM/yyyy");
	return fomat.format(day);
	
}
}
