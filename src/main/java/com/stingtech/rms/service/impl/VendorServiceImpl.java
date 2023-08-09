package com.stingtech.rms.service.impl;

import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.repository.VendorRepository;
import com.stingtech.rms.service.VendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }

    @Override
    public Vendor getVendorById(Long id) {
        return vendorRepository.findById(id).get();
    }

    @Override
    public Vendor saveVendor(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor updateVendor(Long id, Vendor vendor) {
        /*
        First establish if Vendor exists, then update vendor with the changes
         */
        Vendor existingVendor = vendorRepository.findById(id).get();
        existingVendor.setVendorName(vendor.getVendorName());

        // now save the vendor
        return vendorRepository.save(existingVendor);
    }

    @Override
    public void deleteVendor(Long id) {
        vendorRepository.deleteById(id);
    }
}
