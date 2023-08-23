package com.stingtech.rms.service;

import com.stingtech.rms.entity.Repair;
import com.stingtech.rms.repository.RepairRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RepairService {

    private final RepairRepository repairRepository;

    @Autowired
    public RepairService(RepairRepository repairRepository) {
        this.repairRepository = repairRepository;
    }

    public List<Repair> getRepairs() {
        return repairRepository.findAll();
    }

    public Repair addRepair(Repair repair) {
        return repairRepository.save(repair);
    }

    public Optional<Repair> getRepairById(Long repairId){
        return repairRepository.findById(repairId);
    }
    public void deleteRepair(Long repairId) {
        repairRepository.deleteById(repairId);
    }

    public Repair updateRepair(Long repairId) {

        return null;
    }
}
