package com.stingtech.rms.controller;

import com.stingtech.rms.entity.TerminalModel;
import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.service.ModelService;
import com.stingtech.rms.service.VendorService;
import org.springframework.beans.NotReadablePropertyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.util.List;
import java.util.Optional;

@Controller()
//@RequestMapping("/model")
public class ModelController {

    private final ModelService modelService;
    private final VendorService vendorService;

    @Autowired
    public ModelController(ModelService modelService, VendorService vendorService) {
        this.modelService = modelService;
        this.vendorService = vendorService;
    }

    @GetMapping("/model/models")
    public String listModels(Model model){
        model.addAttribute("vendors", vendorService.getAllVendors());
        model.addAttribute("terminalModels", modelService.getAllModels());
        return "model/models";
}

    @GetMapping("/model/models/new")
    public String createModelForm(Model model){
        //create terminal model from Form data
        List<Vendor> vendors = vendorService.getAllVendors();
        TerminalModel terminalModel = new TerminalModel();
        model.addAttribute("vendors", vendors);
        model.addAttribute("model", terminalModel);
        return "model/create-model";
    }
    @PostMapping("/models")
    public String saveModel(@ModelAttribute TerminalModel terminalModel, Model model){
        try{
            modelService.saveModel(terminalModel);
        }
        catch(IllegalStateException exception){
            String errorMessage = "Model already exists!";
            model.addAttribute("error", errorMessage);
            throw exception; //rethrow the exception to GlobalExceptionHandler class
        }
        return "redirect:/model/models";
    }

    @GetMapping("/model/models/edit/{id}")
    public String editModelForm(@PathVariable Long id, Model model)
    throws Exception {
        model.addAttribute("terminalModel", modelService.getModelById(id));
        model.addAttribute("vendor", vendorService.getAllVendors());
        return "model/edit-model";
    }

    /*
       This method handles updating of models. It takes the id of the model and updates the relevant field.
       The updated terminalModel object is then POSTed
     */
    @PostMapping("/models/{id}")
    public String updateModel(@PathVariable Long id, @ModelAttribute TerminalModel terminalModel, Model model){
        modelService.updateModel(id, terminalModel);
        return "redirect:/model/models";
    }

    //method to handle delete model
    @GetMapping("/model/models/{id}")
    public String deleteModel(@PathVariable Long id){
        //delete student by id
        modelService.deleteModel(id);
        return "redirect:/model/models";
    }


}
