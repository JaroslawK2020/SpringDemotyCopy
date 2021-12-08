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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne
//    @PrimaryKeyJoinColumn
    private PostEntity postEntity;

    @Column
    private VotesType voteUp;

    @Column
    private VotesType voteDown;
}
