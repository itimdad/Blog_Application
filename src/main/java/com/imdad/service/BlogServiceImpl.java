package com.imdad.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdad.binding.CommentForm;
import com.imdad.binding.CreatePostForm;
import com.imdad.entity.CommentEntity;
import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;
import com.imdad.repository.CommentRepo;
import com.imdad.repository.PostRepo;
import com.imdad.repository.UserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class BlogServiceImpl implements BlogService{

	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	HttpSession httpSession;
	
	@Autowired
	CommentRepo commentRepo;



	@Override
	public boolean createBlogPost(CreatePostForm form) {
		// TODO Auto-generated method stub
		
		PostEntity entity = new PostEntity();
		
		BeanUtils.copyProperties(form, entity);
		
		UserEntity userEntity = (UserEntity)httpSession.getAttribute("userEntity");

		entity.setUserEntity(userEntity);
		
		postRepo.save(entity);
		
		return true;
	}


	@Override
	public List<PostEntity> getDashboardData(UserEntity entity) {
		// TODO Auto-generated method stub
		
		List<PostEntity> posts = postRepo.findByUserEntityOrderByPostIdDesc(entity);
		
		return posts;
	}



	@Override
	public List<CommentEntity> getAllComment() {
		// TODO Auto-generated method stub
		
		UserEntity userEntity= (UserEntity) httpSession.getAttribute("userEntity");
		
		List<CommentEntity> comments = commentRepo.findByPostEntity_UserEntity_UserId(userEntity.getUserId());
		
		return comments;
	}


	@Override
	public boolean deleteComments(Integer commentId) {
		
		if(commentId == null) {
			return false;
		}
		
		commentRepo.deleteById(commentId);

		return true;
	}


	@Override
	public CreatePostForm getPostForEdit(Integer postId) {
		// TODO Auto-generated method stub
		PostEntity postEntity = postRepo.findById(postId).get();
		
		CreatePostForm form = new CreatePostForm();
		
		BeanUtils.copyProperties(postEntity, form);
		
		return form;
	}

}
