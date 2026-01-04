package com.imdad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imdad.binding.CommentForm;
import com.imdad.entity.CommentEntity;
import com.imdad.entity.PostEntity;
import com.imdad.service.IndexService;

@Controller
public class IndexController {
	
	@Autowired
	IndexService indexService;
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		
		List<PostEntity> allPosts = indexService.getAllPosts();
		
		model.addAttribute("posts", allPosts);
		
		return "index";
	}
	
	
	@GetMapping("/post/{postId}")
	public String viewPost(@PathVariable Integer postId, Model model) {
		
		PostEntity post = indexService.getPostForIndex(postId);
		List<CommentEntity> comments = indexService.getComments(postId);
		
		CommentForm commentForm = new CommentForm();
		commentForm.setPostId(postId);
		
		model.addAttribute("comment", commentForm);
		model.addAttribute("comments", comments);
		
		model.addAttribute("post", post);
		return "post";
	}
	
	@PostMapping("/comment")
	public String saveComment(CommentForm form, Model model) {
		

		indexService.doCommentOnPost(form);

		return "redirect:/post/" + form.getPostId();	}

}
