package com.github.diinisalma.bioskop.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "t_studio")
@Data
@AllArgsConstructor
public class StudioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(name = "row_seats")
    private Integer rowSeats;

    @Column(name = "col_seats")
    private Integer colSeats;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private StudioTypeEntity studioTypeEntity;

    @ManyToOne
    @JoinColumn(name = "cinema_id")
    private CinemaEntity cinemaEntity;
}
