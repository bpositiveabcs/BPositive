package bpos.repository.Implementations;

import bpos.model.Center;
import bpos.model.Validators.Implementation.CenterValidator;
import bpos.repository.Interfaces.CenterRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBCenterRepository implements CenterRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    CenterValidator centerValidator;
    @Override
    public Center findByUsername(String username) {
        return null;
    }

    @Override
    public Center findByEmail(String email) {
        return null;
    }

    @Override
    public Center findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Iterable<Center> findByName(String name) {
        return null;
    }

    @Override
    public Optional<Center> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Center> findAll() {
        return null;
    }

    @Override
    public Optional<Center> save(Center entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Center> delete(Center entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Center> update(Center entity) {
        return Optional.empty();
    }
}
