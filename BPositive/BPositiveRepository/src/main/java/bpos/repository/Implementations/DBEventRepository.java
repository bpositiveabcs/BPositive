package bpos.repository.Implementations;

import bpos.model.Event;
import bpos.model.Validators.Implementation.EventValidator;
import bpos.repository.Interfaces.EventRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Optional;

public class DBEventRepository implements EventRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private EventValidator eventValidator;
    @Override
    public Iterable<Event> findByNume(String nume) {
        return null;
    }

    @Override
    public Iterable<Event> findByDataAnunt(LocalDate data) {
        return null;
    }

    @Override
    public Iterable<Event> findByCentruId(Integer centruId) {
        return null;
    }

    @Override
    public Iterable<Event> findByDataInceput(LocalDate data) {
        return null;
    }

    @Override
    public Optional<Event> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Event> findAll() {
        return null;
    }

    @Override
    public Optional<Event> save(Event entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Event> delete(Event entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Event> update(Event entity) {
        return Optional.empty();
    }
}
