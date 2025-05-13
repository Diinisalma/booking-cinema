package com.github.diinisalma.bioskop.web;

import com.github.diinisalma.bioskop.dto.CityPayloadDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.ResultPageResponseDTO;
import com.github.diinisalma.bioskop.service.CityService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/city")
public class CityController {
    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public ResponseEntity<ResultPageResponseDTO<CityResponseDTO>> getCities(
            @RequestParam(value = "limit", defaultValue = "10") Integer limit,
            @RequestParam(value = "name", required = false) String cityName,
            Pageable pageable
    ) {
        pageable = PageRequest.of(pageable.getPageNumber(), limit, pageable.getSort());
        return ResponseEntity.ok(cityService.getAllCities(pageable, cityName));
    }

    @PostMapping
    public ResponseEntity<Void> createCity(@RequestBody CityPayloadDTO dto) {
        cityService.createCity(dto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCity(@PathVariable Long id, @RequestBody CityPayloadDTO dto) {
        cityService.updateCity(id, dto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCity(@PathVariable Long id) {
        cityService.deleteCity(id);
        return ResponseEntity.ok().build();
    }
}
