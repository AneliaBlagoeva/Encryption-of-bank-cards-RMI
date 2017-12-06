/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zadacha7;

// Fig. 19.12: DeckOfCards.java
// Using algorithm shuffle.
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// class to represent a Card in a deck of cards
class Card 
{    
   public static enum Face { Ace, Deuce, Three, Four, Five, Six,
      Seven, Eight, Nine, Ten, Jack, Queen, King  };
   public static enum Suit { Clubs, Diamonds, Hearts, Spades };

   private final Face face; // face of card
   private final Suit suit; // suit of card
   
   // two-argument constructor
   public Card( Face cardFace, Suit cardSuit ) 
   {   
       face = cardFace; // initialize face of card
       suit = cardSuit; // initialize suit of card
   } // end two-argument Card constructor
   
   // return face of the card
   public Face getFace() 
   { 
      return face; 
   } // end method getFace
   
   public void setSuit(int suitIndex)
   {
       if(suitIndex>0){
           
       }
   }

   // return suit of Card
   public Suit getSuit() 
   { 
      return suit; 
   } // end method getSuit

   // return String representation of Card
   public String toString()
   {
      return String.format( "%s of %s", face, suit );
   } // end method toString
   
   public static List<Card> dealCards(){
       List<Card> hand=new ArrayList<Card>();
       for (int i = 0; i < 5; i++) {
           Random r=new Random();
           Suit[] valuesSuit=Suit.values();
           Face[] valuesFace=Face.values();
           Card c=new Card(valuesFace[r.nextInt(14)],valuesSuit[r.nextInt(5)]);
           hand.add(c);
       }
       
       return hand;
   }
} // end class Card

