package com.nnh.dal.service.impl;

import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnh.dal.reposiroty.CityRepository;
import com.nnh.dal.reposiroty.RoleRepository;
import com.nnh.dal.reposiroty.UserRepository;
import com.nnh.dal.service.IUserService;
import com.nnh.model.convert.UserConvert;
import com.nnh.model.dto.UserDTO;
import com.nnh.model.entity.UserEntity;

@Service
public class UserService implements IUserService{
	@Autowired
	private CityRepository cityRep;
	
	@Autowired
	private RoleRepository roleRep;
	
	@Autowired
	private UserRepository userRep;
	
	ResourceBundle rb = ResourceBundle.getBundle("message");

	public UserDTO save(UserDTO dto) {
		UserEntity entity = UserConvert.toEntity(dto);
		String messageStr = "";
		entity.setCityUser(cityRep.findOneByName(dto.getCityName()));
		entity.setRoles(roleRep.findByCode("ADMIN"));
		if(dto.getPassword().equals(dto.getPassword2())) {
			if(userRep.findOneByUsername(dto.getUsername()) == null) {
				if(userRep.findOneByEmail(dto.getEmail()) == null) {
					if(userRep.findOneByPhoneNum(dto.getPhoneNum()) == null) {
						userRep.save(entity);
					} else {
						messageStr = rb.getString("phone-num-exist");
					}
				} else {
					messageStr = rb.getString("email-exist");
				}
			} else {
				messageStr = rb.getString("username-exist");
			}
		} else {
			messageStr = rb.getString("password-not-match");
		}
		dto.setMessage(messageStr);
		
		return dto;
		
	}

	public UserEntity findOne(UserDTO dto) {
		
		return userRep.findOneByUsernameAndPassword(dto.getUsername(), dto.getPassword());
	}
	
	
}
