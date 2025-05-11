package com.github.diinisalma.bioskop.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "t_order_seat")
@Data
@AllArgsConstructor
public class OrderSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private BookingEntity orderEntity;

    @ManyToOne
    @JoinColumn(name = "seat_id")
    private SeatStudioEntity seatStudioEntity;
}
