package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor, Integer> {
}
