package dev.Sameer.BookMyShow.DTO;

import dev.Sameer.BookMyShow.Entity.ShowSeat;
import dev.Sameer.BookMyShow.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketRequestDTO {
    private List<Integer> showSeatIds;
    private User user;
}
