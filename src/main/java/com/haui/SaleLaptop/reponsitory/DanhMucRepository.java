package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.DanhMucEntity;

@Repository
public interface DanhMucRepository extends JpaRepository<DanhMucEntity, Integer>{

}
