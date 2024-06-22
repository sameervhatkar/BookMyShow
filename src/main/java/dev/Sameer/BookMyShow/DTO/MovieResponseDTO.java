package dev.Sameer.BookMyShow.DTO;

import dev.Sameer.BookMyShow.Entity.Actor;
import dev.Sameer.BookMyShow.Enum.MovieFeature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieResponseDTO {
    private String movieName;
    private String movieDescription;
    private List<String> actorList;
    private List<String> movieFeatureList;
}
