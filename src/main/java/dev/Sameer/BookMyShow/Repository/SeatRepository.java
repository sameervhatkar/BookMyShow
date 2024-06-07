package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
}
