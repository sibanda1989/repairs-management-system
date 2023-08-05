package com.stingtech.rms.service;

import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.repository.ModelRepository;

import java.util.List;

public interface ModelService{
    List<TerminalModel> getAllModels();
    TerminalModel getModelById(Long modelId);
    TerminalModel saveModel(TerminalModel terminalModel);
    TerminalModel updateModel(Long modelId);
    void deleteModel(Long modelId);
}
