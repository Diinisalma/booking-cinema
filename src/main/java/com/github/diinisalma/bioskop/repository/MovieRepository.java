package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
