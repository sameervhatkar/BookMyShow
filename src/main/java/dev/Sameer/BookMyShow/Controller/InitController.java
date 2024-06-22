package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.AudiRequestDTO;
import dev.Sameer.BookMyShow.Service.AuditoriumSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InitController {

    @Autowired
    private AuditoriumSeatService auditoriumSeatService;

    @PostMapping("/addAudi")
    public ResponseEntity addingAudis(@RequestBody AudiRequestDTO audiRequestDTO) {
        return ResponseEntity.ok(auditoriumSeatService.fillingSeatInAuditorium(
                audiRequestDTO.getTheatreName(),
                audiRequestDTO.getNoOfAudi())
        );
    }
}
