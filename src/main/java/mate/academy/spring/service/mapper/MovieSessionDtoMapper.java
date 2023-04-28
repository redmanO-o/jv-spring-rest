package mate.academy.spring.service.mapper;

import mate.academy.spring.model.CinemaHall;
import mate.academy.spring.model.Movie;
import mate.academy.spring.model.MovieSession;
import mate.academy.spring.model.dto.MovieSessionRequestDto;
import mate.academy.spring.model.dto.MovieSessionResponseDto;
import org.springframework.stereotype.Component;

@Component
public class MovieSessionDtoMapper {
    public MovieSessionResponseDto toDto(MovieSession movieSession) {
        MovieSessionResponseDto responseDto = new MovieSessionResponseDto();
        responseDto.setId(movieSession.getId());
        responseDto.setMovieId(movieSession.getMovie().getId());
        responseDto.setCinemaHallId(movieSession.getCinemaHall().getId());
        responseDto.setShowTime(movieSession.getShowTime());
        return responseDto;
    }

    public MovieSession toModel(MovieSessionRequestDto requestDto) {
        MovieSession movieSession = new MovieSession();
        Movie movie = new Movie();
        movie.setId(requestDto.getMovieId());
        movieSession.setMovie(movie);
        CinemaHall cinemaHall = new CinemaHall();
        cinemaHall.setId(requestDto.getCinemaHallId());
        movieSession.setCinemaHall(cinemaHall);
        movieSession.setShowTime(requestDto.getShowTime());
        return movieSession;
    }
}
