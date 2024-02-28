package com.nnh.dal.reposiroty;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.nnh.model.entity.CityEntity;
import com.nnh.model.entity.DepartmentEntity;

public interface DepartmentRepository extends JpaRepository<DepartmentEntity, Long>{
	List<DepartmentEntity> findAll();
	Page<DepartmentEntity> findAll(Pageable pageable);
	List<DepartmentEntity> findByCityDepartment(CityEntity cityEntity);
	DepartmentEntity findOneById(Long id);
}
