package com.stingtech.rms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terminals")
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long terminalId;
    @Column(nullable = false)
    private String ptid;
    @ManyToOne(targetEntity = TerminalModel.class)
    @JoinColumn(nullable = false)
    private TerminalModel terminalModel;

    public Terminal(String ptid) {
        this.ptid = ptid;
    }

    public Terminal() {

    }
}
