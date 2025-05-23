package com.github.diinisalma.bioskop.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.github.diinisalma.bioskop.entity.City;
import com.github.diinisalma.bioskop.repository.CityRepository;
import com.github.diinisalma.bioskop.dto.CityPayloadDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.ResultPageResponseDTO;
import com.github.diinisalma.bioskop.service.CityService;

@Service
public class CityServiceImpl implements CityService {
    private final CityRepository cityRepository;

    public CityServiceImpl(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void createCity(CityPayloadDTO dto) {
        City entity = new City();
        entity.setName(dto.name());
        cityRepository.save(entity);
    }

    @Override
    public void updateCity(Long id, CityPayloadDTO dto) {
        City entity = new City(id, dto.name());
        cityRepository.save(entity);
    }

    @Override
    public void deleteCity(Long id) {
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
}
