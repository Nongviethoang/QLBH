package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.ThanhVienEntity;

@Repository
public interface ThanhVienRepository extends JpaRepository<ThanhVienEntity,Integer>{

}
