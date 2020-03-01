package pl.zaliczeniejava.zaliczenieapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.zaliczeniejava.zaliczenieapp.dao.entity.Event;
import pl.zaliczeniejava.zaliczenieapp.manager.EventManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventyApi {

    private EventManager events;

    @Autowired
    public EventyApi(EventManager event) {
        this.events = event;
    }

    @GetMapping("/")
    public String home(ModelMap modelMap){
        modelMap.put("hello","Witaj Świecie");
        return "ret";
    }

    @GetMapping("/all")
    public Iterable<Event> getAll(){
        return events.findAll();
    }

    @GetMapping
    public Optional<Event> getById(@RequestParam Long index){
        return events.findById(index);
    }

    @PostMapping()
    public Event addEvent (@RequestBody Event event){
        return events.save(event);
    }

    @PutMapping
    public Event updateEvent(@RequestBody Event event){
        return events.save(event);
    }

    @DeleteMapping
    public void deleteEvent(@RequestParam Long index){
        events.deleteById(index);
    }


}
