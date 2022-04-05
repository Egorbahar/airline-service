package com.godeltech.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "equipage")
public class Equipage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "engineer_id")
    private Engineer engineer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "capitan_id")
    private Capitan capitan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "second_pilot_id")
    private SecondPilot secondPilot;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stewardess_id")
    private Stewardess stewardess;

}