package com.example.comments.service;

import com.example.comments.entity.comment_entity;
import com.example.comments.repository.comment_repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class comment_service {
    @Autowired
    comment_repo commentrepo;
    public ResponseEntity<List<comment_entity>> getallcomments(Integer id) {
        try {
            return new ResponseEntity<>(commentrepo.findByBlogId(id), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> addcomments(comment_entity ce) {
        try {
            commentrepo.save(ce);
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Sorry, but couldn't create", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<String> updateblogs(String be, Integer commentId) {
        try{
            List<comment_entity> temp = findbyid(commentId);
            temp.get(0).setCommentContent(be);
            commentrepo.save(temp.get(0));
            return new ResponseEntity<>("Success", HttpStatus.CREATED);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Sorry, but couldn't update", HttpStatus.BAD_REQUEST);
    }

    private List<comment_entity> findbyid(Integer commentId) {
        return commentrepo.findByBlogId(commentId);
    }
}
