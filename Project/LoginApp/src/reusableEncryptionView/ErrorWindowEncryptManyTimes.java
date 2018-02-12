package reusableEncryptionView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Error window if card number is encrypted more than 12 times
 * */
/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class ErrorWindowEncryptManyTimes implements Initializable {

    @FXML
    private Label label;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
