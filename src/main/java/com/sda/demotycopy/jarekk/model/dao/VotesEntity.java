package com.sda.demotycopy.jarekk.model.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "votesDB")
public class VotesEntity {

    @Id
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private PostEntity postEntity;

    @Column
    private Long voteUp;

    @Column
    private Long voteDown;
}
