package csafinalproject;

import java.awt.Container;
import java.awt.FlowLayout;

import java.util.ArrayList;

public class Deck extends Container {
    private ArrayList<Card> cards;
    
    // setup card list and layout
    public Deck() {
        cards = new ArrayList<Card>();
        setLayout(new FlowLayout(FlowLayout.CENTER, -25, 0));
    }
    
    // deck size getter
    public int deckSize() { return cards.size(); }
    
    // card getter
    public Card getCard(int index) { return cards.get(index); }
    
    // adds a card to this deck
    public void addCard(Card card) { 
        cards.add(0, card);
        displayCards();
    }
    
    // moves a card to a different deck and removes it from this deck
    public void moveCard(int index, Deck deck) {
        deck.addCard(getCard(index));
        cards.remove(index);
        displayCards();
    }
    
    // moves all cards from the deck with this rank to another deck
    public void moveRanks(int rank, Deck deck) {
        for (int i = cards.size() - 1; i >= 0; i--)
            if (cards.get(i).getRank() == rank)
                moveCard(i, deck);
        displayCards();
    }
    
    // removes any cards with this rank
    public void removeRanks(int rank) {
        for (int i = cards.size() - 1; i >= 0; i--)
            if (cards.get(i).getRank() == rank)
                cards.remove(i);
        displayCards();
    }
    
    // counts the total number of cards with this rank 
    public int getRankGroupCount(int rank) {
        int count = 0;
        for (Card c : cards)
            if (c.getRank() == rank)
                count++;
        return count;
    }
    
    // returns whether this deck contains a card with this rank
    public boolean hasRank(int rank) {
        for (Card c : cards)
            if (c.getRank() == rank)
                return true;
        return false;
    }
    
    // returns a list of ranks that can be choosen from this deck 
    public ArrayList<Integer> getOptionsList() {
        ArrayList<Integer> options = new ArrayList<Integer>();
        
        for (Card c : cards)
            if (!options.contains(c.getRank()))
                options.add(c.getRank());
        
        return options;
    }
    
    public void displayCards() {
        removeAll();
        
        for(Card c : cards) add(c);
    }
}