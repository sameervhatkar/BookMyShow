package dev.Sameer.BookMyShow.Entity;

import dev.Sameer.BookMyShow.Enum.TicketStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends BaseModel{
    private LocalDateTime bookingTime;
    private double ticketAmount;
    @OneToMany
    private List<ShowSeat> showSeatList;
    @ManyToOne
    private Show show;
    @Enumerated(EnumType.STRING)
    private TicketStatus ticketStatus;
}
