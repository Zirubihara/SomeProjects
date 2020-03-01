package pl.zaliczeniejava.zaliczenieapp.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.zaliczeniejava.zaliczenieapp.dao.entity.Event;

@Repository
public interface EventRepo extends CrudRepository<Event, Long> {
}
