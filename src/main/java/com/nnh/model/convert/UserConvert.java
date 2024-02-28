package com.nnh.model.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnh.dal.reposiroty.CityRepository;
import com.nnh.dal.reposiroty.RoleRepository;
import com.nnh.model.dto.UserDTO;
import com.nnh.model.entity.UserEntity;

@Component
public class UserConvert {
	@Autowired
	private RoleRepository roleRep;
	
	public static UserEntity toEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setFullname(dto.getFullname());
		entity.setUsername(dto.getUsername());
		entity.setPassword(dto.getPassword());
		entity.setPhoneNum(dto.getPhoneNum());
		entity.setEmail(dto.getEmail());
		
		return entity;
	}
	
	public static UserDTO toDto(UserEntity entity) {
		UserDTO dto = new UserDTO();
		dto.setFullname(entity.getFullname());
		dto.setUsername(entity.getUsername());
		dto.setPassword(entity.getPassword());
		dto.setCityName(entity.getCityUser().getName());
		dto.setPhoneNum(entity.getPhoneNum());
		dto.setEmail(entity.getEmail());
		dto.setCityName(entity.getCityUser().getName());
		
		return dto;
	}
}
