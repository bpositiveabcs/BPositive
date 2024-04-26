package bpos.repository.Implementations;

import bpos.model.RetrievedCoupons;
import bpos.model.Validators.Implementation.RetrievedCouponsValidator;
import bpos.repository.Interfaces.RetrievedCouponsRepository;
import bpos.repository.Utils.DBGetters;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

public class DBRetrievedCouponsRepository implements RetrievedCouponsRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private RetrievedCouponsValidator retrievedCouponsValidator;

    public DBRetrievedCouponsRepository(Properties properties, RetrievedCouponsValidator retrievedCouponsValidator) {
        this.dbUtils = new DBUtils(properties);
        this.retrievedCouponsValidator = retrievedCouponsValidator;
    }

    private Iterable<RetrievedCoupons> findAllUtilitary(List<String> attributes, List<Object> values)
    {
        Connection con=dbUtils.getConnection();
        String sql="SELECT * FROM View_CupoaneRetrieved";
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
        List<RetrievedCoupons> retrievedCoupons=new java.util.ArrayList<>();
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
                    RetrievedCoupons retrievedCoupon= DBGetters.getRetrievedCoupons(resultSet);
                    retrievedCoupons.add(retrievedCoupon);
                }
            }
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return retrievedCoupons;
    }
    @Override
    public Optional<RetrievedCoupons> findOne(Integer integer) {
        List<String> attributes=new java.util.ArrayList<>();
        List<Object> values=new java.util.ArrayList<>();
        attributes.add("id_CupoaneRetrieved");
        values.add(integer);
        Iterable<RetrievedCoupons> retrievedCoupons=findAllUtilitary(attributes,values);
        if(retrievedCoupons.iterator().hasNext())
        {
            return Optional.of(retrievedCoupons.iterator().next());
        }
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
