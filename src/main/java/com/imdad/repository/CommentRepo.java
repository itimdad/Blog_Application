package com.imdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdad.entity.CommentEntity;

public interface CommentRepo  extends JpaRepository<CommentEntity, Integer>{

}
