/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import cards.Card;
import common.ILoginable;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

/**
 *
 * @author Anelia
 */
public class FXMLDocumentController {

    @FXML
    private Button sotedByBankCards;
    @FXML
    private Button sortedByEncrypted;

    private Encryption encryp;
    //private Cards cards;
    
    public void inizializeServer(){
                try {
            ILoginable o = new Login();
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("Login", o);

            encryp = new Encryption();

            registry.rebind("Encryption", encryp);
//            System.in.read();
 //           System.exit(0);

        } catch (RemoteException ex) {
            System.out.println("remote" + ex);
   //     } catch (IOException ex) {
  //          Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FXMLDocumentController() {
       inizializeServer();
    }

    @FXML
    private void sotedByBankCards(ActionEvent event) {
      ((Encryption)encryp).cards.sortByBankId();
      ArrayList<Card> arr=new ArrayList<Card>();
      arr=((Encryption)encryp).cards.getEncryptedCards();
      
      arr.forEach(System.out::println);

    }

    @FXML
    private void sortedByEncrypted(ActionEvent event) {
        ArrayList<String> allCards = new ArrayList<String>();
        for (Card c : encryp.cards.getEncryptedCards()){
            allCards.addAll(c.getEncodedCodes());
        }

        allCards.sort((one, other) -> one.compareTo(other));

        for(String c: allCards){
            System.out.println(c + " ID: " + encryp.decode(c));
            
        //zapisvam vyv file encrypted ot all cards i izvikvam decode(string)
    }

    }
}
