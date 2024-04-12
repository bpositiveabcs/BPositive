package bpos.repository.Implementations;

import bpos.model.Coupon;
import bpos.model.Validators.Implementation.CouponValidator;
import bpos.repository.Interfaces.CouponRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Optional;

public class DBCouponRepository implements CouponRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private CouponValidator couponValidator;
    @Override
    public Iterable<Coupon> findByCodeCoupon(String code) {
        return null;
    }

    @Override
    public Iterable<Coupon> findByProvider(String provider) {
        return null;
    }

    @Override
    public Iterable<Coupon> findByNume(String nume) {
        return null;
    }

    @Override
    public Iterable<Coupon> findByEndDate(LocalDate endDate) {
        return null;
    }

    @Override
    public Optional<Coupon> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Coupon> findAll() {
        return null;
    }

    @Override
    public Optional<Coupon> save(Coupon entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Coupon> delete(Coupon entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Coupon> update(Coupon entity) {
        return Optional.empty();
    }
}
