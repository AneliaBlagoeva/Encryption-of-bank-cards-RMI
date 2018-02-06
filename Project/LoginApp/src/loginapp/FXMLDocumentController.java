/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginapp;

import deserialization.DeserealizationWarpper;
import deserialization.Users;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import server.Login;

/**
 *
 * @author Anelia
 */
public class FXMLDocumentController implements Initializable {

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
    
    public Login login=null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void onBtnLoginClicked(ActionEvent event) {
        try{
        Users u=DeserealizationWarpper.deserealization();
        String userName=txtUsername.getText();
        String password=txtPassword.getText();
        login=new Login(userName,password);
        login.checkCredentials(u);
        }catch(Exception e){
            System.out.println("Error.");
        }
        
        
    }
    
}
