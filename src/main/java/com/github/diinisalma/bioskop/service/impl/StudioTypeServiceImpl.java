package com.github.diinisalma.bioskop.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.diinisalma.bioskop.dto.StudioTypeResponseDTO;
import com.github.diinisalma.bioskop.repository.StudioTypeRepository;
import com.github.diinisalma.bioskop.service.StudioTypeService;

@Service
public class StudioTypeServiceImpl implements StudioTypeService {

    private final StudioTypeRepository studioTypeRepository;

    public StudioTypeServiceImpl(StudioTypeRepository studioTypeRepository) {
        this.studioTypeRepository = studioTypeRepository;
    }

    @Override
    public List<StudioTypeResponseDTO> findAll() {
        return studioTypeRepository.findAll().stream()
                .map(studioType -> new StudioTypeResponseDTO(studioType.getId(), studioType.getName()))
                .toList();
    }
}