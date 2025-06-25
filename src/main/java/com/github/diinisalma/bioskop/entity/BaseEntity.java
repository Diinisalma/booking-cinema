package com.github.diinisalma.bioskop.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Index;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Table;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Data
@MappedSuperclass
public abstract class BaseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -7288225133550170210L;

    @Column(name = "deleted", columnDefinition = "boolean default false")
    private Boolean deleted;
}
