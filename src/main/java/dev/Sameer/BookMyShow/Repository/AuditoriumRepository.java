package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.Auditorium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Integer> {
}
