package com.nnh.dal.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.model.entity.RoleEntity;
import com.nnh.model.entity.UserEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
	List<RoleEntity> findByCode(String code);
	RoleEntity findOneByUsers(UserEntity user);
}
