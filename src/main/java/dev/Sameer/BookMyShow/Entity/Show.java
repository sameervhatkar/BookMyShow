package dev.Sameer.BookMyShow.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity(name = "BMS_SHOW")
public class Show extends BaseModel {
    private LocalDateTime showStartTime;
    private LocalDateTime showEndTime;
    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Auditorium auditorium;
    @OneToMany
    private List<ShowSeat> showSeatList;
}
