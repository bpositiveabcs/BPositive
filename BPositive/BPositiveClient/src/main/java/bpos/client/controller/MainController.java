package bpos.client.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class MainController {
    @FXML
    private ListView<String> listEvents;

    @FXML
    private ListView<String> listUsers;

    @FXML
    private ListView<String> listCenters;



    private ObservableList<String> getEventNamesFromDatabase() {
        ObservableList<String> eventNames = FXCollections.observableArrayList();

        return eventNames;
    }

    @FXML
    public void initialize() {

        ObservableList<String> eventNames = getEventNamesFromDatabase();
        listEvents.setItems(eventNames);
    }
}


