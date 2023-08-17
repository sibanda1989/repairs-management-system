package com.stingtech.rms.repository;

import com.stingtech.rms.entity.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/*
This repository extends JpaRepository methods for use in the Service layer.
*/


public interface ModelRepository extends JpaRepository<TerminalModel, Long> {
    @Query("SELECT m FROM models m WHERE m.modelName = ?1")
    Optional<TerminalModel> findModelByName(String modelName);
}
