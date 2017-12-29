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
public interface IEncryptable {
    String encrypt(String plainText, String cipher);
    String decrypt(String cipherText, String cipher);
}
