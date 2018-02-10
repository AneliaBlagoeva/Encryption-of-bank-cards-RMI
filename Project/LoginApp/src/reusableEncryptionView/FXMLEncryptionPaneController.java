/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusableEncryptionView;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import server.Chryptable;
import server.Encryption;

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

//    public FXMLEncryptionPaneController() {
//        FXMLLoader fxmlLoader = new FXMLLoader(
//                getClass().getResource("FXMLEncriptionPane.fxml"));
//
//        fxmlLoader.setRoot(this);
//        fxmlLoader.setController(this);
//
//        try {
//            fxmlLoader.load();
//        } catch (IOException exception) {
//            throw new RuntimeException(exception);
//        }
//           
//    }
    @FXML
    private void btnEncodeClicked(ActionEvent event) {
        try {
            encryption = new Encryption(txtCode.getText());
            String result = encryption.encode();
            lblResult.textProperty()
                    .setValue(result);
        } catch (RemoteException e) {
            System.out.println("Error while encoding");
        }
    }

    @FXML
    private void btnDecodeClicked(ActionEvent event) {
        try {
            encryption = new Encryption(txtCode.getText());
            String result = encryption.decode();
            lblResult.textProperty()
                    .setValue(result);
        } catch (RemoteException e) {
            System.out.println("Error while decoding");
        }

    }

    public void initializeRMI() {
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            Chryptable encryption = null;
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
