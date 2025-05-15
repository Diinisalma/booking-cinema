package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.StudioType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudioTypeRepository extends JpaRepository<StudioType, Long> {

}
