package bpos.repository.Implementations;

import bpos.model.Person;
import bpos.model.Validators.Implementation.PersonValidator;
import bpos.repository.Interfaces.PersonRepository;
import bpos.repository.Utils.DBGetters;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class DBPersonRepository implements PersonRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private PersonValidator personValidator;
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
        List<Person> persons=new java.util.ArrayList<>();
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
                    persons.add(person);
                }
            }
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return persons;
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
        return Optional.empty();
    }

    @Override
    public Optional<Person> delete(Person entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Person> update(Person entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Iterable<Person> findByLastName(String lastName) {
        return null;
    }

    @Override
    public Iterable<Person> findByCnp(String cnp) {
        return null;
    }

    @Override
    public Person findByEmail(String email) {
        return null;
    }

    @Override
    public Iterable<Person> findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Person findByUsername(String username) {
        return null;
    }
}
