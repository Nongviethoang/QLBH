package com.haui.SaleLaptop.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.BinhLuanEntity;
import com.haui.SaleLaptop.entities.DanhMucEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class BinhLuanService {
	@PersistenceContext
	EntityManager entityManager;
	public List<BinhLuanEntity> getCmtByIdPro(int id) {
		String sql="select * from salecomputer.tbl_binh_luan b WHERE b.id_san_pham="+id+"";
		
		Query query = entityManager.createNativeQuery(sql,BinhLuanEntity.class);
		
		return query.getResultList();

	}
	public List<BinhLuanEntity> phanTrang(BaseDTO dto) {
		String jpql="SELECT m FROM BinhLuanEntity m WHERE 1=1";
		Query query = entityManager.createQuery(jpql, BinhLuanEntity.class);

		// paging
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());

			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
}
