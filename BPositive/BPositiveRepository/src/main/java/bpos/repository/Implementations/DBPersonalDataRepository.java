package bpos.repository.Implementations;

import bpos.model.PersonalData;
import bpos.model.Validators.Implementation.PersonalDataValidator;
import bpos.repository.Interfaces.PersonalDataRepository;
import bpos.repository.Utils.DBGetters;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class DBPersonalDataRepository implements PersonalDataRepository {
    private DBUtils dbUtils;

    public DBPersonalDataRepository(Properties properties, PersonalDataValidator personalDataValidator) {
        this.dbUtils = new DBUtils(properties);
        this.personalDataValidator = personalDataValidator;
    }

    private static final Logger logger= LogManager.getLogger();
    private PersonalDataValidator personalDataValidator;
    private Iterable<PersonalData> findAllUtilitary(List<String> attributes, List<Object> values)
    {
        Connection con=dbUtils.getConnection();
        String sql="SELECT * FROM View_DatePersonale";
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
        List<PersonalData> personalData=new java.util.ArrayList<>();
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
                    PersonalData personalData1= DBGetters.getPersonalData(resultSet);
                    personalData.add(personalData1);
                }
            }
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return personalData;
    }
    @Override
    public Optional<PersonalData> findOne(Integer integer) {
       List<String> attributes=new java.util.ArrayList<>();
         List<Object> values=new java.util.ArrayList<>();
            attributes.add("id_DatePersonale");
            values.add(integer);
            Iterable<PersonalData> personalData=findAllUtilitary(attributes,values);
            if(personalData.iterator().hasNext())
            {
                return Optional.of(personalData.iterator().next());
            }
            return Optional.empty();
    }

    @Override
    public Iterable<PersonalData> findAll() {
        return findAllUtilitary(null,new java.util.ArrayList<>());
    }

    @Override
    public Optional<PersonalData> save(PersonalData entity) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalData> delete(PersonalData entity) {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalData> update(PersonalData entity) {
        return Optional.empty();
    }

    @Override
    public Iterable<PersonalData> findByFirstName(String firstName) {
        return null;
    }

    @Override
    public Iterable<PersonalData> findByLastName(String lastName) {
        return null;
    }

    @Override
    public PersonalData findByCnp(String cnp) {
        return null;
    }
}
