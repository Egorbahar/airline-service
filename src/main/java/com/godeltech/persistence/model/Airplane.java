package com.godeltech.persistence.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "airplane")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "wind_speed", nullable = false)
    private Double windSpeed;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

}