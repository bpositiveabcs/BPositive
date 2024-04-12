package bpos.repository.Implementations;

import bpos.model.MedicalInfo;
import bpos.model.Validators.Implementation.MedicalInfoValidator;
import bpos.repository.Interfaces.MedicalInfoRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBMedicalInfoRepository implements MedicalInfoRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private MedicalInfoValidator medicalInfoValidator;
    @Override
    public Optional<MedicalInfo> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<MedicalInfo> findAll() {
        return null;
    }

    @Override
    public Optional<MedicalInfo> save(MedicalInfo entity) {
        return Optional.empty();
    }

    @Override
    public Optional<MedicalInfo> delete(MedicalInfo entity) {
        return Optional.empty();
    }

    @Override
    public Optional<MedicalInfo> update(MedicalInfo entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<MedicalInfo> findByBloodType(String bloodType) {
        return null;
    }

    @Override
    public Iterable<MedicalInfo> findByRh(String rh) {
        return null;
    }

    @Override
    public Iterable<MedicalInfo> findByBloodTypeAndRh(String bloodType, String rh) {
        return null;
    }
}
