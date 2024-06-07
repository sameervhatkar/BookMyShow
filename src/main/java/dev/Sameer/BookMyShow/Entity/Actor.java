package dev.Sameer.BookMyShow.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Actor extends BaseModel {
    private String actorName;
    @ManyToMany
    private List<Movie> movieList;
}
