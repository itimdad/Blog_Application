package com.imdad.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imdad.entity.PostEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {

}
