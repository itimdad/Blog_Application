package com.imdad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdad.entity.CommentEntity;

public interface CommentRepo  extends JpaRepository<CommentEntity, Integer>{
	
	
	//getting comments based on post id
	List<CommentEntity> findByPostEntity_PostIdOrderByCommentIdDesc(Integer postId);
	
	//getting comments based on user id
	List<CommentEntity> findByPostEntity_UserEntity_UserId(Integer userId);}
