package com.haui.SaleLaptop.reponsitory;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.ChiTietEntity;

@Repository
public interface ChiTietDonHangRepository extends JpaRepository<ChiTietEntity, Integer> {

}
