package com.nnh.dal.reposiroty;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nnh.model.entity.CommentEntity;
import com.nnh.model.entity.DepartmentEntity;

public interface CommentRepository extends JpaRepository<CommentEntity, Long>{
	List<CommentEntity> findByDepartmentComment(DepartmentEntity department);
}
