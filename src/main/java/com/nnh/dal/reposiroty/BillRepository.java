package com.nnh.dal.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.model.entity.BillEntity;

public interface BillRepository extends JpaRepository<BillEntity, Long> {

}
