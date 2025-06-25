package com.github.diinisalma.bioskop.service;

import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Pageable;

import com.github.diinisalma.bioskop.dto.CityPayloadDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.ResultPageResponseDTO;

import java.util.List;

public interface CityService {
    void createCity(List<CityPayloadDTO> dtos);

    void updateCity(Long id, CityPayloadDTO dto);

    void deleteCity(Long id) throws BadRequestException;

    ResultPageResponseDTO<CityResponseDTO> getAllCities(Pageable pageable, String cityName);

    ResultPageResponseDTO<CityResponseDTO> getCitiesByMovieId(Long movieId, String cityName, Pageable pageable);
}
