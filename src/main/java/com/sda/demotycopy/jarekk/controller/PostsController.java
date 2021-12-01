package com.sda.demotycopy.jarekk.controller;

import com.sda.demotycopy.jarekk.model.dto.get.GetPostResponse;
import com.sda.demotycopy.jarekk.model.dto.post.CreatePostRequest;
import com.sda.demotycopy.jarekk.model.dto.post.CreatePostResponse;
import com.sda.demotycopy.jarekk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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

    @ResponseStatus(HttpStatus.ACCEPTED)
    @GetMapping(path = "/api/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetPostResponse returnPostById(@PathVariable(name = "postId") Long postId){
        return postService.returnPostFromEntity(postId);
    }

//    @ResponseStatus(HttpStatus.ACCEPTED)
//    @GetMapping(path ="/api/posts/",produces = MediaType.APPLICATION_JSON_VALUE)
//    public

}
