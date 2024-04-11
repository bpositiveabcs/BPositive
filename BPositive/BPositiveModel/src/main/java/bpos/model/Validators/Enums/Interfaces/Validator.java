package bpos.model.Validators.Enums.Interfaces;


import bpos.model.Exceptions.ValidatorException;

public interface Validator<T> {
    void validate(T entity) throws ValidatorException;
}
