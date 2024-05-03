package bpos.networking.rpc;

import bpos.model.*;
import bpos.model.Enums.BloodType;
import bpos.model.Enums.Rh;
import bpos.networking.dto.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Optional;

public class DTOUtils {
    public static Person getFromDTOPerson(PersonDTO user) {
        if(user==null)
            return null;
        Person person=new Person();
        LogInfo loginfo=getFromDTOLogInfo(user.getPersonLogInfo());
        PersonalData personalData=getFromDTOPersonalData(user.getPersonalDate());
        MedicalInfo medicalInfo=getFromDTOMedicalInfo(user.getMedicalInfo());
        Institution institution=getFromDTOInstitution(user.getInstitution());
        if(Objects.equals(user.getPoints(), "") || user.getPoints()==null){
            person= new Person(loginfo,0,personalData,medicalInfo,institution);
        }
        else{
            person=new Person(loginfo, Integer.parseInt(user.getPoints()),personalData,medicalInfo,institution);
        }
        if(Objects.equals(user.getId(), "") || user.getId()==null){
            return person;
        }
        else {
            person.setId(Integer.valueOf(user.getId()));
        }
        return person;
    }

    public static LogInfo getFromDTOLogInfo(LogInfoDTO user) {
        if(user==null){
            return null;
        }
        LogInfo logInfo=new LogInfo();
        if(Objects.equals(user.getId(), "") || user.getId()==null){
            logInfo= new LogInfo(user.getUsername(),user.getPassword(),user.getEmail(),user.getSeed());
            return logInfo;
        }
        else {
            logInfo= new LogInfo(user.getUsername(),user.getPassword(),user.getEmail(),user.getSeed());
            logInfo.setId(Integer.valueOf(user.getId()));
        }
        return logInfo;
    }

    public static PersonDTO getDTOPerson(Optional<Person> pers) {
        if(pers.isEmpty()){
            return new PersonDTO();
        }
        else {
            Person person=pers.get();
            PersonDTO personDTO=new PersonDTO();
            if(person.getId()!=null){
                personDTO.setId(String.valueOf(person.getId()));
            }
            else{
                personDTO.setId("");
            }
            if(person.getPersonLogInfo()!=null){
                personDTO.setPersonLogInfo(getDTOLogInfo(Optional.of(person.getPersonLogInfo())));
            }
            else{
                personDTO.setPersonLogInfo(new LogInfoDTO());
            }
            if(person.getPoints()!=0){
                personDTO.setPoints(String.valueOf(person.getPoints()));
            }
            else{
                personDTO.setPoints("");
            }
            if(person.getPersonalDate()!=null){
                personDTO.setPersonalDate(getDTOPersonalData(Optional.of(person.getPersonalDate())));
            }
            else{
                personDTO.setPersonalDate(new PersonalDataDTO());
            }
            if(person.getMedicalInfo()!=null){
                personDTO.setMedicalInfo(getDTOMedicalInfo(Optional.of(person.getMedicalInfo())));
            }
            else{
                personDTO.setMedicalInfo(new MedicalInfoDTO());
            }
            if(person.getInstitution()!=null){
                personDTO.setInstitution(getDTOInstitution(Optional.of(person.getInstitution())));
            }
            else{
                personDTO.setInstitution(new InstitutionDTO());
            }
            return personDTO;
        }
    }

    public static MedicalInfoDTO getDTOMedicalInfo(Optional<MedicalInfo> medicalInfo) {
        if(medicalInfo.isEmpty()){
            return null;
        }
        else {
            MedicalInfo medicalInfo1 = medicalInfo.get();
            MedicalInfoDTO medicalInfoDTO = new MedicalInfoDTO();
            if (medicalInfo1.getId() != null) {
                medicalInfoDTO.setId(String.valueOf(medicalInfo1.getId()));
            } else {
                medicalInfoDTO.setId("");
            }
            if (medicalInfo1.getBloodType() != null) {
                medicalInfoDTO.setBloodType(medicalInfo1.getBloodType().toString());
            } else {
                medicalInfoDTO.setBloodType("");
            }
           medicalInfoDTO.setEligibility(String.valueOf(medicalInfo1.getEligibility()));
            if (medicalInfo1.getRh() != null) {
                medicalInfoDTO.setRh(medicalInfo1.getRh().toString());
            } else {
                medicalInfoDTO.setRh("");
            }
            return medicalInfoDTO;
        }
    }

    public static CenterDTO getDTOCenter(Optional<Center> pers) {
        if(pers.isEmpty()){
            return null;
        }
        else {
            Center center=pers.get();
            CenterDTO centerDTO=new CenterDTO();
            if(center.getId()!=null){
                centerDTO.setId(String.valueOf(center.getId()));
            }
            else{
                centerDTO.setId("");
            }
            if(center.getCenterName()!=null){
                centerDTO.setCenterName(center.getCenterName());
            }
            else{
                centerDTO.setCenterName("");
            }
            if(center.getAddress()!=null){
                centerDTO.setAddress(center.getAddress());
            }
            else{
                centerDTO.setAddress("");
            }
            if(center.getInstitutionDetails()!=null){
                centerDTO.setInstitutionDetails(center.getInstitutionDetails());
            }
            else{
                centerDTO.setInstitutionDetails("");
            }
            if(center.getLogInfo()!=null){
                centerDTO.setLogInfo(getDTOLogInfo(Optional.of(center.getLogInfo())));
            }
            else{
                centerDTO.setLogInfo(new LogInfoDTO());
            }
            return centerDTO;
        }
    }

