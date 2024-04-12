package bpos.repository.Implementations;

import bpos.model.Student;
import bpos.model.Validators.Implementation.StudentValidator;
import bpos.repository.Interfaces.StudentRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Optional;

public class DBStudentRepository implements StudentRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private StudentValidator    studentValidator;
    @Override
    public Optional<Student> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Student> findAll() {
        return null;
    }

    @Override
    public Optional<Student> save(Student entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> delete(Student entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Student> update(Student entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<Student> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Iterable<Student> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Iterable<Student> findByCnp(String cnp) {
        return null;
    }

    @Override
    public Student findByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<Student> findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Student findByUsername(String username) {
        return null;
    }
}
