package com.imdad.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.imdad.binding.CreatePostForm;
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
		
		UserEntity userEntity = (UserEntity)httpSession.getAttribute("userEntity");
		
		List<PostEntity> dashboardData = blogService.getDashboardData(userEntity);
		
		model.addAttribute("", dashboardData);
		
		return "dashboard";
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
}
