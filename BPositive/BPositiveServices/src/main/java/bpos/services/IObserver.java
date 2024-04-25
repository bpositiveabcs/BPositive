package bpos.services;

import bpos.model.Center;
import bpos.model.Donation;
import bpos.model.Event;
import bpos.model.Person;

import java.rmi.ServerException;

public interface IObserver {
    void loginPersonEvent(Person password) throws ServicesExceptions;
    void logoutPersonEvent(Person password) throws ServicesExceptions;
    void loginCenterEvent(Center password) throws ServicesExceptions;
    void logoutCenterEvent(Center password) throws ServicesExceptions;
    void eventHappened(Event event) throws ServicesExceptions;
    void donationRegistered(Donation donation) throws ServicesExceptions;
}
