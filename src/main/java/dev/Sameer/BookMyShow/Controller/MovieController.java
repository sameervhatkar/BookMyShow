package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.MovieRequestDTO;
import dev.Sameer.BookMyShow.DTO.MovieResponseDTO;
import dev.Sameer.BookMyShow.Entity.Movie;
import dev.Sameer.BookMyShow.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/addMovie")
    public ResponseEntity<MovieResponseDTO> addMovie(@RequestBody MovieRequestDTO movieRequestDTO) {
        MovieResponseDTO savedMovie = movieService.addMovie(movieRequestDTO);
        return ResponseEntity.ok(savedMovie);
    }
}
