package com.project.blogproject.service;

import com.project.blogproject.entity.blog_entity;
import com.project.blogproject.repository.blog_repo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class blog_service {
    @Autowired
    blog_repo blogrepo;
    public ResponseEntity<List<blog_entity>> getallblogs() {
        try{
            return new ResponseEntity<>(blogrepo.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addblogs(blog_entity be) {
        try {
            blogrepo.save(be);
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Sorry, but couldn't create", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> updateblogs(String be, Integer blogId) {
        try {
            List<blog_entity> temp = findbyid(blogId);
            temp.get(0).setBlogContent(be);
            blogrepo.save(temp.get(0));
            return new ResponseEntity<>("Success", HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>("Sorry, but couldn't update", HttpStatus.BAD_REQUEST);
    }

    public List<blog_entity> findbyid(Integer blogId) {
        return blogrepo.findByBlogId(blogId);
    }
}
