package com.github.diinisalma.bioskop.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CityPayloadDTO(


        String name,

        @NotBlank(message = "Description is required")
        String description
) {
}
