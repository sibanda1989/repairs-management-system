package com.stingtech.rms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class TerminalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private long modelId;
    @Column(nullable = false)
    private String modelName;
    @ManyToOne(targetEntity = Vendor.class)
    @JoinColumn(nullable = false)
    private Vendor vendor;
}
