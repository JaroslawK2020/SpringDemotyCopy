package com.sda.demotycopy.jarekk.repository;

import com.sda.demotycopy.jarekk.model.dao.VotesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotesRepository extends JpaRepository<VotesEntity, Long> {
}
