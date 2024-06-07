package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show, Integer> {
}
