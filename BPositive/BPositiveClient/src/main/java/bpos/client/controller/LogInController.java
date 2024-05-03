package bpos.client.controller;

import bpos.model.LogInfo;
import bpos.model.Person;
import bpos.services.IObserver;
import bpos.services.IServiceImpl;
import bpos.services.ServicesExceptions;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

public class LogInController {

    @FXML
    public TextField usernameTextField;
    @FXML
    public PasswordField passwordTextField;

    IServiceImpl service = null;
    IObserver obs = null;



    public void initialize() {
        System.out.println("LogInController initialized");
    }

    public void setProperties(IServiceImpl server) {
        this.service = server;

    }

    public void handleLogin() throws IOException, ServicesExceptions {
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main-admin.fxml"));
        Parent userViewParent = loader.load();
        MainController userController = loader.getController();

        //Optional<Person> user = service.login(new LogInfo(username, password, "", ""), obs);
        LogInfo loginfo_user = service.findByUsernameLogInfo(username);
        if(!Objects.equals(loginfo_user.getPassword(), password)){
            System.out.println("Password is not correct");
            passwordTextField.clear();
            return;
        }
        System.out.println(loginfo_user.toString());
        Optional<Person> user = service.login(loginfo_user, obs);


        if (user.isPresent() && user.get().getPersonLogInfo().getPassword().equals(password)) {
            System.out.println("Login successful");

            userController.setServer(service);
            userController.setLoggedUser(user);

            Scene userViewScene = new Scene(userViewParent);
            Stage stage = (Stage) usernameTextField.getScene().getWindow();
            stage.setScene(userViewScene);
            stage.show();
        } else {
            System.out.println("Login failed");
            passwordTextField.clear();
            usernameTextField.clear();
        }
    }
}