    public static Center getFromDTOCenter(CenterDTO user) {
        if(user==null){
            return null;
        }
        Center center=new Center();
        LogInfo loginfo=getFromDTOLogInfo(user.getLogInfo());
        if(Objects.equals(user.getId(), "") || user.getId()==null){
            center= new Center(user.getInstitutionDetails(),loginfo,user.getCenterName(),user.getAddress());
            return center;
        }
        else {
            center= new Center(user.getInstitutionDetails(),loginfo,user.getCenterName(),user.getAddress());
            center.setId(Integer.valueOf(user.getId()));
        }
        return center;
    }

    public static AddressDTO getDTOAddress(Optional<Address> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            Address address=persons.get();
            AddressDTO addressDTO=new AddressDTO();
            if(address.getId()!=null){
                addressDTO.setId(String.valueOf(address.getId()));
            }
            else{
                addressDTO.setId("");
            }
            if(address.getCity()!=null){
                addressDTO.setCity(address.getCity());
            }
            else{
                addressDTO.setCity("");
            }
            if(address.getCountry()!=null){
                addressDTO.setCountry(address.getCountry());
            }
            else{
                addressDTO.setCountry("");
            }
            if(address.getStreet()!=null){
                addressDTO.setStreet(address.getStreet());
            }
            else{
                addressDTO.setStreet("");
            }
            if(address.getNumberStreet()!=null){
                addressDTO.setNumberStreet(address.getNumberStreet());
            }
            else{
                addressDTO.setNumberStreet("");
            }
            if(address.getBlock()!=null){
                addressDTO.setBlock(address.getBlock());
            }
            else{
                addressDTO.setBlock("");
            }
            if(address.getFloor()!=null){
                addressDTO.setFloor(String.valueOf(address.getFloor()));
            }
            else{
                addressDTO.setFloor("");
            }
            if(address.getApartment()!=null){
                addressDTO.setApartment(address.getApartment());
            }
            else{
                addressDTO.setApartment("");
            }
            return addressDTO;
        }
    }

    public static Iterable<AddressDTO> getDTOAddressList(Iterable<Address> persons) {
        ArrayList<AddressDTO> addressDTOS=new ArrayList<>();
        for(Address address:persons){
            AddressDTO addressDTO=getDTOAddress(Optional.of(address));
            addressDTOS.add(addressDTO);
        }
        return addressDTOS;
    }

    public static Address getFromDTOAddress(AddressDTO addressDTO) {
        if(addressDTO==null){
            return null;
        }
        Address address=new Address();

        if(Objects.equals(addressDTO.getFloor(), "") || addressDTO.getFloor()==null){
            address.setFloor(0);
        }
        else{
            address.setFloor(Integer.parseInt(addressDTO.getFloor()));
        }
        address.setCountry(addressDTO.getCountry());
        address.setCounty(addressDTO.getCounty());
        address.setCity(addressDTO.getCity());
        address.setStreet(addressDTO.getStreet());
        address.setNumberStreet(addressDTO.getNumberStreet());
        address.setBlock(addressDTO.getBlock());
        address.setApartment(addressDTO.getApartment());
        if(Objects.equals(addressDTO.getId(), "") || addressDTO.getId()==null){
            return address;
        }
        else {
            address.setId(Integer.valueOf(addressDTO.getId()));
        }
        return address;
    }

    public static BloodTestDTO getDTOBloodTest(Optional<BloodTest> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            BloodTest bloodTest = persons.get();
            BloodTestDTO bloodTestDTO = new BloodTestDTO();
            if (bloodTest.getId() != null) {
                bloodTestDTO.setId(String.valueOf(bloodTest.getId()));
            } else {
                bloodTestDTO.setId("");
            }
          //  bloodTestDTO.setMedicalInfo(getDTOMedicalInfo(Optional.of(bloodTest.getMedicalInfo())));
            if (bloodTest.getName() != null) {
                bloodTestDTO.setName(bloodTest.getName());
            } else {
                bloodTestDTO.setName(null);
            }
            if (bloodTest.getPath() != null) {
                bloodTestDTO.setPath(bloodTest.getPath());
            } else {
                bloodTestDTO.setPath("");
            }
            return bloodTestDTO;
        }
    }

    public static Iterable<BloodTestDTO> getDTOBloodTestList(Iterable<BloodTest> persons) {
        ArrayList<BloodTestDTO> bloodTestDTOS=new ArrayList<>();
        for(BloodTest bloodTest:persons){
            BloodTestDTO bloodTestDTO=getDTOBloodTest(Optional.of(bloodTest));
            bloodTestDTOS.add(bloodTestDTO);
        }
        return bloodTestDTOS;
    }

    public static BloodTest getFromDTOBloodTest(BloodTestDTO addressDTO) {
        if(addressDTO==null){
            return null;
        }
        BloodTest bloodTest=new BloodTest();
        MedicalInfo medicalInfo=getFromDTOMedicalInfo(addressDTO.getMedicalInfo());
        bloodTest.setMedicalInfo(medicalInfo.getId());
        bloodTest.setName(addressDTO.getName());
        bloodTest.setPath(addressDTO.getPath());
        if(Objects.equals(addressDTO.getId(), "") || addressDTO.getId()==null){
            return bloodTest;
        }
        else {
            bloodTest.setId(Integer.valueOf(addressDTO.getId()));
        }
        return bloodTest;
    }

    public static Iterable<CenterDTO> getDTOCenterList(Iterable<Center> persons) {
        ArrayList<CenterDTO> centerDTOS=new ArrayList<>();
        for(Center center:persons){
            CenterDTO centerDTO=getDTOCenter(Optional.of(center));
            centerDTOS.add(centerDTO);
        }
        return centerDTOS;
    }

    public static Iterable<CouponDTO> getDTOCouponList(Iterable<Coupon> persons) {
        ArrayList<CouponDTO> couponDTOS=new ArrayList<>();
        for(Coupon coupon:persons){
            CouponDTO couponDTO=getDTOCoupon(Optional.of(coupon));
            couponDTOS.add(couponDTO);
        }
        return couponDTOS;
    }

    public static CouponDTO getDTOCoupon(Optional<Coupon> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            Coupon coupon = persons.get();
            CouponDTO couponDTO = new CouponDTO();
            if (coupon.getId() != null) {
                couponDTO.setId(String.valueOf(coupon.getId()));
            } else {
                couponDTO.setId("");
            }
            if (coupon.getName() != null) {
                couponDTO.setName(coupon.getName());
            } else {
                couponDTO.setName("");
            }
            if(coupon.getNecessaryPoints()!=0){
                couponDTO.setNecessaryPoints(String.valueOf(coupon.getNecessaryPoints()));
            }
            else{
                couponDTO.setNecessaryPoints("");
            }
            if (coupon.getProvider() != null) {
                couponDTO.setProvider(coupon.getProvider());
            } else {
                couponDTO.setProvider("");
            }
            if (coupon.getOffer() != null) {
                couponDTO.setOffer(coupon.getOffer());
            } else {
                couponDTO.setOffer("");
            }
            if (coupon.getUnavailableToClaimFrom() != null) {
                couponDTO.setUnavailableToClaimFrom(coupon.getUnavailableToClaimFrom().toString());
            } else {
                couponDTO.setUnavailableToClaimFrom("");
            }
            if(coupon.getValidityPeriod()!=0){
                couponDTO.setValidityPeriod(String.valueOf(coupon.getValidityPeriod()));
            }
            else{
                couponDTO.setValidityPeriod("");
            }
            if (coupon.getSeries() != null) {
                couponDTO.setSeries(coupon.getSeries());
            } else {
                couponDTO.setSeries("");
            }
            return couponDTO;
        }
    }

    public static Coupon getFromDTOCoupon(CouponDTO addressDTO) {
        if(addressDTO==null){
            return null;
        }
        Coupon coupon=new Coupon();
        if(Objects.equals(addressDTO.getNecessaryPoints(), "") || addressDTO.getNecessaryPoints()==null){
            coupon.setNecessaryPoints(0);
        }
        else{
            coupon.setNecessaryPoints(Integer.parseInt(addressDTO.getNecessaryPoints()));
        }
        coupon.setName(addressDTO.getName());
        coupon.setProvider(addressDTO.getProvider());
        coupon.setOffer(addressDTO.getOffer());
        if(!Objects.equals(addressDTO.getUnavailableToClaimFrom(), "") || addressDTO.getUnavailableToClaimFrom()!=null )
            coupon.setUnavailableToClaimFrom(LocalDateTime.parse(addressDTO.getUnavailableToClaimFrom()));
        else{
            coupon.setUnavailableToClaimFrom(null);
        }
        if(Objects.equals(addressDTO.getValidityPeriod(), "") || addressDTO.getValidityPeriod()==null ){
            coupon.setValidityPeriod(0);
        }
        else{
            coupon.setValidityPeriod(Integer.parseInt(addressDTO.getValidityPeriod()));
        }
        coupon.setSeries(addressDTO.getSeries());
        if(Objects.equals(addressDTO.getId(), "") || addressDTO.getId()==null){
            return coupon;
        }
        else {
            coupon.setId(Integer.valueOf(addressDTO.getId()));
        }
        return coupon;
    }

    public static Iterable<DonationDTO> getDTODonationList(Iterable<Donation> persons) {
        ArrayList<DonationDTO> donationDTOS=new ArrayList<>();
        for(Donation donation:persons){
            DonationDTO donationDTO=getDTODonation(Optional.of(donation));
            donationDTOS.add(donationDTO);
        }
        return donationDTOS;
    }

    public static DonationDTO getDTODonation(Optional<Donation> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            Donation donation = persons.get();
            DonationDTO donationDTO = new DonationDTO();
            if (donation.getId() != null) {
                donationDTO.setId(String.valueOf(donation.getId()));
            } else {
                donationDTO.setId("");
            }

            donationDTO.setDonationType(getDTODonationType(Optional.of(donation.getDonationType())));

            if(donation.getPoints()!=0){
                donationDTO.setPoints(String.valueOf(donation.getPoints()));
            }
            else{
                donationDTO.setPoints("");
            }
            return donationDTO;
        }
    }

    public static Donation getFromDTODonation(DonationDTO dateDonation) {
        if(dateDonation==null){
            return null;
        }
        Donation donation=new Donation();
        DonationType donationType=getFROMDTODonationType(dateDonation.getDonationType());
        donation.setDonationType(donationType);
        if(Objects.equals(dateDonation.getPoints(), "") || dateDonation.getPoints()==null){
            donation.setPoints(0);
        }
        else{
            donation.setPoints(Integer.parseInt(dateDonation.getPoints()));
        }
        if(Objects.equals(dateDonation.getId(), "")){
            return donation;
        }
        else {
            donation.setId(Integer.valueOf(dateDonation.getId()));
        }
        return donation;
    }

    public static DonationTypeDTO getDTODonationType(Optional<DonationType> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            DonationType donationType = persons.get();
            DonationTypeDTO donationTypeDTO = new DonationTypeDTO();
            if (donationType.getId() != null) {
                donationTypeDTO.setId(String.valueOf(donationType.getId()));
            } else {
                donationTypeDTO.setId("");
            }
            if (donationType.getName() != null) {
                donationTypeDTO.setName(donationType.getName());
            } else {
                donationTypeDTO.setName("");
            }
            if (donationType.getWaitingInterval() != 0) {
                donationTypeDTO.setWaitingInterval(String.valueOf(donationType.getWaitingInterval()));
            } else {
                donationTypeDTO.setWaitingInterval("");
            }
            return donationTypeDTO;
        }
    }

    public static DonationType getFROMDTODonationType(DonationTypeDTO dateDonation) {
        if(dateDonation==null){
            return null;
        }
        DonationType donationType=new DonationType();
        if(Objects.equals(dateDonation.getWaitingInterval(), "") || dateDonation.getWaitingInterval()==null){
            donationType.setWaitingInterval(0);
        }
        else{
            donationType.setWaitingInterval(Integer.parseInt(dateDonation.getWaitingInterval()));
        }
        donationType.setName(dateDonation.getName());
        if(Objects.equals(dateDonation.getId(), "") || dateDonation.getId()==null){
            return donationType;
        }
        else {
            donationType.setId(Integer.valueOf(dateDonation.getId()));
        }
        return donationType;
    }

    public static Iterable<DonationTypeDTO> getDTODonationTypeList(Iterable<DonationType> persons) {
        ArrayList<DonationTypeDTO> donationTypeDTOS=new ArrayList<>();
        for(DonationType donationType:persons){
            DonationTypeDTO donationTypeDTO=getDTODonationType(Optional.of(donationType));
            donationTypeDTOS.add(donationTypeDTO);
        }
        return donationTypeDTOS;
    }

    public static Iterable<EventDTO> getDTOEventList(Iterable<Event> persons) {
        ArrayList<EventDTO> eventDTOS=new ArrayList<>();
        for(Event event:persons){
            EventDTO eventDTO=getDTOEvent(Optional.of(event));
            eventDTOS.add(eventDTO);
        }
        return eventDTOS;
    }

    public static EventDTO getDTOEvent(Optional<Event> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            Event event = persons.get();
            EventDTO eventDTO = new EventDTO();
            if (event.getId() != null) {
                eventDTO.setId(String.valueOf(event.getId()));
            } else {
                eventDTO.setId("");
            }

            eventDTO.setCenter(getDTOCenter(Optional.of(event.getCenter())));
            if(event.getEventAnnouncementDate()!=null){
                eventDTO.setEventAnnouncementDate(event.getEventAnnouncementDate().toString());
            }
            else{
                eventDTO.setEventAnnouncementDate("");
            }
            if(event.getEventDescription()!=null){
                eventDTO.setEventDescription(event.getEventDescription());
            }
            else{
                eventDTO.setEventDescription("");
            }
            if(event.getEventEndDate()!=null){
                eventDTO.setEventEndDate(event.getEventEndDate().toString());
            }
            else{
                eventDTO.setEventEndDate("");
            }
            if(event.getEventRequirements()!=null){
                eventDTO.setEventRequirements(event.getEventRequirements());
            }
            else{
                eventDTO.setEventRequirements("");
            }
            if(event.getEventStartDate()!=null){
                eventDTO.setEventStartDate(event.getEventStartDate().toString());
            }
            else{
                eventDTO.setEventStartDate("");
            }
            if(event.getMaxParticipants()!=0){
                eventDTO.setMaxParticipants(String.valueOf(event.getMaxParticipants()));
            }
            else{
                eventDTO.setMaxParticipants("");
            }
            if(event.getEventName()!=null){
                eventDTO.setEventName(event.getEventName());
            }
            else{
                eventDTO.setEventName("");
            }

            return eventDTO;
        }
    }

    public static Event getFromDTOEvent(EventDTO date) {
        if(date==null){
            return null;
        }
        Event event=new Event();
        Center center=getFromDTOCenter(date.getCenter());
        event.setCenter(center);
        if(!Objects.equals(date.getEventAnnouncementDate(), "") || date.getEventAnnouncementDate()!=null)
            event.setEventAnnouncementDate(LocalDateTime.parse(date.getEventAnnouncementDate()));
        else{
            event.setEventAnnouncementDate(null);
        }
        event.setEventDescription(date.getEventDescription());
        if(!Objects.equals(date.getEventEndDate(), "") || date.getEventEndDate()!=null)
            event.setEventEndDate(LocalDateTime.parse(date.getEventEndDate()));
        else{
            event.setEventEndDate(null);
        }
        event.setEventRequirements(date.getEventRequirements());
        if(!Objects.equals(date.getEventStartDate(), "") || date.getEventStartDate()!=null)
            event.setEventStartDate(LocalDateTime.parse(date.getEventStartDate()));
        else{
            event.setEventStartDate(null);
        }
        if(Objects.equals(date.getMaxParticipants(), "") || date.getMaxParticipants()==null){
            event.setMaxParticipants(0);
        }
        else{
            event.setMaxParticipants(Integer.parseInt(date.getMaxParticipants()));
        }
        event.setEventName(date.getEventName());
        if(Objects.equals(date.getId(), "") || date.getId()==null){
            return event;
        }
        else {
            event.setId(Integer.valueOf(date.getId()));
        }

        return event;
    }

    public static Iterable<InstitutionDTO> getDTOInstitutionList(Iterable<Institution> persons) {
        ArrayList<InstitutionDTO> institutionDTOS=new ArrayList<>();
        for(Institution institution:persons){
            InstitutionDTO institutionDTO=getDTOInstitution(Optional.of(institution));
            institutionDTOS.add(institutionDTO);
        }
        return institutionDTOS;
    }

    public static Institution getFromDTOInstitution(InstitutionDTO institutionDTO) {
        if(institutionDTO==null){
            return null;
        }
        Institution institution=new Institution();
        if(Objects.equals(institutionDTO.getId(), "") || institutionDTO.getId()==null){
            return institution;
        }
        else {
            institution.setId(Integer.valueOf(institutionDTO.getId()));
        }
        return institution;
    }

    public static InstitutionDTO getDTOInstitution(Optional<Institution> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            Institution institution = persons.get();
            InstitutionDTO institutionDTO = new InstitutionDTO();
            if (institution.getId() != null) {
                institutionDTO.setId(String.valueOf(institution.getId()));
            } else {
                institutionDTO.setId("");
            }
            return institutionDTO;
        }
    }

    public static LogInfoDTO getDTOLogInfo(Optional<LogInfo> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            LogInfo logInfo = persons.get();
            LogInfoDTO logInfoDTO = new LogInfoDTO();
            if (logInfo.getId() != null) {
                logInfoDTO.setId(String.valueOf(logInfo.getId()));
            } else {
                logInfoDTO.setId("");
            }
            if (logInfo.getEmail() != null) {
                logInfoDTO.setEmail(logInfo.getEmail());
            } else {
                logInfoDTO.setEmail("");
            }
            if (logInfo.getPassword() != null) {
                logInfoDTO.setPassword(logInfo.getPassword());
            } else {
                logInfoDTO.setPassword("");
            }
            if (logInfo.getSeed() != null) {
                logInfoDTO.setSeed(logInfo.getSeed());
            } else {
                logInfoDTO.setSeed("");
            }
            if (logInfo.getUsername() != null) {
                logInfoDTO.setUsername(logInfo.getUsername());
            } else {
                logInfoDTO.setUsername("");
            }
            return logInfoDTO;
        }
    }

    public static Iterable<LogInfoDTO> getDTOLogInfoList(Iterable<LogInfo> persons) {
        ArrayList<LogInfoDTO> logInfoDTOS=new ArrayList<>();
        for(LogInfo logInfo:persons){
            LogInfoDTO logInfoDTO=getDTOLogInfo(Optional.of(logInfo));
            logInfoDTOS.add(logInfoDTO);
        }
        return logInfoDTOS;
    }

    public static Iterable<MedicalInfoDTO> getDTOMedicalInfoList(Iterable<MedicalInfo> persons) {
        ArrayList<MedicalInfoDTO> medicalInfoDTOS=new ArrayList<>();
        for(MedicalInfo medicalInfo:persons){
            MedicalInfoDTO medicalInfoDTO=getDTOMedicalInfo(Optional.of(medicalInfo));
            medicalInfoDTOS.add(medicalInfoDTO);
        }
        return medicalInfoDTOS;
    }

    public static MedicalInfo getFromDTOMedicalInfo(MedicalInfoDTO medicalInfoDTO) {
        if(medicalInfoDTO==null){
            return null;
        }
        MedicalInfo medicalInfo=new MedicalInfo();
        if(Objects.equals(medicalInfoDTO.getId(), "") || medicalInfoDTO.getId()==null){
            return medicalInfo;
        }
        else {
            medicalInfo.setId(Integer.valueOf(medicalInfoDTO.getId()));
        }
        if(Objects.equals(medicalInfoDTO.getBloodType(), "") || medicalInfoDTO.getBloodType()==null){
            medicalInfo.setBloodType(null);
        }
        else{
            medicalInfo.setBloodType(BloodType.valueOf(medicalInfoDTO.getBloodType()));
        }
        if(Objects.equals(medicalInfoDTO.getEligibility(), "") || medicalInfoDTO.getEligibility()==null ){
            medicalInfo.setEligibility(false);
        }
        else{
            medicalInfo.setEligibility(Boolean.parseBoolean(medicalInfoDTO.getEligibility()));
        }
        if(Objects.equals(medicalInfoDTO.getRh(), "") || medicalInfoDTO.getRh()==null){
            medicalInfo.setRh(null);
        }
        else {
            medicalInfo.setRh(Rh.valueOf(medicalInfoDTO.getRh()));
        }
        return medicalInfo;
    }

    public static PersonalDataDTO getDTOPersonalData(Optional<PersonalData> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            PersonalData personalData = persons.get();
            PersonalDataDTO personalDataDTO = new PersonalDataDTO();
            if (personalData.getId() != null) {
                personalDataDTO.setId(String.valueOf(personalData.getId()));
            } else {
                personalDataDTO.setId("");
            }
            if (personalData.getBirthDate() != null) {
                personalDataDTO.setBirthDate(personalData.getBirthDate().toString());
            } else {
                personalDataDTO.setBirthDate("");
            }
            if (personalData.getFirstName() != null) {
                personalDataDTO.setFirstName(personalData.getFirstName());
            } else {
                personalDataDTO.setFirstName("");
            }
            if (personalData.getLastName() != null) {
                personalDataDTO.setLastName(personalData.getLastName());
            } else {
                personalDataDTO.setLastName("");
            }
            if (personalData.getSex() != null) {
                personalDataDTO.setSex(personalData.getSex());
            } else {
                personalDataDTO.setSex("");
            }
            if (personalData.getCnp() != null) {
                personalDataDTO.setCnp(personalData.getCnp());
            } else {
                personalDataDTO.setCnp("");
            }
            if (personalData.getPhoneNumber() != null) {
                personalDataDTO.setPhoneNumber(personalData.getPhoneNumber());
            } else {
                personalDataDTO.setPhoneNumber("");
            }
            return personalDataDTO;
        }
    }

    public static Iterable<PersonalDataDTO> getDTOPersonalDataList(Iterable<PersonalData> persons) {
        ArrayList<PersonalDataDTO> personalDataDTOS=new ArrayList<>();
        for(PersonalData personalData:persons){
            PersonalDataDTO personalDataDTO=getDTOPersonalData(Optional.of(personalData));
            personalDataDTOS.add(personalDataDTO);
        }
        return personalDataDTOS;
    }

    public static PersonalData getFromDTOPersonalData(PersonalDataDTO institution) {
        if(institution==null){
            return null;
        }
        PersonalData personalData=new PersonalData();
        personalData.setAddress(getFromDTOAddress(institution.getAddress()));
        if(Objects.equals(institution.getId(), "") || institution.getId()==null){
            return personalData;
        }
        else {
            personalData.setId(Integer.valueOf(institution.getId()));
        }
        if(Objects.equals(institution.getCnp(), "") || institution.getCnp()==null){
            personalData.setCnp("");
        }
        else{
            personalData.setCnp(institution.getCnp());
        }
        if(Objects.equals(institution.getPhoneNumber(), "") || institution.getPhoneNumber()==null){
            personalData.setPhoneNumber("");
        }
        else{
            personalData.setPhoneNumber(institution.getPhoneNumber());
        }
        if(Objects.equals(institution.getBirthDate(), "") || institution.getBirthDate()==null){
            personalData.setBirthDate(null);
        }
        else{
            personalData.setBirthDate(LocalDate.parse(institution.getBirthDate()));
        }
        if(Objects.equals(institution.getFirstName(), "") || institution.getFirstName()==null){
            personalData.setFirstName("");
        }
        else{
            personalData.setFirstName(institution.getFirstName());
        }
        if(Objects.equals(institution.getLastName(), "") || institution.getLastName()==null){
            personalData.setLastName("");
        }
        else{
            personalData.setLastName(institution.getLastName());
        }
        if(Objects.equals(institution.getSex(), "") || institution.getSex()==null){
            personalData.setSex("");
        }
        else {
            personalData.setSex(institution.getSex());
        }
        return personalData;
    }

    public static Iterable<PersonDTO> getDTOPersonList(Iterable<Person> persons) {
        ArrayList<PersonDTO> personDTOS=new ArrayList<>();
        for(Person person:persons){
            PersonDTO personDTO=getDTOPerson(Optional.of(person));
            personDTOS.add(personDTO);
        }
        return personDTOS;
    }

    public static RetrivedCouponsDTO getDTORetrivedCoupon(Optional<RetrievedCoupons> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            RetrievedCoupons retrievedCoupons = persons.get();
            RetrivedCouponsDTO retrivedCouponsDTO = new RetrivedCouponsDTO();
            if (retrievedCoupons.getId() != null) {
                retrivedCouponsDTO.setId(String.valueOf(retrievedCoupons.getId()));
            } else {
                retrivedCouponsDTO.setId("");
            }

            retrivedCouponsDTO.setCoupon(getDTOCoupon(Optional.of(retrievedCoupons.getCoupon())));

            if(retrievedCoupons.getExpirationDate()!=null){
                retrivedCouponsDTO.setExpirationDate(retrievedCoupons.getExpirationDate().toString());
            }
            else{
                retrivedCouponsDTO.setExpirationDate("");
            }
            if(retrievedCoupons.getReceivedDate()!=null){
                retrivedCouponsDTO.setReceivedDate(retrievedCoupons.getReceivedDate().toString());
            }
            else{
                retrivedCouponsDTO.setReceivedDate("");
            }
            return retrivedCouponsDTO;
        }
    }

    public static Iterable<RetrivedCouponsDTO> getDTORetrivedCouponList(Iterable<RetrievedCoupons> persons) {
        ArrayList<RetrivedCouponsDTO> retrivedCouponsDTOS=new ArrayList<>();
        for(RetrievedCoupons retrievedCoupons:persons){
            RetrivedCouponsDTO retrivedCouponsDTO=getDTORetrivedCoupon(Optional.of(retrievedCoupons));
            retrivedCouponsDTOS.add(retrivedCouponsDTO);
        }
        return retrivedCouponsDTOS;
    }

    public static RetrievedCoupons getFromDTORetrivedCoupon(RetrivedCouponsDTO institution) {
        if(institution==null){
            return null;
        }
        RetrievedCoupons retrievedCoupons=new RetrievedCoupons();
        Coupon coupon=getFromDTOCoupon(institution.getCoupon());
        retrievedCoupons.setCoupon(coupon);
        if(!Objects.equals(institution.getExpirationDate(), "") || institution.getExpirationDate()!=null)
            retrievedCoupons.setExpirationDate(LocalDateTime.parse(institution.getExpirationDate()));
        else{
            retrievedCoupons.setExpirationDate(null);
        }
        if(!Objects.equals(institution.getReceivedDate(), "") || institution.getReceivedDate()!=null)
            retrievedCoupons.setReceivedDate(LocalDateTime.parse(institution.getReceivedDate()));
        else{
            retrievedCoupons.setReceivedDate(null);
        }
        if(Objects.equals(institution.getId(), "") || institution.getId()==null){
            return retrievedCoupons;
        }
        else {
            retrievedCoupons.setId(Integer.valueOf(institution.getId()));
        }
        return retrievedCoupons;
    }

    public static Student getFromDTOStudent(StudentDTO institution) {
        if(institution==null){
            return null;
        }
        Student student=new Student();
        student.setMedicalInfo(getFromDTOMedicalInfo(institution.getMedicalInfo()));
        student.setPersonalDate(getFromDTOPersonalData(institution.getPersonalDate()));
        student.setPersonLogInfo(getFromDTOLogInfo(institution.getPersonLogInfo()));
        student.setInstitution(getFromDTOInstitution(institution.getUniversity()));
        if(Objects.equals(institution.getId(), "") || institution.getId()==null){
            return student;
        }
        else {
            student.setId(Integer.valueOf(institution.getId()));
        }
        if(Objects.equals(institution.getYear(), "") || institution.getYear()==null){
            student.setYear(0);
        }
        else{
            student.setYear(Integer.parseInt(institution.getYear()));
        }
        if(Objects.equals(institution.getFaculty(), "") || institution.getFaculty()==null){
            student.setFaculty("");
        }
        else{
            student.setFaculty(institution.getFaculty());
        }
        if(Objects.equals(institution.getGroup(), "") || institution.getGroup()==null){
            student.setGroup("");
        }
        else{
            student.setGroup(institution.getGroup());
        }
        if(Objects.equals(institution.getDepartment(), "") || institution.getDepartment()==null){
            student.setDepartment("");
        }
        else{
            student.setDepartment(institution.getDepartment());
        }
        if(institution.getPoints()==0){
            student.setPoints(0);
        }
        else{
            student.setPoints(institution.getPoints());
        }
        return student;
    }

    public static StudentDTO getDTOStudent(Optional<Student> persons) {
        if(persons.isEmpty()){
            return null;
        }
        else {
            Student student = persons.get();
            StudentDTO studentDTO = new StudentDTO();
            if (student.getId() != null) {
                studentDTO.setId(String.valueOf(student.getId()));
            } else {
                studentDTO.setId("");
            }
            studentDTO.setMedicalInfo(getDTOMedicalInfo(Optional.of(student.getMedicalInfo())));
            studentDTO.setPersonalDate(getDTOPersonalData(Optional.of(student.getPersonalDate())));
            studentDTO.setPersonLogInfo(getDTOLogInfo(Optional.of(student.getPersonLogInfo())));
            studentDTO.setUniversity(getDTOInstitution(Optional.of(student.getInstitution())));
            if(student.getYear()!=0){
                studentDTO.setYear(String.valueOf(student.getYear()));
            }
            else{
                studentDTO.setYear("");
            }
            if(student.getFaculty()!=null){
                studentDTO.setFaculty(student.getFaculty());
            }
            else{
                studentDTO.setFaculty("");
            }
            if(student.getGroup()!=null){
                studentDTO.setGroup(student.getGroup());
            }
            else{
                studentDTO.setGroup("");
            }
            if(student.getDepartment()!=null){
                studentDTO.setDepartment(student.getDepartment());
            }
            else{
                studentDTO.setDepartment("");
            }
            if(student.getPoints()!=0){
                studentDTO.setPoints(student.getPoints());
            }
            else{
                studentDTO.setPoints(0);
            }
            return studentDTO;
        }
    }

    public static Iterable<StudentDTO> getDTOStudentList(Iterable<Student> persons) {
        ArrayList<StudentDTO> studentDTOS=new ArrayList<>();
        for(Student student:persons){
            StudentDTO studentDTO=getDTOStudent(Optional.of(student));
            studentDTOS.add(studentDTO);
        }
        return studentDTOS;
    }

    public static Iterable<Address> getFromDTOAddressList(Iterable<AddressDTO> addressDTOS) {
        ArrayList<Address> addresses=new ArrayList<>();
        for(AddressDTO addressDTO:addressDTOS){
            Address address=getFromDTOAddress(addressDTO);
            addresses.add(address);
        }
        return addresses;
    }

    public static Iterable<BloodTest> getFromDTOBloodTestList(Iterable<BloodTestDTO> addressDTOS) {
        ArrayList<BloodTest> bloodTests=new ArrayList<>();
        for(BloodTestDTO bloodTestDTO:addressDTOS){
            BloodTest bloodTest=getFromDTOBloodTest(bloodTestDTO);
            bloodTests.add(bloodTest);
        }
        return bloodTests;
    }

    public static Iterable<Center> getFromDTOCenterList(Iterable<CenterDTO> addressDTOS) {
        ArrayList<Center> centers=new ArrayList<>();
        for(CenterDTO centerDTO:addressDTOS){
            Center center=getFromDTOCenter(centerDTO);
            centers.add(center);
        }
        return centers;
    }

    public static Iterable<Coupon> getFromDTOCouponList(Iterable<CouponDTO> addressDTOS) {
        ArrayList<Coupon> coupons=new ArrayList<>();
        for(CouponDTO couponDTO:addressDTOS){
            Coupon coupon=getFromDTOCoupon(couponDTO);
            coupons.add(coupon);
        }
        return coupons;
    }

    public static Iterable<Donation> getFromDTODonationList(Iterable<DonationDTO> addressDTOS) {
        ArrayList<Donation> donations=new ArrayList<>();
        for(DonationDTO donationDTO:addressDTOS){
            Donation donation=getFromDTODonation(donationDTO);
            donations.add(donation);
        }
        return donations;
    }

    public static Iterable<DonationType> getFROMDTODonationTypeList(Iterable<DonationTypeDTO> addressDTOS) {
        ArrayList<DonationType> donationTypes=new ArrayList<>();
        for(DonationTypeDTO donationTypeDTO:addressDTOS){
            DonationType donationType=getFROMDTODonationType(donationTypeDTO);
            donationTypes.add(donationType);
        }
        return donationTypes;
    }

    public static Iterable<Event> getFromDTOEventList(Iterable<EventDTO> addressDTOS) {
        ArrayList<Event> events=new ArrayList<>();
        for(EventDTO eventDTO:addressDTOS){
            Event event=getFromDTOEvent(eventDTO);
            events.add(event);
        }
        return events;
    }

    public static Iterable<Institution> getFromDTOInstitutionList(Iterable<InstitutionDTO> addressDTOS) {
        ArrayList<Institution> institutions=new ArrayList<>();
        for(InstitutionDTO institutionDTO:addressDTOS){
            Institution institution=getFromDTOInstitution(institutionDTO);
            institutions.add(institution);
        }
        return institutions;
    }

    public static Iterable<LogInfo> getFromDTOLogInfoList(Iterable<LogInfoDTO> addressDTOS) {
        ArrayList<LogInfo> logInfos=new ArrayList<>();
        for(LogInfoDTO logInfoDTO:addressDTOS){
            LogInfo logInfo=getFromDTOLogInfo(logInfoDTO);
            logInfos.add(logInfo);
        }
        return logInfos;
    }

    public static Iterable<MedicalInfo> getFromDTOMedicalInfoList(Iterable<MedicalInfoDTO> addressDTOS) {
        ArrayList<MedicalInfo> medicalInfos=new ArrayList<>();
        for(MedicalInfoDTO medicalInfoDTO:addressDTOS){
            MedicalInfo medicalInfo=getFromDTOMedicalInfo(medicalInfoDTO);
            medicalInfos.add(medicalInfo);
        }
        return medicalInfos;
    }

    public static Iterable<PersonalData> getFromDTOPersonalDataList(Iterable<PersonalDataDTO> addressDTOS) {
        ArrayList<PersonalData> personalDatas=new ArrayList<>();
        for(PersonalDataDTO personalDataDTO:addressDTOS){
            PersonalData personalData=getFromDTOPersonalData(personalDataDTO);
            personalDatas.add(personalData);
        }
        return personalDatas;
    }

    public static Iterable<Person> getFromDTOPersonList(Iterable<PersonDTO> addressDTOS) {
        ArrayList<Person> persons=new ArrayList<>();
        for(PersonDTO personDTO:addressDTOS){
            Person person=getFromDTOPerson(personDTO);
            persons.add(person);
        }
        return persons;
    }



    public static Iterable<RetrievedCoupons> getFromDTORetrievedCouponsList(Iterable<RetrivedCouponsDTO> addressDTOS) {
        ArrayList<RetrievedCoupons> retrievedCoupons=new ArrayList<>();
        for(RetrivedCouponsDTO retrievedCouponsDTO:addressDTOS){
            RetrievedCoupons retrievedCoupon=getFromDTORetrivedCoupon(retrievedCouponsDTO);
            retrievedCoupons.add(retrievedCoupon);
        }
        return retrievedCoupons;
    }

    public static Iterable<Student> getFromDTOStudentList(Iterable<StudentDTO> addressDTOS) {
        ArrayList<Student> students=new ArrayList<>();
        for(StudentDTO studentDTO:addressDTOS){
            Student student=getFromDTOStudent(studentDTO);
            students.add(student);
        }
        return students;
    }
}


