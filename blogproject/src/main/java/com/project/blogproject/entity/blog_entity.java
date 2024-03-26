package com.project.blogproject.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class blog_entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blog_id")
    private Integer blogId;
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "blog_content")
    private String blogContent;
    @Column(name = "blog_category")
    private String blogCategory;
}
