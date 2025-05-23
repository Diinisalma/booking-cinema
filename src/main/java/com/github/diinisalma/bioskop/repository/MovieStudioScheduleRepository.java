package com.github.diinisalma.bioskop.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.github.diinisalma.bioskop.entity.MovieStudioSchedule;

@Repository
public interface MovieStudioScheduleRepository extends JpaRepository<MovieStudioSchedule, Long> {
        List<MovieStudioSchedule> findByMovieIdAndStartTimeGreaterThan(Long movieId, LocalDateTime startTime);

        @Query("SELECT mss FROM MovieStudioSchedule mss " +
                        "JOIN mss.studio s " +
                        "JOIN s.cinema c " +
                        "WHERE c.city.id = :cityId " +
                        "AND mss.movie.id = :movieId " +
                        "AND mss.startTime > :startTime")
        List<MovieStudioSchedule> findByCityIdAndMovieId(Long cityId, Long movieId, LocalDateTime startTime);

        @Query(value = "SELECT mss.* FROM t_movie_studio_schedule mss " +
                        "JOIN t_studio s ON s.id = mss.studio_id " +
                        "JOIN t_cinema c ON c.id = s.cinema_id " +
                        "WHERE c.city_id = :cityId " +
                        "AND mss.movie_id = :movieId " +
                        "AND mss.start_time::time > (:timeOnly)::time", nativeQuery = true)
        List<MovieStudioSchedule> findByCityIdAndMovieIdAndTimeOnly(Long cityId, Long movieId, LocalDateTime timeOnly);
}
