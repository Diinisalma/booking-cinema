package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.SeatType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatTypeRepository extends JpaRepository<SeatType, Long> {

}
