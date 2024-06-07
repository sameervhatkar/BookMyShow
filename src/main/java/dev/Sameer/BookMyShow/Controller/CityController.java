package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.CityRequestDTO;
import dev.Sameer.BookMyShow.Entity.City;
import dev.Sameer.BookMyShow.Service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @PostMapping("/addcity")
    public ResponseEntity addCity(@RequestBody CityRequestDTO cityRequestDTO) {
        return ResponseEntity.ok(cityService.saveCity(cityRequestDTO.getCityName()));
    }

    @GetMapping("/fetchAllCities")
    public ResponseEntity getCities() {
        List<City> cities = cityService.getAllCities();
        return ResponseEntity.ok(cities);
    }

    @PostMapping("/deleteCity/{cityName}")
    public ResponseEntity deleteCity(@PathVariable("cityName") String cityName) {
        return ResponseEntity.ok(cityService.deleteCity(cityName));
    }
}
