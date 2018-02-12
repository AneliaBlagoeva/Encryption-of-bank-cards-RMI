
package reusableEncryptionView;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Load encryption window
 * */
/**
 *
 * @author Anelia
 */
public class EncryptionView extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        URL path = getClass().getResource("FXMLEncryptionPane.fxml");
        Parent root = FXMLLoader.load(path);
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

}
