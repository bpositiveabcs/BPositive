package bpos.repository.Utils;

import bpos.model.*;
import bpos.model.Enums.BloodType;
import bpos.model.Enums.Rh;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class DBGetters {
    public static Address getAddress(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_Adresa");
        String tara=resultSet.getString("tara_Adresa");
        String judet=resultSet.getString("judet_Adresa");
        String localitate=resultSet.getString("localitate_Adresa");
        String strada=resultSet.getString("strada_Adresa");
        String numar=resultSet.getString("numar_Adresa");
        String bloc=resultSet.getString("bloc_Adresa");
        int etaj=resultSet.getInt("etaj_Adresa");
        String apartament=resultSet.getString("apartament_Adresa");
        Address address=new Address(tara,localitate,judet,strada,numar,bloc,etaj,apartament);
        address.setId(id);
        return address;
    }
    protected static Institution getInstitution(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_Institutie");
        String nume=resultSet.getString("nume_Institutie");
        String email=resultSet.getString("email_Institutie");
        String adress=resultSet.getString("adresa_Institutie");
        Institution institution=new Institution(nume,email,adress);
        institution.setId(id);
        return institution;
    }
    protected static DonationType getDonationType(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_TipDonatie");
        String nume=resultSet.getString("nume_TipDonatie");
        int interval=resultSet.getInt("interval_asteptare_TipDonatie");
        DonationType donationType=new DonationType(nume,interval);
        donationType.setId(id);
        return donationType;
    }
    protected static PersonalData getPersonalData(ResultSet resultSet) throws SQLException {
         Integer id=resultSet.getInt("id_DatePersonale");
         String nume=resultSet.getString("nume_DatePersonale");
         String prenume=resultSet.getString("prenume_DatePersonale");
         LocalDate dataNasterii=resultSet.getDate("dataNasterii_DatePersonale").toLocalDate();
         String cnp=resultSet.getString("CNP_DatePersonale");
         String sex=resultSet.getString("sex_DatePersonale");
         Address address=getAddress(resultSet);
         String telefon=resultSet.getString("telefon_DatePersonale");
         PersonalData personalData=new PersonalData(address,telefon,prenume,nume,cnp,sex,dataNasterii);
         personalData.setId(id);
         return personalData;
    }
    protected static Coupon getCoupon(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id_Cupon");
        String nume=resultSet.getString("nume_Cupon");
        String provider=resultSet.getString("provider_Cupon");
        String oferta=resultSet.getString("oferta_Cupon");
        int puncte_necesare=resultSet.getInt("puncte_necesare_Cupon");
        String serie=resultSet.getString("serieCupon_Cupon");
        int perioada_valabilitate=resultSet.getInt("timp_valabilitate_Cupon");
        LocalDateTime indisponibil_de_la=resultSet.getTimestamp("unavailable_to_claim_from_Cupon").toLocalDateTime();
        Coupon coupon=new Coupon(puncte_necesare,nume,provider,oferta,indisponibil_de_la,perioada_valabilitate,serie);
        coupon.setId(id);
        return coupon;
    }

    protected static RetrievedCoupons getRetrievedCoupons(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_CupoaneRetrieved");
        LocalDateTime receivedDate=resultSet.getTimestamp("preluat_la_data_de_CupoaneRetrieved").toLocalDateTime();
        LocalDateTime expirationDate=resultSet.getTimestamp("expira_la_CupoaneRetrieved").toLocalDateTime();
        Coupon coupon=getCoupon(resultSet);
        RetrievedCoupons retrievedCoupons=new RetrievedCoupons(coupon,receivedDate,expirationDate);
        retrievedCoupons.setId(id);
        return retrievedCoupons;
    }
    public static BloodTest getBloodTest(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_Analiza");
        String nume=resultSet.getString("nume_Analiza");
        String calerator=resultSet.getString("cale_Analiza");
        MedicalInfo medicalInfo=getMedicalInfo(resultSet);
        BloodTest bloodTest=new BloodTest(nume,calerator, medicalInfo);
        bloodTest.setId(id);
        return bloodTest;
    }
    protected static MedicalInfo getMedicalInfo(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_MedicalInformation");
        boolean eligibil=resultSet.getBoolean("eligibilitateDonare_MedicalInformation");
        BloodType grupaSanguina= BloodType.valueOf(resultSet.getString("grupaSange_MedicalInformation"));
        Rh rh = Rh.valueOf(resultSet.getString("rh_MedicalInformation"));
        MedicalInfo medicalInfo=new MedicalInfo(eligibil,grupaSanguina,rh,new ArrayList<>());
        medicalInfo.setId(id);
        return medicalInfo;
    }
    protected static LogInfo getLogInfo(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_LogInInfo");
        String username=resultSet.getString("username_LogInInfo");
        String password=resultSet.getString("password_LogInInfo");
        String email=resultSet.getString("email_LogInInfo");
        String seed=resultSet.getString("seed_LogInInfo");
       LogInfo logInfo=new LogInfo(username,password,email,seed);
        logInfo.setId(id);
        return logInfo;
    }

    protected static Center getCenter(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_Centru");
        String nume=resultSet.getString("nume_Centru");
        String informatii=resultSet.getString("informatii_Centru");
        String adresa=resultSet.getString("adresa_Centru");

        LogInfo logInfo=getLogInfo(resultSet);
        Center center=new Center(informatii,logInfo,nume,adresa);
        center.setId(id);
        return center;
    }
    protected static Donation getDonation(ResultSet resultSet) throws SQLException {
        Integer id=resultSet.getInt("id_Donatie");
        int puncte=resultSet.getInt("puncte_Donatie");
        DonationType donationType=getDonationType(resultSet);
        Donation donation=new Donation(donationType,puncte);
        donation.setId(id);
        return donation;
    }
    protected static Person getPerson(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id_Person");
        LogInfo logInfo=getLogInfo(resultSet);
        Integer points=resultSet.getInt("puncte_Person");
        PersonalData personalData=getPersonalData(resultSet);
        Institution institution=getInstitution(resultSet);
        MedicalInfo medicalInfo=getMedicalInfo(resultSet);
        Person person=new Person(logInfo,points,personalData,medicalInfo,institution);
        person.setId(id);
        return person;

    }
    protected static Student getStudent(ResultSet resultSet) throws SQLException {
        int id=resultSet.getInt("id_Student");
        String department=resultSet.getString("departament_Student");
        String faculty=resultSet.getString("facultate_Student");
        int an=resultSet.getInt("an_Student");
        String grupa=resultSet.getString("grupa_Student");
        Person person=getPerson(resultSet);
        Student student=new Student(department,faculty,an,grupa,person);
        student.setId(id);
        return student;
    }

}
