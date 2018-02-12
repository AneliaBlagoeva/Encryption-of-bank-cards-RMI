/**
 * Login window controller. It contains event handlers for login button
 * and check if credentials are correct or if the user has rights for encrypt/decrypt
*/
package loginapp;

import common.ILoginable;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

   /**
    * get instance from ILoginable interface from registry Login on port 1099
    * */
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

    /**
     * Event handler on button login clicked. Checks if the user has rights or if username
     * and password are correct  . Calls method from server side.
     * */
    @FXML
    private void onBtnLoginClicked(ActionEvent event) throws IOException {
        try {
            
            String userName = txtUsername.getText();
            String password = txtPassword.getText();
            
            initializeRMI();
            
            Parent root1;
            if (!((loginObj.checkCredentials(userName,password)) && isValidPassword(password) && isValidUsername(userName))) {
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
    
    /**
     * Method for validating password by regex expression. 
      The password should contains digit, small letter, upercase letter, 
      special symbol and have to be min 8 symbols 
      */
    public boolean isValidPassword(String password) {

        String PASSWORD_REGEXP =  "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                
        Pattern pattern = Pattern.compile(PASSWORD_REGEXP);
        Matcher matcher;
        matcher = pattern.matcher(password);
        return matcher.matches();
    }
    
    /**
     * Method for validating username by regex expression. 
      The username should contains small letter, upercase letter, 
      can contains digit 
      */
    public boolean isValidUsername(String username) {

        String  USERNAME_REGEXP ="^[A-Za-z0-9]+(?:[ _-][A-Za-z0-9]+)*$";

        Pattern pattern = Pattern.compile(USERNAME_REGEXP);
        Matcher matcher;
        matcher = pattern.matcher(username);
        return matcher.matches();
    }

}
