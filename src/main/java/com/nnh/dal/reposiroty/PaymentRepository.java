package com.nnh.dal.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.model.entity.PaymentEntity;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
