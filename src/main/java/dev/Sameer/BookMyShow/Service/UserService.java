package dev.Sameer.BookMyShow.Service;


import dev.Sameer.BookMyShow.DTO.UserLoginRequestDTO;
import dev.Sameer.BookMyShow.DTO.UserResponseDTO;
import dev.Sameer.BookMyShow.DTO.UserSignInRequestDTO;
import dev.Sameer.BookMyShow.Entity.User;
import dev.Sameer.BookMyShow.Exception.UserNotFoundException;
import dev.Sameer.BookMyShow.Mapper.EntityToDTOMapper;
import dev.Sameer.BookMyShow.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserResponseDTO signIn(UserSignInRequestDTO userSignInRequestDTO) {
        User user = new User();
        user.setUserName(userSignInRequestDTO.getUserName());
        user.setUserEmail(userSignInRequestDTO.getUserEmail());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setUserPassword(encoder.encode(userSignInRequestDTO.getUserPassword()));
        user.setTicketList(new ArrayList<>());
        userRepository.save(user);
        return EntityToDTOMapper.convertUserEntityToUserDTO(user);
    }

    public UserResponseDTO logIn(UserLoginRequestDTO userLoginRequestDTO) {
        User user = userRepository.findUserByUserEmail(userLoginRequestDTO.getUserEmail());
        if(user == null) {
            throw new UserNotFoundException("User with userEmail " + userLoginRequestDTO.getUserEmail() + " does not exist");
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(userLoginRequestDTO.getUserPassword(), user.getUserPassword())) {
            return EntityToDTOMapper.convertUserEntityToUserDTO(user);
        }
        throw new UserNotFoundException("Invalid Password");
    }
}
