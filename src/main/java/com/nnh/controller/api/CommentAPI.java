package com.nnh.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nnh.dal.service.ICommentService;

@CrossOrigin
@RestController
public class CommentAPI {
	@Autowired
	private ICommentService commentService;
	
	@PostMapping("/commentdelete")
	public void deleteModel(@RequestBody Long id) {
		commentService.delete(id);
	}
}
	
