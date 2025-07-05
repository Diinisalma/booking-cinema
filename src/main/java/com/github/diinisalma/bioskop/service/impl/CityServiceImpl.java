package com.github.diinisalma.bioskop.service.impl;

import com.github.diinisalma.bioskop.dto.CityPayloadDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.ResultPageResponseDTO;
import com.github.diinisalma.bioskop.entity.City;
import com.github.diinisalma.bioskop.exception.ResourceNotFoundException;
import com.github.diinisalma.bioskop.repository.CityRepository;
import com.github.diinisalma.bioskop.service.CityService;
import jakarta.persistence.EntityNotFoundException;
import org.apache.coyote.BadRequestException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void createCity(List<CityPayloadDTO> dtos) {
        List<City> entities = dtos.stream().map(dto -> {
            City entity = new City();
            entity.setName(dto.name());
            return entity;
        }).toList();
        cityRepository.saveAll(entities);
    }

    @Override
    public void updateCity(Long id, CityPayloadDTO dto) {
        City entity = cityRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("City not found with id: " + id));
        entity.setId(id);
        entity.setName(dto.name());
        cityRepository.save(entity);
    }

    @Override
    public void deleteCity(Long id) throws BadRequestException {
        cityRepository.deleteById(id);
    }

    @Override
    public ResultPageResponseDTO<CityResponseDTO> getAllCities(Pageable pageable, String cityName) {
        cityName = StringUtils.hasText(cityName) ? "%" + cityName + "%" : "%";
        Page<City> cities = cityRepository.findByNameLikeIgnoreCase(cityName, pageable);
        List<CityResponseDTO> result = cities.stream().map(city -> new CityResponseDTO(city.getId(), city.getName()))
                .toList();
        return new ResultPageResponseDTO<>(result, cities.getTotalPages(), cities.getTotalElements());
    }

    @Override
    public ResultPageResponseDTO<CityResponseDTO> getCitiesByMovieId(Long movieId, String cityName, Pageable pageable) {
        cityName = StringUtils.hasText(cityName) ? "%" + cityName + "%" : "%";
        // Page<City> cities = cityRepository.getByMovieId(movieId, cityName, pageable);
        // List<CityResponseDTO> result = cities.stream().map(city -> new CityResponseDTO(city.getId(), city.getName()))
        //         .toList();
        // return new ResultPageResponseDTO<>(result, cities.getTotalPages(), cities.getTotalElements());
        return null;
    }
}
