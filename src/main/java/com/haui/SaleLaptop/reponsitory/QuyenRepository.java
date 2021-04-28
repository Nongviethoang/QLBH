package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.QuyenEntity;

@Repository
public interface QuyenRepository extends JpaRepository<QuyenEntity, Integer>{

}
