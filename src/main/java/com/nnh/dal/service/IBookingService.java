package com.nnh.dal.service;

import java.util.List;

import com.nnh.model.dto.BookingDTO;
import com.nnh.model.entity.UserEntity;

public interface IBookingService {
	BookingDTO save(BookingDTO bookingDTO);
	List<BookingDTO> findByUser(UserEntity user);
}
