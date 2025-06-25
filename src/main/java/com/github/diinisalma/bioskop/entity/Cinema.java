package com.github.diinisalma.bioskop.entity;

import java.util.Set;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_cinema")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SecureIdIndex
@EqualsAndHashCode(callSuper = true)
public class Cinema extends SecureIdBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "city_id", nullable = false)
    private City city;

    @OneToMany(mappedBy="cinema")
    private Set<Studio> studios;
}
