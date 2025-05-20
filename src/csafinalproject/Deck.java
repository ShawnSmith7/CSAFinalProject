/*
 * Nicholas Reynolds
 * 5/12/2025
 * Creates a card game
 * Java NetBeans 22
 */
package csafinalproject;

import java.util.ArrayList;

public class Deck {
        
        public ArrayList<Card> deck = new ArrayList<>();
        
        public ArrayList getDeck() {
            
            return deck;
        }
        
        public Deck() {
        
        for(int i = 0; i < 108; i++) {
            
            if(i < 10) {
                
                deck.add(new Card(i, Card.Suit.red));
            }
            
            else if(i < 19) {
                
                deck.add(new Card((i - 9), Card.Suit.red));
            }
            
            else if(i < 21) {
                
                deck.add(new Card(Card.Action.reverse, Card.Suit.red));
            }
            
            else if(i < 23) {
                
                deck.add(new Card(Card.Action.skip, Card.Suit.red));
            }
            
            else if(i < 25) {
                
                deck.add(new Card(Card.Action.draw2, Card.Suit.red));
            }
            
            else if(i < 35) {
                
                deck.add(new Card(i - 25, Card.Suit.yellow));
            }
            
            else if(i < 44) {
                
                deck.add(new Card((i - 34), Card.Suit.yellow));
            }
            
            else if(i < 46) {
                
                deck.add(new Card(Card.Action.reverse, Card.Suit.yellow));
            }
            
            else if(i < 48) {
                
                deck.add(new Card(Card.Action.skip, Card.Suit.yellow));
            }
            
            else if(i < 50) {
                
                deck.add(new Card(Card.Action.draw2, Card.Suit.yellow));
            }
            
            else if(i < 60) {
                
                deck.add(new Card(i - 50, Card.Suit.green));
            }
            
            else if(i < 69) {
                
                deck.add(new Card((i - 59), Card.Suit.green));
            }
            
            else if(i < 71) {
                
                deck.add(new Card(Card.Action.reverse, Card.Suit.green));
            }
            
            else if(i < 73) {
                
                deck.add(new Card(Card.Action.skip, Card.Suit.green));
            }
            
            else if(i < 75) {
                
                deck.add(new Card(Card.Action.draw2, Card.Suit.green));
            }
            
            else if(i < 85) {
                
                deck.add(new Card(i - 75, Card.Suit.blue));
            }
            
            else if(i < 94) {
                
                deck.add(new Card((i - 84), Card.Suit.blue));
            }
            
            else if(i < 96) {
                
                deck.add(new Card(Card.Action.reverse, Card.Suit.blue));
            }
            
            else if(i < 98) {
                
                deck.add(new Card(Card.Action.skip, Card.Suit.blue));
            }
            
            else if(i < 100) {
                
                deck.add(new Card(Card.Action.draw2, Card.Suit.blue));
            }
            
            else if(i < 104) {
                
                deck.add(new Card(Card.Action.wild));
            }
            
            else if(i < 108) {
                
                deck.add(new Card(Card.Action.wilddraw4));
            }
            
        }
        
    }
    
}
