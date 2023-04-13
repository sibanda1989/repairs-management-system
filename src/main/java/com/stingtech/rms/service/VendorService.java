package com.stingtech.rms.service;

import com.stingtech.rms.entity.Vendor;

import java.util.List;

public interface VendorService {
    List<Vendor> getAllVendors();
    Vendor getVendorById(Long id);
    Vendor saveVendor(Vendor vendor);

    Vendor updateVendor(Vendor existingVendor);
}
