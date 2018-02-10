/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import common.ILoginable;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 *
 * @author Anelia
 */
public class FXMLDocumentController{

    @FXML
    private Label lblPassword;
    @FXML
    private Label lblUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private TextField txtUsername;
    @FXML
    private Button btnLogin;

    public ILoginable loginObj;

   
    public void initializeRMI() {
         try {
            Registry registry = LocateRegistry.getRegistry(1099);

            try {
                loginObj = (ILoginable) registry.lookup("Login");  
                
                
            } catch (NotBoundException | AccessException ex) {
                System.out.println(ex);
            }
            System.out.println("Server object " + loginObj + " found");
        } catch (RemoteException ex) {
            System.out.println("Cannot connect to server!");
        }
    }

    @FXML
    private void onBtnLoginClicked(ActionEvent event) throws IOException {
        try {
            
            String userName = txtUsername.getText();
            String password = txtPassword.getText();
            
            initializeRMI();
            //LoginWrapper login=new LoginWrapper((Login)loginObj.getLoginWrapper());
            
            Parent root1;
            if (!(loginObj.checkCredentials(userName,password))) {
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorWindow.fxml"));
                    root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                } catch (IOException e) {
                    System.out.println("Error." + e);
                }
            }else{
                         FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/reusableEncryptionView/FXMLEncryptionPane.fxml"));
                    root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                        }
        } catch (RemoteException e) {
            System.out.println("Error." + e);
        }

    }

}
