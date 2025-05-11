package com.github.diinisalma.bioskop.domain;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "t_seat_studio")
@Data
@AllArgsConstructor
public class SeatStudioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "studio_id")
    private StudioEntity studioEntity;

    @ManyToOne
    @JoinColumn(name = "seat_type_id")
    private SeatTypeEntity seatTypeEntity;

    @ManyToOne
    @JoinColumn(name = "seat_element_id")
    private SeatElementEntity seatElementEntity;

    @Column(name = "row")
    private Integer rowIndex;

    @Column(name = "col")
    private Integer colIndex;

    private Long price;

    @Column(name = "is_available")
    private Boolean isAvailable;

    private String code;

    @ManyToMany(mappedBy = "seats")
    private Set<BookingEntity> bookings;

}
