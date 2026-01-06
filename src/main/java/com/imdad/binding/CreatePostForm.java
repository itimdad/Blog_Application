package com.imdad.binding;

import lombok.Data;

@Data
public class CreatePostForm {

	private Integer postId;
	private String title;
	private String description;
	private String content;
}
