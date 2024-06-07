package dev.Sameer.BookMyShow.Repository;

import dev.Sameer.BookMyShow.Entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
    City findCityByCityName(String cityName);
}
