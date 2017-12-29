/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//TEST

//package kontrolno;
//
//import java.util.ArrayList;

/**
 *
 * @author Anelia
 */
//public class CipherEncoding {
//    private final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
//    String cipher;
//    ArrayList<Character> cipherPad=new ArrayList<Character>();
//    
//
//    public CipherEncoding(String cipher) {
//        this.cipher = cipher;
//    }
//    
//    private ArrayList<Character> generateCipherPad(){
//     
//        char[] cipherCpy=cipher.toCharArray();
//        for(Character el:cipherCpy){
//            if(!cipherPad.contains(el)){
//               cipherPad.add(el);
//            }
//        }
//        
//        StringBuilder reversedAlphabet = new StringBuilder();           
//        reversedAlphabet.append(alphabet);                  
//        reversedAlphabet = reversedAlphabet.reverse();
//        
//        char[] reversedAlphabetArr=reversedAlphabet.toString().toCharArray();
//        
//        for(Character el:reversedAlphabetArr){
//            if(!cipherPad.contains(el)){
//               cipherPad.add(el);
//            }
//        }
//
//        return cipherPad;
//    }
//    
//    public String encode(String plaintext){
//        
//        generateCipherPad();
//        char[] plaintextArr=plaintext.toCharArray();
//        StringBuilder result=new StringBuilder();
//        
//        for(Character letter:plaintextArr){
//            int indexInAlphabet=alphabet.indexOf(letter);
//            result.append(cipherPad.get(indexInAlphabet));
//        }
//        
//        return result.toString();
//    }
//    
//    
//    public String decode(String encodedText){
//        
//        generateCipherPad();
//        char[] encodedTextArr=encodedText.toCharArray();
//        StringBuilder result=new StringBuilder();
//        
//        for(Character letter:encodedTextArr){
//            int indexInCipherPad=cipherPad.indexOf(letter);
//            result.append(alphabet.charAt(indexInCipherPad));
//        }
//        
//        return result.toString();
//    }
//    
//    public static void main(String[] args) {
//          CipherEncoding obj=new CipherEncoding("FEATHER");
//          System.out.println(obj.decode(obj.encode("WEATHER")));
//    }
//}
