package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.DTO.ShowRequestDTO;
import dev.Sameer.BookMyShow.DTO.ShowResponseDTO;
import dev.Sameer.BookMyShow.Entity.*;
import dev.Sameer.BookMyShow.Mapper.EntityToDTOMapper;
import dev.Sameer.BookMyShow.Repository.AuditoriumRepository;
import dev.Sameer.BookMyShow.Repository.MovieRepository;
import dev.Sameer.BookMyShow.Repository.ShowRepository;
import dev.Sameer.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheatreRepository theatreRepository;

    @Autowired
    private ShowSeatService showSeatService;

    @Autowired
    private AuditoriumRepository auditoriumRepository;



    public ShowResponseDTO createShow(ShowRequestDTO showRequestDTO) {
        int year = showRequestDTO.getYear();
        int month = showRequestDTO.getMonth();
        int tarikh = showRequestDTO.getDate();
        int hour = showRequestDTO.getHours();
        int mins = showRequestDTO.getMinutes();
        LocalDate date = LocalDate.of(year, month, tarikh);
        LocalTime time = LocalTime.of(hour, mins);
        LocalDateTime startTime = LocalDateTime.of(date, time);
        //Creating shows
        Show show = new Show();
        show.setShowStartTime(startTime);
        show.setShowEndTime(startTime.plusHours(3));
        Movie movie = movieRepository.findMovieByMovieName(showRequestDTO.getMovieName());
        if(movie == null) {
            movie.setMovieName(showRequestDTO.getMovieName());
            movieRepository.save(movie);
        }
        show.setMovie(movie);
        int audiGenerationId = (int) (Math.random() * 5) + 1;
        Theatre theatre = theatreRepository.findTheatreByTheatreName(showRequestDTO.getTheatreName());
        show.setTheatre(theatre);
        Auditorium auditorium = theatre.getAuditoriumList().get(audiGenerationId);
        show.setAuditorium(auditorium);
        auditorium.setShows(List.of(show));
        showRepository.save(show);
        //Generating ShowSeats
        List<ShowSeat> showSeatList = new ArrayList<>();
        for(Seat seat : auditorium.getSeats()) {
            showSeatList.add(showSeatService.generateShowSeat(show, seat));
        }
        show.setShowSeatList(showSeatList);
        showRepository.save(show);
        auditoriumRepository.save(auditorium);
        return EntityToDTOMapper.convertShowEntityToDTO(show);
    }
}
