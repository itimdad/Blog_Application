package com.imdad.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "POST_TBL")
public class PostEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;
	
	@CreatedDate
	private LocalDate createdDate;
	private String title;
	private String description;
	
	@Lob
	private String content;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity userEntity;
	
	@OneToMany(mappedBy = "postEntity", cascade = CascadeType.REMOVE)
	private List<CommentEntity> comments;
}
