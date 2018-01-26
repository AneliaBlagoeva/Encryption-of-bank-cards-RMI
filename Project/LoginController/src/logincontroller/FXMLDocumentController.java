/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logincontroller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Label lblUsername;
    @FXML
    private TextField txtUsername;
    @FXML
    private Label lblPassword;
    @FXML
    private TextField txtPassword;
    @FXML
    private Button btnLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnClicked(ActionEvent event) {
        System.out.println("Click!");
    }
    
}
