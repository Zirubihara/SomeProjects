package pl.zaliczeniejava.zaliczenieapp.dao.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Event {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id

    private Long id;

    private String event_name;

    private String event_description;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate event_date;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pub_date;

    private String location;

    private int places;

    public Event() {
    }

    public Event(Long id, String event_name, LocalDate event_date, String event_description, LocalDate pub_date, String location, int places) {
        this.id = id;
        this.event_name = event_name;
        this.event_date = event_date;
        this.event_description = event_description;
        this.pub_date = pub_date;
        this.location = location;
        this.places = places;
    }


    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }

    public LocalDate getPub_date() {
        return pub_date;
    }

    public void setPub_date(LocalDate pub_date) {
        this.pub_date = pub_date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPlaces() {
        return places;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

            public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", event_name='" + event_name + '\'' +
                ", event_description='" + event_description + '\'' +
                ", event_date=" + event_date +
                ", pub_date=" + pub_date +
                ", location='" + location + '\'' +
                ", places=" + places +
                '}';
    }
}
