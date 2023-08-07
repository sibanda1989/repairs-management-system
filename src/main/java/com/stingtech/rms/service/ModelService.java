package com.stingtech.rms.service;

import com.stingtech.rms.entity.TerminalModel;

import java.util.List;

public interface ModelService {
    List<TerminalModel> getAllModels(Long modelId);
    TerminalModel getModelById(Long modelId);
    TerminalModel saveModel(TerminalModel terminalModel);
    TerminalModel updateModel(Long modelId);
    void deleteModel(Long modelId);

}
