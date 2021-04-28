package com.haui.SaleLaptop.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.ThuongHieuEntity;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class ThuongHieuService {
	@PersistenceContext
	EntityManager entityManager;
	public List<ThuongHieuEntity> phanTrang(BaseDTO dto) {
		String jpql="SELECT m FROM ThuongHieuEntity m WHERE 1=1";
		Query query = entityManager.createQuery(jpql, ThuongHieuEntity.class);

		// paging
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());

			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
	
}
