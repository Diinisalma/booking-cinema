package com.github.diinisalma.bioskop.web;

import jakarta.validation.Valid;
import lombok.SneakyThrows;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.diinisalma.bioskop.dto.CityPayloadDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.ResultPageResponseDTO;
import com.github.diinisalma.bioskop.service.CityService;

import java.util.List;

@Controller
@RequestMapping("/city")
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<ResultPageResponseDTO<CityResponseDTO>> getCities(
            @RequestParam(defaultValue = "10") Integer limit,
            @RequestParam(value = "name", required = false) String cityName,
            Pageable pageable
    ) {
        pageable = PageRequest.of(pageable.getPageNumber(), limit, pageable.getSort());
        return ResponseEntity.ok(cityService.getAllCities(pageable, cityName));
    }

    @PostMapping
    public ResponseEntity<Void> createCity(@RequestBody List<CityPayloadDTO> dtos) {
        cityService.createCity(dtos);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCity(@Valid @RequestBody CityPayloadDTO dto, @PathVariable Long id) {
        cityService.updateCity(id, dto);
        return ResponseEntity.ok().build();
    }

    @SneakyThrows
    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("by-movie/{movieId}")
    public ResponseEntity<ResultPageResponseDTO<CityResponseDTO>> getCitiesByMovieId(
        @PathVariable Long movieId,
        @RequestParam(defaultValue = "10") Integer limit,
        @RequestParam(value = "name", required = false) String cityName,
        Pageable pageable
    ) {
        pageable = PageRequest.of(pageable.getPageNumber(), limit, pageable.getSort());
        return ResponseEntity.ok(cityService.getCitiesByMovieId(movieId, cityName, pageable));
    }
}
