package com.imdad.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;

public interface PostRepo extends JpaRepository<PostEntity, Integer> {
	
	List<PostEntity> findByUserEntityOrderByPostIdDesc(UserEntity userEntity);
	
	@Query("""
		    SELECT p
		    FROM PostEntity p
		    WHERE p.isDeleted = false
		      AND (
		            LOWER(p.title) LIKE LOWER(CONCAT('%', :searchText, '%'))
		         OR LOWER(p.description) LIKE LOWER(CONCAT('%', :searchText, '%'))
		      )
		""")
		List<PostEntity> getPostOnMatchContent(@Param("searchText") String searchText);

}
