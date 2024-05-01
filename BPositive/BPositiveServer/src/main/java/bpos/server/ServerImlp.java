package bpos.server;

import bpos.repository.Implementations.*;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class ServerImlp implements IServiceImpl {
    private DBInstitutionRepository dbInstitution;
    private DBLogInfoRepository dbLogInfo;
    private DBMedicalInfoRepository dbMedicalInfo;
    private DBPersonRepository dbPerson;
    private DBPersonalDataRepository dbPersonalData;
    private DBRetrievedCouponsRepository dbRetrievedCoupons;
    private DBAddressRepository dbAddress;
    private DBBloodTestRepository dbBloodTest;
    private DBCenterRepository dbCenter;
    private DBCouponRepository dbCoupon;
    private DBDonationRepository dbDonation;
    private DBDonationTypeRepository dbDonationType;
private DBEventRepository dbEvent;

    public ServerImlp(DBInstitutionRepository dbInstitution, DBLogInfoRepository dbLogInfo, DBMedicalInfoRepository dbMedicalInfo, DBPersonRepository dbPerson, DBPersonalDataRepository dbPersonalData, DBRetrievedCouponsRepository dbRetrievedCoupons, DBAddressRepository dbAddress, DBBloodTestRepository dbBloodTest, DBCenterRepository dbCenter, DBCouponRepository dbCoupon, DBDonationRepository dbDonation, DBDonationTypeRepository dbDonationType, DBEventRepository dbEvent) {
        this.dbInstitution = dbInstitution;
        this.dbLogInfo = dbLogInfo;
        this.dbMedicalInfo = dbMedicalInfo;
        this.dbPerson = dbPerson;
        this.dbPersonalData = dbPersonalData;
        this.dbRetrievedCoupons = dbRetrievedCoupons;
        this.dbAddress = dbAddress;
        this.dbBloodTest = dbBloodTest;
        this.dbCenter = dbCenter;
        this.dbCoupon = dbCoupon;
        this.dbDonation = dbDonation;
        this.dbDonationType = dbDonationType;
        this.dbEvent = dbEvent;
    }

//    @Override
//    public Iterable<bpos.model.Address> findAllUtilitaryAddress(List<String> attributes, List<Object> values) throws ServicesExceptions {
//        return null;
//    }

    @Override
    public Optional<bpos.model.Address> findOneAddress(Integer integer) throws ServicesExceptions {
        return dbAddress.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Address> findAllAddresses() throws ServicesExceptions {
        return dbAddress.findAll();
    }

    @Override
    public Optional<bpos.model.BloodTest> findOneBloodTest(Integer integer) throws ServicesExceptions {
        return dbBloodTest.findOne(integer);
    }


    @Override
    public Iterable<bpos.model.BloodTest> findAllBloodTest() throws ServicesExceptions {
        return dbBloodTest.findAll();
    }


    @Override
    public bpos.model.Center findByUsernameCenter(String username) throws ServicesExceptions {
        return dbCenter.findByUsername(username);
    }

    @Override
    public bpos.model.Center findByEmailCenter(String email) throws ServicesExceptions {
        return dbCenter.findByEmail(email);
    }

    @Override
    public Iterable<bpos.model.Center> findByNameCenter(String name) throws ServicesExceptions {
        return dbCenter.findByName(name);
    }

    @Override
    public Optional<bpos.model.Center> findOneCenter(Integer integer) throws ServicesExceptions {
        return dbCenter.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Center> findAllCenters() throws ServicesExceptions {
        return dbCenter.findAll();
    }


    @Override
    public Iterable<bpos.model.Coupon> findByCodeCoupon(String code) throws ServicesExceptions {
        return dbCoupon.findByCodeCoupon(code);
    }

    @Override
    public Iterable<bpos.model.Coupon> findByProviderCoupon(String provider) throws ServicesExceptions {
        return dbCoupon.findByProvider(provider);
    }

    @Override
    public Iterable<bpos.model.Coupon> findByNameCoupon(String name) throws ServicesExceptions {
        return dbCoupon.findByNume(name);
    }

    @Override
    public Iterable<bpos.model.Coupon> findByEndDateCoupon(LocalDate endDate) throws ServicesExceptions {
        return dbCoupon.findByEndDate(endDate);
    }

    @Override
    public Optional<bpos.model.Coupon> findOneCoupon(Integer integer) throws ServicesExceptions {
        return dbCoupon.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Coupon> findAllCoupons() throws ServicesExceptions {
        return dbCoupon.findAll();
    }



    @Override
    public Iterable<bpos.model.Donation> findByTipDonation(String tipDonatie) throws ServicesExceptions {
        return dbDonation.findByTipDonatie(tipDonatie);
    }

    @Override
    public Iterable<bpos.model.Donation> findByIdTipDonation(Integer idTipDonatie) throws ServicesExceptions {
        return dbDonation.findByIdTipDonatie(idTipDonatie);
    }

    @Override
    public Optional<bpos.model.Donation> findOneDonation(Integer integer) throws ServicesExceptions {
        return dbDonation.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Donation> findAllDonations() throws ServicesExceptions {
        return dbDonation.findAll();
    }



    @Override
    public Optional<bpos.model.DonationType> findOneDonationType(Integer integer) throws ServicesExceptions {
        return dbDonationType.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.DonationType> findAllDonationType() throws ServicesExceptions {
        return dbDonationType.findAll();
    }


    @Override
    public Iterable<bpos.model.Event> findByNameEvent(String nume) throws ServicesExceptions {
        return dbEvent.findByNume(nume);
    }

    @Override
    public Iterable<bpos.model.Event> findByAnnouncementDateEvent(LocalDate data) throws ServicesExceptions {
        return dbEvent.findByDataAnunt(data);
    }

    @Override
    public Iterable<bpos.model.Event> findByCenterIdEvent(Integer centruId) throws ServicesExceptions {
        return dbEvent.findByCentruId(centruId);
    }

    @Override
    public Iterable<bpos.model.Event> findByDataInceputEvent(LocalDate data) throws ServicesExceptions {
        return dbEvent.findByDataInceput(data);
    }

    @Override
    public Optional<bpos.model.Event> findOneEvent(Integer integer) throws ServicesExceptions {
        return dbEvent.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Event> findAllEvents() throws ServicesExceptions {
        return dbEvent.findAll();
    }


    @Override
    public Optional<bpos.model.Institution> findOneInstitution(Integer integer) throws ServicesExceptions {
        return dbInstitution.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Institution> findAllInstitutions() throws ServicesExceptions {
        return dbInstitution.findAll();
    }

    @Override
    public Iterable<bpos.model.Institution> findByNameInstitution(String name) throws ServicesExceptions {
        return dbInstitution.findByName(name);
    }

    @Override
    public Iterable<bpos.model.Institution> findByAddressInstitution(String address) throws ServicesExceptions {
        return dbInstitution.findByAddress(address);
    }

    @Override
    public Iterable<bpos.model.Institution> findByEmailInstitution(String email) throws ServicesExceptions {
        return dbInstitution.findByEmail(email);
    }



    @Override
    public Optional<bpos.model.LogInfo> findOneLogInfo(Integer integer) throws ServicesExceptions {
        return dbLogInfo.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.LogInfo> findAllLogInfos() throws ServicesExceptions {
        return dbLogInfo.findAll();
    }

    @Override
    public bpos.model.LogInfo findByUsernameLogInfo(String username) throws ServicesExceptions {
        return dbLogInfo.findByUsername(username);
    }

    @Override
    public bpos.model.LogInfo findByEmailLogInfo(String email) throws ServicesExceptions {
        return dbLogInfo.findByEmail(email);
    }



    @Override
    public Optional<bpos.model.MedicalInfo> findOneMedicalInfo(Integer integer) throws ServicesExceptions {
        return dbMedicalInfo.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.MedicalInfo> findAllMedicalInfos() throws ServicesExceptions {
        return dbMedicalInfo.findAll();
    }

    @Override
    public Iterable<bpos.model.MedicalInfo> findByBloodTypeMedicalInfo(String bloodType) throws ServicesExceptions {
        return dbMedicalInfo.findByBloodType(bloodType);
    }

    @Override
    public Iterable<bpos.model.MedicalInfo> findByRhMedicalInfo(String rh) throws ServicesExceptions {
        return dbMedicalInfo.findByRh(rh);
    }

    @Override
    public Iterable<bpos.model.MedicalInfo> findByBloodTypeAndRhMedicalInfo(String bloodType, String rh) throws ServicesExceptions {
        return  dbMedicalInfo.findByBloodTypeAndRh(bloodType,rh);
    }

//    @Override
//    public Iterable<bpos.model.PersonalData> findAllUtilitaryPersonalData(List<String> attributes, List<Object> values) throws ServicesExceptions {
//        return null;
//    }

    @Override
    public Optional<bpos.model.PersonalData> findOnePersonalData(Integer integer) throws ServicesExceptions {
        return dbPersonalData.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.PersonalData> findAllPersonalDatas() throws ServicesExceptions {
        return dbPersonalData.findAll();
    }

    @Override
    public Iterable<bpos.model.PersonalData> findByFirstNamePersonalData(String firstName) throws ServicesExceptions {
        return dbPersonalData.findByFirstName(firstName);
    }

    @Override
    public Iterable<bpos.model.PersonalData> findByLastNamePersonalData(String lastName) throws ServicesExceptions {
        return dbPersonalData.findByLastName(lastName);
    }

    @Override
    public bpos.model.PersonalData findByCnpPersonalData(String cnp) throws ServicesExceptions {
        return dbPersonalData.findByCnp(cnp);
    }

//    @Override
//    public Iterable<bpos.model.Person> findAllUtilitaryPerson(List<String> attributes, List<Object> values) throws ServicesExceptions {
//        return null;
//    }

    @Override
    public Optional<bpos.model.Person> findOnePerson(Integer integer) throws ServicesExceptions {
        return dbPerson.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.Person> findAllPersons() throws ServicesExceptions {
        return dbPerson.findAll();
    }

    @Override
    public Iterable<bpos.model.Person> findByFirstNamePerson(String firstName) throws ServicesExceptions {
        return dbPerson.findByFirstName(firstName);
    }

    @Override
    public Iterable<bpos.model.Person> findByLastNamePerson(String lastName) throws ServicesExceptions {
        return dbPerson.findByLastName(lastName);
    }

    @Override
    public Iterable<bpos.model.Person> findByCnpPerson(String cnp) throws ServicesExceptions {
        return dbPerson.findByCnp(cnp);
    }

    @Override
    public bpos.model.Person findByEmailPerson(String email) throws ServicesExceptions {
        return dbPerson.findByEmail(email);
    }

    @Override
    public Iterable<bpos.model.Person> findByPhoneNumberPerson(String phoneNumber) throws ServicesExceptions {
        return dbPerson.findByPhoneNumber(phoneNumber);
    }

    @Override
    public bpos.model.Person findByUsernamePerson(String username) throws ServicesExceptions {
        return dbPerson.findByUsername(username);
    }

//    @Override
//    public Iterable<bpos.model.RetrievedCoupons> findAllUtilitaryRetrieved(List<String> attributes, List<Object> values) throws ServicesExceptions {
//        return null;
//    }

    @Override
    public Optional<bpos.model.RetrievedCoupons> findOneRetrieved(Integer integer) throws ServicesExceptions {
        return dbRetrievedCoupons.findOne(integer);
    }

    @Override
    public Iterable<bpos.model.RetrievedCoupons> findAllRetrieved() throws ServicesExceptions {
        return dbRetrievedCoupons.findAll();
    }

    @Override
    public Iterable<bpos.model.RetrievedCoupons> findByCouponIdRetrieved(Integer couponId) throws ServicesExceptions {
        return dbRetrievedCoupons.findByCouponId(couponId);
    }

    @Override
    public Iterable<bpos.model.RetrievedCoupons> findByPersonIdRetrieved(Integer personId) throws ServicesExceptions {
        return dbRetrievedCoupons.findByPersonId(personId);
    }

    @Override
    public Iterable<bpos.model.RetrievedCoupons> findByDateRetrieved(String date) throws ServicesExceptions {
        return dbRetrievedCoupons.findByDate(date);
    }

    @Override
    public Optional<bpos.model.RetrievedCoupons> updateRetrieved(bpos.model.RetrievedCoupons entity) throws ServicesExceptions {
        return dbRetrievedCoupons.update(entity);
    }

    @Override
    public Optional<bpos.model.RetrievedCoupons> deleteRetrieved(bpos.model.RetrievedCoupons entity) throws ServicesExceptions {
        return  dbRetrievedCoupons.delete(entity);
    }

    @Override
    public Optional<bpos.model.RetrievedCoupons> saveRetrieved(bpos.model.RetrievedCoupons entity) throws ServicesExceptions {
        return dbRetrievedCoupons.save(entity);
    }

    @Override
    public Optional<bpos.model.Person> updatePerson(bpos.model.Person entity) throws ServicesExceptions {
        return dbPerson.update(entity);
    }

    @Override
    public Optional<bpos.model.Person> deletePerson(bpos.model.Person entity) throws ServicesExceptions {
        return dbPerson.delete(entity);
    }

    @Override
    public Optional<bpos.model.Person> savePerson(bpos.model.Person entity) throws ServicesExceptions {
        return dbPerson.save(entity);
    }

    @Override
    public Optional<bpos.model.PersonalData> updatePersonalData(bpos.model.PersonalData entity) throws ServicesExceptions {
        return dbPersonalData.update(entity);
    }

    @Override
    public Optional<bpos.model.PersonalData> deletePersonalData(bpos.model.PersonalData entity) throws ServicesExceptions {
        return dbPersonalData.delete(entity);
    }

    @Override
    public Optional<bpos.model.PersonalData> savePersonalData(bpos.model.PersonalData entity) throws ServicesExceptions {
        return  dbPersonalData.save(entity);
    }

    @Override
    public Optional<bpos.model.MedicalInfo> updateMedicalInfo(bpos.model.MedicalInfo entity) throws ServicesExceptions {
        return dbMedicalInfo.update(entity);
    }

    @Override
    public Optional<bpos.model.MedicalInfo> deleteMedicalInfo(bpos.model.MedicalInfo entity) throws ServicesExceptions {
        return dbMedicalInfo.delete(entity);
    }

    @Override
    public Optional<bpos.model.MedicalInfo> saveMedicalInfo(bpos.model.MedicalInfo entity) throws ServicesExceptions {
        return dbMedicalInfo.save(entity);
    }

    @Override
    public Optional<bpos.model.LogInfo> updateLogInfo(bpos.model.LogInfo entity) throws ServicesExceptions {
        return dbLogInfo.update(entity);
    }

    @Override
    public Optional<bpos.model.LogInfo> deleteLogInfo(bpos.model.LogInfo entity) throws ServicesExceptions {
        return dbLogInfo.delete(entity);
    }

    @Override
    public Optional<bpos.model.LogInfo> saveLogInfo(bpos.model.LogInfo entity) throws ServicesExceptions {
        return dbLogInfo.save(entity);
    }

    @Override
    public Optional<bpos.model.Institution> updateInstitution(bpos.model.Institution entity) throws ServicesExceptions {
        return dbInstitution.update(entity);
    }

    @Override
    public Optional<bpos.model.Institution> deleteInstitution(bpos.model.Institution entity) throws ServicesExceptions {
        return dbInstitution.delete(entity);
    }

    @Override
    public Optional<bpos.model.Institution> saveInstitution(bpos.model.Institution entity) throws ServicesExceptions {
        return dbInstitution.save(entity);
    }

    @Override
    public Optional<bpos.model.Event> updateEvent(bpos.model.Event entity) throws ServicesExceptions {
        return dbEvent.update(entity);
    }

    @Override
    public Optional<bpos.model.Event> deleteEvent(bpos.model.Event entity) throws ServicesExceptions {
        return dbEvent.delete(entity);
    }

    @Override
    public Optional<bpos.model.Event> saveEvent(bpos.model.Event entity) throws ServicesExceptions {
        return dbEvent.save(entity);
    }

    @Override
    public Optional<bpos.model.DonationType> updateDonationType(bpos.model.DonationType entity) throws ServicesExceptions {
        return dbDonationType.update(entity);
    }

    @Override
    public Optional<bpos.model.DonationType> deleteDonationType(bpos.model.DonationType entity) throws ServicesExceptions {
        return dbDonationType.delete(entity);
    }

    @Override
    public Optional<bpos.model.DonationType> saveDonationType(bpos.model.DonationType entity) throws ServicesExceptions {
        return dbDonationType.save(entity);
    }

    @Override
    public Optional<bpos.model.Donation> updateDonation(bpos.model.Donation entity) throws ServicesExceptions {
        return dbDonation.update(entity);
    }

    @Override
    public Optional<bpos.model.Donation> deleteDonation(bpos.model.Donation entity) throws ServicesExceptions {
        return dbDonation.delete(entity);
    }

    @Override
    public Optional<bpos.model.Donation> saveDonation(bpos.model.Donation entity) throws ServicesExceptions {
        return dbDonation.save(entity);
    }

    @Override
    public Optional<bpos.model.Coupon> updateCoupon(bpos.model.Coupon entity) throws ServicesExceptions {
        return dbCoupon.update(entity);
    }

    @Override
    public Optional<bpos.model.Coupon> deleteCoupon(bpos.model.Coupon entity) throws ServicesExceptions {
        return dbCoupon.delete(entity);
    }

    @Override
    public Optional<bpos.model.Coupon> saveCoupon(bpos.model.Coupon entity) throws ServicesExceptions {
        return dbCoupon.save(entity);
    }

    @Override
    public Optional<bpos.model.Center> updateCenter(bpos.model.Center entity) throws ServicesExceptions {
        return dbCenter.update(entity);
    }

    @Override
    public Optional<bpos.model.Center> deleteCenter(bpos.model.Center entity) throws ServicesExceptions {
        return dbCenter.delete(entity);
    }

    @Override
    public Optional<bpos.model.Center> saveCenter(bpos.model.Center entity) throws ServicesExceptions {
        return dbCenter.save(entity);
    }

    @Override
    public Optional<bpos.model.BloodTest> updateBloodTest(bpos.model.BloodTest entity) throws ServicesExceptions {
        return dbBloodTest.update(entity);
    }

    @Override
    public Optional<bpos.model.BloodTest> deleteBloodTest(bpos.model.BloodTest entity) throws ServicesExceptions {
        return dbBloodTest.delete(entity);
    }

    @Override
    public Optional<bpos.model.BloodTest> saveBloodTest(bpos.model.BloodTest entity) throws ServicesExceptions {
        return dbBloodTest.save(entity);
    }

    @Override
    public Optional<bpos.model.Address> updateAddress(bpos.model.Address entity) throws ServicesExceptions {
        return dbAddress.update(entity );
    }

    @Override
    public Optional<bpos.model.Address> deleteAddress(bpos.model.Address entity) throws ServicesExceptions {
        return dbAddress.delete(entity);
    }

    @Override
    public Optional<bpos.model.Address> saveAddress(bpos.model.Address entity) throws ServicesExceptions {
        return dbAddress.save(entity);
    }
}
