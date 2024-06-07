package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.Service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/hello")
    public ResponseEntity greetHello() {
        return ResponseEntity.ok(testService.greetHello());
    }
}
