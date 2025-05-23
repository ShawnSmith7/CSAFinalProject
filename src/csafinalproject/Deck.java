package csafinalproject;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;

public class Deck extends Container {
    private ArrayList<Card> cards;
    
    public Deck() {
        setLayout(new FlowLayout());
        cards = new ArrayList<Card>();
    }
    
    // adds a card to the deck and displays it
    public void addCard(Card card) {
        cards.add(0, card);
        displayCards();
    }
    
    // gets a card at an index
    public Card getCard(int index) {
        return cards.get(index);
    }
    
    // moves a card at an index to another deck and removes it from this deck
    public void moveCard(int index, Deck deck) {
        deck.addCard(getCard(index));
        cards.remove(index);
        displayCards();
    }
    
    public int getCardCount() { return cards.size(); }
    
    private void displayCards() {
        removeAll();
        for (int i = 0; i < Math.clamp(cards.size(), 0, 7); i++)
            add(cards.get(i));
    }
}
