package dev.Sameer.BookMyShow.Controller;

import dev.Sameer.BookMyShow.DTO.ActorRequestDTO;
import dev.Sameer.BookMyShow.Entity.Actor;
import dev.Sameer.BookMyShow.Service.ActorService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {

    @Autowired
    private ActorService actorService;

    @PostMapping("/addActor")
    public ResponseEntity<Actor> addActor(@RequestBody ActorRequestDTO actorRequestDTO) {
        return ResponseEntity.ok(actorService.addActor(actorRequestDTO.getActorName()));
    }
}
