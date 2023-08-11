package com.stingtech.rms.service;

import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModelService{
    private final ModelRepository modelRepository;

    @Autowired
    public ModelService(ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }


    public List<TerminalModel> getAllModels(){
        return modelRepository.findAll();
    }
    public TerminalModel getModelById(Long modelId){
        return modelRepository.findById(modelId).get();
    }
    public TerminalModel saveModel(TerminalModel terminalModel){
        return modelRepository.save(terminalModel);
    }
    public TerminalModel updateModel(Long modelId, TerminalModel terminalModel){
        /*
        First establish if model exists, then update model with the changes
         */
        TerminalModel existingModel = modelRepository.findById(modelId).get();
        existingModel.setModelName(terminalModel.getModelName());

        // now save the vendor
        return modelRepository.save(existingModel);
    }
    public void deleteModel(Long modelId){
        modelRepository.deleteById(modelId);
    }
}
