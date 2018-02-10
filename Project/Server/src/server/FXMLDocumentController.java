/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import cards.Cards;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 *
 * @author Anelia
 */
public class FXMLDocumentController implements Initializable {
    private Cards cards;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void sotedByBankCards(ActionEvent event) {
        cards.sortByBankId();
        
    }

    @FXML
    private void sortedByEncrypted(ActionEvent event) {
    }
    
}
