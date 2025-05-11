package com.github.diinisalma.bioskop.domain;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

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
public class BookingEntity {
    @Id
    private String id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private MovieStudioScheduleEntity movieStudioScheduleEntity;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Column(name = "order_timestamp")
    private LocalDateTime orderTimestamp;

    @Column(name = "payment_timestamp")
    private LocalDateTime paymentTimestamp;

    @PrePersist
    public void generateId() {
        LocalDateTime now = LocalDateTime.now();
        this.orderTimestamp = now;
        this.id = now.toEpochSecond(ZoneOffset.UTC) + "_" + this.movieStudioScheduleEntity.getId() + "_"
                + this.userEntity.getId();
    }
}
