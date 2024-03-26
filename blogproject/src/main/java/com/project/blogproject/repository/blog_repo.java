package com.project.blogproject.repository;

import com.project.blogproject.entity.blog_entity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface blog_repo extends JpaRepository<blog_entity, Integer> {
    List<blog_entity>findByBlogId(Integer blogId);
}
