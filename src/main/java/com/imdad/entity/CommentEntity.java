package com.imdad.entity;

import java.time.LocalDate;

import org.hibernate.annotations.ManyToAny;
import org.springframework.data.annotation.CreatedDate;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "COMMENT_TBL")
public class CommentEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commentId;
	private String name;
	private String email;
	@Lob
	private String content;
	
	@CreatedDate
	private LocalDate createdDate;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private PostEntity postEntity;
}
