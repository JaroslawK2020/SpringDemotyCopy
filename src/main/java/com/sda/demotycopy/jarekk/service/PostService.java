package com.sda.demotycopy.jarekk.service;

import com.sda.demotycopy.jarekk.model.dao.GetResponseList;
import com.sda.demotycopy.jarekk.model.dto.get.GetResponse;
import com.sda.demotycopy.jarekk.model.dto.post.CreatePostRequest;
import com.sda.demotycopy.jarekk.model.dto.post.CreatePostResponse;
import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import com.sda.demotycopy.jarekk.model.dto.put.UpdateRequest;
import com.sda.demotycopy.jarekk.model.dto.put.UpdateResponse;
import com.sda.demotycopy.jarekk.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class PostService {

    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public CreatePostResponse addPostToPostEntityAndReturnResponse(CreatePostRequest postRequest) {
        PostEntity postToSave = new PostEntity();
        postToSave.setTopText(postRequest.getTopText());
        postToSave.setBottomText(postRequest.getBottomText());
        postToSave.setImagePath(postRequest.getImagePath());
        postRepository.save(postToSave);
        return convertPostEntityToPostResponse(postToSave);
    }

    private CreatePostResponse convertPostEntityToPostResponse(PostEntity postEntity) {
        return new CreatePostResponse(postEntity);
    }

    public GetResponse returnPostFromEntity(Long postId) {
        return postRepository.searchById(postId)
                .map(postEntity -> convertPostEntityToGetResponse(postEntity))
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Not found post with provided id"
                ));
    }

    private GetResponse convertPostEntityToGetResponse(PostEntity postEntity) {
        return new GetResponse(postEntity);
    }

    public GetResponseList returnPostsListFromDataBase() {
        GetResponseList getResponseList = new GetResponseList();
        getResponseList.setPosts(
                postRepository.findAll()
                        .stream()
                        .map(postEntity -> convertPostEntityToGetResponse(postEntity))
                        .collect(Collectors.toList()));
        return getResponseList;
    }

    public UpdateResponse updatePost(UpdateRequest updateRequest, Long postId) {
            return postRepository.searchById(postId)
                    .map((postEntity) -> updatePostAndConvertPostEntityToUpdateResponse(updateRequest,postEntity,postId))
                    .orElseThrow(new Supplier<ResponseStatusException>() {
                        @Override
                        public ResponseStatusException get() {
                            return new ResponseStatusException(
                                    HttpStatus.NOT_FOUND,
                                    "Not found post with provided id"
                            );
                        }
                    });
    }

    private UpdateResponse updatePostAndConvertPostEntityToUpdateResponse(UpdateRequest updateRequest, PostEntity postEntity, Long postId) {
        PostEntity postToUpdate = postRepository.getById(postId);
        postToUpdate.setTopText(updateRequest.getTopText());
        postToUpdate.setBottomText(updateRequest.getBottomText());
        postToUpdate.setImagePath(updateRequest.getImagePath());
        postRepository.save(postToUpdate);
        return new UpdateResponse(postEntity);
    }


    public void deletePostById(Long postId) {
        postRepository.searchById(postId)
                .orElseThrow(new Supplier<ResponseStatusException>() {
                    @Override
                    public ResponseStatusException get() {
                        return new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Not found post with provided id"
                        );
                    }
                });
        if(postRepository.existsById(postId))
            postRepository.deleteById(postId);
    }
}
