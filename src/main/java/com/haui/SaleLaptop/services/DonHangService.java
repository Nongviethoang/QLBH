package com.haui.SaleLaptop.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class DonHangService {
	@PersistenceContext
	EntityManager entityManager;
	@Autowired
	DonHangRepository donHangRepo;
	public List<DonHangEntity> layDonHangCuaKhach(int idKhach)
	{
		String sql="SELECT * FROM salecomputer.tbl_don_hang d WHERE d.id_thanhvien = "+idKhach+"";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		return query.getResultList();
	}
	public List<DonHangEntity> phanTrang(BaseDTO dto) {
		String jpql=" SELECT dh FROM DonHangEntity dh WHERE 1=1  ORDER BY id DESC";
		Query query=entityManager.createQuery(jpql, DonHangEntity.class);
		// paging
				if (dto.getOffset() != null) {
					dto.setCount(query.getResultList().size());
					query.setFirstResult(dto.getOffset());
					query.setMaxResults(PaginationTaglib.MAX);
				}
	return query.getResultList();
	}
	//Lấy đơn hàng tháng hiện tại
	public List<DonHangEntity> layDonHangThangHienTai()
	{
		String sql="SELECT * FROM salecomputer.tbl_don_hang where month(ngay_lap)=month(now()); ";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		return query.getResultList();
	}
	//Lấy đơn hàng theo thời gian
	public List<DonHangEntity> layDonHangTheoThoiGian(String start, String end)
	{
		String sql="SELECT * FROM salecomputer.tbl_don_hang WHERE ngay_lap between '"+start+"' AND '"+end+"'";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		System.out.println(sql);
		return query.getResultList();
	}
	//L
	public List<DonHangEntity> layDonHangThangHienTai(BaseDTO dto)
	{
		
		String sql="SELECT * FROM salecomputer.tbl_don_hang WHERE month(ngay_lap)=month(now())";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());
			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
	//Lấy đơn hàng theo trạng thái
	public List<DonHangEntity> trangThai(BaseDTO dto)
	{
		
		String sql="SELECT * FROM salecomputer.tbl_don_hang WHERE trang_thai="+dto.getStatus()+"";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());
			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
	//Đơn hàng theo trạng thái hiện tại
	public List<DonHangEntity> trangThaiThangHienTai(BaseDTO dto)
	{
		
		String sql="SELECT * FROM salecomputer.tbl_don_hang WHERE month(ngay_lap)=month(now()) AND trang_thai= "+dto.getStatus()+"";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());
			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		System.out.println("so don_"+query.getResultList().size());
		return query.getResultList();
	}
	//Trạng thái đơn hagnf theo thời gian lọc
	public List<DonHangEntity> trangThaiDonHangLoc(BaseDTO dto)
	{
		String sql="SELECT * FROM salecomputer.tbl_don_hang WHERE ngay_lap BETWEEN+'"+dto.getStartTime()+"' AND '"+dto.getEndTime()+"' AND trang_thai= "+dto.getStatus()+"";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());
			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
	//Lấy đơn hàng lọc theo thời gian
	public List<DonHangEntity> layDonHangThangLoc(BaseDTO dto)
	{
		String sql="SELECT * FROM salecomputer.tbl_don_hang WHERE ngay_lap BETWEEN+'"+dto.getStartTime()+"' AND '"+dto.getEndTime()+"'";
		Query query=entityManager.createNativeQuery(sql, DonHangEntity.class);
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());
			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}
}
