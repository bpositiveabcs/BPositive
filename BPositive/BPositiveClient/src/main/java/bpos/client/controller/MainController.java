package bpos.client.controller;

import bpos.model.Center;
import bpos.model.Event;
import bpos.model.LogInfo;
import bpos.model.Person;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.util.List;
import java.util.Optional;


public class MainController {
    @FXML
    private ListView<Event> listEvents;

    @FXML
    private ListView<Center> listCenters;

    @FXML
    private ListView<LogInfo> listUsers;

    ObservableList<Event> eventList = FXCollections.observableArrayList();

    ObservableList<Center> centerList = FXCollections.observableArrayList();
    ObservableList<LogInfo> userList = FXCollections.observableArrayList();

    private IServiceImpl server;
    private Optional<Person> loggedUser;

    public void setServer(IServiceImpl server) throws ServicesExceptions {
        this.server = server;
        refreshListEvents();
        refreshListCenters();
        refreshListUsers();
    }

    public void setLoggedUser(Optional<Person> user) {
        this.loggedUser = user;

    }



    public void refreshListEvents() throws ServicesExceptions {
        this.eventList.clear();
        Iterable<Event> excursii = server.findAllEvents();
        for (Event excursie : excursii) {
            this.eventList.add(excursie);
        }
        listEvents.setItems(eventList);
    }

    public void refreshListCenters() throws ServicesExceptions {
        this.centerList.clear();
        Iterable<Center> centers = server.findAllCenters();
        for (Center center : centers) {
            this.centerList.add(center);
        }
        listCenters.setItems(centerList);
    }

    public void refreshListUsers() throws ServicesExceptions {
        this.userList.clear();
        List<LogInfo> users = (List<LogInfo>) server.findAllLogInfos();
        for (LogInfo user : users) {
            this.userList.add(user);
        }
        listUsers.setItems(userList);
    }


}




