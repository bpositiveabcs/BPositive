package bpos.repository.Implementations;

import bpos.model.Person;
import bpos.model.Validators.Implementation.PersonValidator;
import bpos.repository.Interfaces.PersonRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBPersonRepository implements PersonRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private PersonValidator personValidator;

    @Override
    public Optional<Person> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findAll() {
        return null;
    }

    @Override
    public Optional<Person> save(Person entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> delete(Person entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> update(Person entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Iterable<Person> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> findByCnp(String cnp) {
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<Person> findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Person findByUsername(String username) {
        return null;
    }
}
