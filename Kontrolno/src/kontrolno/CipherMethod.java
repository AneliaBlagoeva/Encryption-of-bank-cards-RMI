/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kontrolno;

/**
 *
 * @author Anelia
 */
//source file
public class CipherMethod {

    IEncryptable callbackFtn;

    public String encryptText(String plainText, String cipher) {
        return callbackFtn.encrypt(plainText,cipher);
    }

    public String decryptText(String cipherText, String cipher) {
        return callbackFtn.decrypt(cipherText,cipher);
    }

    public CipherMethod(IEncryptable callbackFtn) {
        this.callbackFtn = callbackFtn;
    }
    
}
