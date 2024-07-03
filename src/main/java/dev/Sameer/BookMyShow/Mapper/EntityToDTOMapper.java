package dev.Sameer.BookMyShow.Mapper;

import dev.Sameer.BookMyShow.DTO.MovieRequestDTO;
import dev.Sameer.BookMyShow.DTO.MovieResponseDTO;
import dev.Sameer.BookMyShow.DTO.ShowResponseDTO;
import dev.Sameer.BookMyShow.DTO.UserResponseDTO;
import dev.Sameer.BookMyShow.Entity.Actor;
import dev.Sameer.BookMyShow.Entity.Movie;
import dev.Sameer.BookMyShow.Entity.Show;
import dev.Sameer.BookMyShow.Entity.User;
import dev.Sameer.BookMyShow.Enum.MovieFeature;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class EntityToDTOMapper {
    public static MovieResponseDTO convertMovieEntityToDTO(Movie movie) {
        MovieResponseDTO movieResponseDTO = new MovieResponseDTO();
        movieResponseDTO.setMovieName(movie.getMovieName());
        movieResponseDTO.setMovieDescription(movie.getMovieDescription());
        List<String> actorNameList = new ArrayList<>();
        for(Actor actor : movie.getActorList())
            actorNameList.add(actor.getActorName());
        movieResponseDTO.setActorList(actorNameList);
        List<String> movieFeatureList = new ArrayList<>();
        for(MovieFeature movieFeature : movie.getMovieFeatureList()) {
            if(movieFeature.equals(MovieFeature.TWODIMENSION))
                movieFeatureList.add("TWODIMENSION");
            else if(movieFeature.equals(MovieFeature.THREEDIMENSION))
                movieFeatureList.add("THREEDIMENSION");
            else if(movieFeature.equals(MovieFeature.IMAX))
                movieFeatureList.add("IMAX");
            else if(movieFeature.equals(MovieFeature.DOLBY))
                movieFeatureList.add("DOLBY");

        }
        movieResponseDTO.setMovieFeatureList(movieFeatureList);
        return movieResponseDTO;
    }

    public static ShowResponseDTO convertShowEntityToDTO(Show show) {
        ShowResponseDTO showResponseDTO = new ShowResponseDTO();
        showResponseDTO.setStartTime(show.getShowStartTime());
        showResponseDTO.setEndTime(show.getShowEndTime());
        showResponseDTO.setMovieName(show.getMovie().getMovieName());
        showResponseDTO.setTheatreName(show.getTheatre().getTheatreName());
        showResponseDTO.setAuditoriumName(show.getAuditorium().getAudiName());
        return showResponseDTO;
    }

    public static UserResponseDTO convertUserEntityToUserDTO(User user) {
        UserResponseDTO userResponseDTO = new UserResponseDTO();
        userResponseDTO.setUserName(user.getUserName());
        userResponseDTO.setUserEmail(user.getUserEmail());
        userResponseDTO.setTicketList(user.getTicketList());
        return userResponseDTO;
    }
}
