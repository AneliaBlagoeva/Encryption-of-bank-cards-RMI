/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadacha7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import zadacha7.Card;

/**
 *
 * @author user
 */
// class DeckOfCards declaration
public class DeckOfCards {

    private List< Card> list; // declare List that will store Cards

    // set up deck of Cards and shuffle
    public DeckOfCards() {
        Card[] deck = new Card[52];
        int count = 0; // number of cards

        // populate deck with Card objects
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Face face : Card.Face.values()) {
                deck[count] = new Card(face, suit);
                count++;
            } // end for
        } // end for

        list = Arrays.asList(deck); // get List
        Collections.shuffle(list);  // shuffle deck
    } // end DeckOfCards constructor

    // output deck
    public void printCards() {
        // display 52 cards in two columns
        for (int i = 0; i < list.size(); i++) {
            System.out.printf("%-20s%s", list.get(i),
                    ((i + 1) % 2 == 0) ? "\n" : "");
        }
    } // end method printCards

    private int[] totalHand( List<Card> hand ){
        Card.Face[] valuesFace=Card.Face.values();
        int cnt=0;
        int[] result = new int[valuesFace.length];
        
        for(int j=0;j<valuesFace.length;j++){
         for (int i = 0; i < hand.size(); i++) {
                    if (hand.get(i).getFace() == valuesFace[j]) {                   
                    cnt++;
                }
            }
        result[j]=cnt;
        cnt=0;
        }
        
        
        return result;
    }
    
    //чифт (2 карти с еднаква сила)
    public boolean hasPair(List<Card> hand) {
        int[] totalHand=this.totalHand(hand);
        ArrayList<Integer> totalHandList=new ArrayList<Integer>();
        
        for(int i=0;i<totalHand.length;i++){
            totalHandList.add(totalHand[i]);
        }
        
        if(totalHandList.contains(2)){
            return true;
        }else{
            return false;
        }
    }

    //два чифта
    //чифт (2 карти с еднаква сила)
    public boolean hasDoublePair(List<Card> hand) {
        int[] totalHand=this.totalHand(hand);
        ArrayList<Integer> totalHandList=new ArrayList<Integer>();
        
        for(int i=0;i<totalHand.length;i++){
            if(totalHand[i]==2){
            totalHandList.add(totalHand[i]);
            }
        }
        
        if(totalHandList.size()>=2){
            return true;
        }else{
            return false;
        }
     
    }

    //терца (например, три Аса)
    public boolean hasTerca(List<Card> hand) {
        int[] totalHand=this.totalHand(hand);
        ArrayList<Integer> totalHandList=new ArrayList<Integer>();
        
        for(int i=0;i<totalHand.length;i++){
            totalHandList.add(totalHand[i]);
        }
        
        if(totalHandList.contains(3)){
            return true;
        }else{
            return false;
        }
    }

    // четири карти с еднаква сила (например, четири Аса)
    public boolean hasFourSameFaces(List<Card> hand) {
       int[] totalHand=this.totalHand(hand);
        ArrayList<Integer> totalHandList=new ArrayList<Integer>();
        
        for(int i=0;i<totalHand.length;i++){
            totalHandList.add(totalHand[i]);
        }
        
        if(totalHandList.contains(4)){
            return true;
        }else{
            return false;
        }
    }

    //пет карти с еднакъв цвят 
    public boolean hasFiveSameSuits(List<Card> hand) {
        int cnt = 1;
        boolean flag = false;
        int handSize=hand.size();
        
            for (int j = 1; j < handSize; j++) {
                if (hand.get(0).getSuit() == hand.get(j).getSuit()) {
                    cnt++;
                }
            }
            if (cnt == 5) {
                return true;
            }else{
                return false;
            }

    }

    //последователност (т.е., пет карти с поредни стойности на сила)
    public boolean areConsecutive(List<Card> hand) {
        boolean flag = true;
        int handSize=hand.size();

        for (int i = 0; i < handSize-1; i++) {
            if (hand.get(i).getFace().ordinal() < hand.get(i + 1).getFace().ordinal()) {
                flag = true;
            } else {
                flag = false;
                break;
            }

        }
        return flag;
    }

    //“пълна къща” (т.е., две карти от един цвят и три карти от друг цвят)
    public boolean isFullHand(List<Card> hand) {
        ArrayList cpyHand = new ArrayList(hand);
        
        int cnt = 1;
        boolean flag = false;
        
        for (int i = 0; i < cpyHand.size()-1; i++) {
            for (int j = i + 1; j < cpyHand.size(); j++) {
                if (hand.get(i).getSuit() == hand.get(j).getSuit()) {                   
                    cpyHand.remove(j);
                    cnt++;
                }
            }
            if (cnt == 3 || cnt==2) {
                flag = flag && true;
                cpyHand.remove(i);
            }else{
                flag=flag && false;
                break;
            }
            
            cnt=1;
        }

        return flag;
    }
    
    
    
    public static void main(String args[]) {
        DeckOfCards cards = new DeckOfCards();
        cards.printCards();
        List<Card> hand=Card.dealCards();
        System.out.print(hand.toString());
        
        boolean result;
        
        result=cards.hasPair(hand);
        System.out.printf("%nHas pair (same face): %b %n",result);
        
        result=cards.hasDoublePair(hand);
        System.out.printf("Has double pair: %b %n",result);
        
        result=cards.hasTerca(hand);
        System.out.printf("Has terca (three faces): %b %n",result);
        
        result=cards.hasFourSameFaces(hand);
        System.out.printf("Has four same faces cards: %b %n",result);
        
        result=cards.hasFiveSameSuits(hand);
        System.out.printf("Has 5 same suits cards: %b %n",result);
        
        result=cards.areConsecutive(hand);
        System.out.printf("Are consecutive cards: %b %n",result);
        
        result=cards.isFullHand(hand);
        System.out.printf("Is full hand - 3 colors and 2 colors: %b %n",result);
        
        int[] res=cards.totalHand(hand);
        for(int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }
    } // end main  
} // end class DeckOfCards

