package com.imdad.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
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
@EntityListeners(AuditingEntityListener.class)
@SQLDelete(sql = "UPDATE comment_tbl SET is_deleted = true WHERE comment_id = ?")
@Where(clause = "is_deleted = false")
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
	@Column( updatable = false)
	private LocalDateTime createdDate;
	
	private boolean isDeleted = false;
	
	@ManyToOne
	@JoinColumn(name = "post_id")
	private PostEntity postEntity;
}
