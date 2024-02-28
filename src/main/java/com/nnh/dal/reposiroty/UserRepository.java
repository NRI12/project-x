package com.nnh.dal.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.User;

import com.nnh.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByUsername(String username);
	UserEntity findOneByEmail(String email);
	UserEntity findOneByPhoneNum(Integer phoneNum);
	UserEntity findOneByUsernameAndPassword(String username, String password);
	UserEntity findOneByFullname(String fullname);
}

