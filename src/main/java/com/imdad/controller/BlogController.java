package com.imdad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.imdad.binding.CreatePostForm;
import com.imdad.entity.CommentEntity;
import com.imdad.entity.PostEntity;
import com.imdad.entity.UserEntity;
import com.imdad.service.BlogService;

import jakarta.servlet.http.HttpSession;

@Controller
public class BlogController {
	
	@Autowired
	BlogService blogService;
	
	@Autowired
	HttpSession httpSession;
	
	
	@GetMapping("/dashboard")
	public String loadDashboardPage(Model model) {
		
		init(model);
		
		return "dashboard";
	}

	private void init(Model model) {
		UserEntity userEntity = (UserEntity)httpSession.getAttribute("userEntity");
		
		List<PostEntity> dashboardData = blogService.getDashboardData(userEntity);
		
		model.addAttribute("posts", dashboardData);
	}

	@GetMapping("/post")
	public String createPostPage(Model model) {
		
		model.addAttribute("postForm", new CreatePostForm());
		
		return "createBlog";
	}
	
	@PostMapping("/post")
	public String savePost(@ModelAttribute("postForm") CreatePostForm form, Model model ) {
		
		boolean status = blogService.createBlogPost(form);
		
		if(status) {
			model.addAttribute("successMsg", "Blog Added successfully");
		} else {
			model.addAttribute("errMsg", "Something is wrong");
		}
		
		return "createBlog";
	}
	
	@GetMapping("/comments")
	public String getAllCommentsForUser(Model model) {
		
		List<CommentEntity> comments = blogService.getAllComment();

		model.addAttribute("comments", comments);
		
		return "comments";
	}
	
	@GetMapping("/deleteComment/{commentId}")
	public String deleteComment(@PathVariable Integer commentId, 
			RedirectAttributes model
			) {
		
		boolean status = blogService.deleteComments(commentId);
		
		if(status) {
			model.addAttribute("successMsg", "Deleted successFully");
		}
		else {
			model.addAttribute("errMsg", "Something wrong");
		}
		
		return "redirect:/comments";
	}
	
	@GetMapping("/editPost/{postId}")
	public String updatePost(@PathVariable Integer postId, Model model) {
		
		CreatePostForm postForm = blogService.getPostForEdit(postId);
		
		model.addAttribute("postForm", postForm);
		
		return "createBlog";
		
	}
	
	@GetMapping("/deletePost/{postId}")
	public String deletePost(@PathVariable Integer postId, Model model) {
		
		boolean status = blogService.deletePostById(postId);
		
		if(status) {
			model.addAttribute("successMsg", "Post deleted");
		}
		else {
			model.addAttribute("errMsg", "Something is wrong");
		}
		
		init(model);
		
		return "dashboard";
	}
}
