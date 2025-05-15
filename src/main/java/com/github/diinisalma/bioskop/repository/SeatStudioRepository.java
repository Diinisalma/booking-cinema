package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.SeatStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatStudioRepository extends JpaRepository<SeatStudio, Long> {

}
