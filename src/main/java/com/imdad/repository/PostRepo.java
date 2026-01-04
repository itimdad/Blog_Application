package com.imdad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
	
	List<PostEntity> findByUserEntityOrderByPostIdDesc(UserEntity userEntity);
}
