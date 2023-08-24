package com.stingtech.rms.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "repairs")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repairId;
    @ManyToOne(targetEntity = Terminal.class)
    @JoinColumn(nullable = false)
    private Terminal terminal;
    @Column(name = "date_received", nullable = false)
    private Date dateReceived;
    @Column(name = "date_ready")
    private Date dateReady;
    @Column(name = "fault")
    private String fault;
    @Column(name = "solution")
    private String solution;

    public Repair() {
    }

    public Repair(Date dateReceived, Terminal terminal) {
        this.dateReceived = dateReceived;
        this.terminal = terminal;
    }

    public Repair(Date dateReceived, Terminal terminal, Date dateReady, String fault, String solution) {
        this.dateReceived = dateReceived;
        this.terminal = terminal;
        this.dateReady = dateReady;
        this.fault = fault;
        this.solution = solution;
    }

//    public Repair() {
//    }


    public long getRepairId() {
        return repairId;
    }

    public void setRepairId(long repairId) {
        this.repairId = repairId;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }

    public Date getDateReceived() {
        return dateReceived;
    }

    public void setDateReceived(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Date getDateReady() {
        return dateReady;
    }

    public void setDateReady(Date dateReady) {
        this.dateReady = dateReady;
    }

    public String getFault() {
        return fault;
    }

    public void setFault(String fault) {
        this.fault = fault;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }
}
