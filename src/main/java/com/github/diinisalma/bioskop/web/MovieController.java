package com.github.diinisalma.bioskop.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.diinisalma.bioskop.dto.MovieDetailResponseDTO;
import com.github.diinisalma.bioskop.dto.MovieListResponseDTO;
import com.github.diinisalma.bioskop.service.MovieService;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieListResponseDTO>> getMovies() {
        return ResponseEntity.ok(movieService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailResponseDTO> getMovieById(@PathVariable Long id) {
        return ResponseEntity.ok(movieService.findById(id));
    }

}
