package dev.Sameer.BookMyShow.DTO;

import dev.Sameer.BookMyShow.Entity.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BookTicketResponseDTO {
    private List<Integer> showSeatIds;
    private double totalAmount;
}
