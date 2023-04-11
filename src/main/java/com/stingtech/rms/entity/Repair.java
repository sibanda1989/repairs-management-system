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
    @JoinColumn(name = "terminal", nullable = false)
    private Terminal terminal;
    @Column(name = "date_received", nullable = false)
    private Date dateReceived;
    @Column(name = "date_ready", nullable = false)
    private Date dateReady;
    @Column(name = "fault", nullable = false)
    private String fault;
    @Column(name = "solution", nullable = false)
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
