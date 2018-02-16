package reusableEncryptionView;

import common.Chryptable;
import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
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

/** Encryption window. It contains textfield for 
 * card number code and buttons encrypt and decrypt.
 * The relationship with the server is by shared instance of type Interface
 * Cryptable.
*/

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

    /** Constructor in which we get
    the instance of registry Encryption.
    */
    public FXMLEncryptionPaneController() {
        initializeRMI();
    }
    
    /**
    Event handler on button encrypt clicked.Also this method checks
    for validation of the card number. 
    Call method for encrypt from server side;
    */
    @FXML
    private void btnEncodeClicked(ActionEvent event) throws IOException {
        try {
            if(( (txtCode.getText().charAt(0)=='3') || (txtCode.getText().charAt(0)=='4') || (txtCode.getText().charAt(0)=='5')) && (luhnTest(txtCode.getText())==true)){
            String result = encryption.encode(txtCode.getText());

            if(!"".equals(result)){
            lblResult.textProperty().setValue(result);
            }
            else{
                /**
                 if card number is encrypted more than 12 times load error window
                */
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/reusableEncryptionView/ErrorWindowEncryptManyTimes.fxml"));
                   Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                    }
            }else{
                /**
                 * if card number does not start with 3,4,5 or does not match Luhn algorithm load error window
                */
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/reusableEncryptionView/ErrorWindowLuhnAlg.fxml"));
                   Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
            }
            
        } catch (RemoteException e) {
            System.out.println("Error while encoding");
        }
    }

    /**
    Event handler on button decrypt clicked.Also this method checks
    for validation of the card number. 
    Call method for encrypt from server side;
    */
    @FXML
    private void btnDecodeClicked(ActionEvent event) throws IOException {
       try {
            System.out.println(txtCode.getText());
            String result = encryption.decode(txtCode.getText());

            if(!"".equals(result)){
            lblResult.textProperty().setValue(result);
            }
            else{
                /**
                card is not existing
                */
                
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/reusableEncryptionView/ErrorWindowNotExistingCard.fxml"));
                   Parent root1 = (Parent) fxmlLoader.load();
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root1));
                    stage.show();
                    }
            }catch(IOException e){
                System.out.println("Error while decrypting!");
            }
               
    }

    /**
    Method for getting instance of Interface Cryptable from
    registry Encryption on port 1099
    */
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
    
    /**
    Method for testing if card number is valid by Luhn algorithm.
    1. Sum all digit on odd position -- s1
    2. Double all digits on even positions
    3. Sum digits from 2 and this them as numbers on even positions
    4. Sum all digits from 3 -- s2
    5. To be correct card num have to match s1 + s2 % 10 is null
    */
    public boolean luhnTest(String s){
       char[] inputArr = s.toCharArray();
       int sumOdd=0;
        int sumDoubledEven=0;
        
        ArrayList<Integer> resultArr = new ArrayList<Integer>();

        for (char current : inputArr) {
                int digit = (Character.getNumericValue(current));
                resultArr.add(digit);
            }
        
        for(int i=0;i<resultArr.size();i+=2){
            sumOdd+=resultArr.get(i);
        }
        
        for(int i=1;i<resultArr.size();i+=2){
            int temp=resultArr.get(i)*2;
            int sumDigitsTemp=(temp%10)+(temp/10);
            sumDoubledEven+=sumDigitsTemp;          
        }

      return ((sumOdd+sumDoubledEven)%10)==0;  
}
}
