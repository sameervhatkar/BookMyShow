package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.ShowRequestDTO;
import dev.Sameer.BookMyShow.DTO.ShowResponseDTO;
import dev.Sameer.BookMyShow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("/addShow")
    public ResponseEntity<ShowResponseDTO> createShow(@RequestBody ShowRequestDTO showRequestDTO) {
        ShowResponseDTO showResponseDTO = showService.createShow(showRequestDTO);
        return ResponseEntity.ok(showResponseDTO);
    }
}
