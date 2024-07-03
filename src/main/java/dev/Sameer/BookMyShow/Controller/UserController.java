package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.UserLoginRequestDTO;
import dev.Sameer.BookMyShow.DTO.UserResponseDTO;
import dev.Sameer.BookMyShow.DTO.UserSignInRequestDTO;
import dev.Sameer.BookMyShow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/signin")
    public ResponseEntity<UserResponseDTO> signIn(@RequestBody UserSignInRequestDTO userSignInRequestDTO) {
        return ResponseEntity.ok(userService.signIn(userSignInRequestDTO));
    }

    @GetMapping("/login")
    public ResponseEntity<UserResponseDTO> signIn(@RequestBody UserLoginRequestDTO userLoginRequestDTO) {
        return ResponseEntity.ok(userService.logIn(userLoginRequestDTO));
    }
}
