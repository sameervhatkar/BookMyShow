package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.TheatreRequestDTO;
import dev.Sameer.BookMyShow.Service.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheatreController {

    @Autowired
    private TheatreService theatreService;

    @PostMapping("/addTheatre")
    public ResponseEntity addTheatre(@RequestBody TheatreRequestDTO theatreRequestDTO) {
        return ResponseEntity.ok(theatreService.addTheatre(theatreRequestDTO));
    }

    @PostMapping("/deleteTheatre/{theatreName}")
    public ResponseEntity deleteTheatre(@PathVariable ("theatreName") String theatreName) {
        return ResponseEntity.ok(theatreService.deleteTheatre(theatreName));
    }


}
