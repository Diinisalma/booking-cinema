package com.github.diinisalma.bioskop.web;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.diinisalma.bioskop.dto.MovieStudioScheduleResponseDTO;
import com.github.diinisalma.bioskop.service.MovieStudioScheduleService;

@Controller
@RequestMapping("/cinemas")
public class CinemaController {

    private final MovieStudioScheduleService movieStudioScheduleService;

    public CinemaController(MovieStudioScheduleService movieStudioScheduleService) {
        this.movieStudioScheduleService = movieStudioScheduleService;
    }

    @GetMapping("/city/{cityId}/movie/{movieId}/schedule")
    public ResponseEntity<List<MovieStudioScheduleResponseDTO>> getMovieStudioSchedulesByCityIdAndMovieId(
            @PathVariable Long cityId, @PathVariable Long movieId) {
        return ResponseEntity
                .ok(movieStudioScheduleService.findByCityIdAndMovieId(cityId, movieId, LocalDateTime.now()));
    }
}
