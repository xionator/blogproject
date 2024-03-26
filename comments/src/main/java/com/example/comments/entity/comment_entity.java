package com.example.comments.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class comment_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "comment_content")
    private String commentContent;
    @Column(name = "blog_id")
    private Integer blogId;

}
