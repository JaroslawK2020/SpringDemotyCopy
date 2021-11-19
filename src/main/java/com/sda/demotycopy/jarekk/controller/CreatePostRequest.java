package com.sda.demotycopy.jarekk.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class CreatePostRequest {

    private String topText;
    private String bottomText;
    private String imagePath;

    public String getTopText() {
        return topText;
    }

    public void setTopText(String topText) {
        this.topText = topText;
    }

    public String getBottomText() {
        return bottomText;
    }

    public void setBottomText(@Valid @NotNull String bottomText) {
        this.bottomText = bottomText;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(@Valid @NotNull String imagePath) {
        this.imagePath = imagePath;
    }
}
