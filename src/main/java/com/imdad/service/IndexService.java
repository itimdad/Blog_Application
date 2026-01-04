package com.imdad.service;

import java.util.List;

import com.imdad.binding.CommentForm;
import com.imdad.entity.CommentEntity;
import com.imdad.entity.PostEntity;

public interface IndexService {
	
	public List<PostEntity> getAllPosts();
	
	public PostEntity getPostForIndex(Integer postId);
	
	public boolean doCommentOnPost(CommentForm form);
	
	public List<CommentEntity> getComments(Integer postId);

}
