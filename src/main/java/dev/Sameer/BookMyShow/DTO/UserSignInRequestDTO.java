package dev.Sameer.BookMyShow.DTO;

import dev.Sameer.BookMyShow.Entity.Ticket;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserSignInRequestDTO {
    private String userName;
    private String userEmail;
    private String userPassword;
}
