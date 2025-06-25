package com.github.diinisalma.bioskop.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.diinisalma.bioskop.entity.City;

import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Page<City> findByNameLikeIgnoreCase(String name, Pageable pageable);

    // @Query("SELECT DISTINCT city FROM City city " +
    //        "JOIN city.cinemas cinema " +
    //        "JOIN cinema.studios studio " +
    //        "JOIN studio.movieStudioSchedules mss " +
    //        "WHERE mss.movie.id = :movieId " +
    //        "AND LOWER(city.name) LIKE LOWER(CONCAT('%', :cityName, '%'))")
    // Page<City> getByMovieId(Long movieId, String cityName, Pageable pageable);
}
