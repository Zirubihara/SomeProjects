package pl.zaliczeniejava.zaliczenieapp.api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.zaliczeniejava.zaliczenieapp.dao.entity.Event;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class EventController {

    private List<Event> events;

    public EventController(){
        Event event1 = new Event(1L,"Event", LocalDate.of(2020,2,1),"Egzamin z Lalgorytmiki",LocalDate.of(2069,12,1),"a",1);
        Event event2 = new Event(2L,"CheckIT", LocalDate.of(2069,12,1),"Konferencja dla licealistów",LocalDate.of(2069,12,1),"a",1);
        events = new ArrayList<>();
        events.add(event1);
        events.add(event2);
    }

    @GetMapping("/all")
    public String all(Model model){
        model.addAttribute("events",events);
        return "all";
    }

    @GetMapping("/add")
    public String getEvents(Model model){
        model.addAttribute("events",events);
        model.addAttribute("newEvent",new Event());
        return "add";
    }

    @PostMapping("/addEvent")
    public String addEvent(@ModelAttribute Event event){
        events.add(event);
        return "redirect:/add";
    }
}
