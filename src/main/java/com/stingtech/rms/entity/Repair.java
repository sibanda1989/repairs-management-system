package com.stingtech.rms.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "repairs")
public class Repair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long repairId;
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

    public Repair(Date dateReceived) {
        this.dateReceived = dateReceived;
    }

    public Repair(Date dateReceived, Date dateReady, String fault, String solution) {
        this.dateReceived = dateReceived;
        this.dateReady = dateReady;
        this.fault = fault;
        this.solution = solution;
    }

    public Repair() {
    }
}
