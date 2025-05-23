package com.github.diinisalma.bioskop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.diinisalma.bioskop.dto.MovieDetailResponseDTO;
import com.github.diinisalma.bioskop.dto.MovieListResponseDTO;
import com.github.diinisalma.bioskop.entity.Movie;
import com.github.diinisalma.bioskop.repository.MovieRepository;
import com.github.diinisalma.bioskop.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public List<MovieListResponseDTO> findAll() {
        List<Movie> movies = movieRepository.findAll();
        return movies.stream()
                .<MovieListResponseDTO>map(movie -> new MovieListResponseDTO(
                        movie.getId(),
                        movie.getTitle(),
                        movie.getPortraitImageUrl()))
                .toList();
    }

    @Override
    public MovieDetailResponseDTO findById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));
        return new MovieDetailResponseDTO(
                movie.getId(),
                movie.getTitle(),
                movie.getLandscapeImageUrl(),
                movie.getSynopsis(),
                movie.getGenre(),
                movie.getDuration());
    }

    @Override
    public List<MovieListResponseDTO> findByCityId(Long cityId) {
        List<Movie> movies = movieRepository.findByCityId(cityId);
        return movies.stream()
                .<MovieListResponseDTO>map(movie -> new MovieListResponseDTO(
                        movie.getId(),
                        movie.getTitle(),
                        movie.getPortraitImageUrl()))
                .toList();
    }
}