/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusableEncryptionView;

import common.Chryptable;
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
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class FXMLEncryptionPaneController extends AnchorPane {

    @FXML
    private Label lblResult;
    @FXML
    private TextField txtCode;
    @FXML
    private Button btnDecode;
    @FXML
    private Button btnEncode;

    Chryptable encryption = null;

    public FXMLEncryptionPaneController() {
        initializeRMI();
           
    }
    @FXML
    private void btnEncodeClicked(ActionEvent event) throws IOException {
        try {
            String result = encryption.encode(txtCode.getText());

            if(!"".equals(result)){
            lblResult.textProperty().setValue(result);
           // encryption.addCard(result);
            }
            else{
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("ErrorWindow.fxml"));
                   Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                    }
        } catch (RemoteException e) {
            System.out.println("Error while encoding");
        }
    }

    @FXML
    private void btnDecodeClicked(ActionEvent event) {
        try {
            
            String result = encryption.decode(txtCode.getText());
            lblResult.textProperty()
                    .setValue(result);
        } catch (RemoteException e) {
            System.out.println("Error while decoding");
        }

    }

    public void initializeRMI() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            try {
                encryption = (Chryptable) registry.lookup("Encryption");
            } catch (NotBoundException | AccessException ex) {
                System.out.println(ex);
            }
            System.out.println("Server object " + encryption + " found");
        } catch (RemoteException ex) {
            System.out.println("Cannot connect to server!");
        }
    }
}
