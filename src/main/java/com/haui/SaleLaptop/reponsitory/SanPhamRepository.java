package com.haui.SaleLaptop.reponsitory;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.haui.SaleLaptop.entities.SanPhamEntity;

@Repository
public interface SanPhamRepository extends JpaRepository<SanPhamEntity, Integer>{
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("update SanPhamEntity sp set sp.soLuong =:soLuong where sp.id =:Id")
	void update(@Param("Id") int  id, @Param("soLuong") int soLuong);
}
