package com.haui.SaleLaptop.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {
	@Id//xac dinh khoa chinh
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "trang_thai", nullable = true)
	private int trangThai;
	@Column(name = "create_by", nullable = true)
	private Integer createBy;
	@Column(name = "update_by", nullable = true)
	private Integer updateBy;
	@Column(name = "create_date", nullable = true)
	private Date createDate;

	@Column(name = "update_date", nullable = true)
	private Date updateDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(int trangThai) {
		this.trangThai = trangThai;
	}

	public Integer getCreateBy() {
		return createBy;
	}
	public void setCreateBy(Integer createBy) {
		this.createBy = createBy;
	}
	public Integer getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Integer updateBy) {
		this.updateBy = updateBy;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	
}
