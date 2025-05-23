package com.github.diinisalma.bioskop.service;

import java.util.List;

import com.github.diinisalma.bioskop.dto.StudioTypeResponseDTO;

public interface StudioTypeService {
    List<StudioTypeResponseDTO> findAll();
}
