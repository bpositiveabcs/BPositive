package bpos.repository.Implementations;

import bpos.model.PersonalData;
import bpos.model.Validators.Implementation.PersonalDataValidator;
import bpos.repository.Interfaces.PersonalDataRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBPersonalDataRepository implements PersonalDataRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private PersonalDataValidator personalDataValidator;
    @Override
    public Optional<PersonalData> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<PersonalData> findAll() {
        return null;
    }

    @Override
    public Optional<PersonalData> save(PersonalData entity) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalData> delete(PersonalData entity) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalData> update(PersonalData entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<PersonalData> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Iterable<PersonalData> findByLastName(String lastName) {
        return null;
    }

    @Override
    public PersonalData findByCnp(String cnp) {
        return null;
    }
}
