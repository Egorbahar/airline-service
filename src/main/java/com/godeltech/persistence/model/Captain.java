package com.godeltech.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "captain")
public class Captain {
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

    @OneToMany(mappedBy = "captain")
    private Set<Equipage> equipages = new LinkedHashSet<>();

}