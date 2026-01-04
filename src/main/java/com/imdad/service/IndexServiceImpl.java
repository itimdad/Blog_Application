package com.imdad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdad.binding.CommentForm;
import com.imdad.entity.CommentEntity;
import com.imdad.entity.PostEntity;
import com.imdad.repository.CommentRepo;
import com.imdad.repository.PostRepo;

@Service
public class IndexServiceImpl implements IndexService{
	
	@Autowired
	CommentRepo commentRepo;
	
	@Autowired
	PostRepo postRepo;

	@Override
	public List<PostEntity> getAllPosts() {

		List<PostEntity> allPosts = postRepo.findAll();
		
		return allPosts;
	}

	@Override
	public PostEntity getPostForIndex(Integer postId) {
		// TODO Auto-generated method stub
		
		PostEntity postEntity = postRepo.findById(postId).get();
		
		return postEntity;
	}

	@Override
	public boolean doCommentOnPost(CommentForm form) {
		// TODO Auto-generated method stub
		
		CommentEntity entity = new CommentEntity();
		
		//finding post by post id
		
		PostEntity postEntity = postRepo.findById(form.getPostId()).get();
		
		//copying form data to the comment entity
		BeanUtils.copyProperties(form, entity);
		
		//setting post data in comment
		entity.setPostEntity(postEntity);
		
		//saving comment
		commentRepo.save(entity);
		
		return true;
	}

	@Override
	public List<CommentEntity> getComments(Integer postId) {

		List<CommentEntity> comments = commentRepo.findByPostEntity_PostIdOrderByCommentIdDesc(postId);
		
		return comments;
	}



}
