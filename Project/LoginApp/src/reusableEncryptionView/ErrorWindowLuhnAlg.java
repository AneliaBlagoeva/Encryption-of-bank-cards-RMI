package reusableEncryptionView;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Error window FXML Controller class if card
 * number is < 16 symvols, doesnt start with 3,4,5
 * or doesnt match Luhn algorithm
*/

/**
 * FXML Controller class
 *
 * @author Anelia
 */
public class ErrorWindowLuhnAlg implements Initializable {

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
