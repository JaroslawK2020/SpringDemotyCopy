package com.sda.demotycopy.jarekk.model.dto.get;

import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import lombok.Data;

@Data
public class GetResponse {
    private Long id;
    private String topText;
    private String bottomText;
    private String imagePath;

    public GetResponse(PostEntity postEntity) {
        this.id = postEntity.getId();
        this.topText = postEntity.getTopText();
        this.bottomText = postEntity.getBottomText();
        this.imagePath = postEntity.getImagePath();
    }
}
