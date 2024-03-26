package com.project.blogproject.controller;


import com.project.blogproject.entity.blog_entity;
import com.project.blogproject.entity.comment_entity_copy;
import com.project.blogproject.service.blog_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/toblog")
public class blog_controller {
    @Autowired
    blog_service blogservice;
    RestTemplate restTemplate;

    @GetMapping("/getblogs")
    public ResponseEntity<List<blog_entity>> gettheblogs(){return blogservice.getallblogs();}
    @GetMapping("getblogs/{id}")
    public List<blog_entity> findbyid(@PathVariable("id") Integer blogId){
        return blogservice.findbyid(blogId);
    }

    @PostMapping("/addblogs")
    public ResponseEntity<String> addblogs(@RequestBody blog_entity be){
        return blogservice.addblogs(be);
    }

    @PutMapping("/updateblogs/{blog_id}")
    public ResponseEntity<String> updateblogs(@RequestBody String be, @PathVariable Integer blog_id){
        return blogservice.updateblogs(be, blog_id);
    }
    @GetMapping("getblogs/{id}/comments")
    List<comment_entity_copy> getcomments(@PathVariable("id") Integer id, RestTemplate restTemplate1){
        String url = String.format("http://localhost:8081/tocomment/commentgive/%d", id);
        System.out.println(url);
        List<comment_entity_copy> g = restTemplate1.getForObject(url, List.class);
        System.out.println(g);
        return g;
    }

}