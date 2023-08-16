package com.stingtech.rms.repository;

import com.stingtech.rms.entity.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ModelRepository extends JpaRepository<TerminalModel, Long> {
}
