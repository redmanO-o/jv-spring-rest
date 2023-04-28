package mate.academy.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.spring.model.dto.MovieRequestDto;
import mate.academy.spring.model.dto.MovieResponseDto;
import mate.academy.spring.service.MovieService;
import mate.academy.spring.service.mapper.MovieDtoMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService service;
    private final MovieDtoMapper dtoMapper;

    public MovieController(MovieService service, MovieDtoMapper dtoMapper) {
        this.service = service;
        this.dtoMapper = dtoMapper;
    }

    @PostMapping
    public MovieResponseDto create(@RequestBody MovieRequestDto movie) {
        return dtoMapper.toDto(service.add(dtoMapper.toModel(movie)));
    }

    @GetMapping
    public List<MovieResponseDto> getAll() {
        return service.getAll().stream()
                .map(dtoMapper::toDto)
                .collect(Collectors.toList());
    }
}