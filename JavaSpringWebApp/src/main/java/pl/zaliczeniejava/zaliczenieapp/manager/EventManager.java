package pl.zaliczeniejava.zaliczenieapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.zaliczeniejava.zaliczenieapp.dao.EventRepo;
import pl.zaliczeniejava.zaliczenieapp.dao.entity.Event;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class EventManager {

    private EventRepo eventRepo;

    @Autowired
    public EventManager(EventRepo eventRepo) {
        this.eventRepo = eventRepo;
    }

    public Optional<Event> findById(Long id){
        return eventRepo.findById(id);
    }

    public Iterable<Event> findAll(){
        return eventRepo.findAll();
    }

    public Event save(Event event){
        return eventRepo.save(event);
    }

    public void deleteById(Long id){
        eventRepo.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void fillDB() {

    }
}
