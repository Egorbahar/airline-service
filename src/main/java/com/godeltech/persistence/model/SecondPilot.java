package com.godeltech.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "second_pilot")
public class SecondPilot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "flights_number")
    private Integer flightsNumber;

    @Column(name = "rank", nullable = false, length = 50)
    private String rank;
}