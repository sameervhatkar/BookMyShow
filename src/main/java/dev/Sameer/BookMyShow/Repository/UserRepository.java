package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
