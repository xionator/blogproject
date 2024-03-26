package com.example.comments.repository;

import com.example.comments.entity.comment_entity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface comment_repo extends JpaRepository<comment_entity, Integer> {
    List<comment_entity> findByBlogId(Integer id);
}
