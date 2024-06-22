package dev.Sameer.BookMyShow.Entity;

import dev.Sameer.BookMyShow.Enum.SeatStatus;
import dev.Sameer.BookMyShow.Enum.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends BaseModel {
    private String seatNumber;
    @Enumerated(EnumType.STRING)
    private SeatType seatType;
    private int matRow;
    private int matCol;
    @Enumerated(EnumType.STRING)
    private SeatStatus seatStatus;
}
