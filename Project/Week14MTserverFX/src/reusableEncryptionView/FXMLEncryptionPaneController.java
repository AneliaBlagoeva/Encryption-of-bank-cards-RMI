/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusableEncryptionView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import server.Chryptable;

/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class FXMLEncryptionPaneController extends AnchorPane implements Initializable{

    @FXML
    private Label lblResult;
    @FXML
    private TextField txtCode;

    Chryptable encryption=null;
    @FXML
    private Button btnDecode;
    @FXML
    private Button btnEncode;

    
    public FXMLEncryptionPaneController() {
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("FXMLEncriptionPane.fxml"));

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
        FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("FXMLEncriptionPane.fxml"));

        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);

        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }
}