package dev.Sameer.BookMyShow.DTO;

import dev.Sameer.BookMyShow.Entity.Auditorium;
import dev.Sameer.BookMyShow.Entity.Movie;
import dev.Sameer.BookMyShow.Entity.ShowSeat;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class ShowRequestDTO {
    private int hours, minutes, year, month, date;
    private String movieName;
    private String theatreName;
}
