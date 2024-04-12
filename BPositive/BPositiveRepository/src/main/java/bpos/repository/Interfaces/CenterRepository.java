package bpos.repository.Interfaces;

import bpos.model.Center;

public interface CenterRepository extends IRepository<Integer, Center> {
    Center findByUsername(String username);
    Center findByEmail(String email);
    Center findByPhoneNumber(String phoneNumber);
    Iterable<Center> findByName(String name);
}
