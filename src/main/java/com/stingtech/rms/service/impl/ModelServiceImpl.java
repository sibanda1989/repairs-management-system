package com.stingtech.rms.service.impl;

import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.repository.ModelRepository;
import com.stingtech.rms.service.ModelService;

import java.util.List;

public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;

    public ModelServiceImpl( ModelRepository modelRepository) {
        this.modelRepository = modelRepository;
    }

    @Override
    public List<TerminalModel> getAllModels() {
        return modelRepository.findAll();
    }

    @Override
    public TerminalModel getModelById(Long modelId) {
        return modelRepository.findById(modelId).get();
    }

    @Override
    public TerminalModel saveModel(TerminalModel terminalModel){
        return modelRepository.save(terminalModel);
    }

    @Override
    public TerminalModel updateModel(Long modelId) {
        return null;
    }

    @Override
    public void deleteModel(Long modelId) {

    }
}
