package bpos.server;

import bpos.model.Validators.Enums.Interfaces.Validator;
import bpos.model.Validators.Implementation.*;
import bpos.networking.utils.AbstractServer;
import bpos.networking.utils.RpcConcurrentServer;
import bpos.networking.utils.ServerException;
import bpos.repository.Implementations.*;
import bpos.services.IServiceImpl;

import java.io.IOException;
import java.util.Properties;

public class StartRpcServer {
    private static int defaultPort = 55556;

    public static void main(String[] args) {
        // UserRepository userRepo=new UserRepositoryMock();
        Properties serverProps = new Properties();
        try {
            serverProps.load(StartRpcServer.class.getClassLoader().getResourceAsStream("server.properties"));
            System.out.println("Server properties set. ");
            serverProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find competitionserver.properties " + e);
            return;
        }
        PersonValidator personValidator = new PersonValidator();
        DBPersonRepository personRepository = new DBPersonRepository(serverProps, personValidator);
        PersonalDataValidator personalDataValidator = new PersonalDataValidator();
        DBPersonalDataRepository personalDataRepository = new DBPersonalDataRepository(serverProps, personalDataValidator);
        MedicalInfoValidator medicalInfoValidator = new MedicalInfoValidator();
        DBMedicalInfoRepository medicalInfoRepository = new DBMedicalInfoRepository(serverProps, medicalInfoValidator);
        LogInfoValidator logInfoValidator = new LogInfoValidator();
        DBLogInfoRepository logInfoRepository = new DBLogInfoRepository(serverProps,logInfoValidator);
        DonationValidator donationValidator = new DonationValidator();
        DBDonationRepository donationRepository = new DBDonationRepository(serverProps, donationValidator);

        AddressValidator addressValidator = new AddressValidator();
        DBAddressRepository addressRepository = new DBAddressRepository(serverProps, addressValidator);
        BloodTestValidator bloodTestValidator = new BloodTestValidator();
        DBBloodTestRepository bloodTestRepository = new DBBloodTestRepository(serverProps, bloodTestValidator);
        CenterValidator centerValidator = new CenterValidator();
        DBCenterRepository centerRepository = new DBCenterRepository(serverProps, centerValidator);
        EventValidator eventValidator = new EventValidator();
        DBEventRepository eventRepository = new DBEventRepository(serverProps, eventValidator);
        InstitutionValidator institutionValidator = new InstitutionValidator();
        DBInstitutionRepository institutionRepository = new DBInstitutionRepository(serverProps,institutionValidator);
        RetrievedCouponsValidator retrievedCouponsValidator = new RetrievedCouponsValidator();
        DBRetrievedCouponsRepository retrievedCouponsRepository = new DBRetrievedCouponsRepository(serverProps,retrievedCouponsValidator);
        StudentValidator studentValidator = new StudentValidator();
        DBStudentRepository studentRepository = new DBStudentRepository(serverProps,studentValidator);
        CouponValidator couponValidator = new CouponValidator();
        DBCouponRepository couponRepository = new DBCouponRepository(serverProps,couponValidator);
        DonationTypeValidator donationTypeValidator = new DonationTypeValidator();
        DBDonationTypeRepository donationTypeRepository = new DBDonationTypeRepository(serverProps,donationTypeValidator);
        IServiceImpl serviceImpl = new ServerImlp(institutionRepository,logInfoRepository,medicalInfoRepository,personRepository,personalDataRepository,retrievedCouponsRepository,addressRepository,bloodTestRepository,centerRepository,couponRepository,donationRepository,donationTypeRepository,eventRepository,studentRepository);
        int competitionServerPort = defaultPort;
        try{
            competitionServerPort = Integer.parseInt(serverProps.getProperty("server.port"));
        } catch (NumberFormatException nef) {
            System.err.println("Wrong  Port Number" + nef.getMessage());
            System.err.println("Using default port " + defaultPort);
        }
        System.out.println("Starting server on port: " + competitionServerPort);
        AbstractServer server = new RpcConcurrentServer(competitionServerPort, serviceImpl);
        try {
            server.start();
        } catch (ServerException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                server.stop();
            } catch (ServerException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
