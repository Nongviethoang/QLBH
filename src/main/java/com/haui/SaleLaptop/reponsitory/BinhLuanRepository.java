package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.BinhLuanEntity;

@Repository
public interface BinhLuanRepository extends JpaRepository<BinhLuanEntity,Integer> {

}
