package com.github.diinisalma.bioskop.dto;

public record CinemaResponseDTO(
        Long id,
        String name,
        CityResponseDTO city) {
}
