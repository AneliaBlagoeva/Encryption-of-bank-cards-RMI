/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusableEncryptionView;

import java.io.IOException;
import java.net.URL;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import rmiObject.Chryptable;

/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class FXMLEncryptionPaneController extends AnchorPane implements Initializable {

    @FXML
    private Label lblResult;
    @FXML
    private TextField txtCode;

    Chryptable encryption = null;
    @FXML
    private AnchorPane pane;
    @FXML
    private Button btnEncode;
    @FXML
    private Button btnDecode;

    /**
     * Initializes the controller class.
     */

    public FXMLEncryptionPaneController() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("FXMLDocument.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
        
    @FXML
    private void btnEncodeClicked(ActionEvent event) {
        try {
            String result = encryption.encode(txtCode.getText());
            lblResult.textProperty()
                    .setValue(result);
        } catch (Exception e) {
            System.out.println("Error while encoding");
        }
    }

    @FXML
    private void btnDecodeClicked(ActionEvent event) {
        try {
            String result = encryption.decode(txtCode.getText());
            lblResult.textProperty()
                    .setValue(result);
        } catch (Exception e) {
            System.out.println("Error while decoding");
        }

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
}
