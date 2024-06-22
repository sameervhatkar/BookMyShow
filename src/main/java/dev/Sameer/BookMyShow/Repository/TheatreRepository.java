package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {
    Theatre findTheatreByTheatreName(String theatreName);
}
