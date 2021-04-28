package com.haui.SaleLaptop.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Service;


import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class ThanhVienService {
@PersistenceContext
EntityManager entityManager;
public List<ThanhVienEntity> phanTrang(BaseDTO dto) {
	String jpql="SELECT tv FROM ThanhVienEntity tv WHERE 1=1";
	Query query=entityManager.createQuery(jpql, ThanhVienEntity.class);
	// paging
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());

			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
}
public ThanhVienEntity loadUserByUsername(String email) {
	try {
		String jpql = "Select u From ThanhVienEntity u Where 1=1";
		jpql=jpql+"AND u.email='" + email + "'";
		Query query = entityManager.createQuery(jpql, ThanhVienEntity.class);
		System.out.println("email là"+email);
		ThanhVienEntity tv=(ThanhVienEntity)query.getSingleResult();
		System.out.println("tvlaf :"+tv);
		return tv;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}
} 
}
