package com.imdad.service;

import java.util.List;

import com.imdad.binding.CommentForm;
import com.imdad.binding.CreatePostForm;
import com.imdad.entity.CommentEntity;
import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;

public interface BlogService {

	public boolean createBlogPost(CreatePostForm form);
	
	public List<CommentEntity> getAllComment();
	
	public boolean deleteComments(Integer commentId);
	
	public List<PostEntity> getDashboardData(UserEntity entity);
	
	public CreatePostForm getPostForEdit(Integer postId);
	
	public boolean deletePostById(Integer postId);
}
