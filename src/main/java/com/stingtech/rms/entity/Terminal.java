package com.stingtech.rms.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terminals")
public class Terminal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long terminalId;
    @Column(nullable = false)
    private String ptid;
    @ManyToOne(targetEntity = TerminalModel.class)
    @JoinColumn(nullable = false)
    private TerminalModel terminalModel;

    public Terminal(Long terminalId, String ptid, TerminalModel terminalModel) {
        this.terminalId = terminalId;
        this.ptid = ptid;
        this.terminalModel = terminalModel;
    }

    public Terminal() {
    }

    public Long getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(Long terminalId) {
        this.terminalId = terminalId;
    }

    public String getPtid() {
        return ptid;
    }

    public void setPtid(String ptid) {
        this.ptid = ptid;
    }

    public TerminalModel getTerminalModel() {
        return terminalModel;
    }

    public void setTerminalModel(TerminalModel terminalModel) {
        this.terminalModel = terminalModel;
    }
}
