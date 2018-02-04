/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import server.ILoginable;

/**
 *
 * @author Anelia
 */
public class LoginApp extends Application {
    
    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            ILoginable login = null;
            try {
                login = (ILoginable) registry.lookup("Login");    
            } catch (NotBoundException ex) {
                System.out.println(ex);
            } catch (AccessException ex) {
                System.out.println(ex);
            }
            System.out.println("Server object " + login + " found");
        } catch (Exception ex) {
            System.out.println("Cannot connect to server!");
        }

        launch(args);
    }
    
}
