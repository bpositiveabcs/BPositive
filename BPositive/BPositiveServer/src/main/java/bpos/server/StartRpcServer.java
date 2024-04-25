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
            serverProps.load(StartRpcServer.class.getResourceAsStream("/competitionserver.properties"));
            System.out.println("Server properties set. ");
            serverProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find competitionserver.properties " + e);
            return;
        }
        DBPersonRepository personRepository = new DBPersonRepository();
        DBPersonalDataRepository personalDataRepository = new DBPersonalDataRepository();
        DBMedicalInfoRepository medicalInfoRepository = new DBMedicalInfoRepository();
        DBLogInfoRepository logInfoRepository = new DBLogInfoRepository();
        DBDonationRepository donationRepository = new DBDonationRepository();
        AddressValidator addressValidator = new AddressValidator();
        DBAddressRepository addressRepository = new DBAddressRepository(serverProps, addressValidator);
        BloodTestValidator bloodTestValidator = new BloodTestValidator();
        DBBloodTestRepository bloodTestRepository = new DBBloodTestRepository(serverProps, bloodTestValidator);
        CenterValidator centerValidator = new CenterValidator();
        DBCenterRepository centerRepository = new DBCenterRepository(serverProps, centerValidator);
        DBEventRepository eventRepository = new DBEventRepository();
        DBInstitutionRepository institutionRepository = new DBInstitutionRepository();
        DBRetrievedCouponsRepository retrievedCouponsRepository = new DBRetrievedCouponsRepository();
        DBStudentRepository studentRepository = new DBStudentRepository();
        CouponValidator couponValidator = new CouponValidator();
        DBCouponRepository couponRepository = new DBCouponRepository(serverProps,couponValidator);
        DonationTypeValidator donationTypeValidator = new DonationTypeValidator();
        DBDonationTypeRepository donationTypeRepository = new DBDonationTypeRepository(serverProps,donationTypeValidator);
        IServiceImpl serviceImpl = new ServerImlp(institutionRepository,logInfoRepository,medicalInfoRepository,personRepository,personalDataRepository,retrievedCouponsRepository,addressRepository,bloodTestRepository,centerRepository,couponRepository,donationRepository,donationTypeRepository,eventRepository,studentRepository);
        int competitionServerPort = defaultPort;
        try{
            competitionServerPort = Integer.parseInt(serverProps.getProperty("competition.server.port"));
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
