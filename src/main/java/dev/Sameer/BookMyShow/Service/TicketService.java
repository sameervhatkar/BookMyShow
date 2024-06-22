package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.Entity.Show;
import dev.Sameer.BookMyShow.Entity.ShowSeat;
import dev.Sameer.BookMyShow.Entity.Ticket;
import dev.Sameer.BookMyShow.Entity.User;
import dev.Sameer.BookMyShow.Enum.ShowSeatStatus;
import dev.Sameer.BookMyShow.Enum.TicketStatus;
import dev.Sameer.BookMyShow.Exception.SeatNotAvailableException;
import dev.Sameer.BookMyShow.Repository.ShowSeatRepository;
import dev.Sameer.BookMyShow.Repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketService {
    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private ShowSeatService showSeatService;

    public Ticket bookTicket(List<Integer> showSeatIds, User user) {
        checkAndLockedSeat(showSeatIds);
        if(startPayment(showSeatIds)) {
            Ticket ticket = new Ticket();
            ticket.setBookingTime(LocalDateTime.now());
            List<ShowSeat> showSeatList = new ArrayList<>();
            Show show = null;
            for(int ids : showSeatIds) {
                ShowSeat showSeat = showSeatService.getShowSeat(ids);
                show = showSeat.getShow();
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeatList.add(showSeat);
                showSeatService.saveShowSeat(showSeat);
            }
            ticket.setShowSeatList(showSeatList);
            ticket.setShow(show);
            ticket.setTicketStatus(TicketStatus.BOOKED);
            ticketRepository.save(ticket);
            return ticket;
        }

        return null;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void checkAndLockedSeat(List<Integer> showSeatIds) {
        for(int seatId : showSeatIds) {
            ShowSeat seat = showSeatService.getShowSeat(seatId);
            if(!seat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)) {
                throw new SeatNotAvailableException("Seats are not available");
            }
        }
        for(int seatId : showSeatIds) {
            ShowSeat seat = showSeatService.getShowSeat(seatId);
            seat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            showSeatService.saveShowSeat(seat);
        }
    }

    public boolean startPayment(List<Integer> showSeatIds) {
        return true;
    }
}
