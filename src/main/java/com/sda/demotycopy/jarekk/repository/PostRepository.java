package com.sda.demotycopy.jarekk.repository;

import com.sda.demotycopy.jarekk.model.dao.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity,Long> {

    @Query("select post from PostEntity post where post.id = :id")
    Optional<PostEntity> searchById(Long id);

}
