package com.sda.demotycopy.jarekk.model.dto.put;

import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import lombok.Data;

@Data
public class UpdateResponse {
    private Long id;
    private String topText;
    private String bottomText;
    private String imagePath;

    public UpdateResponse(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.topText = postEntity.getTopText();
        this.bottomText = postEntity.getBottomText();
        this.imagePath = postEntity.getImagePath();
    }
}
