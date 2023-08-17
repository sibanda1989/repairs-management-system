package com.stingtech.rms.repository;

import com.stingtech.rms.entity.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;

/*
This repository extends JpaRepository methods for use in the Service layer.
*/


public interface ModelRepository extends JpaRepository<TerminalModel, Long> {
}
