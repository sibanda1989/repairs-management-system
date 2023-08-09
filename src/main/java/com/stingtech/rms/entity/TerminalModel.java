package com.stingtech.rms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "models")
public class TerminalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long modelId;
    @Column(nullable = false)
    private String modelName;
    @ManyToOne(targetEntity = Vendor.class)
    @JoinColumn(nullable = false)
    private Vendor vendor;

    public TerminalModel(Long modelId, String modelName, Vendor vendor) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.vendor = vendor;
    }

    public TerminalModel() {

    }

    public Long getModelId() {
        return modelId;
    }

    public void setModelId(Long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }
}
