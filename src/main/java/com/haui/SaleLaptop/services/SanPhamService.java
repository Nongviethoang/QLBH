package com.haui.SaleLaptop.services;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.haui.SaleLaptop.Constaint;
import com.haui.SaleLaptop.dto.BaseDTO;
import com.haui.SaleLaptop.entities.DonHangEntity;
import com.haui.SaleLaptop.entities.SanPhamEntity;
import com.haui.SaleLaptop.entities.ThanhVienEntity;
import com.haui.SaleLaptop.reponsitory.SanPhamRepository;
import com.haui.SaleLaptop.tagligs.PaginationTaglib;

@Service
public class SanPhamService implements Constaint{
@Autowired
private SanPhamRepository sanPhamRepo;
@PersistenceContext
EntityManager entityManager;
public List<SanPhamEntity> search(BaseDTO productSearch) {
	String jpql = "SELECT p FROM SanPhamEntity p where 1=1 ";

	if (!StringUtils.isEmpty(productSearch.getSeo())) {
		jpql = jpql + " AND p.seo = '" + productSearch.getSeo() + "' ";
	}
	
	if (!StringUtils.isEmpty(productSearch.getCategorySeo())) {
		jpql = jpql + " AND p.danhMucs.tenDanhMuc = '" + productSearch.getCategorySeo() + "'";
	}
	if (!StringUtils.isEmpty(productSearch.getSearchText())) {
		jpql = jpql + " AND (p.tenSanPham LIKE '%" +productSearch.getSearchText()+"%') OR (p.danhMucs.tenDanhMuc LIKE '%" +productSearch.getSearchText()+"%') OR (p.thuongHieus.tenThuongHieu LIKE '%" +productSearch.getSearchText()+"%')";
	}
	if (productSearch.getPrice1()>0&&productSearch.getPrice2()==0) {
		jpql = jpql + " AND (p.gia <= " +productSearch.getPrice1()+")";
		
	}
	if (productSearch.getPrice1()>0&&!StringUtils.isEmpty(productSearch.getPrice2())) {
		jpql = jpql + " AND (p.gia between " +productSearch.getPrice1()+" AND "+productSearch.getPrice2()+")";
		
	}
	if (!StringUtils.isEmpty(productSearch.getNameBranch())) {
		jpql = jpql + " AND (p.thuongHieus.tenThuongHieu LIKE '%" +productSearch.getNameBranch()+"%') ";
	}
	Query query = entityManager.createQuery(jpql, SanPhamEntity.class);

	// paging
	if (productSearch.getOffset() != null) {
		productSearch.setCount(query.getResultList().size());

		query.setFirstResult(productSearch.getOffset());
		query.setMaxResults(PaginationTaglib.MAX);
	}
	return query.getResultList();
}
public List<SanPhamEntity> searchName(String search) {
	String jpql = "SELECT p FROM SanPhamEntity p where 1=1";
	jpql = jpql + " AND (p.tenSanPham LIKE '%" +search+"%') OR (p.danhMucs.tenDanhMuc LIKE '%" +search+"%') OR (p.thuongHieus.tenThuongHieu LIKE '%" +search+"%')";
	Query query = entityManager.createQuery(jpql, SanPhamEntity.class);
	return query.getResultList();

}

public List<SanPhamEntity> search(int id) {
	String jpql = "SELECT p FROM SanPhamEntity p where 1=1";
	
		jpql = jpql + " AND (p.danhMucs.id= " +id+")";
	
	Query query = entityManager.createQuery(jpql, SanPhamEntity.class);
	
	return query.getResultList();

}
public List<SanPhamEntity> sameCategory(int id) {
	String jpql = "SELECT * FROM salecomputer.tbl_san_pham s WHERE s.id_danh_muc = "+id+" LIMIT 4";
	Query query = entityManager.createNativeQuery(jpql, SanPhamEntity.class);
	
	return query.getResultList();

}

//Lấy sản phẩm hots
public List<SanPhamEntity> productNew() {
	String sql="SELECT *  FROM salecomputer.tbl_san_pham p order by create_date DESC LIMIT 8";
	Query query=entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return query.getResultList();
}
public List<SanPhamEntity> productHot() {
	String sql="SELECT *  FROM salecomputer.tbl_san_pham p order by so_lan_mua DESC LIMIT 2";
	Query query=entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return query.getResultList();
}
public List<SanPhamEntity> productVP(int tenDanhMuc) {
//	String jpql = "SELECT p FROM SanPhamEntity p where 1=1";
//	
//	jpql = jpql + " AND (p.danhMucs.tenDanhMuc= '" +tenDanhMuc+"')";
//
//	Query query = entityManager.createQuery(jpql, SanPhamEntity.class);
	String sql="SELECT * FROM salecomputer.tbl_san_pham s INNER JOIN salecomputer.tbl_danh_muc m ON "
			+ "s.id_danh_muc=m.id WHERE m.id_cha = "+tenDanhMuc+"";
	Query query1 = entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return query1.setMaxResults(8).getResultList();
	

}
//Lấy sản phẩm theo seo
public List<SanPhamEntity> getSp(String seo) {
	String sql="SELECT *  FROM salecomputer.tbl_san_pham p WHERE p.seo= "+seo+"";
			
	Query query=entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return query.getResultList();
}
private boolean isEmptyUploadFile(MultipartFile image) {
	return image == null || image.getOriginalFilename().isEmpty();
}
//@Transactional(rollbackOn = Exception.class)
//public void saveOrUpdate(SanPhamEntity product, MultipartFile productAvatar) throws Exception {
//	try {
//		//nếu trường hợp là chỉnh sửa
////		
////				if(product.getId()!=null&&product.getId()>0)
////				{
////					SanPhamEntity productDB=sanPhamRepo.findById(product.getId()).get();
////					//nếu upload lại ảnh thì phải xóa ảnh cũ
////					System.out.println("Anh cu"+productDB.getAnh());
////					if(!isEmptyUploadFile(productAvatar))
////					{
////						String avatarPath=ROOT_UPDATE_PATH+productDB.getAnh();
////						new File(avatarPath).delete();
////					}
////					
////				}
//				if(product.getId()!=null&&!isEmptyUploadFile(productAvatar))
//				{
//						String avatarPath=ROOT_UPDATE_PATH+product.getAnh();
//						new File(avatarPath).delete();
//						String filePath="/product/avatar/"+productAvatar.getOriginalFilename();
//						//productAvatar.transferTo(new File("C:\\Users\\ADMIN\\eclipse-workspace\\com.devpro.Shop\\upload\\"+productAvatar.getOriginalFilename()));
//						productAvatar.transferTo(new File(ROOT_UPDATE_PATH+filePath));
//						product.setAnh(filePath);
//						product.setUpdateDate(new Date());
//						System.out.println("ip"+product.getSeo()+product.getUpdateDate()+product.getUpdateBy());
//						sanPhamRepo.save(product);
//				}
//		//Kiem tra neu ng dung upload file
//		//if(productAvatar!=null && !productAvatar.getOriginalFilename().isEmpty())
//		else if(product.getId()==null&&!isEmptyUploadFile(productAvatar))
//		{
//			String filePath="/product/avatar/"+productAvatar.getOriginalFilename();
//			//productAvatar.transferTo(new File("C:\\Users\\ADMIN\\eclipse-workspace\\com.devpro.Shop\\upload\\"+productAvatar.getOriginalFilename()));
//			productAvatar.transferTo(new File(ROOT_UPDATE_PATH+filePath));
//			product.setAnh(filePath);
//			System.out.println("fileanh"+ROOT_UPDATE_PATH+filePath);
//			System.out.println(filePath);
//			product.setSeo("MT-" + System.currentTimeMillis());
//			product.setCreateDate(new Date());
//			float giamGia=100 - (float)(product.getGia().intValue())/(product.getGiaGoc().intValue()/100);
//			product.setPhanTramGiam((int)giamGia);
//			sanPhamRepo.save(product);
//		}
//		//productRepo.save(product);
//		//throw new Exception("Kiem tra hoat dong cua transaction");khong luu khi gap loi
//	//taoj seo tujw doongj
//		//product.setSeo(Untilites.seo(product.getTitle() + "-" + System.currentTimeMillis()));
////		product.setSeo("MT-" + System.currentTimeMillis());
////		product.setCreateDate(new Date());
////		float giamGia=100 - (float)(product.getGia().intValue())/(product.getGiaGoc().intValue()/100);
////		product.setPhanTramGiam((int)giamGia);
////		sanPhamRepo.save(product);
//	} catch (Exception e) {
//		e.printStackTrace();
//		throw e;
//	}
//}
//@Transactional(rollbackOn = Exception.class)
//public void updateProduct(SanPhamEntity product, MultipartFile productAvatar) throws Exception {
//	try {
//		//nếu trường hợp là chỉnh sửa
//		
//				if(product!=null&&productAvatar.getSize()>0)
//				{
//					//nếu upload lại ảnh thì phải xóa ảnh cũ
//						String avatarPath=ROOT_UPDATE_PATH+product.getAnh();
//						new File(avatarPath).delete();
//						String filePath="/product/avatar/"+productAvatar.getOriginalFilename();
//						productAvatar.transferTo(new File(ROOT_UPDATE_PATH+filePath));
//						product.setUpdateDate(new Date());
//
//				}
//				sanPhamRepo.save(product);
//	} catch (Exception e) {
//		e.printStackTrace();
//		throw e;
//	}
//}
public List<SanPhamEntity> laySanPhamThangHienTai()
{
	String sql="SELECT * FROM salecomputer.tbl_san_pham where month(create_date)=month(now()); ";
	Query query=entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return query.getResultList();
}
public List<SanPhamEntity> laySanPhamTheoThoiGian(String start, String end)
{
	String sql="SELECT * FROM salecomputer.tbl_san_pham WHERE create_date between '"+start+"' AND '"+end+"'";
	Query query=entityManager.createNativeQuery(sql, SanPhamEntity.class);
	System.out.println(sql);
	return query.getResultList();
}
public List<SanPhamEntity> categoryParent(BaseDTO productSearch) {
	String sql="";
	if ((productSearch.getCategoryId()!=0)) {
		sql="SELECT * FROM salecomputer.tbl_san_pham s INNER JOIN salecomputer.tbl_danh_muc m ON "
				+ "s.id_danh_muc=m.id WHERE m.id_cha= "+productSearch.getCategoryId()+"";
	}
	Query query = entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return query.getResultList();
	

}
public SanPhamEntity findProductByName(String producName) {
	String sql="SELECT * FROM salecomputer.tbl_san_pham s WHERE s.ten_san_pham= '"+producName+"'";
	Query query = entityManager.createNativeQuery(sql, SanPhamEntity.class);
	return (SanPhamEntity)query.getSingleResult();
}
}
