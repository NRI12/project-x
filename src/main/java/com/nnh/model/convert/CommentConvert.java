package com.nnh.model.convert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nnh.dal.reposiroty.DepartmentRepository;
import com.nnh.model.dto.CommentDTO;
import com.nnh.model.entity.CommentEntity;

@Component
public class CommentConvert {
	public static CommentDTO toDto(CommentEntity entity) {
		CommentDTO dto = new CommentDTO();
		dto.setId(entity.getId());
		dto.setContent(entity.getContent());
		dto.setDepartmentId(entity.getDepartmentComment().getId());
		dto.setFullname(entity.getUserComment().getFullname());
		dto.setUsername(entity.getUserComment().getUsername());
		dto.setCreatedDate(entity.getCreatedDate());
		
		return dto;
	}
	
	public static CommentEntity toEntity(CommentDTO dto) {
		CommentEntity entity = new CommentEntity();
		entity.setContent(dto.getContent());
		
		
		return entity;
	}
}
