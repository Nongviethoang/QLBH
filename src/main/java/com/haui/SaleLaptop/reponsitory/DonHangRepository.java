package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.DonHangEntity;

@Repository
public interface DonHangRepository extends JpaRepository<DonHangEntity, Integer> {

}
