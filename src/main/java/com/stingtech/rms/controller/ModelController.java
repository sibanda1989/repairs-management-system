package com.stingtech.rms.controller;

import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.service.ModelService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ModelController {

    private final ModelService modelService;

    public ModelController(ModelService modelService) {
        this.modelService = modelService;
    }

    @GetMapping("/models")
    public String listModels(){
        modelService.getAllModels();
        return "models";
    }

    @GetMapping("/models/new")
    public String createModelForm(Model model){
        TerminalModel terminalModel = new TerminalModel();
        model.addAttribute("model", terminalModel);
        return "model";
    }
    @PostMapping("/models")
    public String saveModel(@ModelAttribute TerminalModel terminalModel){
        modelService.saveModel(terminalModel);
        return null;
    }

    public String updateModel(){
        return null;
    }

    public String deleteModel(){
        return null;
    }


}
