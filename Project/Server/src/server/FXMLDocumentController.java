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
 * FXML controller class for server interface.
 * Server contains two buttons, for create file
 * of encrypted cards sorted by card id
 * and button for creating file with ecrypted card id
 * sorted by encrypted nums.
 */
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

    /**
     * MAIN part
     * create registry for Login class
     * and Encryption class on port 1099.
     */
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

    /**
     * constructor in which we inizialize
     * a server and create registry
     */
    public FXMLDocumentController() {
        inizializeServer();
    }

    /**
     * event handler for button generate txt file
     * of card ids, sorted by card id.
     * @param event
     * @throws IOException 
     */
    @FXML
    private void sotedByBankCards(ActionEvent event) throws IOException {
        ((Encryption) encryp).cards.sortByBankId();
        ArrayList<Card> arr = new ArrayList<Card>();
        arr = ((Encryption) encryp).cards.getEncryptedCards();

        for(Card c:arr){
            writeToFile(c.toString());
        }

    }

    /**
     * event handler for button generate txt file
     * with card id sorted by encrypted code clicked.
     * @param event 
     */
    @FXML
    private void sortedByEncrypted(ActionEvent event) {
        ArrayList<String> allCards = new ArrayList<String>();
        for (Card c : encryp.cards.getEncryptedCards()) {
            allCards.addAll(c.EncryptedCodeToStringList());
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
    
    /**
     * helper function for writing into
     * txt file
     * @param line
     * @throws IOException 
     */
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

