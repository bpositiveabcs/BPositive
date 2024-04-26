package bpos.networking.rpc;

import bpos.model.*;
import bpos.services.IObserver;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ServicesRpcProxy implements IServiceImpl {
    private String host;
    private int port;

    private IObserver client;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private Socket connection;

    private BlockingQueue<Response> qresponses;
    private volatile boolean finished;
    public ServicesRpcProxy(String host, int port) {
        this.host = host;
        this.port = port;

        qresponses=new LinkedBlockingQueue<Response>();
    }
    @Override
    public Optional<Address> findOneAddress(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Address> findAllAddresses() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Address> saveAddress(Address entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Address> deleteAddress(Address entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Address> updateAddress(Address entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<BloodTest> findOneBloodTest(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<BloodTest> findAllBloodTest() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<BloodTest> saveBloodTest(BloodTest entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<BloodTest> deleteBloodTest(BloodTest entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<BloodTest> updateBloodTest(BloodTest entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Center findByUsernameCenter(String username) throws ServicesExceptions {
        return null;
    }

    @Override
    public Center findByEmailCenter(String email) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Center> findByNameCenter(String name) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Center> findOneCenter(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Center> findAllCenters() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Center> saveCenter(Center entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Center> deleteCenter(Center entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Center> updateCenter(Center entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Coupon> findByCodeCoupon(String code) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Coupon> findByProviderCoupon(String provider) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Coupon> findByNameCoupon(String name) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Coupon> findByEndDateCoupon(LocalDate endDate) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Coupon> findOneCoupon(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Coupon> findAllCoupons() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Coupon> saveCoupon(Coupon entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Coupon> deleteCoupon(Coupon entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Coupon> updateCoupon(Coupon entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Donation> findByTipDonation(String tipDonation) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Donation> findByIdTipDonation(Integer tipDonation) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Donation> findOneDonation(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Donation> findAllDonations() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Donation> saveDonation(Donation entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Donation> deleteDonation(Donation entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Donation> updateDonation(Donation entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<DonationType> findOneDonationType(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<DonationType> findAllDonationType() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<DonationType> saveDonationType(DonationType entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<DonationType> deleteDonationType(DonationType entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<DonationType> updateDonationType(DonationType entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Event> findByNameEvent(String nume) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Event> findByAnnouncementDateEvent(LocalDate data) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Event> findByCenterIdEvent(Integer centruId) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Event> findByDataInceputEvent(LocalDate data) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Event> findOneEvent(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Event> findAllEvents() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Event> saveEvent(Event entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Event> deleteEvent(Event entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Event> updateEvent(Event entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Institution> findOneInstitution(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Institution> findAllInstitutions() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Institution> saveInstitution(Institution entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Institution> deleteInstitution(Institution entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Institution> updateInstitution(Institution entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Institution> findByNameInstitution(String name) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Institution> findByAddressInstitution(String address) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Institution> findByEmailInstitution(String email) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<LogInfo> findOneLogInfo(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<LogInfo> findAllLogInfos() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<LogInfo> saveLogInfo(LogInfo entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<LogInfo> deleteLogInfo(LogInfo entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<LogInfo> updateLogInfo(LogInfo entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public LogInfo findByUsernameLogInfo(String username) throws ServicesExceptions {
        return null;
    }

    @Override
    public LogInfo findByEmailLogInfo(String email) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<MedicalInfo> findOneMedicalInfo(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<MedicalInfo> findAllMedicalInfos() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<MedicalInfo> saveMedicalInfo(MedicalInfo entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<MedicalInfo> deleteMedicalInfo(MedicalInfo entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<MedicalInfo> updateMedicalInfo(MedicalInfo entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<MedicalInfo> findByBloodTypeMedicalInfo(String bloodType) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<MedicalInfo> findByRhMedicalInfo(String rh) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<MedicalInfo> findByBloodTypeAndRhMedicalInfo(String bloodType, String rh) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<PersonalData> findOnePersonalData(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<PersonalData> findAllPersonalDatas() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<PersonalData> savePersonalData(PersonalData entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalData> deletePersonalData(PersonalData entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<PersonalData> updatePersonalData(PersonalData entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<PersonalData> findByFirstNamePersonalData(String firstName) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<PersonalData> findByLastNamePersonalData(String lastName) throws ServicesExceptions {
        return null;
    }

    @Override
    public PersonalData findByCnpPersonalData(String cnp) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Person> findOnePerson(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findAllPersons() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Person> savePerson(Person entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Person> deletePerson(Person entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Person> updatePerson(Person entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Person> findByFirstNamePerson(String firstName) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Person> findByLastNamePerson(String lastName) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Person> findByCnpPerson(String cnp) throws ServicesExceptions {
        return null;
    }

    @Override
    public Person findByEmailPerson(String email) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Person> findByPhoneNumberPerson(String phoneNumber) throws ServicesExceptions {
        return null;
    }

    @Override
    public Person findByUsernamePerson(String username) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<RetrievedCoupons> findOneRetrieved(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<RetrievedCoupons> findAllRetrieved() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<RetrievedCoupons> saveRetrieved(RetrievedCoupons entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<RetrievedCoupons> deleteRetrieved(RetrievedCoupons entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<RetrievedCoupons> updateRetrieved(RetrievedCoupons entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<RetrievedCoupons> findByCouponIdRetrieved(Integer couponId) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<RetrievedCoupons> findByPersonIdRetrieved(Integer personId) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<RetrievedCoupons> findByDateRetrieved(String date) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Student> findOneStudent(Integer integer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Student> findAllStudent() throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Student> saveStudent(Student entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Student> deleteStudent(Student entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Student> updateStudent(Student entity) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Iterable<Student> findByFirstNameStudent(String firstName) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Student> findByLastNameStudent(String lastName) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Student> findByCnpStudent(String cnp) throws ServicesExceptions {
        return null;
    }

    @Override
    public Student findByEmailStudent(String email) throws ServicesExceptions {
        return null;
    }

    @Override
    public Iterable<Student> findByPhoneNumberStudent(String phoneNumber) throws ServicesExceptions {
        return null;
    }

    @Override
    public Student findByUsernameStudent(String username) throws ServicesExceptions {
        return null;
    }

    @Override
    public Optional<Person> login(LogInfo logInfo, IObserver observer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public Optional<Center> loginCenter(LogInfo logInfo, IObserver observer) throws ServicesExceptions {
        return Optional.empty();
    }

    @Override
    public void logoutCenter(Center center, IObserver observer) throws ServicesExceptions {

    }

    @Override
    public void logoutPerson(Person center, IObserver observer) throws ServicesExceptions {

    }

    @Override
    public void donationRegister(Donation donation, Person person, Event event) throws ServicesExceptions {

    }
    // to do
}
