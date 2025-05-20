package com.github.diinisalma.bioskop.entity;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

import com.github.diinisalma.bioskop.domain.OrderStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
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

    @Column(name = "cancel_timestamp")
    private LocalDateTime cancelTimestamp;

    @PrePersist
    public void generateId() {
        LocalDateTime now = LocalDateTime.now();
        this.orderTimestamp = now;
        this.id = now.toInstant(ZoneOffset.UTC).toEpochMilli() + "_" + this.movieStudioSchedule.getId() + "_"
                + this.user.getId();
    }
}
