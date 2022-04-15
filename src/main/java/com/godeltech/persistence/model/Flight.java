package com.godeltech.persistence.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departure_airport_id", nullable = false)
    private Airport departureAirport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arrival_airport_id", nullable = false)
    private Airport arrivalAirport;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "plane_id", nullable = false)
    private Airplane plane;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "captain_id", nullable = false)
    private Captain captain;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "second_pilot_id", nullable = false)
    private SecondPilot secondPilot;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "stewardess_id", nullable = false)
    private Stewardess stewardess;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "engineer_id", nullable = false)
    private Engineer engineer;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_progress_status_id")
    private FlightProgressStatus flightProgressStatus;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_start_status_id")
    private FlightStartStatus flightStartStatus;

}