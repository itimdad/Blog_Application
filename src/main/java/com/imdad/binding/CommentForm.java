package com.imdad.binding;

import org.springframework.stereotype.Component;

import lombok.Data;

@Component
@Data
public class CommentForm {
	
	private Integer postId;
	private String name;
	private String email;
	private String content;

}
