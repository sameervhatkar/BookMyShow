package dev.Sameer.BookMyShow.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity(name = "BMS_USER")
public class User extends BaseModel {
    private String userName;
    private String userEmail;
    @OneToMany
    private List<Ticket> ticketList;
}
