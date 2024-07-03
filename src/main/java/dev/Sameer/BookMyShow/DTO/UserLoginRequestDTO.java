package dev.Sameer.BookMyShow.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserLoginRequestDTO {
    private String userEmail;
    private String userPassword;
}
