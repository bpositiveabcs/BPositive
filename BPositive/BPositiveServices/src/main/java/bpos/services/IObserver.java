package bpos.services;

import bpos.model.Donation;
import bpos.model.Event;

import java.rmi.ServerException;

public interface IObserver {
    void eventHappened(Event event) throws ServicesExceptions;
    void donationRegistered(Donation donation) throws ServicesExceptions;
}
