/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.github.diinisalma.bioskop.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record MovieStudioScheduleResponseDTO(
        Long id,
        StudioResponseDTO studio,
        LocalDateTime startTime,
        BigDecimal price) {
}
