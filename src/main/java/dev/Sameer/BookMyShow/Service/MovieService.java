package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.DTO.MovieRequestDTO;
import dev.Sameer.BookMyShow.DTO.MovieResponseDTO;
import dev.Sameer.BookMyShow.Entity.Actor;
import dev.Sameer.BookMyShow.Entity.Movie;
import dev.Sameer.BookMyShow.Enum.MovieFeature;
import dev.Sameer.BookMyShow.Mapper.EntityToDTOMapper;
import dev.Sameer.BookMyShow.Repository.ActorRepository;
import dev.Sameer.BookMyShow.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

        public MovieResponseDTO addMovie(MovieRequestDTO movieRequestDTO) {
        Movie movie = new Movie();
        movie.setMovieName(movieRequestDTO.getMovieName());
        movie.setMovieDescription(movieRequestDTO.getMovieDescription());
        List<MovieFeature> movieFeatures = new ArrayList<>();
        for(String movieFeature : movieRequestDTO.getMovieFeatureList()) {
            String feature = movieFeature.toUpperCase();
            switch(feature) {
                case "TWODIMENSION" -> movieFeatures.add(MovieFeature.TWODIMENSION);
                case "THREEDIMENSION"  -> movieFeatures.add(MovieFeature.THREEDIMENSION);
                case "IMAX" -> movieFeatures.add(MovieFeature.IMAX);
                case "DOLBY" -> movieFeatures.add(MovieFeature.DOLBY);
            }
        }
        movie.setMovieFeatureList(movieFeatures);

        List<Actor> actors = new ArrayList<>();
        for(String actorName : movieRequestDTO.getActorNameList()) {
            Actor actor = actorRepository.findActorByActorName(actorName);
            if (actor == null) {
                Actor saveActor = new Actor();
                saveActor.setActorName(actorName);
                actorRepository.save(saveActor);
                actors.add(saveActor);
            } else {
                actors.add(actor);
            }
        }
        movie.setActorList(actors);
        movieRepository.save(movie);
        for(String actorName : movieRequestDTO.getActorNameList()) {
            Actor actor = actorRepository.findActorByActorName(actorName);
            List<Movie> movieList = actor.getMovieList();
            movieList.add(movie);
            actor.setMovieList(movieList);
            actorRepository.save(actor);
        }

        return EntityToDTOMapper.convertMovieEntityToDTO(movie);
    }
}
