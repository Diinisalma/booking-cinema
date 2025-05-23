package com.github.diinisalma.bioskop.web;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.diinisalma.bioskop.dto.StudioTypeResponseDTO;
import com.github.diinisalma.bioskop.service.StudioTypeService;

@Controller
@RequestMapping("/studio-types")
public class StudioTypeController {

    private final StudioTypeService studioTypeService;

    public StudioTypeController(StudioTypeService studioTypeService) {
        this.studioTypeService = studioTypeService;
    }

    @GetMapping
    public ResponseEntity<List<StudioTypeResponseDTO>> getStudioTypes() {
        return ResponseEntity.ok(studioTypeService.findAll());
    }
}
