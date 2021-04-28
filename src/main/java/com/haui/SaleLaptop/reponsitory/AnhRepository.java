package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.AnhSanPhamEntity;
@Repository
public interface AnhRepository extends JpaRepository<AnhSanPhamEntity, Integer> {

}
