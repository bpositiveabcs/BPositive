package bpos.repository.Implementations;

import bpos.model.LogInfo;
import bpos.model.Validators.Implementation.LogInfoValidator;
import bpos.repository.Interfaces.LogInfoRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBLogInfoRepository implements LogInfoRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private LogInfoValidator logInfoValidator;
    @Override
    public Optional<LogInfo> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<LogInfo> findAll() {
        return null;
    }

    @Override
    public Optional<LogInfo> save(LogInfo entity) {
        return Optional.empty();
    }

    @Override
    public Optional<LogInfo> delete(LogInfo entity) {
        return Optional.empty();
    }

    @Override
    public Optional<LogInfo> update(LogInfo entity) {
        return Optional.empty();
    }

    @Override
    public LogInfo findByUsername(String username) {
        return null;
    }

    @Override
    public LogInfo findByEmail(String email) {
        return null;
    }
}
