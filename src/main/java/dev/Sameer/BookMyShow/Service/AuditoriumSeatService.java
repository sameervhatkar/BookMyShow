package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.Entity.Auditorium;
import dev.Sameer.BookMyShow.Entity.Seat;
import dev.Sameer.BookMyShow.Entity.Theatre;
import dev.Sameer.BookMyShow.Enum.AuditoriumFeature;
import dev.Sameer.BookMyShow.Enum.SeatStatus;
import dev.Sameer.BookMyShow.Enum.SeatType;
import dev.Sameer.BookMyShow.Repository.AuditoriumRepository;
import dev.Sameer.BookMyShow.Repository.SeatRepository;
import dev.Sameer.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuditoriumSeatService {

    @Autowired
    private AuditoriumRepository auditoriumRepository;

    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private TheatreRepository theatreRepository;





    public Theatre fillingSeatInAuditorium(String theatreName, int noOfAuditorium) {

        List<Auditorium> auditoriumList = new ArrayList<>();
        Theatre theatre = theatreRepository.findTheatreByTheatreName(theatreName);
        for(int i = 1; i <= noOfAuditorium; i++) {
            Auditorium auditorium = new Auditorium();
            auditorium.setAudiName("Audi" + i);
            auditorium.setAudiCapacity(50);
            List<Seat> seatList = new ArrayList<>();
            for(int j = 1; j <= 5; j++) {
                for(int k = 1; k <= 10; k++) {
                    Seat seat = new Seat();
                    seat.setSeatNumber((char)(64+j) + String.valueOf(k));
                    if(j < 4)
                        seat.setSeatType(SeatType.SILVER);
                    else if(j == 4)
                        seat.setSeatType(SeatType.GOLD);
                    else
                        seat.setSeatType(SeatType.PLATINUM);
                    seat.setMatRow(j);
                    seat.setMatCol(k);
                    seat.setSeatStatus(SeatStatus.AVAILABLE);
                    seatRepository.save(seat);
                    seatList.add(seat);
                }
            }
            auditorium.setSeats(seatList);
            auditorium.setAuditoriumFeatures(List.of(AuditoriumFeature.IMAX,
                    AuditoriumFeature.DOLBY,
                    AuditoriumFeature.THREEDIMENSION,
                    AuditoriumFeature.TWODIMENSION));
            auditoriumRepository.save(auditorium);
            auditoriumList.add(auditorium);
        }
        theatre.setAuditoriumList(auditoriumList);
        theatreRepository.save(theatre);
        return theatre;


    }

}
