package com.godeltech.persistence.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "airport")
public class Airport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "code", nullable = false, length = 3)
    private String code;
    @Column(name = "city_name", nullable = false, length = 25)
    private String cityName;
    @Column(name = "visibility", nullable = false)
    private Integer visibility;

}