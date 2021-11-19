package com.sda.demotycopy.jarekk.controller;

import lombok.Data;

@Data
public class CreatePostResponse {
    private String topText;
    private String bottomText;
    private String imagePath;

    public CreatePostResponse(String topText, String bottomText, String imagePath) {
        this.topText = topText;
        this.bottomText = bottomText;
        this.imagePath = imagePath;
    }


}
