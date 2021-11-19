package com.sda.demotycopy.jarekk.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String topText;

    @Column
    private String bottomText;

    @Column
    private String imagePath;

    @Override
    public String toString() {
        return "PostEntity{" +
                "id=" + id +
                ", topText='" + topText + '\'' +
                ", bottomText='" + bottomText + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}
