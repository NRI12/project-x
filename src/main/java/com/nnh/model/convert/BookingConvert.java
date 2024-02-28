package com.nnh.model.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnh.dal.reposiroty.DepartmentRepository;
import com.nnh.model.dto.BookingDTO;
import com.nnh.model.entity.BookingEntity;

@Component
public class BookingConvert {
	@Autowired
	private DepartmentRepository departmentRep;
	
	public static BookingDTO toDto(BookingEntity entity) {
		BookingDTO dto = new BookingDTO();
		dto.setCheckinDate(entity.getCheckinDate());
		dto.setCheckoutDate(entity.getCheckoutDate());
		dto.setAdultAmount(entity.getAdultAmount());
		dto.setChildAmount(entity.getChildAmount());
		dto.setDepartmentName(entity.getDepartment().getTitle());
		dto.setCreatedDate(entity.getCreatedDate());
		
		return dto;
	}
	
	public static BookingEntity toEntity(BookingDTO dto) {
		BookingEntity entity = new BookingEntity();
		entity.setCheckinDate(dto.getCheckinDate());
		entity.setCheckoutDate(dto.getCheckoutDate());
		entity.setAdultAmount(dto.getAdultAmount());
		entity.setChildAmount(dto.getChildAmount());
		entity.setUserBooking(dto.getUser());
		entity.setBookingDate(entity.getModifiedDate());
		
		return entity;
	}
}
