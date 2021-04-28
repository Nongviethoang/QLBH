package com.haui.SaleLaptop.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class DanhMucServices {
	@PersistenceContext
	EntityManager entityManager;
	
	public List<DanhMucEntity> getAllParents() {
		String jpql = "select * from salecomputer.tbl_danh_muc tc where tc.id_cha is null";
		Query query = entityManager.createNativeQuery(jpql, DanhMucEntity.class);
		return query.getResultList();
	}
	public List<DanhMucEntity> phanTrang(BaseDTO dto) {
		String jpql="SELECT m FROM DanhMucEntity m WHERE 1=1";
		Query query = entityManager.createQuery(jpql, DanhMucEntity.class);

		// paging
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());

			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
	public List<DanhMucEntity> searchCategory(String name) {
		
		String sql= "SELECT * FROM salecomputer.tbl_danh_muc where ten_danh_muc='"+name+"'";
		Query query = entityManager.createNativeQuery(sql, DanhMucEntity.class);
		return query.getResultList();
	}
	public void sort(List<SanPhamEntity> listSp,int value) {
		if(value==1)
		{
			Collections.sort(listSp,  new Comparator<SanPhamEntity>() {

				@Override
				public int compare(SanPhamEntity o1, SanPhamEntity o2) {
					
					return o1.getTenSanPham().compareToIgnoreCase(o2.getTenSanPham());
				}
			});
		}
		if(value==2)
		{
			Collections.sort(listSp,  new Comparator<SanPhamEntity>() {

				@Override
				public int compare(SanPhamEntity o1, SanPhamEntity o2) {
					
					return o2.getTenSanPham().compareToIgnoreCase(o1.getTenSanPham());
				}
			});
		}
		if(value==3)
		{
			Collections.sort(listSp,  new Comparator<SanPhamEntity>() {

				@Override
				public int compare(SanPhamEntity o1, SanPhamEntity o2) {
					
					return o1.getGia().doubleValue()>o2.getGia().doubleValue()?1:-1;
				}
			});
		}
		if(value==4)
		{
			Collections.sort(listSp,  new Comparator<SanPhamEntity>() {

				@Override
				public int compare(SanPhamEntity o1, SanPhamEntity o2) {
					
					return o1.getGia().doubleValue()<o2.getGia().doubleValue()?1:-1;
				}
			});
		}
	}
	
}
