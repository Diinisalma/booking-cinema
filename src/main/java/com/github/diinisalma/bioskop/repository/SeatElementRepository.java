package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.SeatElement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatElementRepository extends JpaRepository<SeatElement, Long> {

}
