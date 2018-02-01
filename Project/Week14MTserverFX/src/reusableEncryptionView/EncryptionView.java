/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusableEncryptionView;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import server.Chryptable;

/**
 *
 * @author Administrator
 */
public class EncryptionView extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("FXMLEncryptionPane.fxml"));

       // fxmlLoader.setRoot(this);
       //fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            Chryptable encryption = null;
            try {
                encryption = (Chryptable) registry.lookup("Encryption");
            } catch (NotBoundException ex) {
                System.out.println(ex);
            } catch (AccessException ex) {
                System.out.println(ex);
            }
            System.out.println("Server object " + encryption + " found");
        } catch (Exception ex) {
            System.out.println(ex);
        }

        launch(args);

    }

}
