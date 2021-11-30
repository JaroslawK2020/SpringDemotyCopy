package com.sda.demotycopy.jarekk.service;

import com.sda.demotycopy.jarekk.model.dto.CreatePostRequest;
import com.sda.demotycopy.jarekk.model.dto.CreatePostResponse;
import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import com.sda.demotycopy.jarekk.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

@Service
public class PostService {

    private final PostRepository postRepository;
    PostEntity postToSave;

    @Autowired
    public PostService(PostRepository postRepository) {
        postToSave = new PostEntity();
        this.postRepository = postRepository;
    }

    public CreatePostResponse addPostToPostEntityAndReturnResponse(CreatePostRequest postRequest){

        postToSave.setTopText(postRequest.getTopText());
        postToSave.setBottomText(postRequest.getBottomText());
        postToSave.setImagePath(postRequest.getImagePath());
        postRepository.save(postToSave);
        return convertPostEntityToPostResponse(postToSave);
    }

    public CreatePostResponse returnPostFromEntity(Long postId){
        return postRepository.searchById(postId)
                .map(postEntity -> convertPostEntityToPostResponse(postEntity))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Not found post with provided id"
                ));
    }

    private CreatePostResponse convertPostEntityToPostResponse(PostEntity postEntity){
        CreatePostResponse respone = new CreatePostResponse(postEntity);
        return respone ;
    }
}
