package com.github.diinisalma.bioskop.service;

import java.util.List;

import com.github.diinisalma.bioskop.dto.MovieDetailResponseDTO;
import com.github.diinisalma.bioskop.dto.MovieListResponseDTO;

public interface MovieService {
    List<MovieListResponseDTO> findAll();

    MovieDetailResponseDTO findById(Long id);
}
