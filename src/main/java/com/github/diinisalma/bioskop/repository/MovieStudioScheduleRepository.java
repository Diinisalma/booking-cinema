package com.github.diinisalma.bioskop.repository;

import com.github.diinisalma.bioskop.entity.MovieStudioSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieStudioScheduleRepository extends JpaRepository<MovieStudioSchedule, Long> {

}
