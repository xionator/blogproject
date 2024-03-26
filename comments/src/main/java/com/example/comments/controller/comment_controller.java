package com.example.comments.controller;

import com.example.comments.entity.comment_entity;
import com.example.comments.service.comment_service;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tocomment")
public class comment_controller {
    @Autowired
    comment_service commentservice;
    @GetMapping("/{id}/comments")
    public ResponseEntity<List<comment_entity>> getthecommentsforblog(@PathVariable("id") Integer id) {
        return commentservice.getallcomments(id);
    }
    @PostMapping("/addcomment")
    public ResponseEntity<String> addcommentstoblog(@RequestBody comment_entity ce){
        return commentservice.addcomments(ce);
    }

    @PutMapping("/updatecomments/{comment_id}")
    public ResponseEntity<String> updateblogs(@RequestBody String be, @PathVariable Integer comment_id){
        return commentservice.updateblogs(be, comment_id);
    }
    @GetMapping("/commentgive/{id}")
    public ResponseEntity<List<comment_entity>> givecomment(@PathVariable("id") Integer id){
        return commentservice.getallcomments(id);
    }

}
