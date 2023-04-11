package com.stingtech.rms.service.impl;

import com.stingtech.rms.entity.Vendor;
import com.stingtech.rms.repository.VendorRepository;
import com.stingtech.rms.service.VendorService;

import java.util.List;

public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;

    public VendorServiceImpl(VendorRepository vendorRepository) {
        this.vendorRepository = vendorRepository;
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorRepository.findAll();
    }
}
