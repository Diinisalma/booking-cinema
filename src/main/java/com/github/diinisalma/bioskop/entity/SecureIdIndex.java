package com.github.diinisalma.bioskop.entity;

import jakarta.persistence.Index;
import jakarta.persistence.Table;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Table(indexes = {
        @Index(name = "secure_id_idx", columnList = "secure_id")
})
public @interface SecureIdIndex {}
