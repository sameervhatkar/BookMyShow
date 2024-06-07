package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Integer> {
}
