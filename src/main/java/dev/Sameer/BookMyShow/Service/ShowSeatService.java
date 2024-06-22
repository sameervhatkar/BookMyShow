package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.Entity.ShowSeat;
import dev.Sameer.BookMyShow.Repository.ShowSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
