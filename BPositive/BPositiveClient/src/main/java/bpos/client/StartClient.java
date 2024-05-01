package bpos.client;

import bpos.client.controller.LogInController;
import bpos.client.controller.MainController;
import bpos.networking.rpc.ServicesRpcProxy;
import bpos.services.IServiceImpl;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Properties;

public class StartClient extends Application {
    private Stage primaryStage;

    private static int defaultChatPort = 55556;
    private static String defaultServer = "localhost";

    @Override
    public void start(Stage primaryStage) throws Exception {
        System.out.println("In start");
        Properties clientProps = new Properties();
        try {
            clientProps.load(StartClient.class.getClassLoader().getResourceAsStream("client.properties"));
            System.out.println("Client properties set. ");
            clientProps.list(System.out);
        } catch (IOException e) {
            System.err.println("Cannot find client.properties " + e);
            return;
        }
        String serverIP = clientProps.getProperty("server.host", defaultServer);
        int serverPort = defaultChatPort;
        try {
            serverPort = Integer.parseInt(clientProps.getProperty("server.port"));
        } catch (NumberFormatException ex) {
            System.err.println("Wrong port number " + ex.getMessage());
            System.out.println("Using default port: " + defaultChatPort);
        }
        System.out.println("Using server IP " + serverIP);
        System.out.println("Using server port " + serverPort);
        IServiceImpl server = new ServicesRpcProxy(serverIP, serverPort);


//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main-admin.fxml"));
//        Parent root = loader.load();
//        MainController controller = loader.getController();
//        Scene scene = new Scene(root);
//        primaryStage.setScene(scene);
//        controller.initialize();
//
//        primaryStage.show();

//        FXMLLoader loader = new FXMLLoader(getClass().getResource("/main-admin.fxml"));
//        Parent root = loader.load();
//        MainController controller = loader.getController();
//
//        // Setează serverul înainte de a apela initialize()
//        controller.setServer(server);
//
//
//        // Set up the primary stage
//        primaryStage.setTitle("Your Application Title");
//        primaryStage.setScene(new Scene(root, 800, 600));
//        primaryStage.show();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/login-screen.fxml"));
        Parent root = loader.load();
        LogInController controller = loader.getController();
        controller.setProperties(server);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.show();





    }

    public static void main(String[] args) {
        launch(args);
    }

}
