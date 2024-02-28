package com.nnh.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class CommentEntity extends BaseEntity{
	@Column(name = "content")
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userComment;
	
	@ManyToOne
	@JoinColumn(name = "department_id")
	private DepartmentEntity departmentComment;

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public UserEntity getUserComment() {
		return userComment;
	}

	public void setUserComment(UserEntity userComment) {
		this.userComment = userComment;
	}

	public DepartmentEntity getDepartmentComment() {
		return departmentComment;
	}

	public void setDepartmentComment(DepartmentEntity departmentComment) {
		this.departmentComment = departmentComment;
	}
	
	
}
