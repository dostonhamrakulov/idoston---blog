package com.asosiy.idoston.controller;

import com.asosiy.idoston.model.Post;
import com.asosiy.idoston.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @PostMapping(path = "/add")
    public @ResponseBody String addNewPost(@RequestBody Post post){
        postRepository.save(post);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<Post> getAllPosts(){
        return postRepository.findAll();
    }
}
