package com.imdad.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imdad.binding.CommentForm;
import com.imdad.binding.CreatePostForm;
import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;
import com.imdad.repository.PostRepo;
import com.imdad.repository.UserRepo;
import jakarta.servlet.http.HttpSession;

@Service
public class BlogServiceImpl implements BlogService{

    private final UserRepo userRepo;
	
	@Autowired
	PostRepo postRepo;
	
	@Autowired
	HttpSession httpSession;

    BlogServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

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
	public boolean commentOnPost(CommentForm form) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PostEntity getPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostEntity> getDashboardData(UserEntity entity) {
		// TODO Auto-generated method stub
		
		List<PostEntity> posts = postRepo.findByUserEntityOrderByPostIdDesc(entity);
		
		
		
		return posts;
	}

}
