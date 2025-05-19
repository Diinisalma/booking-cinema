package com.github.diinisalma.bioskop.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "t_studio")
@Data
@AllArgsConstructor
public class Studio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "row_seats", nullable = false)
    private Integer rowSeats;

    @Column(name = "col_seats", nullable = false)
    private Integer colSeats;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private StudioType studioType;

    @ManyToOne
    @JoinColumn(name = "cinema_id", nullable = false)
    private Cinema cinema;
}
