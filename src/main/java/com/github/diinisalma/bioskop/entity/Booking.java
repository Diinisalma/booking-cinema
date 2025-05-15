package com.github.diinisalma.bioskop.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Set;

import com.github.diinisalma.bioskop.domain.OrderStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_booking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private MovieStudioSchedule movieStudioSchedule;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private OrderStatus status;

    @Column(name = "order_timestamp", nullable = false)
    private LocalDateTime orderTimestamp;

    @Column(name = "payment_timestamp")
    private LocalDateTime paymentTimestamp;

    @ManyToMany
    @JoinTable(name = "t_order_seat", joinColumns = @JoinColumn(name = "booking_id"), inverseJoinColumns = @JoinColumn(name = "seat_id"))
    private Set<SeatStudio> seats;

    @PrePersist
    public void generateId() {
        LocalDateTime now = LocalDateTime.now();
        this.orderTimestamp = now;
        this.id = now.toEpochSecond(ZoneOffset.UTC) + "_" + this.movieStudioSchedule.getId() + "_"
                + this.user.getId();
    }
}
