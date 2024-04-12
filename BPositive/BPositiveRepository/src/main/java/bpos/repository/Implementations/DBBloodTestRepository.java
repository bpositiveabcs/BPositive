package bpos.repository.Implementations;

import bpos.model.BloodTest;
import bpos.model.Validators.Implementation.BloodTestValidator;
import bpos.repository.Interfaces.BloodTestRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBBloodTestRepository implements BloodTestRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    BloodTestValidator bloodTestValidator;
    @Override
    public Optional<BloodTest> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<BloodTest> findAll() {
        return null;
    }

    @Override
    public Optional<BloodTest> save(BloodTest entity) {
        return Optional.empty();
    }

    @Override
    public Optional<BloodTest> delete(BloodTest entity) {
        return Optional.empty();
    }

    @Override
    public Optional<BloodTest> update(BloodTest entity) {
        return Optional.empty();
    }
}
