package com.sda.demotycopy.jarekk.service;

import com.sda.demotycopy.jarekk.model.dto.CreatePostRequest;
import com.sda.demotycopy.jarekk.model.dto.CreatePostResponse;
import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import com.sda.demotycopy.jarekk.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public CreatePostResponse addPostToPostEntityAndReturnResponse(CreatePostRequest postRequest){
        PostEntity postToSave = new PostEntity();
        postToSave.setTopText(postRequest.getTopText());
        postToSave.setBottomText(postRequest.getBottomText());
        postToSave.setImagePath(postRequest.getImagePath());
        postRepository.save(postToSave);
        CreatePostResponse postResponse = new CreatePostResponse(postToSave);
        return postResponse;
    }
}
