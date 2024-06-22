package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.DTO.TheatreRequestDTO;
import dev.Sameer.BookMyShow.Entity.City;
import dev.Sameer.BookMyShow.Entity.Theatre;
import dev.Sameer.BookMyShow.Exception.TheatreNotFoundException;
import dev.Sameer.BookMyShow.Repository.CityRepository;
import dev.Sameer.BookMyShow.Repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepository theatreRepository;
    @Autowired
    private CityRepository cityRepository;

    public Theatre addTheatre(TheatreRequestDTO theatreRequestDTO) {
        Theatre savedTheatre = new Theatre();
        savedTheatre.setTheatreName(theatreRequestDTO.getTheatreName());
        savedTheatre.setTheatreAddress(theatreRequestDTO.getTheatreAddress());
        theatreRepository.save(savedTheatre);

        City city = cityRepository.findCityByCityName(theatreRequestDTO.getCityName());
        List<Theatre> theatres = city.getTheatres();
        theatres.add(savedTheatre);

        cityRepository.save(city);

        return savedTheatre;
    }

    public boolean deleteTheatre(String theatreName) {
        Theatre deleteTheatre = theatreRepository.findTheatreByTheatreName(theatreName);
        if(deleteTheatre == null) {
            throw new TheatreNotFoundException("The theatre you want to delete is already not present.");
        }
        else
            theatreRepository.delete(deleteTheatre);
        return true;
    }
}
