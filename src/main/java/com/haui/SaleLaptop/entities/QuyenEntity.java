package com.haui.SaleLaptop.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;



@Entity
@Table(name = "tbl_quyen")
public class QuyenEntity extends BaseEntity implements GrantedAuthority {
@Column(name = "ten_quyen",length = 45,nullable = false
)
private String tenQuyen;
@Column(name = "mo_ta",length = 45,nullable = false
)
private String moTa;
//@OneToMany(mappedBy = "quyens",fetch = FetchType.EAGER)
//private List<ThanhVienEntity> thanhViens = new ArrayList<ThanhVienEntity>();
@ManyToMany(mappedBy = "quyens",fetch = FetchType.EAGER)
private List<ThanhVienEntity> thanhViens=new ArrayList<>();
public String getTenQuyen() {
	return tenQuyen;
}
public void setTenQuyen(String tenQuyen) {
	this.tenQuyen = tenQuyen;
}
public String getMoTa() {
	return moTa;
}
public void setMoTa(String moTa) {
	this.moTa = moTa;
}
public List<ThanhVienEntity> getThanhViens() {
	return thanhViens;
}
public void setThanhViens(List<ThanhVienEntity> thanhViens) {
	this.thanhViens = thanhViens;
}
@Override
public String getAuthority() {
	// TODO Auto-generated method stub
	return this.tenQuyen;
}

}
