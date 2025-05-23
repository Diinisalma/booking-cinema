package com.github.diinisalma.bioskop.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.github.diinisalma.bioskop.dto.CinemaResponseDTO;
import com.github.diinisalma.bioskop.dto.CityResponseDTO;
import com.github.diinisalma.bioskop.dto.MovieStudioScheduleResponseDTO;
import com.github.diinisalma.bioskop.dto.StudioResponseDTO;
import com.github.diinisalma.bioskop.dto.StudioTypeResponseDTO;
import com.github.diinisalma.bioskop.repository.MovieStudioScheduleRepository;
import com.github.diinisalma.bioskop.service.MovieStudioScheduleService;

@Service
public class MovieStudioScheduleServiceImpl implements MovieStudioScheduleService {

    private final MovieStudioScheduleRepository movieStudioScheduleRepository;

    public MovieStudioScheduleServiceImpl(MovieStudioScheduleRepository movieStudioScheduleRepository) {
        this.movieStudioScheduleRepository = movieStudioScheduleRepository;
    }

    @Override
    public List<MovieStudioScheduleResponseDTO> findByMovieId(Long movieId, LocalDateTime startTime) {
        return movieStudioScheduleRepository.findByMovieIdAndStartTimeGreaterThan(movieId, startTime).stream()
                .<MovieStudioScheduleResponseDTO>map(movieStudioSchedule -> new MovieStudioScheduleResponseDTO(
                        movieStudioSchedule.getId(),
                        new StudioResponseDTO(
                                movieStudioSchedule.getStudio().getId(),
                                movieStudioSchedule.getStudio().getName(),
                                new CinemaResponseDTO(
                                        movieStudioSchedule.getStudio().getCinema().getId(),
                                        movieStudioSchedule.getStudio().getCinema().getName(),
                                        new CityResponseDTO(
                                                movieStudioSchedule.getStudio().getCinema().getCity().getId(),
                                                movieStudioSchedule.getStudio().getCinema().getCity().getName())),
                                new StudioTypeResponseDTO(
                                        movieStudioSchedule.getStudio().getStudioType().getId(),
                                        movieStudioSchedule.getStudio().getStudioType().getName())),
                        movieStudioSchedule.getStartTime(),
                        movieStudioSchedule.getPrice()))
                .toList();
    }

    @Override
    public List<MovieStudioScheduleResponseDTO> findByCityIdAndMovieId(Long cityId, Long movieId,
            LocalDateTime startTime) {
        return movieStudioScheduleRepository.findByCityIdAndMovieIdAndTimeOnly(cityId, movieId, startTime).stream()
                .<MovieStudioScheduleResponseDTO>map(movieStudioSchedule -> new MovieStudioScheduleResponseDTO(
                        movieStudioSchedule.getId(),
                        new StudioResponseDTO(
                                movieStudioSchedule.getStudio().getId(),
                                movieStudioSchedule.getStudio().getName(),
                                new CinemaResponseDTO(
                                        movieStudioSchedule.getStudio().getCinema().getId(),
                                        movieStudioSchedule.getStudio().getCinema().getName(),
                                        new CityResponseDTO(
                                                movieStudioSchedule.getStudio().getCinema().getCity().getId(),
                                                movieStudioSchedule.getStudio().getCinema().getCity().getName())),
                                new StudioTypeResponseDTO(
                                        movieStudioSchedule.getStudio().getStudioType().getId(),
                                        movieStudioSchedule.getStudio().getStudioType().getName())),
                        movieStudioSchedule.getStartTime(),
                        movieStudioSchedule.getPrice()))
                .toList();
    }

}
