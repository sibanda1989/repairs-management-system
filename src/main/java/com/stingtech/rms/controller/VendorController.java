package com.stingtech.rms.controller;

import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/vendors")
    public String listVendors(Model model){
        model.addAttribute("vendors", vendorService.getAllVendors());
        return "vendors";
    }

    @GetMapping("/vendors/new")
    public String createVendorForm(Model model){
        // Create vendor object from form data
        Vendor vendor = new Vendor();
        model.addAttribute("vendor", vendor);
        return "create_vendor";
    }

    @PostMapping("/vendors")
    //create new vendor
    public String saveVendor(@ModelAttribute("vendor") Vendor vendor){
        //accept and save form input to create new vendor
        vendorService.saveVendor(vendor);
        return "redirect:/vendors";
    }

    @GetMapping("/students/edit/{id}")
    public String editVendorForm(@PathVariable Long id, Model model){
        model.addAttribute("vendor", vendorService.getVendorById(id));
        return "edit-vendor";
    }
}
