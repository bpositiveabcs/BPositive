package bpos.model.Validators.Enums.Interfaces;


import bpos.model.Validators.Enums.ValidatorStrategy;

public interface Factory {
    Validator createValidator(ValidatorStrategy validatorStrategy);
}
