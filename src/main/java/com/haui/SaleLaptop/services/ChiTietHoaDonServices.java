package com.haui.SaleLaptop.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.haui.SaleLaptop.Constaint;
import com.haui.SaleLaptop.entities.ChiTietEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.reponsitory.ChiTietDonHangRepository;

@Service
public class ChiTietHoaDonServices implements
Constaint{
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	private ChiTietDonHangRepository chiTietRepo;
	public List<ChiTietEntity> getAllById(int id){
		String jpql = "SELECT c FROM ChiTietEntity c where 1=1";
		jpql = jpql + " AND (c.donHangs.id= " +id+")";
		Query query = entityManager.createQuery(jpql, ChiTietEntity.class);
		return query.getResultList();
	}

}
