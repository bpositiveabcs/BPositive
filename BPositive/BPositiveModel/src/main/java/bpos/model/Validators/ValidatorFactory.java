package bpos.model.Validators;

import bpos.model.Validators.Enums.Interfaces.Factory;
import bpos.model.Validators.Enums.Interfaces.Validator;
import bpos.model.Validators.Enums.ValidatorStrategy;
import bpos.model.Exceptions.ValidatorException;
import bpos.model.Validators.Implementation.*;

public class ValidatorFactory implements Factory {
    private static ValidatorFactory instance;
    @Override
    public Validator createValidator(ValidatorStrategy validatorStrategy) throws ValidatorException{
        switch (validatorStrategy)
        {
            case ADDRESS:
                return new AddressValidator();
            case BLOODTEST:
                            return new BloodTestValidator();
            case CENTER:
                            return new CenterValidator();
            case COUPON:

                            return new CouponValidator();
            case DONATION:

                            return new DonationValidator();
            case DONATIONTYPE:

                                return new DonationTypeValidator();
            case EVENT:

                                    return new EventValidator();
            case INSTITUTION:

                                        return new InstitutionValidator();
            case LOGINFO:

                                            return new LogInfoValidator();
            case MEDICALINFO:
                return new MedicalInfoValidator();
            case PERSON:
                return new PersonValidator();
            case PERSONALDATA:
                return new PersonalDataValidator();
            case RETRIEVEDCOUPONS:
                return new RetrievedCouponsValidator();
            case STUDENT:
                return new StudentValidator();
            default:
                throw new ValidatorException("Invalid Validator Strategy"); }

    }
    public static ValidatorFactory getInstance()
    {
        if(instance==null)
        {
            instance=new ValidatorFactory();
        }
        return instance;
    }
}
