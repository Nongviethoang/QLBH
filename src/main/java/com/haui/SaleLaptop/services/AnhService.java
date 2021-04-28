package com.haui.SaleLaptop.services;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.haui.SaleLaptop.Constaint;
import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.reponsitory.AnhRepository;
import com.haui.SaleLaptop.reponsitory.DonHangRepository;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class AnhService implements Constaint {
	@PersistenceContext
	EntityManager entityManager;
@Autowired
AnhRepository anhRepo;
	public List<AnhSanPhamEntity> phanTrang(BaseDTO dto) {
		String jpql = " SELECT anh FROM AnhSanPhamEntity anh WHERE 1=1";
		Query query = entityManager.createQuery(jpql, AnhSanPhamEntity.class);
		// paging
		if (dto.getOffset() != null) {
			dto.setCount(query.getResultList().size());

			query.setFirstResult(dto.getOffset());
			query.setMaxResults(PaginationTaglib.MAX);
		}
		return query.getResultList();
	}

	private boolean isEmptyUploadFile(MultipartFile image) {
		return image == null || image.getOriginalFilename().isEmpty();
	}

	@Transactional(rollbackOn = Exception.class)
	public void saveOrUpdate(AnhSanPhamEntity anh, MultipartFile anhAvatar) throws Exception {
		try {
			if (anh.getId() != null && !isEmptyUploadFile(anhAvatar)) {
				String avatarPath = ROOT_UPDATE_PATH + anh.getPath();
				new File(avatarPath).delete();
				String filePath = "/product/avatar/" + anhAvatar.getOriginalFilename();
				anhAvatar.transferTo(new File(ROOT_UPDATE_PATH + filePath));
				anh.setPath(filePath);
				anh.setUpdateDate(new Date());
				anhRepo.save(anh);
			}
			else if (anh.getId() == null && !isEmptyUploadFile(anhAvatar)) {
				String filePath = "/product/avatar/" + anhAvatar.getOriginalFilename();
				anhAvatar.transferTo(new File(ROOT_UPDATE_PATH + filePath));
				anh.setPath(filePath);
				anh.setCreateDate(new Date());
				anhRepo.save(anh);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	public List<AnhSanPhamEntity> anhSp(int idSanPham) {
		String sql="SELECT *  FROM salecomputer.tbl_anh_san_pham p WHERE p.id_san_pham= "+idSanPham+"";
		Query query=entityManager.createNativeQuery(sql, AnhSanPhamEntity.class);
		return query.getResultList();
	}
}
