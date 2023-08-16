package com.stingtech.rms.controller;

import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.service.ModelService;
import com.stingtech.rms.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ModelController {

    private final ModelService modelService;
    private final VendorService vendorService;

    @Autowired
    public ModelController(ModelService modelService, VendorService vendorService) {
        this.modelService = modelService;
        this.vendorService = vendorService;
    }

    @GetMapping("/models")
    public String listModels(Model model){
        model.addAttribute("vendors", vendorService.getAllVendors());
        model.addAttribute("terminalModels", modelService.getAllModels());
        return "models";
}

    @GetMapping("/models/new")
    public String createModelForm(Model model){
        //create terminal model from Form data
        List<Vendor> vendors = vendorService.getAllVendors();
        TerminalModel terminalModel = new TerminalModel();
        model.addAttribute("vendors", vendors);
        model.addAttribute("model", terminalModel);
        return "create-model";
    }
    @PostMapping("/models")
    public String saveModel(@ModelAttribute TerminalModel terminalModel){
        modelService.saveModel(terminalModel);
        return "redirect:/models";
    }

    public String updateModel(){
        return null;
    }

    public String deleteModel(){
        return null;
    }


}
