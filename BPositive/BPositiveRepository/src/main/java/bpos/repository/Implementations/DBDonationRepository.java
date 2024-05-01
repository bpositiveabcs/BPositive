package bpos.repository.Implementations;

import bpos.model.Donation;
import bpos.model.Validators.Implementation.DonationValidator;
import bpos.repository.Interfaces.DonationRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBDonationRepository implements DonationRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private DonationValidator donationValidator;
    @Override
    public Iterable<Donation> findByTipDonatie(String tipDonatie) {
        return null;
    }

    @Override
    public Iterable<Donation> findByIdTipDonatie(Integer idTipDonatie) {
        return null;
    }

    @Override
    public Optional<Donation> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Donation> findAll() {
        return null;
    }

    @Override
    public Optional<Donation> save(Donation entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Donation> delete(Donation entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Donation> update(Donation entity) {
        return Optional.empty();
    }
}
