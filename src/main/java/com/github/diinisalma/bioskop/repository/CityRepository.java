package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Page<City> findByNameLikeIgnoreCase(String name, Pageable pageable);
}
