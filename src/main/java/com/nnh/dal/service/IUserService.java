package com.nnh.dal.service;

import com.nnh.model.dto.UserDTO;
import com.nnh.model.entity.UserEntity;

public interface IUserService {
	UserDTO save(UserDTO dto);
	UserEntity findOne(UserDTO dto);
}
