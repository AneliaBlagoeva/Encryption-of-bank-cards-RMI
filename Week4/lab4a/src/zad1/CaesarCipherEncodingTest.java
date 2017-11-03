package zad1;

import javax.swing.JOptionPane;

public class CaesarCipherEncodingTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //declaration
        int userChoice;//select option
        int length; //cipherCode
        String userText;
        String[] options = {"encrypt", "decrypt"};
        String result;
        CaesarCipherEncoding cipher;

        //initialization
        length = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter shift length: "));

        cipher = new CaesarCipherEncoding(length);

        userChoice = JOptionPane.showOptionDialog(null, "Choose option", "title", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
                options, options[0]);

        userText = JOptionPane.showInputDialog(null, "Enter text for processing: ");

        //processing
        if (userChoice == 0) {
            result = cipher.encrypt(userText);
        } else {
            result = cipher.decrypt(userText);
        }

        //output
        JOptionPane.showMessageDialog(null, "Converted string is: " + result);
    }

}
