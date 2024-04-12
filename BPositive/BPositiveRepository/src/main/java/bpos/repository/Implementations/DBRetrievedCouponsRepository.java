package bpos.repository.Implementations;

import bpos.model.RetrievedCoupons;
import bpos.model.Validators.Implementation.RetrievedCouponsValidator;
import bpos.repository.Interfaces.RetrievedCouponsRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBRetrievedCouponsRepository implements RetrievedCouponsRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private RetrievedCouponsValidator retrievedCouponsValidator;
    @Override
    public Optional<RetrievedCoupons> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<RetrievedCoupons> findAll() {
        return null;
    }

    @Override
    public Optional<RetrievedCoupons> save(RetrievedCoupons entity) {
        return Optional.empty();
    }

    @Override
    public Optional<RetrievedCoupons> delete(RetrievedCoupons entity) {
        return Optional.empty();
    }

    @Override
    public Optional<RetrievedCoupons> update(RetrievedCoupons entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<RetrievedCoupons> findByPersonId(int personId) {
        return null;
    }

    @Override
    public Iterable<RetrievedCoupons> findByCouponId(int couponId) {
        return null;
    }

    @Override
    public Iterable<RetrievedCoupons> findByDate(String date) {
        return null;
    }
}
