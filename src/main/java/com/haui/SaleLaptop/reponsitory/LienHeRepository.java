package com.haui.SaleLaptop.reponsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.haui.SaleLaptop.entities.LienHeEntity;


@Repository
public interface LienHeRepository extends JpaRepository<LienHeEntity,Integer>{

}
