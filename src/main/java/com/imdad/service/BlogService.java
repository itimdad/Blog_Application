package com.imdad.service;

import java.util.List;

import com.imdad.binding.CommentForm;
import com.imdad.binding.CreatePostForm;
import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;

public interface BlogService {

	public boolean createBlogPost(CreatePostForm form);
	
	public boolean commentOnPost(CommentForm form);
	
	public PostEntity getPost();
	
	public List<PostEntity> getDashboardData(UserEntity entity);
}
