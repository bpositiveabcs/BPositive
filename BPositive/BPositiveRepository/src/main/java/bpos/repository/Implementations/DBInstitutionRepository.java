package bpos.repository.Implementations;

import bpos.model.Institution;
import bpos.model.Validators.Implementation.InstitutionValidator;
import bpos.repository.Interfaces.InstitutionRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBInstitutionRepository implements InstitutionRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private InstitutionValidator institutionValidator;
    @Override
    public Optional<Institution> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Institution> findAll() {
        return null;
    }

    @Override
    public Optional<Institution> save(Institution entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Institution> delete(Institution entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Institution> update(Institution entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<Institution> findByName(String name) {
        return null;
    }

    @Override
    public Iterable<Institution> findByAddress(String address) {
        return null;
    }

    @Override
    public Iterable<Institution> findByEmail(String email) {
        return null;
    }
}
