package dev.Sameer.BookMyShow.Entity;

import dev.Sameer.BookMyShow.Enum.MovieFeature;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel {
    private String movieName;
    private String movieDescription;
    @ManyToMany
    private List<Actor> actorList;
    @ElementCollection
    @Enumerated(EnumType.STRING)
    private List<MovieFeature> movieFeatureList;
}
