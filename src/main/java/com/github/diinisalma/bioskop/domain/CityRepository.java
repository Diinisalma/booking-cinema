package com.github.diinisalma.bioskop.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    Page<CityEntity> findByNameLikeIgnoreCase(String name, Pageable pageable);
}
