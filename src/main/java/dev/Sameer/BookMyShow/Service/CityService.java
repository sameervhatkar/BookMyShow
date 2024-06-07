package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.Entity.City;
import dev.Sameer.BookMyShow.Repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityRepository cityRepository;

    public City saveCity(String cityName) {
        City city = new City();
        city.setCityName(cityName);
        return cityRepository.save(city);
    }

    public List<City> getAllCities() {
        return cityRepository.findAll();
    }

    public boolean deleteCity(String cityName) {
        City delCity = cityRepository.findCityByCityName(cityName);
        cityRepository.delete(delCity);
        return true;
    }
}
