package dev.Sameer.BookMyShow.DTO;

import dev.Sameer.BookMyShow.Entity.Auditorium;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class ShowResponseDTO {
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String movieName;
    private String theatreName;
    private String auditoriumName;
}
