package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.Entity.Seat;
import dev.Sameer.BookMyShow.Entity.Show;
import dev.Sameer.BookMyShow.Entity.ShowSeat;
import dev.Sameer.BookMyShow.Enum.SeatType;
import dev.Sameer.BookMyShow.Enum.ShowSeatStatus;
import dev.Sameer.BookMyShow.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class ShowSeatService {

    @Autowired
    private ShowSeatRepository showSeatRepository;

    public ShowSeat getShowSeat(int showSeatId) {
        return showSeatRepository.findById(showSeatId).get();
    }

    public ShowSeat saveShowSeat(ShowSeat showseat) {
        return showSeatRepository.save(showseat);
    }

    public ShowSeat generateShowSeat(Show show, Seat seat) {
        ShowSeat showSeat = new ShowSeat();
        if(isShowStartTimeBetween9amAnd12(show.getShowStartTime())) {
            if(seat.getSeatType().equals(SeatType.SILVER))
                showSeat.setPrice(90);
            else if(seat.getSeatType().equals(SeatType.GOLD))
                showSeat.setPrice(120);
            else if(seat.getSeatType().equals(SeatType.PLATINUM))
                showSeat.setPrice(150);

        }
        else if(isShowStartTimeBetween1pmAnd4(show.getShowStartTime())) {
            if(seat.getSeatType().equals(SeatType.SILVER))
                showSeat.setPrice(150);
            else if(seat.getSeatType().equals(SeatType.GOLD))
                showSeat.setPrice(180);
            else if(seat.getSeatType().equals(SeatType.PLATINUM))
                showSeat.setPrice(210);
        }
        else if(isShowStartTimeBetween5pmAnd8(show.getShowStartTime())) {
            if(seat.getSeatType().equals(SeatType.SILVER))
                showSeat.setPrice(150);
            else if(seat.getSeatType().equals(SeatType.GOLD))
                showSeat.setPrice(180);
            else if(seat.getSeatType().equals(SeatType.PLATINUM))
                showSeat.setPrice(210);
        }
        else if(isShowStartTimeBetween9pmAnd12(show.getShowStartTime())) {
            if(seat.getSeatType().equals(SeatType.SILVER))
                showSeat.setPrice(210);
            else if(seat.getSeatType().equals(SeatType.GOLD))
                showSeat.setPrice(240);
            else if(seat.getSeatType().equals(SeatType.PLATINUM))
                showSeat.setPrice(270);
        }
        showSeat.setSeat(seat);
        showSeat.setShow(show);
        showSeat.setShowSeatStatus(ShowSeatStatus.AVAILABLE);
        showSeatRepository.save(showSeat);
        return showSeat;
    }

    public static boolean isShowStartTimeBetween9amAnd12(LocalDateTime showStartTime) {
        LocalTime startTime = LocalTime.of(9, 0);  // 9:00 AM
        LocalTime endTime = LocalTime.of(12, 0);   // 12:00 PM
        LocalTime showTime = showStartTime.toLocalTime();

        return !showTime.isBefore(startTime) && !showTime.isAfter(endTime);
    }
    public static boolean isShowStartTimeBetween1pmAnd4(LocalDateTime showStartTime) {
        LocalTime startTime = LocalTime.of(13, 0);  // 1:00 PM
        LocalTime endTime = LocalTime.of(16, 0);   // 4:00 PM
        LocalTime showTime = showStartTime.toLocalTime();

        return !showTime.isBefore(startTime) && !showTime.isAfter(endTime);
    }
    public static boolean isShowStartTimeBetween5pmAnd8(LocalDateTime showStartTime) {
        LocalTime startTime = LocalTime.of(17, 0);  // 5:00 PM
        LocalTime endTime = LocalTime.of(20, 0);   // 8:00 PM
        LocalTime showTime = showStartTime.toLocalTime();

        return !showTime.isBefore(startTime) && !showTime.isAfter(endTime);
    }
    public static boolean isShowStartTimeBetween9pmAnd12(LocalDateTime showStartTime) {
        LocalTime startTime = LocalTime.of(21, 0);  // 9:00 PM
        LocalTime endTime = LocalTime.of(0, 0);   // 12:00 AM
        LocalTime showTime = showStartTime.toLocalTime();

        return !showTime.isBefore(startTime) && !showTime.isAfter(endTime);
    }



}
