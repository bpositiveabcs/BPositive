package bpos.repository.Implementations;

import bpos.model.Center;
import bpos.model.Validators.Implementation.CenterValidator;
import bpos.repository.Interfaces.CenterRepository;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class DBCenterRepository implements CenterRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    CenterValidator centerValidator;
    public DBCenterRepository(Properties properties, CenterValidator centerValidator){
        this.centerValidator=centerValidator;
        this.dbUtils=new DBUtils(properties);
    }
    private Iterable<Center> findAllUtilitary(List<String > attributes, List<Object> values)
    {
        Connection con=dbUtils.getConnection();
        List<Center> centers=new java.util.ArrayList<>();
        String sql="SELECT * from View_Centru";
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
        try (PreparedStatement preparedStatement=con.prepareStatement(sql))
        {
            for(int i=0;i<values.size();i++)
            {
                preparedStatement.setObject(i+1,values.get(i));
            }
            try(ResultSet resultSet=preparedStatement.executeQuery())
            {
                while(resultSet.next())
                {
                    Center center= bpos.repository.Utils.DBGetters.getCenter(resultSet);
                    centers.add(center);
                }
            }
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
            System.out.println("Error finding all elements DB"+ e);
        }
        return centers;
    }
    @Override
    public Center findByUsername(String username) {
        List<Center>  list= (List<Center>) findAllUtilitary(List.of("username_LogInInfo") ,List.of(username));
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Center findByEmail(String email) {

        List<Center>  list= (List<Center>) findAllUtilitary(List.of("email_LogInInfo"),List.of(email));
        return list.isEmpty()?null:list.get(0);
    }

    @Override
    public Center findByPhoneNumber(String phoneNumber) {
        return null;
    }

    @Override
    public Iterable<Center> findByName(String name) {
        return null;
    }

    @Override
    public Optional<Center> findOne(Integer integer) {
        return Optional.empty();
    }

    @Override
    public Iterable<Center> findAll() {
        return null;
    }

    @Override
    public Optional<Center> save(Center entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Center> delete(Center entity) {
        return Optional.empty();
    }

    @Override
    public Optional<Center> update(Center entity) {
        return Optional.empty();
    }
}
