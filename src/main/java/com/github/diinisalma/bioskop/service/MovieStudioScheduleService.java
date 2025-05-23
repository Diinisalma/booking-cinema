package com.github.diinisalma.bioskop.service;

import java.time.LocalDateTime;
import java.util.List;

import com.github.diinisalma.bioskop.dto.MovieStudioScheduleResponseDTO;

public interface MovieStudioScheduleService {
    List<MovieStudioScheduleResponseDTO> findByMovieId(Long movieId, LocalDateTime startTime);

    List<MovieStudioScheduleResponseDTO> findByCityIdAndMovieId(Long cityId, Long movieId, LocalDateTime startTime);
}
