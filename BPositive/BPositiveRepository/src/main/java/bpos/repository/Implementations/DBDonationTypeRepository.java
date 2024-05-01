package bpos.repository.Implementations;

import bpos.model.DonationType;
import bpos.model.Validators.Implementation.DonationTypeValidator;
import bpos.repository.Interfaces.DonationTypeRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBDonationTypeRepository implements DonationTypeRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private DonationTypeValidator donationTypeValidator;
    @Override
    public Optional<DonationType> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<DonationType> findAll() {
        return null;
    }

    @Override
    public Optional<DonationType> save(DonationType entity) {
        return Optional.empty();
    }

    @Override
    public Optional<DonationType> delete(DonationType entity) {
        return Optional.empty();
    }

    @Override
    public Optional<DonationType> update(DonationType entity) {
        return Optional.empty();
    }
}
