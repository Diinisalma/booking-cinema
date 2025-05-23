package com.github.diinisalma.bioskop.dto;

public record StudioResponseDTO(
                Long id,
                String name,
                CinemaResponseDTO cinema,
                StudioTypeResponseDTO studioType) {
}
