package com.sda.demotycopy.jarekk.controller;

import com.sda.demotycopy.jarekk.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "/api/posts")
public class PostsController {
    private final PostService postService;
    private CreatePostResponse createPostResponse;

    @Autowired
    public PostsController(PostService postService) {
        this.postService = postService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void save(@RequestBody CreatePostRequest createPostRequest){
        postService.addPostToPostEntity(
                createPostResponse = new CreatePostResponse(
                createPostRequest.getTopText(),
                createPostRequest.getBottomText(),
                createPostRequest.getImagePath())
        );
    }


}
