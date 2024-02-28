package com.nnh.dal.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.model.entity.BookingEntity;
import com.nnh.model.entity.UserEntity;

public interface BookingRepository extends JpaRepository<BookingEntity, Long> {
	List<BookingEntity> findByUserBooking(UserEntity user);
}
