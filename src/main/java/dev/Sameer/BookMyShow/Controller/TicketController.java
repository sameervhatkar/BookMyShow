package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.BookTicketRequestDTO;
import dev.Sameer.BookMyShow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/ticket")
    public ResponseEntity bookTicket(@RequestBody BookTicketRequestDTO bookTicketRequestDTO) {
        return ResponseEntity.ok(ticketService.bookTicket(
                bookTicketRequestDTO.getShowSeatIds(),
                bookTicketRequestDTO.getUser()
        ));
    }
}
