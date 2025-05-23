package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

}
