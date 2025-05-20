package com.github.diinisalma.bioskop.dto;

public record MovieDetailResponseDTO(
        Long id,
        String title,
        String imageUrl,
        String synopsis,
        String[] genre,
        Integer duration) {

}
