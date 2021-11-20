package com.sda.demotycopy.jarekk.service;

import com.sda.demotycopy.jarekk.controller.CreatePostResponse;
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

    public void addPostToPostEntity(CreatePostResponse postResponse){
        PostEntity postToSave = new PostEntity();
        postToSave.setTopText(postResponse.getTopText());
        postToSave.setBottomText(postResponse.getBottomText());
        postToSave.setImagePath(postResponse.getImagePath());
        postRepository.save(postToSave);
    }
}
