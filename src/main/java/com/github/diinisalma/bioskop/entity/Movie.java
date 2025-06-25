package com.github.diinisalma.bioskop.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    // tambah max character
    @Column(length = 200)
    private String synopsis;
    private String[] genre;

    @Column(nullable = false, columnDefinition = "smallint")
    private Integer duration;

    @Column(name = "portrait_image_url")
    private String portraitImageUrl;

    @Column(name = "landscape_image_url")
    private String landscapeImageUrl;

    @OneToMany(mappedBy = "movie")
    private List<MovieStudioSchedule> movieStudioSchedules;


}
