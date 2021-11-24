package com.sda.demotycopy.jarekk.controller;

import com.sda.demotycopy.jarekk.model.dto.CreatePostRequest;
import com.sda.demotycopy.jarekk.model.dto.CreatePostResponse;
import com.sda.demotycopy.jarekk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class PostsController {
    private final PostService postService;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/api/posts")
    public CreatePostResponse save(@RequestBody CreatePostRequest createPostRequest){
        return postService.addPostToPostEntityAndReturnResponse(createPostRequest);
    }
}
