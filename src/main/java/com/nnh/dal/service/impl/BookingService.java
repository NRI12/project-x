package com.nnh.dal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnh.dal.reposiroty.BookingRepository;
import com.nnh.dal.reposiroty.DepartmentRepository;
import com.nnh.dal.service.IBookingService;
import com.nnh.dal.service.IDepartmentService;
import com.nnh.dal.service.IUserService;
import com.nnh.model.convert.BookingConvert;
import com.nnh.model.dto.BookingDTO;
import com.nnh.model.entity.BookingEntity;
import com.nnh.model.entity.UserEntity;

@Service
public class BookingService implements IBookingService{
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IDepartmentService departmentService;
	
	@Autowired
	private BookingRepository bookingRep;
	
	@Autowired
	private DepartmentRepository departmentRep;

	public BookingDTO save(BookingDTO bookingDTO) {
		BookingEntity entity = BookingConvert.toEntity(bookingDTO);
		entity.setDepartment(departmentRep.findById(bookingDTO.getDepartmentId()).get());
		entity = bookingRep.save(entity);
		bookingDTO = BookingConvert.toDto(entity);
		
		return bookingDTO;
	}

	public List<BookingDTO> findByUser(UserEntity user) {
		List<BookingDTO> bookingListToDTO = new ArrayList<BookingDTO>();
		List<BookingEntity> bookingList = bookingRep.findByUserBooking(user);
		
		for(BookingEntity booking : bookingList) {
			bookingListToDTO.add(BookingConvert.toDto(booking));
		}
		
		return bookingListToDTO;
	}

}
