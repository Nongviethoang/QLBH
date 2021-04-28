package com.haui.SaleLaptop.entities;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.checkerframework.checker.lock.qual.Holding;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ibm.icu.text.SimpleDateFormat;

@Entity
@Table(name = "tbl_thanh_vien")
public class ThanhVienEntity extends BaseEntity implements UserDetails {
@Column(name = "ngay_sinh",nullable = true
)
@DateTimeFormat(pattern =  "yyyy-MM-dd")
private Date ngaySinh;
@Column(name = "gioi_tinh",nullable = true
)
private boolean gioiTinh ;
@Column(name = "dia_chi",length = 100,nullable = true
)
private String diaChi;
@Column(name = "so_dien_thoai",length = 11,nullable = true
)
private String soDienThoai;
@Column(name = "email",length = 45,nullable = false,unique = true
)
private String email;
@Column(name = "ho_ten",length = 45,nullable = false
)
private String hoTen;
@Column(name = "mat_khau",length = 200,nullable = false
)
private String password;

@Column(name = "anh",nullable = true,length = 45)
private String anh;
@OneToMany(mappedBy = "thanhViens",cascade = CascadeType.ALL)
private List<BinhLuanEntity> binhLuans=new ArrayList<BinhLuanEntity>();
//@ManyToOne(fetch = FetchType.EAGER)
//@JoinColumn(name = "id_quyen")
//private QuyenEntity quyens ;
@ManyToMany(fetch = FetchType.EAGER)
@Fetch(value = FetchMode.SUBSELECT)
@JoinTable(name = "tbl_quyen_thanhvien",joinColumns = @JoinColumn(name="id_thanh_vien"),inverseJoinColumns = @JoinColumn(name="id_quyen"))
private List<QuyenEntity> quyens=new ArrayList<>();
@OneToMany(mappedBy = "thanhViens",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
@Fetch(value = FetchMode.SUBSELECT)
private List<DonHangEntity> donHangs=new ArrayList<DonHangEntity>();
public Date getNgaySinh() {
	
	return ngaySinh;
}
public void setNgaySinh(Date ngaySinh) {
	this.ngaySinh = ngaySinh;
}
public boolean isGioiTinh() {
	return gioiTinh;
}
public void setGioiTinh(boolean gioiTinh) {
	this.gioiTinh = gioiTinh;
}
public String getDiaChi() {
	return diaChi;
}
public void setDiaChi(String diaChi) {
	this.diaChi = diaChi;
}
public String getSoDienThoai() {
	return soDienThoai;
}
public void setSoDienThoai(String soDienThoai) {
	this.soDienThoai = soDienThoai;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getHoTen() {
	return hoTen;
}
public void setHoTen(String hoTen) {
	this.hoTen = hoTen;
}
public List<BinhLuanEntity> getBinhLuans() {
	return binhLuans;
}
public void setBinhLuans(List<BinhLuanEntity> binhLuans) {
	this.binhLuans = binhLuans;
}

//public QuyenEntity getQuyens() {
//	return quyens;
//}
//public void setQuyens(QuyenEntity quyens) {
//	this.quyens = quyens;
//}

public List<DonHangEntity> getDonHangs() {
	return donHangs;
}
public List<QuyenEntity> getQuyens() {
	return quyens;
}
public void setQuyens(List<QuyenEntity> quyens) {
	this.quyens = quyens;
}
public void setDonHangs(List<DonHangEntity> donHangs) {
	this.donHangs = donHangs;
}
public String getAnh() {
	return anh;
}
public void setAnh(String anh) {
	this.anh = anh;
}

public void setPassword(String password) {
	this.password = password;
}
public String getPassword() {
	return this.password;
}
public String fomatDate(Date ngaySinh) {
	SimpleDateFormat fomat=new SimpleDateFormat("dd/MM/yyyy");
	return fomat.format(ngaySinh);
	
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return this.quyens;
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return this.email;
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}

}
