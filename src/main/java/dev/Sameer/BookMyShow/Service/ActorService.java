package dev.Sameer.BookMyShow.Service;

import dev.Sameer.BookMyShow.Entity.Actor;
import dev.Sameer.BookMyShow.Repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepository;

    public Actor addActor(String actorName) {
        Actor actor = new Actor();
        actor.setActorName(actorName);
        actorRepository.save(actor);
        return actor;
    }
}
