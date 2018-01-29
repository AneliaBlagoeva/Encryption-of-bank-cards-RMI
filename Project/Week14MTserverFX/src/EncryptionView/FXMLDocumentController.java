/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EncryptionView;

import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import rmiObject.Chryptable;

/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Button btnEncode;
    @FXML
    private Label label;
    @FXML
    private Button btnDecode;
    @FXML
    private TextField txtCode;
    @FXML
    private TextField txtResult;

    Chryptable encryption = null;
    private final StringProperty output = new SimpleStringProperty("");

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        String host = "localhost";
        System.out.println(host);
        try {
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            encryption = (Chryptable) registry.lookup("Encryption");

            System.out.println("Server object " + encryption + " found");
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    @FXML
    private void onEncodeClicked(ActionEvent event) {
        try {
            String result = encryption.encode(txtCode.getText());
            txtResult.textProperty()
                         .setValue(result);
        } catch (Exception e) {
            System.out.println("Error while encoding");
        }

    }

    @FXML
    private void onDecodeClicked(ActionEvent event) {

        try {
            String result = encryption.decode(txtCode.getText());
            txtResult.textProperty()
                         .setValue(result);
        } catch (Exception e) {
            System.out.println("Error while decoding");
        }

    }
}
