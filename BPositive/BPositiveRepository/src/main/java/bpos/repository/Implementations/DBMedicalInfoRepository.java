package bpos.repository.Implementations;

import bpos.model.BloodTest;
import bpos.model.MedicalInfo;
import bpos.model.Validators.Implementation.MedicalInfoValidator;
import bpos.repository.Interfaces.MedicalInfoRepository;
import bpos.repository.Utils.DBGetters;
import bpos.repository.Utils.DBUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.util.*;

public class DBMedicalInfoRepository implements MedicalInfoRepository {
    private DBUtils dbUtils;
    private static final Logger logger= LogManager.getLogger();
    private MedicalInfoValidator medicalInfoValidator;
    private Iterable<MedicalInfo> findAllUtilitary(List<String> attributes, List<Object> values)
    {
        Connection con=dbUtils.getConnection();
        String sql="SELECT * FROM View_MedicalInformation";
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
        HashMap<Integer,List<MedicalInfo>> medicalInfos=new HashMap<>();
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
                    MedicalInfo medicalInfo= DBGetters.getMedicalInfo(resultSet);
                    if(!medicalInfos.containsKey(medicalInfo.getId()))
                    {
                        List<MedicalInfo> medicalInfoList=new ArrayList<>();
                        medicalInfoList.add(medicalInfo);
                        medicalInfos.put(medicalInfo.getId(),medicalInfoList);
                    }
                    else
                    {
                        medicalInfos.get(medicalInfo.getId()).add(medicalInfo);
                    }
                }
                setBloodTests(medicalInfos);

            }
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
        }
        return medicalInfos;
    }

    private List<MedicalInfo> setBloodTests(HashMap<Integer, List<MedicalInfo>> medicalInfos) {
        List<MedicalInfo> medicalInfoList= (List<MedicalInfo>) medicalInfos.values();
        for(Map.Entry<Integer,MedicalInfo> entry:medicalInfos.entrySet())
        {
            MedicalInfo medicalInfo=entry.getValue();
            {
                medicalInfo.setMedicalHistory(DBGetters.getBloodTests(medicalInfo.getId()));
            }
            {
                medicalInfo.setMedicalHistory(DBGetters.getBloodTests(medicalInfo.getId()));
            }
        }
        {
            medicalInfo.setMedicalHistory(DBGetters.getBloodTests(medicalInfo.getId()));
        }
        {
            medicalInfo.setMedicalHistory(DBGetters.getBloodTests(medicalInfo.getId()));
        }
    }

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
        if (entity == null) {
            throw new IllegalArgumentException("entity must not be null");

        }
        if(medicalInfoValidator!=null)
        {
            medicalInfoValidator.validate(entity);
        }
        Connection con=dbUtils.getConnection();
        try(java.sql.PreparedStatement preparedStatement=con.prepareStatement("INSERT INTO MedicalInformation(eligibil_MedicalInformation,grupaSange_MedicalInformation,rh_MedicalInformation) VALUES (?,?,?)"))
        {
            preparedStatement.setBoolean(1,entity.isEligibil());
            preparedStatement.setString(2,entity.getBloodType().toString());
            preparedStatement.setString(3,entity.getRh().toString());
            preparedStatement.executeUpdate();
            return Optional.empty();
        }
        catch (java.sql.SQLException e)
        {
            logger.error(e);
            return Optional.of(entity);
        }
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
