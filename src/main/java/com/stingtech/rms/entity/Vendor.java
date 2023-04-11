package com.stingtech.rms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendors")
public class Vendor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long vendorId;
    @Column(nullable = false)
    private String vendorName;
}
