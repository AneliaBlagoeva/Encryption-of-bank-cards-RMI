/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab8f17javafx;

import com.CipherGenerator;
import com.Cipherable;
import com.Result;
import com.Wrapper;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

/**
 *
 * @author echrk
 */
public class Lab8F17JavaFX extends Application {

    private TextField txtSeed;
    private TextField txtSize;
    private Alert messageBox;

    private Button btnGenerateAZ;
    private Button btnGenerateSelect;
    private Button btnQuit;
    private CipherGenerator serviceConsumer; // consumer of service providers
    private Wrapper wrapper4ServiceProviders; // wraps providers for random sequence services

    @Override
    public void start(Stage primaryStage) {
        
        serviceConsumer = new CipherGenerator();
        messageBox = new Alert(Alert.AlertType.INFORMATION);
        FlowPane root = new FlowPane(14, 14);
        root.setAlignment(Pos.CENTER);
        txtSeed = new TextField("Enter the seed");
        txtSeed.setPrefColumnCount(20);
        txtSize = new TextField("Enter the size");
        txtSize.setPrefColumnCount(20);
        btnGenerateAZ = new Button();

        btnGenerateAZ.setText("Generate random   A- Z");
        btnGenerateAZ.setPrefWidth(150);
        btnGenerateAZ.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                handleAction(event);
            }
        });
        btnGenerateSelect = new Button();

        btnGenerateSelect.setText("Random sunset of A- Z");
        btnGenerateSelect.setPrefWidth(150);
        btnGenerateSelect.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                handleAction(event);
            }
        });
        btnQuit = new Button();
        btnQuit.setText("Quit");
        btnQuit.setPrefWidth(150);
        btnQuit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Platform.exit();
            }
        });
        root.getChildren().addAll(txtSeed, txtSize, btnGenerateAZ,
                btnGenerateSelect, btnQuit);

        Scene scene = new Scene(root, 350, 250);

        primaryStage.setTitle("Generate random sequence");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void handleAction(ActionEvent event) {
        Cipherable cipher;
        String mboxTitle;
        wrapper4ServiceProviders = new Wrapper(Integer.parseInt(txtSize.getText()));
        if (event.getSource() == btnGenerateAZ) {
            cipher = wrapper4ServiceProviders.makeFixeSelection();
            mboxTitle = "Generate random subset A- Z";
        } else {
            cipher = wrapper4ServiceProviders.makeFixedRandom();
            mboxTitle = "Random subsequence of letters A- Z";
        }
        Result result = serviceConsumer.countDistinct(cipher,
                Integer.parseInt(txtSeed.getText()));
        messageBox.setTitle(mboxTitle);
        messageBox.setHeaderText("Count distinct characters out of " + 
                                                            txtSize.getText());
        messageBox.setContentText(result.toString());
        messageBox.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
