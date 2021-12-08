package com.sda.demotycopy.jarekk.model.dao;

public enum VotesType {
    VOTE_UP(1),
    VOTES_DOWN(1);

    private int votes;

    private VotesType(int votes) {
        this.votes = votes;
    }
}
