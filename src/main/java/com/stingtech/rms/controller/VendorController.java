package com.stingtech.rms.controller;

import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.service.VendorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class VendorController {

    private final VendorService vendorService;

    public VendorController(VendorService vendorService) {
        this.vendorService = vendorService;
    }

    @GetMapping("/vendors")
    public List<Vendor> getVendors(){
        return vendorService.getAllVendors();
    }
}
