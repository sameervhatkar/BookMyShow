package dev.Sameer.BookMyShow.Exception;

import dev.Sameer.BookMyShow.DTO.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handlesUserNotFoundException(UserNotFoundException userNotFoundException) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                userNotFoundException.getMessage(),
                404
        );
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

}
