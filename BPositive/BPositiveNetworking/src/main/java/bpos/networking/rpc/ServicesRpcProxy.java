package bpos.networking.rpc;

import bpos.model.*;
import bpos.networking.dto.*;
import bpos.services.IObserver;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;

import java.io.IOException;
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
        Request req =new Request.Builder().type(RequestType.FIND_ONE_ADDRESS).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        AddressDTO addressDTO= (AddressDTO) response.data();
        Address address= DTOUtils.getFromDTOAddress(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Address> findAllAddresses() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_ADDRESS).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<AddressDTO> addressDTOS= (Iterable<AddressDTO>) response.data();
        Iterable<Address> addresses= DTOUtils.getFromDTOAddressList(addressDTOS);
        return addresses;
    }

    @Override
    public Optional<Address> saveAddress(Address entity) throws ServicesExceptions {
        AddressDTO addressDTO= DTOUtils.getDTOAddress(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveAddress).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        AddressDTO addressDTO1= (AddressDTO) response.data();
        Address address= DTOUtils.getFromDTOAddress(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Address> deleteAddress(Address entity) throws ServicesExceptions {
        AddressDTO addressDTO= DTOUtils.getDTOAddress(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteAddress).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        AddressDTO addressDTO1= (AddressDTO) response.data();
        Address address= DTOUtils.getFromDTOAddress(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Address> updateAddress(Address entity) throws ServicesExceptions {
        AddressDTO addressDTO= DTOUtils.getDTOAddress(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateAddress).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        AddressDTO addressDTO1= (AddressDTO) response.data();
        Address address= DTOUtils.getFromDTOAddress(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<BloodTest> findOneBloodTest(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_BLOOD_TEST).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        BloodTestDTO addressDTO= (BloodTestDTO) response.data();
        BloodTest address= DTOUtils.getFromDTOBloodTest(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<BloodTest> findAllBloodTest() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_BLOOD_TEST).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<BloodTestDTO> addressDTOS= (Iterable<BloodTestDTO>) response.data();
        return DTOUtils.getFromDTOBloodTestList(addressDTOS);
    }

    @Override
    public Optional<BloodTest> saveBloodTest(BloodTest entity) throws ServicesExceptions {
        BloodTestDTO addressDTO= DTOUtils.getDTOBloodTest(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveBloodTest).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        BloodTestDTO addressDTO1= (BloodTestDTO) response.data();
        BloodTest address= DTOUtils.getFromDTOBloodTest(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<BloodTest> deleteBloodTest(BloodTest entity) throws ServicesExceptions {
        BloodTestDTO addressDTO= DTOUtils.getDTOBloodTest(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteBloodTest).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        BloodTestDTO addressDTO1= (BloodTestDTO) response.data();
        BloodTest address= DTOUtils.getFromDTOBloodTest(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<BloodTest> updateBloodTest(BloodTest entity) throws ServicesExceptions {
        BloodTestDTO addressDTO= DTOUtils.getDTOBloodTest(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateBloodTest).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        BloodTestDTO addressDTO1= (BloodTestDTO) response.data();
        BloodTest address= DTOUtils.getFromDTOBloodTest(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Center findByUsernameCenter(String username) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_USERNAME_CENTER).data(username).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CenterDTO addressDTO= (CenterDTO) response.data();
        return DTOUtils.getFromDTOCenter(addressDTO);
    }

    @Override
    public Center findByEmailCenter(String email) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_EMAIL_CENTER).data(email).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CenterDTO addressDTO= (CenterDTO) response.data();
        return DTOUtils.getFromDTOCenter(addressDTO);
    }

    @Override
    public Iterable<Center> findByNameCenter(String name) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_NAME_CENTER).data(name).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CenterDTO> addressDTOS= (Iterable<CenterDTO>) response.data();
        return DTOUtils.getFromDTOCenterList(addressDTOS);
    }

    @Override
    public Optional<Center> findOneCenter(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_CENTER).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CenterDTO addressDTO= (CenterDTO) response.data();
        Center address= DTOUtils.getFromDTOCenter(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Center> findAllCenters() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_CENTERS).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CenterDTO> addressDTOS= (Iterable<CenterDTO>) response.data();
        return DTOUtils.getFromDTOCenterList(addressDTOS);
    }

    @Override
    public Optional<Center> saveCenter(Center entity) throws ServicesExceptions {
        CenterDTO addressDTO= DTOUtils.getDTOCenter(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveCenter).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CenterDTO addressDTO1= (CenterDTO) response.data();
        Center address= DTOUtils.getFromDTOCenter(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Center> deleteCenter(Center entity) throws ServicesExceptions {
        CenterDTO addressDTO= DTOUtils.getDTOCenter(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteCenter).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CenterDTO addressDTO1= (CenterDTO) response.data();
        Center address= DTOUtils.getFromDTOCenter(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Center> updateCenter(Center entity) throws ServicesExceptions {
        CenterDTO addressDTO= DTOUtils.getDTOCenter(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateCenter).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CenterDTO addressDTO1= (CenterDTO) response.data();
        Center address= DTOUtils.getFromDTOCenter(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Coupon> findByCodeCoupon(String code) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_CODE_COUPON).data(code).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CouponDTO> addressDTOS= (Iterable<CouponDTO>) response.data();
        return DTOUtils.getFromDTOCouponList(addressDTOS);

    }

    @Override
    public Iterable<Coupon> findByProviderCoupon(String provider) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_PROVIDER_COUPON).data(provider).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CouponDTO> addressDTOS= (Iterable<CouponDTO>) response.data();
        return DTOUtils.getFromDTOCouponList(addressDTOS);
    }

    @Override
    public Iterable<Coupon> findByNameCoupon(String name) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_NAME_COUPON).data(name).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CouponDTO> addressDTOS= (Iterable<CouponDTO>) response.data();
        return DTOUtils.getFromDTOCouponList(addressDTOS);
    }

    @Override
    public Iterable<Coupon> findByEndDateCoupon(LocalDate endDate) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_END_DATE_COUPON).data(String.valueOf(endDate)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CouponDTO> addressDTOS= (Iterable<CouponDTO>) response.data();
        return DTOUtils.getFromDTOCouponList(addressDTOS);
    }

    @Override
    public Optional<Coupon> findOneCoupon(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_COUPON).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CouponDTO addressDTO= (CouponDTO) response.data();
        Coupon address= DTOUtils.getFromDTOCoupon(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Coupon> findAllCoupons() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_COUPONS).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<CouponDTO> addressDTOS= (Iterable<CouponDTO>) response.data();
        return DTOUtils.getFromDTOCouponList(addressDTOS);
    }

    @Override
    public Optional<Coupon> saveCoupon(Coupon entity) throws ServicesExceptions {
        CouponDTO addressDTO= DTOUtils.getDTOCoupon(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveCoupon).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CouponDTO addressDTO1= (CouponDTO) response.data();
        Coupon address= DTOUtils.getFromDTOCoupon(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Coupon> deleteCoupon(Coupon entity) throws ServicesExceptions {
        CouponDTO addressDTO= DTOUtils.getDTOCoupon(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteCoupon).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CouponDTO addressDTO1= (CouponDTO) response.data();
        Coupon address= DTOUtils.getFromDTOCoupon(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Coupon> updateCoupon(Coupon entity) throws ServicesExceptions {
        CouponDTO addressDTO= DTOUtils.getDTOCoupon(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateCoupon).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        CouponDTO addressDTO1= (CouponDTO) response.data();
        Coupon address= DTOUtils.getFromDTOCoupon(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Donation> findByTipDonation(String tipDonation) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_TYPE_DONATION).data(tipDonation).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<DonationDTO> addressDTOS= (Iterable<DonationDTO>) response.data();
        return DTOUtils.getFromDTODonationList(addressDTOS);
    }

    @Override
    public Iterable<Donation> findByIdTipDonation(Integer tipDonation) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_ID_TYPE_DONATION).data(String.valueOf(tipDonation)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<DonationDTO> addressDTOS= (Iterable<DonationDTO>) response.data();
        return DTOUtils.getFromDTODonationList(addressDTOS);
    }

    @Override
    public Optional<Donation> findOneDonation(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_DONATION).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationDTO addressDTO= (DonationDTO) response.data();
        Donation address= DTOUtils.getFromDTODonation(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Donation> findAllDonations() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_DONATIONS).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<DonationDTO> addressDTOS= (Iterable<DonationDTO>) response.data();
        return DTOUtils.getFromDTODonationList(addressDTOS);
    }

    @Override
    public Optional<Donation> saveDonation(Donation entity) throws ServicesExceptions {
        DonationDTO addressDTO= DTOUtils.getDTODonation(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveDonation).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationDTO addressDTO1= (DonationDTO) response.data();
        Donation address= DTOUtils.getFromDTODonation(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Donation> deleteDonation(Donation entity) throws ServicesExceptions {
        DonationDTO addressDTO= DTOUtils.getDTODonation(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteDonation).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationDTO addressDTO1= (DonationDTO) response.data();
        Donation address= DTOUtils.getFromDTODonation(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Donation> updateDonation(Donation entity) throws ServicesExceptions {
        DonationDTO addressDTO= DTOUtils.getDTODonation(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateDonation).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationDTO addressDTO1= (DonationDTO) response.data();
        Donation address= DTOUtils.getFromDTODonation(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<DonationType> findOneDonationType(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_DONATION_TYPE).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationTypeDTO addressDTO= (DonationTypeDTO) response.data();
        DonationType address= DTOUtils.getFROMDTODonationType(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<DonationType> findAllDonationType() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_DONATION_TYPES).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<DonationTypeDTO> addressDTOS= (Iterable<DonationTypeDTO>) response.data();
        return DTOUtils.getFROMDTODonationTypeList(addressDTOS);
    }

    @Override
    public Optional<DonationType> saveDonationType(DonationType entity) throws ServicesExceptions {
        DonationTypeDTO addressDTO= DTOUtils.getDTODonationType(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveDonationType).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationTypeDTO addressDTO1= (DonationTypeDTO) response.data();
        DonationType address= DTOUtils.getFROMDTODonationType(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<DonationType> deleteDonationType(DonationType entity) throws ServicesExceptions {
        DonationTypeDTO addressDTO= DTOUtils.getDTODonationType(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteDonationType).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationTypeDTO addressDTO1= (DonationTypeDTO) response.data();
        DonationType address= DTOUtils.getFROMDTODonationType(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<DonationType> updateDonationType(DonationType entity) throws ServicesExceptions {
        DonationTypeDTO addressDTO= DTOUtils.getDTODonationType(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateDonationType).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        DonationTypeDTO addressDTO1= (DonationTypeDTO) response.data();
        DonationType address= DTOUtils.getFROMDTODonationType(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Event> findByNameEvent(String nume) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_NAME_EVENT).data(nume).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<EventDTO> addressDTOS= (Iterable<EventDTO>) response.data();
        Iterable<Event> addresses= DTOUtils.getFromDTOEventList(addressDTOS);
        return addresses;
    }

    @Override
    public Iterable<Event> findByAnnouncementDateEvent(LocalDate data) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_ANNOUNCEMENT_DATE_EVENT).data(String.valueOf(data)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<EventDTO> addressDTOS= (Iterable<EventDTO>) response.data();
        return DTOUtils.getFromDTOEventList(addressDTOS);
    }

    @Override
    public Iterable<Event> findByCenterIdEvent(Integer centruId) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_CENTER_ID_EVENT).data(String.valueOf(centruId)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<EventDTO> addressDTOS= (Iterable<EventDTO>) response.data();
        return DTOUtils.getFromDTOEventList(addressDTOS);
    }

    @Override
    public Iterable<Event> findByDataInceputEvent(LocalDate data) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_DATA_BEGIN_EVENT).data(String.valueOf(data)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<EventDTO> addressDTOS= (Iterable<EventDTO>) response.data();
        return DTOUtils.getFromDTOEventList(addressDTOS);
    }

    @Override
    public Optional<Event> findOneEvent(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_EVENT).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        EventDTO addressDTO= (EventDTO) response.data();
        Event address= DTOUtils.getFromDTOEvent(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Event> findAllEvents() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_EVENTS).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<EventDTO> addressDTOS= (Iterable<EventDTO>) response.data();
        return DTOUtils.getFromDTOEventList(addressDTOS);
    }

    @Override
    public Optional<Event> saveEvent(Event entity) throws ServicesExceptions {
        EventDTO addressDTO= DTOUtils.getDTOEvent(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveEvent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        EventDTO addressDTO1= (EventDTO) response.data();
        Event address= DTOUtils.getFromDTOEvent(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Event> deleteEvent(Event entity) throws ServicesExceptions {
        EventDTO addressDTO= DTOUtils.getDTOEvent(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteEvent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        EventDTO addressDTO1= (EventDTO) response.data();
        Event address= DTOUtils.getFromDTOEvent(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Event> updateEvent(Event entity) throws ServicesExceptions {
        EventDTO addressDTO= DTOUtils.getDTOEvent(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateEvent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        EventDTO addressDTO1= (EventDTO) response.data();
        Event address= DTOUtils.getFromDTOEvent(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Institution> findOneInstitution(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_INSTITUTION).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        InstitutionDTO addressDTO= (InstitutionDTO) response.data();
        Institution address= DTOUtils.getFromDTOInstitution(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Institution> findAllInstitutions() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_INSTITUTION).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<InstitutionDTO> addressDTOS= (Iterable<InstitutionDTO>) response.data();
        return DTOUtils.getFromDTOInstitutionList(addressDTOS);
    }

    @Override
    public Optional<Institution> saveInstitution(Institution entity) throws ServicesExceptions {
        InstitutionDTO addressDTO= DTOUtils.getDTOInstitution(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveEvent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        InstitutionDTO addressDTO1= (InstitutionDTO) response.data();
        Institution address= DTOUtils.getFromDTOInstitution(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Institution> deleteInstitution(Institution entity) throws ServicesExceptions {
        InstitutionDTO addressDTO= DTOUtils.getDTOInstitution(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteInstitution).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        InstitutionDTO addressDTO1= (InstitutionDTO) response.data();
        Institution address= DTOUtils.getFromDTOInstitution(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Institution> updateInstitution(Institution entity) throws ServicesExceptions {
        InstitutionDTO addressDTO= DTOUtils.getDTOInstitution(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateInstitution).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        InstitutionDTO addressDTO1= (InstitutionDTO) response.data();
        Institution address= DTOUtils.getFromDTOInstitution(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Institution> findByNameInstitution(String name) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_NAME_INSTITUTION).data(name).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<InstitutionDTO> addressDTOS= (Iterable<InstitutionDTO>) response.data();
        return DTOUtils.getFromDTOInstitutionList(addressDTOS);
    }

    @Override
    public Iterable<Institution> findByAddressInstitution(String address) throws ServicesExceptions {
Request req =new Request.Builder().type(RequestType.FIND_BY_ADDRESS_INSTITUTION).data(address).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<InstitutionDTO> addressDTOS= (Iterable<InstitutionDTO>) response.data();
        return DTOUtils.getFromDTOInstitutionList(addressDTOS);
    }

    @Override
    public Iterable<Institution> findByEmailInstitution(String email) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_EMAIL_INSTITUTION).data(email).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<InstitutionDTO> addressDTOS= (Iterable<InstitutionDTO>) response.data();
        return DTOUtils.getFromDTOInstitutionList(addressDTOS);
    }

    @Override
    public Optional<LogInfo> findOneLogInfo(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_ADDRESS).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        LogInfoDTO addressDTO= (LogInfoDTO) response.data();
        LogInfo address= DTOUtils.getFromDTOLogInfo(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<LogInfo> findAllLogInfos() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_LOG_INFO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<LogInfoDTO> addressDTOS= (Iterable<LogInfoDTO>) response.data();
        return DTOUtils.getFromDTOLogInfoList(addressDTOS);
    }

    @Override
    public Optional<LogInfo> saveLogInfo(LogInfo entity) throws ServicesExceptions {
        LogInfoDTO addressDTO= DTOUtils.getDTOLogInfo(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveLogInfo).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        LogInfoDTO addressDTO1= (LogInfoDTO) response.data();
        LogInfo address= DTOUtils.getFromDTOLogInfo(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<LogInfo> deleteLogInfo(LogInfo entity) throws ServicesExceptions {
        LogInfoDTO addressDTO= DTOUtils.getDTOLogInfo(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteLogInfo).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        LogInfoDTO addressDTO1= (LogInfoDTO) response.data();
        LogInfo address= DTOUtils.getFromDTOLogInfo(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<LogInfo> updateLogInfo(LogInfo entity) throws ServicesExceptions {
        LogInfoDTO addressDTO= DTOUtils.getDTOLogInfo(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateLogInfo).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        LogInfoDTO addressDTO1= (LogInfoDTO) response.data();
        LogInfo address= DTOUtils.getFromDTOLogInfo(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public LogInfo findByUsernameLogInfo(String username) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_USERNAME_LOG_INFO).data(username).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        LogInfoDTO addressDTO= (LogInfoDTO) response.data();
        return DTOUtils.getFromDTOLogInfo(addressDTO);
    }

    @Override
    public LogInfo findByEmailLogInfo(String email) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_EMAIL_LOG_INFO).data(email).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        LogInfoDTO addressDTO= (LogInfoDTO) response.data();
        return DTOUtils.getFromDTOLogInfo(addressDTO);
    }

    @Override
    public Optional<MedicalInfo> findOneMedicalInfo(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_MEDICAL_INFO).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        MedicalInfoDTO addressDTO= (MedicalInfoDTO) response.data();
        MedicalInfo address= DTOUtils.getFromDTOMedicalInfo(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<MedicalInfo> findAllMedicalInfos() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_MEDICAL_INFOS).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<MedicalInfoDTO> addressDTOS= (Iterable<MedicalInfoDTO>) response.data();
        return DTOUtils.getFromDTOMedicalInfoList(addressDTOS);
    }

    @Override
    public Optional<MedicalInfo> saveMedicalInfo(MedicalInfo entity) throws ServicesExceptions {
        MedicalInfoDTO addressDTO= DTOUtils.getDTOMedicalInfo(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveMedicalInfo).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        MedicalInfoDTO addressDTO1= (MedicalInfoDTO) response.data();
        MedicalInfo address= DTOUtils.getFromDTOMedicalInfo(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<MedicalInfo> deleteMedicalInfo(MedicalInfo entity) throws ServicesExceptions {
        MedicalInfoDTO addressDTO= DTOUtils.getDTOMedicalInfo(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteMedicalInfo).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        MedicalInfoDTO addressDTO1= (MedicalInfoDTO) response.data();
        MedicalInfo address= DTOUtils.getFromDTOMedicalInfo(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<MedicalInfo> updateMedicalInfo(MedicalInfo entity) throws ServicesExceptions {
        MedicalInfoDTO addressDTO= DTOUtils.getDTOMedicalInfo(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateMedicalInfo).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        MedicalInfoDTO addressDTO1= (MedicalInfoDTO) response.data();
        MedicalInfo address= DTOUtils.getFromDTOMedicalInfo(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<MedicalInfo> findByBloodTypeMedicalInfo(String bloodType) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_BLOOD_TYPE_MEDICAL_INFO).data(bloodType).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<MedicalInfoDTO> addressDTOS= (Iterable<MedicalInfoDTO>) response.data();
        return DTOUtils.getFromDTOMedicalInfoList(addressDTOS);
    }

    @Override
    public Iterable<MedicalInfo> findByRhMedicalInfo(String rh) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_RH_MEDICAL_INFO).data(rh).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<MedicalInfoDTO> addressDTOS= (Iterable<MedicalInfoDTO>) response.data();
        return DTOUtils.getFromDTOMedicalInfoList(addressDTOS);
    }

    @Override
    public Iterable<MedicalInfo> findByBloodTypeAndRhMedicalInfo(String bloodType, String rh) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_BLOOD_TYPE_AND_RH_MEDICAL_INFO).data(bloodType).data2(rh).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<MedicalInfoDTO> addressDTOS= (Iterable<MedicalInfoDTO>) response.data();
        return DTOUtils.getFromDTOMedicalInfoList(addressDTOS);
    }

    @Override
    public Optional<PersonalData> findOnePersonalData(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_PERSONAL_DATA).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonalDataDTO addressDTO= (PersonalDataDTO) response.data();
        PersonalData address= DTOUtils.getFromDTOPersonalData(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<PersonalData> findAllPersonalDatas() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_PERSONAL_DATA).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonalDataDTO> addressDTOS= (Iterable<PersonalDataDTO>) response.data();
        return DTOUtils.getFromDTOPersonalDataList(addressDTOS);
    }

    @Override
    public Optional<PersonalData> savePersonalData(PersonalData entity) throws ServicesExceptions {
        PersonalDataDTO addressDTO= DTOUtils.getDTOPersonalData(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.savePersonalData).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonalDataDTO addressDTO1= (PersonalDataDTO) response.data();
        PersonalData address= DTOUtils.getFromDTOPersonalData(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<PersonalData> deletePersonalData(PersonalData entity) throws ServicesExceptions {
        PersonalDataDTO addressDTO= DTOUtils.getDTOPersonalData(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deletePersonalData).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonalDataDTO addressDTO1= (PersonalDataDTO) response.data();
        PersonalData address= DTOUtils.getFromDTOPersonalData(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<PersonalData> updatePersonalData(PersonalData entity) throws ServicesExceptions {
        PersonalDataDTO addressDTO= DTOUtils.getDTOPersonalData(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updatePersonalData).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonalDataDTO addressDTO1= (PersonalDataDTO) response.data();
        PersonalData address= DTOUtils.getFromDTOPersonalData(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<PersonalData> findByFirstNamePersonalData(String firstName) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_FIRST_NAME_PERSONAL_DATA).data(firstName).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonalDataDTO> addressDTOS= (Iterable<PersonalDataDTO>) response.data();
        return DTOUtils.getFromDTOPersonalDataList(addressDTOS);
    }

    @Override
    public Iterable<PersonalData> findByLastNamePersonalData(String lastName) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_LAST_NAME_PERSONAL_DATA).data(lastName).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonalDataDTO> addressDTOS= (Iterable<PersonalDataDTO>) response.data();
        return DTOUtils.getFromDTOPersonalDataList(addressDTOS);
    }

    @Override
    public PersonalData findByCnpPersonalData(String cnp) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_CNP_PERSONAL_DATA).data(cnp).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonalDataDTO addressDTO= (PersonalDataDTO) response.data();
        return DTOUtils.getFromDTOPersonalData(addressDTO);
    }

    @Override
    public Optional<Person> findOnePerson(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_PERSON).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonDTO addressDTO= (PersonDTO) response.data();
        Person address= DTOUtils.getFromDTOPerson(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Person> findAllPersons() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_PERSON).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonDTO> addressDTOS= (Iterable<PersonDTO>) response.data();
        return DTOUtils.getFromDTOPersonList(addressDTOS);
    }

    @Override
    public Optional<Person> savePerson(Person entity) throws ServicesExceptions {
        PersonDTO addressDTO= DTOUtils.getDTOPerson(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.savePerson).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonDTO addressDTO1= (PersonDTO) response.data();
        Person address= DTOUtils.getFromDTOPerson(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Person> deletePerson(Person entity) throws ServicesExceptions {
        PersonDTO addressDTO= DTOUtils.getDTOPerson(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deletePerson).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonDTO addressDTO1= (PersonDTO) response.data();
        Person address= DTOUtils.getFromDTOPerson(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Person> updatePerson(Person entity) throws ServicesExceptions {
        PersonDTO addressDTO= DTOUtils.getDTOPerson(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updatePerson).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonDTO addressDTO1= (PersonDTO) response.data();
        Person address= DTOUtils.getFromDTOPerson(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Person> findByFirstNamePerson(String firstName) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_FIRST_NAME_PERSON).data(firstName).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonDTO> addressDTOS= (Iterable<PersonDTO>) response.data();
        return DTOUtils.getFromDTOPersonList(addressDTOS);
    }

    @Override
    public Iterable<Person> findByLastNamePerson(String lastName) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_LAST_NAME_PERSON).data(lastName).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonDTO> addressDTOS= (Iterable<PersonDTO>) response.data();
        return DTOUtils.getFromDTOPersonList(addressDTOS);
    }

    @Override
    public Iterable<Person> findByCnpPerson(String cnp) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_CNP_PERSON).data(cnp).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonDTO> addressDTOS= (Iterable<PersonDTO>) response.data();
        return DTOUtils.getFromDTOPersonList(addressDTOS);
    }

    @Override
    public Person findByEmailPerson(String email) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_EMAIL_PERSON).data(email).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonDTO addressDTO= (PersonDTO) response.data();
        return DTOUtils.getFromDTOPerson(addressDTO);
    }

    @Override
    public Iterable<Person> findByPhoneNumberPerson(String phoneNumber) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_PHONE_NUMBER_PERSON).data(phoneNumber).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<PersonDTO> addressDTOS= (Iterable<PersonDTO>) response.data();
        return DTOUtils.getFromDTOPersonList(addressDTOS);
    }

    @Override
    public Person findByUsernamePerson(String username) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_USERNAME_PERSON).data(username).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        PersonDTO addressDTO= (PersonDTO) response.data();
        return DTOUtils.getFromDTOPerson(addressDTO);
    }

    @Override
    public Optional<RetrievedCoupons> findOneRetrieved(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ONE_RETRIEVED).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        RetrivedCouponsDTO addressDTO= (RetrivedCouponsDTO) response.data();
        RetrievedCoupons address= DTOUtils.getFromDTORetrivedCoupon(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<RetrievedCoupons> findAllRetrieved() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_ALL_RETRIEVED).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<RetrivedCouponsDTO> addressDTOS= (Iterable<RetrivedCouponsDTO>) response.data();
        return DTOUtils.getFromDTORetrievedCouponsList(addressDTOS);
    }

    @Override
    public Optional<RetrievedCoupons> saveRetrieved(RetrievedCoupons entity) throws ServicesExceptions {
        RetrivedCouponsDTO addressDTO= DTOUtils.getDTORetrivedCoupon(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveRetrieved).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        RetrivedCouponsDTO addressDTO1= (RetrivedCouponsDTO) response.data();
        RetrievedCoupons address= DTOUtils.getFromDTORetrivedCoupon(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<RetrievedCoupons> deleteRetrieved(RetrievedCoupons entity) throws ServicesExceptions {
        RetrivedCouponsDTO addressDTO= DTOUtils.getDTORetrivedCoupon(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteRetrieved).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        RetrivedCouponsDTO addressDTO1= (RetrivedCouponsDTO) response.data();
        RetrievedCoupons address= DTOUtils.getFromDTORetrivedCoupon(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<RetrievedCoupons> updateRetrieved(RetrievedCoupons entity) throws ServicesExceptions {
        RetrivedCouponsDTO addressDTO= DTOUtils.getDTORetrivedCoupon(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateRetrieved).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        RetrivedCouponsDTO addressDTO1= (RetrivedCouponsDTO) response.data();
        RetrievedCoupons address= DTOUtils.getFromDTORetrivedCoupon(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<RetrievedCoupons> findByCouponIdRetrieved(Integer couponId) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_COUPON_ID_RETRIEVED).data(String.valueOf(couponId)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<RetrivedCouponsDTO> addressDTOS= (Iterable<RetrivedCouponsDTO>) response.data();
        return DTOUtils.getFromDTORetrievedCouponsList(addressDTOS);
    }

    @Override
    public Iterable<RetrievedCoupons> findByPersonIdRetrieved(Integer personId) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_PERSON_ID_RETRIEVED).data(String.valueOf(personId)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<RetrivedCouponsDTO> addressDTOS= (Iterable<RetrivedCouponsDTO>) response.data();
        return DTOUtils.getFromDTORetrievedCouponsList(addressDTOS);
    }

    @Override
    public Iterable<RetrievedCoupons> findByDateRetrieved(String date) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.FIND_BY_DATE_RETRIEVED).data(date).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<RetrivedCouponsDTO> addressDTOS= (Iterable<RetrivedCouponsDTO>) response.data();
        return DTOUtils.getFromDTORetrievedCouponsList(addressDTOS);
    }

    @Override
    public Optional<Student> findOneStudent(Integer integer) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findOneStudent).data(String.valueOf(integer)).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        StudentDTO addressDTO= (StudentDTO) response.data();
        Student address= DTOUtils.getFromDTOStudent(addressDTO);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Student> findAllStudent() throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findAllStudent).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<StudentDTO> addressDTOS= (Iterable<StudentDTO>) response.data();
        return DTOUtils.getFromDTOStudentList(addressDTOS);
    }

    @Override
    public Optional<Student> saveStudent(Student entity) throws ServicesExceptions {
        StudentDTO addressDTO= DTOUtils.getDTOStudent(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.saveStudent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        StudentDTO addressDTO1= (StudentDTO) response.data();
        Student address= DTOUtils.getFromDTOStudent(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Student> deleteStudent(Student entity) throws ServicesExceptions {
        StudentDTO addressDTO= DTOUtils.getDTOStudent(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.deleteStudent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        StudentDTO addressDTO1= (StudentDTO) response.data();
        Student address= DTOUtils.getFromDTOStudent(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Student> updateStudent(Student entity) throws ServicesExceptions {
        StudentDTO addressDTO= DTOUtils.getDTOStudent(Optional.of(entity));
        Request req =new Request.Builder().type(RequestType.updateStudent).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        StudentDTO addressDTO1= (StudentDTO) response.data();
        Student address= DTOUtils.getFromDTOStudent(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Iterable<Student> findByFirstNameStudent(String firstName) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findByFirstNameStudent).data(firstName).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<StudentDTO> addressDTOS= (Iterable<StudentDTO>) response.data();
        return DTOUtils.getFromDTOStudentList(addressDTOS);
    }

    @Override
    public Iterable<Student> findByLastNameStudent(String lastName) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findByLastNameStudent).data(lastName).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<StudentDTO> addressDTOS= (Iterable<StudentDTO>) response.data();
        return DTOUtils.getFromDTOStudentList(addressDTOS);
    }

    @Override
    public Iterable<Student> findByCnpStudent(String cnp) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findByCnpStudent).data(cnp).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<StudentDTO> addressDTOS= (Iterable<StudentDTO>) response.data();
        return DTOUtils.getFromDTOStudentList(addressDTOS);
    }

    @Override
    public Student findByEmailStudent(String email) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findByEmailStudent).data(email).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        StudentDTO addressDTO= (StudentDTO) response.data();
        return DTOUtils.getFromDTOStudent(addressDTO);
    }

    @Override
    public Iterable<Student> findByPhoneNumberStudent(String phoneNumber) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findByPhoneNumberStudent).data(phoneNumber).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        Iterable<StudentDTO> addressDTOS= (Iterable<StudentDTO>) response.data();
        return DTOUtils.getFromDTOStudentList(addressDTOS);
    }

    @Override
    public Student findByUsernameStudent(String username) throws ServicesExceptions {
        Request req =new Request.Builder().type(RequestType.findByUsernameStudent).data(username).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        StudentDTO addressDTO= (StudentDTO) response.data();
        return DTOUtils.getFromDTOStudent(addressDTO);
    }

    @Override
    public Optional<Person> login(LogInfo logInfo, IObserver observer) throws ServicesExceptions {
        initializeConnection();
        LogInfoDTO addressDTO= DTOUtils.getDTOLogInfo(Optional.of(logInfo));
        Request req =new Request.Builder().type(RequestType.LOGIN_PERSON).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        this.client=observer;
        PersonDTO addressDTO1= (PersonDTO) response.data();
        Person address= DTOUtils.getFromDTOPerson(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public Optional<Center> loginCenter(LogInfo logInfo, IObserver observer) throws ServicesExceptions {
        initializeConnection();
        LogInfoDTO addressDTO= DTOUtils.getDTOLogInfo(Optional.of(logInfo));
        Request req =new Request.Builder().type(RequestType.LOGIN_CENTER).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
        this.client=observer;
        CenterDTO addressDTO1= (CenterDTO) response.data();
        Center address= DTOUtils.getFromDTOCenter(addressDTO1);
        return Optional.ofNullable(address);
    }

    @Override
    public void logoutCenter(Center center, IObserver observer) throws ServicesExceptions {
        CenterDTO addressDTO= DTOUtils.getDTOCenter(Optional.of(center));
        Request req =new Request.Builder().type(RequestType.LOGOUT_CENTER).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        closeConnection();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
    }

    @Override
    public void logoutPerson(Person center, IObserver observer) throws ServicesExceptions {
        PersonDTO addressDTO= DTOUtils.getDTOPerson(Optional.of(center));
        Request req =new Request.Builder().type(RequestType.LOGOUT_PERSON).data(addressDTO).build();
        sendRequest(req);
        Response response=readResponse();
        closeConnection();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
    }

    @Override
    public void donationRegister(Donation donation, Person person, Event event) throws ServicesExceptions {
        DonationDTO addressDTO= DTOUtils.getDTODonation(Optional.of(donation));
        PersonDTO addressDTO1= DTOUtils.getDTOPerson(Optional.of(person));
        EventDTO addressDTO2= DTOUtils.getDTOEvent(Optional.of(event));
        Request req =new Request.Builder().type(RequestType.donationRegister).data(addressDTO).data(addressDTO1).data3(addressDTO2).build();
        sendRequest(req);
        Response response=readResponse();
        if (response.type()== ResponseType.ERROR){
            String err=response.data().toString();
            closeConnection();
            throw new ServicesExceptions(err);
        }
    }
    // to do
    private void initializeConnection() throws ServicesExceptions {
        try {
            connection=new Socket(host,port);
            output=new ObjectOutputStream(connection.getOutputStream());
            output.flush();
            input=new ObjectInputStream(connection.getInputStream());
            finished=false;
            startReader();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void startReader(){
        Thread tw=new Thread(new ReaderThread());
        tw.start();
    }
    private void sendRequest(Request request)throws ServicesExceptions {
        try {
            output.writeObject(request);
            output.flush();
        } catch (IOException e) {
            throw new ServicesExceptions("Error sending object "+e);
        }

    }
    private void closeConnection() {
        finished=true;
        try {
            input.close();
            output.close();
            connection.close();
            client=null;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private boolean isUpdate(Response response){
        return response.type()== ResponseType.NEW ;
    }
    private void handleUpdate(Response response){
//        if (response.type()== ResponseType.NEW){
//            //System.out.println("am trimis raspuns");
//            RegistrationDTO regDTO= (RegistrationDTO) response.data();
//            Registration org= DTOUtils.getFromDTO((regDTO));
//
//            try {
//                client.participantsRegistered(org);
//            } catch (CompetitionException e) {
//                e.printStackTrace();
//            }
//        }
//
  }
    private Response readResponse() throws ServicesExceptions {
        Response response=null;
        try{

            response=qresponses.take();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return response;
    }

    private class ReaderThread implements Runnable{
        public void run() {
            while(!finished){
                try {
                    Object response=input.readObject();
                    //System.out.println("response received "+response);
                    if (isUpdate((Response)response)){
                        handleUpdate((Response)response);
                    }else{

                        try {
                            qresponses.put((Response)response);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Reading error "+e);
                } catch (ClassNotFoundException e) {
                    System.out.println("Reading error "+e);
                }
            }
        }
    }
}
