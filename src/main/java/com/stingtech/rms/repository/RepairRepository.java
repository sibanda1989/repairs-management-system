package com.stingtech.rms.repository;

import com.stingtech.rms.entity.Repair;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RepairRepository extends JpaRepository<Repair, Long> {
//    @Query("SELECT s FROM Repair r WHERE r.repairId = ?1")
//    void delete(Optional<Repair> existingRepair);
}
