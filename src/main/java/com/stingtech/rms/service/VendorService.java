package com.stingtech.rms.service;

import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class
VendorService {

    private final VendorRepository vendorRepository;

    @Autowired
    public VendorService(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    public List<Vendor> getAllVendors(){
        return vendorRepository.findAll();
    }
    public Vendor getVendorById(Long id){
        Vendor existingVendor = vendorRepository.findById(id).get();
        return existingVendor;
    }
    public Vendor saveVendor(Vendor vendor){
        return vendorRepository.save(vendor);
    }

    public Vendor updateVendor(Long id, Vendor vendor){
        /*
        First establish if Vendor exists, then update vendor with the changes
         */
        Vendor existingVendor = vendorRepository.findById(id).get();
        existingVendor.setVendorName(vendor.getVendorName());

        // now save the vendor
        return vendorRepository.save(existingVendor);
    }

    public void deleteVendor(Long id){
        vendorRepository.deleteById(id);
    }
}
