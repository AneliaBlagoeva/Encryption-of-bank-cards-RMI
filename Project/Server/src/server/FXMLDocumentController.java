/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import cards.Card;
import common.ILoginable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    public void inizializeServer() {
        try {
            ILoginable o = new Login();
            Registry registry = LocateRegistry.createRegistry(1099);

            registry.rebind("Login", o);

            encryp = new Encryption();

            registry.rebind("Encryption", encryp);

        } catch (RemoteException ex) {
            System.out.println("remote" + ex);
        }
    }

    public FXMLDocumentController() {
        inizializeServer();
    }

    @FXML
    private void sotedByBankCards(ActionEvent event) throws IOException {
        ((Encryption) encryp).cards.sortByBankId();
        ArrayList<Card> arr = new ArrayList<Card>();
        arr = ((Encryption) encryp).cards.getEncryptedCards();

        for(Card c:arr){
            writeToFile(c.toString());
        }

    }

    @FXML
    private void sortedByEncrypted(ActionEvent event) {
        ArrayList<String> allCards = new ArrayList<String>();
        for (Card c : encryp.cards.getEncryptedCards()) {
            allCards.addAll(c.getEncodedCodes());
        }

        allCards.sort((one, other) -> one.compareTo(other));

        for (String c : allCards) {
            try {
                String str=String.format(c + " ID: " + encryp.decode(c));
                
                writeToFile(str);
                //zapisvam vyv file encrypted ot all cards i izvikvam decode(string)
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public static void writeToFile(String line) throws IOException {
        FileOutputStream fop = null;
		File file;

		try {

			file = new File("newfile.txt");
			fop = new FileOutputStream(file,true);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = line.getBytes();

			fop.write(contentInBytes);
                        fop.write("\n".getBytes());
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
    }

