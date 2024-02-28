package com.nnh.dal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nnh.dal.reposiroty.CommentRepository;
import com.nnh.dal.reposiroty.DepartmentRepository;
import com.nnh.dal.reposiroty.UserRepository;
import com.nnh.dal.service.ICommentService;
import com.nnh.model.convert.CommentConvert;
import com.nnh.model.dto.CommentDTO;
import com.nnh.model.entity.CommentEntity;

@Service
public class CommentService implements ICommentService{
	@Autowired
	private CommentRepository commentRep;
	@Autowired
	private UserRepository userRep;
	
	@Autowired
	private DepartmentRepository departmentRep;

	public CommentDTO save(CommentDTO dto) {
		CommentEntity entity = CommentConvert.toEntity(dto);
		entity.setDepartmentComment(departmentRep.findById(dto.getDepartmentId()).get());
		entity.setUserComment(userRep.findOneByUsername(dto.getUsername()));
		
		entity = commentRep.save(entity);
		
		return CommentConvert.toDto(entity);
	}

	public List<CommentDTO> findAllByDepartment(Long id) {
		List<CommentDTO> dto = new ArrayList<CommentDTO>();
		List<CommentEntity> comments = commentRep.findByDepartmentComment(departmentRep.findOneById(id));
		for(CommentEntity comment : comments) {
			dto.add(CommentConvert.toDto(comment));
		}
		
		return dto;
	}

	public void delete(Long id) {
		commentRep.deleteById(id);
		
	}
}
