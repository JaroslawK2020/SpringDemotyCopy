package com.sda.demotycopy.jarekk.repository;

import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Profile("database")
public interface PostRepository extends JpaRepository<PostEntity,Long> {
    PostEntity addPost(PostEntity postEntity);

}
