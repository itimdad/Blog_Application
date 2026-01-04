package com.imdad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdad.entity.CommentEntity;

public interface CommentRepo  extends JpaRepository<CommentEntity, Integer>{
	
	List<CommentEntity> findByPostEntity_PostIdOrderByCommentIdDesc(Integer postId);
}
