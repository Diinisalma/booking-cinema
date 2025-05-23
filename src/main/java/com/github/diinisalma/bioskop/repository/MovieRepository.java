package com.github.diinisalma.bioskop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.diinisalma.bioskop.entity.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN m.movieStudioSchedules mss " +
            "JOIN mss.studio s " +
            "JOIN s.cinema c " +
            "WHERE c.city.id = :cityId")
    List<Movie> findByCityId(@Param("cityId") Long cityId);
}
