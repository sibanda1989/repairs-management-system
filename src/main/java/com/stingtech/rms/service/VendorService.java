package com.stingtech.rms.service;

import com.stingtech.rms.entity.Vendor;

import java.util.List;

public interface IVendorService {
    List<Vendor> getAllVendors();
    Vendor getVendorById(Long id);
    Vendor saveVendor(Vendor vendor);

    Vendor updateVendor(Vendor existingVendor);

    void deleteVendor(Long id);
}
