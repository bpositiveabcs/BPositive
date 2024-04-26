package bpos.networking.rpc;

import bpos.model.*;
import bpos.networking.dto.*;
import bpos.networking.utils.ServerException;
import bpos.services.IObserver;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class ClientRpcWorker implements Runnable, IObserver{

    private IServiceImpl server;
    private Socket connection;

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile boolean connected;
    public ClientRpcWorker(IServiceImpl server, Socket connection) {
        this.server = server;
        this.connection = connection;
        try{
            output=new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
            connected=true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void loginPersonEvent(bpos.model.Person password) throws ServicesExceptions {

    }

    @Override
    public void logoutPersonEvent(bpos.model.Person password) throws ServicesExceptions {

    }

    @Override
    public void loginCenterEvent(bpos.model.Center password) throws ServicesExceptions {

    }

    @Override
    public void logoutCenterEvent(bpos.model.Center password) throws ServicesExceptions {

    }

    @Override
    public void eventHappened(bpos.model.Event event) throws ServicesExceptions {

    }

    @Override
    public void donationRegistered(bpos.model.Donation donation) throws ServicesExceptions {

    }

    @Override
    public void run() {
        while(connected){
            try {
                Object request=input.readObject();
                Response response=handleRequest((Request)request);
                // System.out.println("Request received "+request);
                if (response!=null){
                    sendResponse(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (ServicesExceptions e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        try {
            input.close();
            output.close();
            connection.close();
        } catch (IOException e) {
            System.out.println("Error "+e);
        }
    }
    private static Response okResponse=new Response.Builder().type(ResponseType.OK).build();
    private void sendResponse(Response response) throws IOException{
        // System.out.println("sending response "+response);
        synchronized (output) {
            output.writeObject(response);
            output.flush();
        }
    }
    private Response handleRequest(Request request) throws ServicesExceptions {
        Response response=null;
        if (request.type()== RequestType.LOGIN_PERSON){
            System.out.println("Login request ..."+request.type());
            LogInfoDTO user=(LogInfoDTO)request.data();
            LogInfo person= DTOUtils.getFromDTOLogInfo(user);
            try {
                Optional<Person> pers=server.login(person, this);
                return new Response.Builder().type(ResponseType.LOGIN_PERSON).data(DTOUtils.getDTOPerson(pers)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.LOGIN_CENTER){
            System.out.println("Login request ..."+request.type());
            LogInfoDTO user=(LogInfoDTO)request.data();
            LogInfo person= DTOUtils.getFromDTOLogInfo(user);
            try {
                Optional<Center> pers=server.loginCenter(person, this);
                return new Response.Builder().type(ResponseType.LOGIN_PERSON).data(DTOUtils.getDTOCenter(pers)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.LOGOUT_PERSON){
            System.out.println("Logout request ..."+request.type());
            PersonDTO user=(PersonDTO) request.data();
            Person person= DTOUtils.getFromDTOPerson(user);
            try {
                server.logoutPerson(person, this);
                return new Response.Builder().type(ResponseType.LOGOUT_PERSON).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.LOGOUT_CENTER){
            System.out.println("Logout request ..."+request.type());
            CenterDTO user=(CenterDTO) request.data();
            Center person= DTOUtils.getFromDTOCenter(user);
            try {
                server.logoutCenter(person, this);
                return new Response.Builder().type(ResponseType.LOGOUT_CENTER).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_ADDRESS){
            System.out.println("Get all persons request ..."+request.type());
            String integer=(String) request.data();
            try {
                 Optional<Address>persons=server.findOneAddress(Integer.parseInt(integer));

                return new Response.Builder().type(ResponseType.FIND_ONE_ADDRESS).data(DTOUtils.getDTOAddress(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_ADDRESS){
            System.out.println("Get all persons request ..."+request.type());
            try {
                Iterable<Address>persons=server.findAllAddresses();

                return new Response.Builder().type(ResponseType.FIND_ALL_ADDRESS).data(DTOUtils.getDTOAddressList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveAddress){
            System.out.println("Get all persons request ..."+request.type());
            try {
                AddressDTO addressDTO=(AddressDTO) request.data();
                Address address=DTOUtils.getFromDTOAddress(addressDTO);
                Optional<Address>persons=server.saveAddress(address);
                return new Response.Builder().type(ResponseType.saveAddress).data(DTOUtils.getDTOAddress(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteAddress) {
            System.out.println("Get all persons request ..." + request.type());
            try {
                AddressDTO addressDTO = (AddressDTO) request.data();
                Address address = DTOUtils.getFromDTOAddress(addressDTO);
                Optional<Address> persons = server.deleteAddress(address);
                return new Response.Builder().type(ResponseType.deleteAddress).data(DTOUtils.getDTOAddress(persons)).build();
            } catch (ServicesExceptions e) {
                connected = false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
            if (request.type()== RequestType.updateAddress){
                System.out.println("Get all persons request ..."+request.type());
                try {
                    AddressDTO addressDTO=(AddressDTO) request.data();
                    Address address=DTOUtils.getFromDTOAddress(addressDTO);
                    Optional<Address>persons=server.updateAddress(address);
                    return new Response.Builder().type(ResponseType.updateAddress).data(DTOUtils.getDTOAddress(persons)).build();
                } catch (ServicesExceptions e) {
                    connected=false;
                    return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
                }
            }
        if (request.type()== RequestType.FIND_ONE_BLOOD_TEST){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String integer=(String) request.data();
                Optional<BloodTest>persons=server.findOneBloodTest(Integer.valueOf(integer));
                return new Response.Builder().type(ResponseType.FIND_ONE_BLOOD_TEST).data(DTOUtils.getDTOBloodTest(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_BLOOD_TEST){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<BloodTest>persons=server.findAllBloodTest();
                return new Response.Builder().type(ResponseType.FIND_ALL_BLOOD_TEST).data(DTOUtils.getDTOBloodTestList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveBloodTest){
            System.out.println("Get all persons request ..."+request.type());
            try {
                BloodTestDTO addressDTO=(BloodTestDTO) request.data();
                BloodTest address=DTOUtils.getFromDTOBloodTest(addressDTO);
                Optional<BloodTest>persons=server.saveBloodTest(address);
                return new Response.Builder().type(ResponseType.saveBloodTest).data(DTOUtils.getDTOBloodTest(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteBloodTest) {
            System.out.println("Get all persons request ..." + request.type());
            try {
                BloodTestDTO addressDTO = (BloodTestDTO) request.data();
                BloodTest address = DTOUtils.getFromDTOBloodTest(addressDTO);
                Optional<BloodTest> persons = server.deleteBloodTest(address);
                return new Response.Builder().type(ResponseType.deleteBloodTest).data(DTOUtils.getDTOBloodTest(persons)).build();
            } catch (ServicesExceptions e) {
                connected = false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateBloodTest){
            System.out.println("Get all persons request ..."+request.type());
            try {
                BloodTestDTO addressDTO=(BloodTestDTO) request.data();
                BloodTest address=DTOUtils.getFromDTOBloodTest(addressDTO);
                Optional<BloodTest>persons=server.updateBloodTest(address);
                return new Response.Builder().type(ResponseType.updateBloodTest).data(DTOUtils.getDTOBloodTest(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_USERNAME_CENTER){
            System.out.println("Get all persons request ..."+request.type());
            try {
                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Center persons=server.findByUsernameCenter(Objects.requireNonNull(address).getLogInfo().getUsername());
                return new Response.Builder().type(ResponseType.FIND_BY_USERNAME_CENTER).data(DTOUtils.getDTOCenter(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_EMAIL_CENTER){
            System.out.println("Get all persons request ..."+request.type());
            try {
                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Center persons=server.findByEmailCenter(Objects.requireNonNull(address).getLogInfo().getEmail());
                return new Response.Builder().type(ResponseType.FIND_BY_EMAIL_CENTER).data(DTOUtils.getDTOCenter(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_NAME_CENTER){
            System.out.println("Get all persons request ..."+request.type());
            try {
                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Iterable<Center> persons=server.findByNameCenter(Objects.requireNonNull(address).getCenterName());
                return new Response.Builder().type(ResponseType.FIND_BY_NAME_CENTER).data(DTOUtils.getDTOCenterList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_CENTER){
            System.out.println("Get all persons request ..."+request.type());
            try {
                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Optional<Center> persons=server.findOneCenter(Objects.requireNonNull(address).getId());
                return new Response.Builder().type(ResponseType.FIND_ONE_CENTER).data(DTOUtils.getDTOCenter(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_CENTERS){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<Center> persons=server.findAllCenters();
                return new Response.Builder().type(ResponseType.FIND_ALL_CENTERS).data(DTOUtils.getDTOCenterList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveCenter){
            System.out.println("Get all persons request ..."+request.type());
            try {

                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Optional<Center> persons=server.saveCenter(address);
                return new Response.Builder().type(ResponseType.saveCenter).data(DTOUtils.getDTOCenter(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteCenter){
            System.out.println("Get all persons request ..."+request.type());
            try {

                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Optional<Center> persons=server.deleteCenter(address);
                return new Response.Builder().type(ResponseType.deleteCenter).data(DTOUtils.getDTOCenter(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateCenter){
            System.out.println("Get all persons request ..."+request.type());
            try {

                CenterDTO addressDTO=(CenterDTO) request.data();
                Center address=DTOUtils.getFromDTOCenter(addressDTO);
                Optional<Center> persons=server.updateCenter(address);
                return new Response.Builder().type(ResponseType.updateCenter).data(DTOUtils.getDTOCenter(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_CODE_COUPON){
            System.out.println("Get all persons request ..."+request.type());
            try {

                String addressDTO=(String) request.data();

                Iterable<Coupon> persons=server.findByCodeCoupon(addressDTO);
                return new Response.Builder().type(ResponseType.FIND_BY_CODE_COUPON).data(DTOUtils.getDTOCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_PROVIDER_COUPON){
            System.out.println("Get all persons request ..."+request.type());
            try {

                String addressDTO=(String) request.data();
                Iterable<Coupon> persons=server.findByProviderCoupon(addressDTO);
                return new Response.Builder().type(ResponseType.FIND_BY_PROVIDER_COUPON).data(DTOUtils.getDTOCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_NAME_COUPON){
            System.out.println("Get all persons request ..."+request.type());
            try {

                String addressDTO=(String) request.data();
                Iterable<Coupon> persons=server.findByNameCoupon(addressDTO);
                return new Response.Builder().type(ResponseType.FIND_BY_NAME_COUPON).data(DTOUtils.getDTOCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_END_DATE_COUPON){
            System.out.println("Get all persons request ..."+request.type());
            try {

                String addressDTO=(String) request.data();
                Iterable<Coupon> persons=server.findByEndDateCoupon(LocalDate.parse(addressDTO));
                return new Response.Builder().type(ResponseType.FIND_BY_END_DATE_COUPON).data(DTOUtils.getDTOCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_COUPON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String addressDTO=(String) request.data();
                Optional<Coupon> persons=server.findOneCoupon(Integer.valueOf(addressDTO));
                return new Response.Builder().type(ResponseType.FIND_ONE_COUPON).data(DTOUtils.getDTOCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_COUPONS){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<Coupon> persons=server.findAllCoupons();
                return new Response.Builder().type(ResponseType.FIND_ALL_COUPONS).data(DTOUtils.getDTOCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveCoupon){
            System.out.println("Get all persons request ..."+request.type());
            try {

                CouponDTO addressDTO=(CouponDTO) request.data();
                Coupon address=DTOUtils.getFromDTOCoupon(addressDTO);
                Optional<Coupon> persons=server.saveCoupon(address);
                return new Response.Builder().type(ResponseType.saveCoupon).data(DTOUtils.getDTOCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteCoupon){
            System.out.println("Get all persons request ..."+request.type());
            try {

                CouponDTO addressDTO=(CouponDTO) request.data();
                Coupon address=DTOUtils.getFromDTOCoupon(addressDTO);
                Optional<Coupon> persons=server.deleteCoupon(address);
                return new Response.Builder().type(ResponseType.deleteCoupon).data(DTOUtils.getDTOCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateCoupon){
            System.out.println("Get all persons request ..."+request.type());
            try {

                CouponDTO addressDTO=(CouponDTO) request.data();
                Coupon address=DTOUtils.getFromDTOCoupon(addressDTO);
                Optional<Coupon> persons=server.updateCoupon(address);
                return new Response.Builder().type(ResponseType.updateCoupon).data(DTOUtils.getDTOCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_TYPE_DONATION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String tipDonation=(String) request.data();
                Iterable<Donation> persons=server.findByTipDonation(tipDonation);
                return new Response.Builder().type(ResponseType.FIND_BY_TYPE_DONATION).data(DTOUtils.getDTODonationList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_ID_TYPE_DONATION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String dateDonation=(String) request.data();
                Iterable<Donation> persons=server.findByIdTipDonation(Integer.valueOf(dateDonation));
                return new Response.Builder().type(ResponseType.FIND_BY_ID_TYPE_DONATION).data(DTOUtils.getDTODonationList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_DONATION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String dateDonation=(String) request.data();
                Optional<Donation> persons=server.findOneDonation(Integer.valueOf(dateDonation));
                return new Response.Builder().type(ResponseType.FIND_ONE_DONATION).data(DTOUtils.getDTODonation(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_DONATIONS){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<Donation> persons=server.findAllDonations();
                return new Response.Builder().type(ResponseType.FIND_ALL_DONATIONS).data(DTOUtils.getDTODonationList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveDonation){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationDTO dateDonation=(DonationDTO) request.data();
                Donation donation=DTOUtils.getFromDTODonation(dateDonation);
                Optional<Donation> persons=server.saveDonation(donation);
                return new Response.Builder().type(ResponseType.FIND_ONE_DONATION).data(DTOUtils.getDTODonation(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteDonation){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationDTO dateDonation=(DonationDTO) request.data();
                Donation donation=DTOUtils.getFromDTODonation(dateDonation);
                Optional<Donation> persons=server.deleteDonation(donation);
                return new Response.Builder().type(ResponseType.deleteDonation).data(DTOUtils.getDTODonation(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateDonation){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationDTO dateDonation=(DonationDTO) request.data();
                Donation donation=DTOUtils.getFromDTODonation(dateDonation);
                Optional<Donation> persons=server.updateDonation(donation);
                return new Response.Builder().type(ResponseType.updateDonation).data(DTOUtils.getDTODonation(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_DONATION_TYPE){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String dateDonation=(String) request.data();
                Optional<DonationType> persons=server.findOneDonationType(Integer.valueOf(dateDonation));
                return new Response.Builder().type(ResponseType.FIND_ONE_DONATION_TYPE).data(DTOUtils.getDTODonationType(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveDonationType){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationTypeDTO dateDonation=(DonationTypeDTO) request.data();
                DonationType donationType=DTOUtils.getFROMDTODonationType(dateDonation);
                Optional<DonationType> persons=server.saveDonationType(donationType);
                return new Response.Builder().type(ResponseType.saveDonationType).data(DTOUtils.getDTODonationType(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteDonationType){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationTypeDTO dateDonation=(DonationTypeDTO) request.data();
                DonationType donationType=DTOUtils.getFROMDTODonationType(dateDonation);
                Optional<DonationType> persons=server.deleteDonationType(donationType);
                return new Response.Builder().type(ResponseType.deleteDonationType).data(DTOUtils.getDTODonationType(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateDonationType){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationTypeDTO dateDonation=(DonationTypeDTO) request.data();
                DonationType donationType=DTOUtils.getFROMDTODonationType(dateDonation);
                Optional<DonationType> persons=server.updateDonationType(donationType);
                return new Response.Builder().type(ResponseType.updateDonationType).data(DTOUtils.getDTODonationType(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_DONATION_TYPES){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<DonationType> persons=server.findAllDonationType();
                return new Response.Builder().type(ResponseType.FIND_ALL_DONATION_TYPES).data(DTOUtils.getDTODonationTypeList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_NAME_EVENT){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String name=(String)request.data();
                Iterable<Event> persons=server.findByNameEvent(name);
                return new Response.Builder().type(ResponseType.FIND_BY_NAME_EVENT).data(DTOUtils.getDTOEventList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_ANNOUNCEMENT_DATE_EVENT){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Iterable<Event> persons=server.findByAnnouncementDateEvent(LocalDate.parse(date));
                return new Response.Builder().type(ResponseType.FIND_BY_ANNOUNCEMENT_DATE_EVENT).data(DTOUtils.getDTOEventList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_CENTER_ID_EVENT){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Iterable<Event> persons=server.findByCenterIdEvent(Integer.valueOf(date));
                return new Response.Builder().type(ResponseType.FIND_BY_CENTER_ID_EVENT).data(DTOUtils.getDTOEventList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_DATA_BEGIN_EVENT){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Iterable<Event> persons=server.findByDataInceputEvent(LocalDate.parse(date));
                return new Response.Builder().type(ResponseType.FIND_BY_DATA_BEGIN_EVENT).data(DTOUtils.getDTOEventList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_EVENT){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Optional<Event> persons=server.findOneEvent(Integer.valueOf(date));
                return new Response.Builder().type(ResponseType.FIND_ONE_EVENT).data(DTOUtils.getDTOEvent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_EVENTS){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<Event> persons=server.findAllEvents();
                return new Response.Builder().type(ResponseType.FIND_ALL_EVENTS).data(DTOUtils.getDTOEventList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveEvent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                EventDTO date=(EventDTO) request.data();
                Event event=DTOUtils.getFromDTOEvent(date);
                Optional<Event> persons=server.saveEvent(event);
                return new Response.Builder().type(ResponseType.saveEvent).data(DTOUtils.getDTOEvent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteEvent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                EventDTO date=(EventDTO) request.data();
                Event event=DTOUtils.getFromDTOEvent(date);
                Optional<Event> persons=server.deleteEvent(event);
                return new Response.Builder().type(ResponseType.deleteEvent).data(DTOUtils.getDTOEvent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateEvent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                EventDTO date=(EventDTO) request.data();
                Event event=DTOUtils.getFromDTOEvent(date);
                Optional<Event> persons=server.updateEvent(event);
                return new Response.Builder().type(ResponseType.updateEvent).data(DTOUtils.getDTOEvent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_NAME_INSTITUTION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Iterable<Institution> persons=server.findByNameInstitution(date);
                return new Response.Builder().type(ResponseType.FIND_BY_NAME_INSTITUTION).data(DTOUtils.getDTOInstitutionList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_ADDRESS_INSTITUTION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Iterable<Institution> persons=server.findByAddressInstitution(date);
                return new Response.Builder().type(ResponseType.FIND_BY_ADDRESS_INSTITUTION).data(DTOUtils.getDTOInstitutionList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_EMAIL_INSTITUTION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Iterable<Institution> persons=server.findByEmailInstitution(date);
                return new Response.Builder().type(ResponseType.FIND_BY_EMAIL_INSTITUTION).data(DTOUtils.getDTOInstitutionList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_INSTITUTION){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String date=(String)request.data();
                Optional<Institution> persons=server.findOneInstitution(Integer.valueOf(date));
                return new Response.Builder().type(ResponseType.FIND_ONE_INSTITUTION).data(DTOUtils.getDTOInstitution(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_INSTITUTION){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<Institution> persons=server.findAllInstitutions();
                return new Response.Builder().type(ResponseType.FIND_ALL_INSTITUTION).data(DTOUtils.getDTOInstitutionList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveInstitution){
            System.out.println("Get all persons request ..."+request.type());
            try {
                InstitutionDTO institutionDTO=(InstitutionDTO)request.data();
                Institution institution=DTOUtils.getFromDTOInstitution(institutionDTO);
                Optional<Institution> persons=server.saveInstitution(institution);
                return new Response.Builder().type(ResponseType.saveInstitution).data(DTOUtils.getDTOInstitution(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteInstitution){
            System.out.println("Get all persons request ..."+request.type());
            try {
                InstitutionDTO institutionDTO=(InstitutionDTO)request.data();
                Institution institution=DTOUtils.getFromDTOInstitution(institutionDTO);
                Optional<Institution> persons=server.deleteInstitution(institution);
                return new Response.Builder().type(ResponseType.deleteInstitution).data(DTOUtils.getDTOInstitution(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateInstitution){
            System.out.println("Get all persons request ..."+request.type());
            try {
                InstitutionDTO institutionDTO=(InstitutionDTO)request.data();
                Institution institution=DTOUtils.getFromDTOInstitution(institutionDTO);
                Optional<Institution> persons=server.updateInstitution(institution);
                return new Response.Builder().type(ResponseType.updateInstitution).data(DTOUtils.getDTOInstitution(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_LOG_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Optional<LogInfo> persons=server.findOneLogInfo(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_ONE_LOG_INFO).data(DTOUtils.getDTOLogInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_EMAIL_LOG_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                LogInfo persons=server.findByEmailLogInfo(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_EMAIL_LOG_INFO).data(DTOUtils.getDTOLogInfo(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_USERNAME_LOG_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                LogInfo persons=server.findByUsernameLogInfo(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_USERNAME_LOG_INFO).data(DTOUtils.getDTOLogInfo(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_LOG_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                Iterable<LogInfo> persons=server.findAllLogInfos();
                return new Response.Builder().type(ResponseType.FIND_ALL_LOG_INFO).data(DTOUtils.getDTOLogInfoList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveLogInfo){
            System.out.println("Get all persons request ..."+request.type());
            try {
                LogInfoDTO institution=(LogInfoDTO) request.data();
                LogInfo logInfo=DTOUtils.getFromDTOLogInfo(institution);
                Optional<LogInfo> persons=server.saveLogInfo(logInfo);
                return new Response.Builder().type(ResponseType.saveLogInfo).data(DTOUtils.getDTOLogInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteLogInfo){
            System.out.println("Get all persons request ..."+request.type());
            try {
                LogInfoDTO institution=(LogInfoDTO) request.data();
                LogInfo logInfo=DTOUtils.getFromDTOLogInfo(institution);
                Optional<LogInfo> persons=server.deleteLogInfo(logInfo);
                return new Response.Builder().type(ResponseType.deleteLogInfo).data(DTOUtils.getDTOLogInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateLogInfo){
            System.out.println("Get all persons request ..."+request.type());
            try {
                LogInfoDTO institution=(LogInfoDTO) request.data();
                LogInfo logInfo=DTOUtils.getFromDTOLogInfo(institution);
                Optional<LogInfo> persons=server.updateLogInfo(logInfo);
                return new Response.Builder().type(ResponseType.updateLogInfo).data(DTOUtils.getDTOLogInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_MEDICAL_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Optional<MedicalInfo> persons=server.findOneMedicalInfo(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_ONE_MEDICAL_INFO).data(DTOUtils.getDTOMedicalInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }

        if (request.type()== RequestType.FIND_ALL_MEDICAL_INFOS){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<MedicalInfo> persons=server.findAllMedicalInfos();
                return new Response.Builder().type(ResponseType.FIND_ALL_MEDICAL_INFOS).data(DTOUtils.getDTOMedicalInfoList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_BLOOD_TYPE_MEDICAL_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<MedicalInfo> persons=server.findByBloodTypeMedicalInfo(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_BLOOD_TYPE_MEDICAL_INFO).data(DTOUtils.getDTOMedicalInfoList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_RH_MEDICAL_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<MedicalInfo> persons=server.findByRhMedicalInfo(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_RH_MEDICAL_INFO).data(DTOUtils.getDTOMedicalInfoList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_BLOOD_TYPE_AND_RH_MEDICAL_INFO){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                String institution2=(String) request.data2();
                Iterable<MedicalInfo> persons=server.findByBloodTypeAndRhMedicalInfo(institution,institution2);
                return new Response.Builder().type(ResponseType.FIND_BY_BLOOD_TYPE_AND_RH_MEDICAL_INFO).data(DTOUtils.getDTOMedicalInfoList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveMedicalInfo){
            System.out.println("Get all persons request ..."+request.type());
            try {
                MedicalInfoDTO medicalInfoDTO=(MedicalInfoDTO)request.data();
                MedicalInfo medicalInfo=DTOUtils.getFromDTOMedicalInfo(medicalInfoDTO);
                Optional<MedicalInfo> persons=server.saveMedicalInfo(medicalInfo);
                return new Response.Builder().type(ResponseType.saveMedicalInfo).data(DTOUtils.getDTOMedicalInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteMedicalInfo){
            System.out.println("Get all persons request ..."+request.type());
            try {
                MedicalInfoDTO medicalInfoDTO=(MedicalInfoDTO)request.data();
                MedicalInfo medicalInfo=DTOUtils.getFromDTOMedicalInfo(medicalInfoDTO);
                Optional<MedicalInfo> persons=server.deleteMedicalInfo(medicalInfo);
                return new Response.Builder().type(ResponseType.deleteMedicalInfo).data(DTOUtils.getDTOMedicalInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateMedicalInfo){
            System.out.println("Get all persons request ..."+request.type());
            try {
                MedicalInfoDTO medicalInfoDTO=(MedicalInfoDTO)request.data();
                MedicalInfo medicalInfo=DTOUtils.getFromDTOMedicalInfo(medicalInfoDTO);
                Optional<MedicalInfo> persons=server.updateMedicalInfo(medicalInfo);
                return new Response.Builder().type(ResponseType.updateMedicalInfo).data(DTOUtils.getDTOMedicalInfo(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_PERSONAL_DATA){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Optional<PersonalData> persons=server.findOnePersonalData(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_ONE_PERSONAL_DATA).data(DTOUtils.getDTOPersonalData(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_CNP_PERSONAL_DATA){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                PersonalData persons=server.findByCnpPersonalData(institution);
                return new Response.Builder().type(ResponseType.FIND_ONE_PERSONAL_DATA).data(DTOUtils.getDTOPersonalData(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_PERSONAL_DATA){
            System.out.println("Get all persons request ..."+request.type());
            try {

                Iterable<PersonalData> persons=server.findAllPersonalDatas();
                return new Response.Builder().type(ResponseType.FIND_ALL_PERSONAL_DATA).data(DTOUtils.getDTOPersonalDataList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_FIRST_NAME_PERSONAL_DATA){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<PersonalData> persons=server.findByFirstNamePersonalData(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_FIRST_NAME_PERSONAL_DATA).data(DTOUtils.getDTOPersonalDataList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_LAST_NAME_PERSONAL_DATA){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<PersonalData> persons=server.findByLastNamePersonalData(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_LAST_NAME_PERSONAL_DATA).data(DTOUtils.getDTOPersonalDataList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.savePersonalData){
            System.out.println("Get all persons request ..."+request.type());
            try {
                PersonalDataDTO institution=(PersonalDataDTO) request.data();
                PersonalData inst=DTOUtils.getFromDTOPersonalData(institution);
                Optional<PersonalData> persons=server.savePersonalData(inst);
                return new Response.Builder().type(ResponseType.savePersonalData).data(DTOUtils.getDTOPersonalData(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deletePersonalData){
            System.out.println("Get all persons request ..."+request.type());
            try {
                PersonalDataDTO institution=(PersonalDataDTO) request.data();
                PersonalData inst=DTOUtils.getFromDTOPersonalData(institution);
                Optional<PersonalData> persons=server.deletePersonalData(inst);
                return new Response.Builder().type(ResponseType.deletePersonalData).data(DTOUtils.getDTOPersonalData(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updatePersonalData){
            System.out.println("Get all persons request ..."+request.type());
            try {
                PersonalDataDTO institution=(PersonalDataDTO) request.data();
                PersonalData inst=DTOUtils.getFromDTOPersonalData(institution);
                Optional<PersonalData> persons=server.updatePersonalData(inst);
                return new Response.Builder().type(ResponseType.updatePersonalData).data(DTOUtils.getDTOPersonalData(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }

        if (request.type()== RequestType.FIND_ONE_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                //Person personDTO=DTOUtils.getFromDTOPerson(institution);
                Optional<Person> persons=server.findOnePerson(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_ONE_PERSON).data(DTOUtils.getDTOPerson(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                Iterable<Person> persons=server.findAllPersons();
                return new Response.Builder().type(ResponseType.FIND_ALL_PERSON).data(DTOUtils.getDTOPersonList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_FIRST_NAME_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String st=(String)request.data();
                Iterable<Person> persons=server.findByFirstNamePerson(st);
                return new Response.Builder().type(ResponseType.FIND_BY_FIRST_NAME_PERSON).data(DTOUtils.getDTOPersonList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_LAST_NAME_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String st=(String)request.data();
                Iterable<Person> persons=server.findByLastNamePerson(st);
                return new Response.Builder().type(ResponseType.FIND_BY_LAST_NAME_PERSON).data(DTOUtils.getDTOPersonList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_CNP_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String st=(String)request.data();
                Iterable<Person> persons=server.findByCnpPerson(st);
                return new Response.Builder().type(ResponseType.FIND_BY_CNP_PERSON).data(DTOUtils.getDTOPersonList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_PHONE_NUMBER_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String st=(String)request.data();
                Iterable<Person> persons=server.findByPhoneNumberPerson(st);
                return new Response.Builder().type(ResponseType.FIND_BY_PHONE_NUMBER_PERSON).data(DTOUtils.getDTOPersonList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_EMAIL_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                //Person personDTO=DTOUtils.getFromDTOPerson(institution);
               Person persons=server.findByEmailPerson(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_EMAIL_PERSON).data(DTOUtils.getDTOPerson(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_USERNAME_PERSON){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                //Person personDTO=DTOUtils.getFromDTOPerson(institution);
                Person persons=server.findByUsernamePerson(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_USERNAME_PERSON).data(DTOUtils.getDTOPerson(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.savePerson){
            System.out.println("Get all persons request ..."+request.type());
            try {
                PersonDTO institution=(PersonDTO) request.data();
                Person pers=DTOUtils.getFromDTOPerson(institution);
                //Person personDTO=DTOUtils.getFromDTOPerson(institution);
                Optional<Person> persons=server.savePerson(pers);
                return new Response.Builder().type(ResponseType.savePerson).data(DTOUtils.getDTOPerson(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deletePerson){
            System.out.println("Get all persons request ..."+request.type());
            try {
                PersonDTO institution=(PersonDTO) request.data();
                Person pers=DTOUtils.getFromDTOPerson(institution);
                //Person personDTO=DTOUtils.getFromDTOPerson(institution);
                Optional<Person> persons=server.deletePerson(pers);
                return new Response.Builder().type(ResponseType.deletePerson).data(DTOUtils.getDTOPerson(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updatePerson){
            System.out.println("Get all persons request ..."+request.type());
            try {
                PersonDTO institution=(PersonDTO) request.data();
                Person pers=DTOUtils.getFromDTOPerson(institution);
                //Person personDTO=DTOUtils.getFromDTOPerson(institution);
                Optional<Person> persons=server.updatePerson(pers);
                return new Response.Builder().type(ResponseType.updatePerson).data(DTOUtils.getDTOPerson(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ONE_RETRIEVED){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();

                Optional<RetrievedCoupons> persons=server.findOneRetrieved(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_ONE_RETRIEVED).data(DTOUtils.getDTORetrivedCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_COUPON_ID_RETRIEVED){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<RetrievedCoupons> persons=server.findByCouponIdRetrieved(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_BY_COUPON_ID_RETRIEVED).data(DTOUtils.getDTORetrivedCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_PERSON_ID_RETRIEVED){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<RetrievedCoupons> persons=server.findByPersonIdRetrieved(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.FIND_BY_PERSON_ID_RETRIEVED).data(DTOUtils.getDTORetrivedCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_BY_DATE_RETRIEVED){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<RetrievedCoupons> persons=server.findByDateRetrieved(institution);
                return new Response.Builder().type(ResponseType.FIND_BY_DATE_RETRIEVED).data(DTOUtils.getDTORetrivedCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.FIND_ALL_RETRIEVED){
            System.out.println("Get all persons request ..."+request.type());
            try {
                Iterable<RetrievedCoupons> persons=server.findAllRetrieved();
                return new Response.Builder().type(ResponseType.FIND_ALL_RETRIEVED).data(DTOUtils.getDTORetrivedCouponList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveRetrieved){
            System.out.println("Get all persons request ..."+request.type());
            try {
                RetrivedCouponsDTO institution=(RetrivedCouponsDTO) request.data();
                RetrievedCoupons pers=DTOUtils.getFromDTORetrivedCoupon(institution);
                Optional<RetrievedCoupons> persons=server.saveRetrieved(pers);
                return new Response.Builder().type(ResponseType.saveRetrieved).data(DTOUtils.getDTORetrivedCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteRetrieved){
            System.out.println("Get all persons request ..."+request.type());
            try {
                RetrivedCouponsDTO institution=(RetrivedCouponsDTO) request.data();
                RetrievedCoupons pers=DTOUtils.getFromDTORetrivedCoupon(institution);
                Optional<RetrievedCoupons> persons=server.deleteRetrieved(pers);
                return new Response.Builder().type(ResponseType.deleteRetrieved).data(DTOUtils.getDTORetrivedCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateRetrieved){
            System.out.println("Get all persons request ..."+request.type());
            try {
                RetrivedCouponsDTO institution=(RetrivedCouponsDTO) request.data();
                RetrievedCoupons pers=DTOUtils.getFromDTORetrivedCoupon(institution);
                Optional<RetrievedCoupons> persons=server.updateRetrieved(pers);
                return new Response.Builder().type(ResponseType.updateRetrieved).data(DTOUtils.getDTORetrivedCoupon(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findOneStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();

                Optional<Student> persons=server.findOneStudent(Integer.valueOf(institution));
                return new Response.Builder().type(ResponseType.findOneStudent).data(DTOUtils.getDTOStudent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.saveStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                StudentDTO institution=(StudentDTO) request.data();
                Student pers=DTOUtils.getFromDTOStudent(institution);
                Optional<Student> persons=server.saveStudent(pers);
                return new Response.Builder().type(ResponseType.saveStudent).data(DTOUtils.getDTOStudent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.updateStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                StudentDTO institution=(StudentDTO) request.data();
                Student pers=DTOUtils.getFromDTOStudent(institution);
                Optional<Student> persons=server.updateStudent(pers);
                return new Response.Builder().type(ResponseType.updateStudent).data(DTOUtils.getDTOStudent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.deleteStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                StudentDTO institution=(StudentDTO) request.data();
                Student pers=DTOUtils.getFromDTOStudent(institution);
                Optional<Student> persons=server.deleteStudent(pers);
                return new Response.Builder().type(ResponseType.deleteStudent).data(DTOUtils.getDTOStudent(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findByEmailStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Student persons=server.findByEmailStudent(institution);
                return new Response.Builder().type(ResponseType.findByEmailStudent).data(DTOUtils.getDTOStudent(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findByUsernameStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Student persons=server.findByUsernameStudent(institution);
                return new Response.Builder().type(ResponseType.findByUsernameStudent).data(DTOUtils.getDTOStudent(Optional.ofNullable(persons))).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findAllStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                Iterable<Student> persons=server.findAllStudent();
                return new Response.Builder().type(ResponseType.findAllStudent).data(DTOUtils.getDTOStudentList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findByFirstNameStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<Student> persons=server.findByFirstNameStudent(institution);
                return new Response.Builder().type(ResponseType.findByFirstNameStudent).data(DTOUtils.getDTOStudentList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findByLastNameStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<Student> persons=server.findByLastNameStudent(institution);
                return new Response.Builder().type(ResponseType.findByLastNameStudent).data(DTOUtils.getDTOStudentList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findByCnpStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<Student> persons=server.findByCnpStudent(institution);
                return new Response.Builder().type(ResponseType.findByCnpStudent).data(DTOUtils.getDTOStudentList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.findByPhoneNumberStudent){
            System.out.println("Get all persons request ..."+request.type());
            try {
                String institution=(String) request.data();
                Iterable<Student> persons=server.findByPhoneNumberStudent(institution);
                return new Response.Builder().type(ResponseType.findByPhoneNumberStudent).data(DTOUtils.getDTOStudentList(persons)).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }
        if (request.type()== RequestType.donationRegister){
            System.out.println("Get all persons request ..."+request.type());
            try {
                DonationDTO institution=(DonationDTO) request.data();
                PersonDTO person2=(PersonDTO) request.data2();
                EventDTO event=(EventDTO) request.data3();
                Donation donation=DTOUtils.getFromDTODonation(institution);
                Person person=DTOUtils.getFromDTOPerson(person2);
                Event event1=DTOUtils.getFromDTOEvent(event);
                server.donationRegister(donation,person,event1);
                return new Response.Builder().type(ResponseType.NEW).build();
            } catch (ServicesExceptions e) {
                connected=false;
                return new Response.Builder().type(ResponseType.ERROR).data(e.getMessage()).build();
            }
        }


        return response;
    }

}
