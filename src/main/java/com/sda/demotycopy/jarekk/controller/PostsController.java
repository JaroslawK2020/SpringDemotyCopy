package com.sda.demotycopy.jarekk.controller;

import com.sda.demotycopy.jarekk.model.dao.GetResponseList;
import com.sda.demotycopy.jarekk.model.dto.get.GetResponse;
import com.sda.demotycopy.jarekk.model.dto.post.CreatePostRequest;
import com.sda.demotycopy.jarekk.model.dto.post.CreatePostResponse;
import com.sda.demotycopy.jarekk.model.dto.put.UpdateRequest;
import com.sda.demotycopy.jarekk.model.dto.put.UpdateResponse;
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

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path = "/api/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponse returnPostById(@PathVariable(name = "postId") Long postId){
        return postService.returnPostFromEntity(postId);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping(path ="/api/posts/",produces = MediaType.APPLICATION_JSON_VALUE)
    public GetResponseList returnAllPostsList(){
        return postService.returnPostsListFromDataBase();
    }

    @ResponseStatus(HttpStatus.OK)
    @PutMapping(path = "/api/posts/{postId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UpdateResponse updatePostWithProvidedId(@RequestBody UpdateRequest updateRequest, @PathVariable(name = "postId") Long postId){
        return postService.updatePost(updateRequest,postId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path = "/api/posts/{postId}")
    public void deletePostWithProvidedId(@PathVariable(name = "postId") Long postId){
        postService.deletePostById(postId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path = "/api/posts/{postId}/reactions/votesUp")
    public void setPostByIdVotesUp(@PathVariable(name = "postId") Long postId){
        postService.setPostVotesUp(postId);
    }
}
