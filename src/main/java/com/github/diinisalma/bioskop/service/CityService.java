package com.github.diinisalma.bioskop.service;

import com.github.diinisalma.bioskop.dto.CityPayloadDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.ResultPageResponseDTO;
import org.springframework.data.domain.Pageable;

public interface CityService {
    void createCity(CityPayloadDTO dto);

    void updateCity(Long id, CityPayloadDTO dto);

    void deleteCity(Long id);

    ResultPageResponseDTO<CityResponseDTO> getAllCities(Pageable pageable, String cityName);
}
