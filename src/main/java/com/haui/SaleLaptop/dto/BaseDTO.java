package com.haui.SaleLaptop.dto;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.StringUtils;

import com.haui.SaleLaptop.entities.DanhMucEntity;

public class BaseDTO {
	private String seo;
	private String categorySeo;
	private int categoryId;
	private String categoryName;
	private double price1;
	private double price2;
	private String nameBranch;
	private DanhMucEntity danhMucCha;
	private int idAnh;
	private int status;
	private String startTime, endTime;
	
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getIdAnh() {
		return idAnh;
	}
	public void setIdAnh(int idAnh) {
		this.idAnh = idAnh;
	}
	public DanhMucEntity getDanhMucCha() {
		return danhMucCha;
	}
	public void setDanhMucCha(DanhMucEntity danhMucCha) {
		this.danhMucCha = danhMucCha;
	}
	public String getNameBranch() {
		return nameBranch;
	}
	public void setNameBranch(String nameBranch) {
		this.nameBranch = nameBranch;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public Integer offset = 2;//Vị trí của sản phẩm
	public Integer count = 1;//số trang
	//tìm  kiếm
	public String searchText;
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}
	public void buildPaging(HttpServletRequest request) {
		if (!StringUtils.isEmpty(request.getParameter("offset"))) {
			this.offset = Integer.parseInt(request.getParameter("offset"));
		} else {
			this.offset = 0;
		}
	}
	public String getSeo() {
		return seo;
	}

	public void setSeo(String seo) {
		this.seo = seo;
	}

	public String getCategorySeo() {
		return categorySeo;
	}

	public void setCategorySeo(String categorySeo) {
		this.categorySeo = categorySeo;
	}
	public Integer getOffset() {
		return offset;
	}
	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	public double getPrice1() {
		return price1;
	}
	public void setPrice1(double price1) {
		this.price1 = price1;
	}
	public double getPrice2() {
		return price2;
	}
	public void setPrice2(double price2) {
		this.price2 = price2;
	}
	@Override
	public String toString() {
		return "ProductSearch [seo=" + seo + ", categorySeo=" + categorySeo + ", categoryId=" + categoryId
				+ ", categoryName=" + categoryName + ", offset=" + offset + ", count=" + count + ", searchText="
				+ searchText + "]";
	}
	
}
