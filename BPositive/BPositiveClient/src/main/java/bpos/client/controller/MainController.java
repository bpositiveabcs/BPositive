package bpos.client.controller;

import bpos.model.Event;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

import java.sql.SQLException;
import java.util.List;


public class MainController {
    @FXML
    private ListView<Event> listEvents;

    ObservableList<Event> eventList = FXCollections.observableArrayList();

    private IServiceImpl server;

    public void setServer(IServiceImpl server) throws ServicesExceptions {
        this.server = server;
        refreshListEvents();
    }



    public void refreshListEvents() throws ServicesExceptions {
        this.eventList.clear(); // sterge toate elementele existente din eventList
        Iterable<Event> excursii = server.findAllEvents();
        for (Event excursie : excursii) {
            this.eventList.add(excursie);
        }
        listEvents.setItems(eventList); // Seteaza lista actualizata in ListView
    }


}






//package bpos.client.controller;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.fxml.FXML;
//import javafx.scene.control.ListView;
//
//public class MainController {
//    @FXML
//    private ListView<String> listEvents;
//
//    @FXML
//    private ListView<String> listUsers;
//
//    @FXML
//    private ListView<String> listCenters;
//
//
//
//    private ObservableList<String> getEventNamesFromDatabase() {
//        ObservableList<String> eventNames = FXCollections.observableArrayList();
//
//        return eventNames;
//    }
//
//    @FXML
//    public void initialize() {
//
//        ObservableList<String> eventNames = getEventNamesFromDatabase();
//        listEvents.setItems(eventNames);
//    }
//}


