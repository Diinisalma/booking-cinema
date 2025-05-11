package com.github.diinisalma.bioskop.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioRepository extends JpaRepository<StudioEntity, Long> {

}
