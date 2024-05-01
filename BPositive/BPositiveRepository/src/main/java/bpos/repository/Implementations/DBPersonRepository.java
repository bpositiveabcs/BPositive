package bpos.repository.Implementations;

import bpos.model.BloodTest;
import bpos.model.MedicalInfo;
import bpos.model.Person;
import bpos.model.Validators.Implementation.PersonValidator;
import bpos.repository.Interfaces.PersonRepository;
import bpos.repository.Utils.DBGetters;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class DBPersonRepository implements PersonRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private PersonValidator personValidator;

    public DBPersonRepository(Properties properties, PersonValidator personValidator) {
        this.dbUtils = new DBUtils(properties);
        this.personValidator = personValidator;
    }

    private Iterable<Person> findAllUtilitary(List<String> attributes, List<Object> values)
    {
        Connection con=dbUtils.getConnection();
        String sql="SELECT * FROM View_Persoana";
        if(attributes!=null)
        {
            sql+=" where ";
            for(int i=0;i<attributes.size();i++)
            {
                sql+=attributes.get(i)+"=?";
                if(i<attributes.size()-1)
                {
                    sql+=" and ";
                }
            }
        }
        HashMap<Integer,Person> persons=new HashMap<>();
        try (java.sql.PreparedStatement preparedStatement=con.prepareStatement(sql))
        {
            for(int i=0;i<values.size();i++)
            {
                preparedStatement.setObject(i+1,values.get(i));
            }
            try(java.sql.ResultSet resultSet=preparedStatement.executeQuery())
            {
                while(resultSet.next())
                {
                    Person person= DBGetters.getPerson(resultSet);
                    if(!persons.containsKey(person.getId()))
                    {
                        persons.put(person.getId(),person);
                    }
                    else {
                        person=addToMedicalInfo(person,persons.get(person.getId()));
                        persons.put(person.getId(),person);
                    }
                }
            }
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return persons.values();
    }

    private Person addToMedicalInfo(Person person,Person old_person) {
        if(person.getMedicalInfo()!=null)
        {
            MedicalInfo medicalInfo=old_person.getMedicalInfo();
            List<BloodTest> bloodTests=old_person.getMedicalInfo().getMedicalHistory();
            BloodTest to_add=person.getMedicalInfo().getMedicalHistory().get(0);
            bloodTests.add(to_add);
            medicalInfo.setMedicalHistory(bloodTests);
            person.setMedicalInfo(medicalInfo);
            return person;
        }
        return old_person;
    }

    @Override
    public Optional<Person> findOne(Integer integer) {
    List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("ID_Persoana");
        values.add(integer);
        Iterable<Person> persons=findAllUtilitary(attributes,values);
        if(persons.iterator().hasNext())
        {
            return Optional.of(persons.iterator().next());
        }
        return Optional.empty();}

    @Override
    public Iterable<Person> findAll() {
        return findAllUtilitary(null,new java.util.ArrayList<>());
    }

    @Override
    public Optional<Person> save(Person entity) {
        Connection connection=dbUtils.getConnection();
        if(entity==null)
        {
            logger.error("Entity is null");
            return Optional.empty();
        }
        if(personValidator!=null)
        {
            personValidator.validate(entity);
        }
        String sql="INSERT INTO Persoana (id,puncte,id_institutie) VALUES (?,?,?)";
            try(java.sql.PreparedStatement preparedStatement=connection.prepareStatement(sql))
            {
                preparedStatement.setInt(1,entity.getId());
                preparedStatement.setInt(2,entity.getPoints());
                preparedStatement.setInt(3,entity.getInstitution().getId());
                preparedStatement.executeUpdate();
                return Optional.of(entity);
            }
            catch (java.sql.SQLException e)
            {
                logger.error(e);
            }

        return Optional.empty();
    }

    @Override
    public Optional<Person> delete(Person entity) {
        if(entity==null)
        {
            logger.error("Entity is null");
            return Optional.empty();
        }
        String sql="DELETE FROM Persoana WHERE id=?";
        Connection connection=dbUtils.getConnection();

        try(java.sql.PreparedStatement preparedStatement=connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1,entity.getId());
            preparedStatement.executeUpdate();
            return Optional.of(entity);
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Person> update(Person entity) {
        if(entity==null)
        {
            logger.error("Entity is null");
            return Optional.empty();
        }
        if(personValidator!=null)
        {
            personValidator.validate(entity);
        }
        String sql="UPDATE Persoana SET puncte=?,id_institutie=? WHERE id=?";
        Connection connection=dbUtils.getConnection();
        try(java.sql.PreparedStatement preparedStatement=connection.prepareStatement(sql))
        {
            preparedStatement.setInt(1,entity.getPoints());
            preparedStatement.setInt(2,entity.getInstitution().getId());
            preparedStatement.setInt(3,entity.getId());
            preparedStatement.executeUpdate();
            return Optional.of(entity);
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findByFirstName(String firstName) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("prenume_DatePersonale");
        values.add(firstName);
        return findAllUtilitary(attributes,values);
    }

    @Override
    public Iterable<Person> findByLastName(String lastName) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("nume_DatePersonale");
        values.add(lastName);
        return findAllUtilitary(attributes,values);
    }

    @Override
    public Iterable<Person> findByCnp(String cnp) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("cnp_DatePersonale");
        values.add(cnp);
        return findAllUtilitary(attributes,values);
    }

    @Override
    public Person findByEmail(String email) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("email_DatePersonale");
        values.add(email);
        Iterable<Person> persons=findAllUtilitary(attributes,values);
        if(persons.iterator().hasNext())
        {
            return persons.iterator().next();
        }
        return null;
    }

    @Override
    public Iterable<Person> findByPhoneNumber(String phoneNumber) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("telefon_DatePersonale");
        values.add(phoneNumber);
        return findAllUtilitary(attributes,values);
    }

    @Override
    public Person findByUsername(String username) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("username_LogInInfo");
        values.add(username);
        Iterable<Person> persons=findAllUtilitary(attributes,values);
        if(persons.iterator().hasNext())
        {
            return persons.iterator().next();
        }
        return null;
    }
}
