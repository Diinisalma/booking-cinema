package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, String> {

}
