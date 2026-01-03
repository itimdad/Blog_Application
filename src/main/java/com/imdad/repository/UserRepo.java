package com.imdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdad.entity.UserEntity;

public interface UserRepo extends JpaRepository<UserEntity, Integer>{
	
	public UserEntity findByEmail(String email);

}
