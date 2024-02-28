package com.nnh.dal.service;

import java.util.List;

import com.nnh.model.dto.CommentDTO;

public interface ICommentService {
	CommentDTO save(CommentDTO dto);
	List<CommentDTO> findAllByDepartment(Long id);
	void delete(Long id);
}
