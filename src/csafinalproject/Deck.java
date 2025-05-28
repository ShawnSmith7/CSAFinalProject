package csafinalproject;

import java.awt.*;

import java.util.ArrayList;
import java.util.Random;

public class Deck extends Container {
    private ArrayList<Card> cards;
    
    public Deck() {
        setLayout(new FlowLayout(FlowLayout.CENTER, -25, 0));
        cards = new ArrayList<Card>();
    }
    
    public void displayCards() {
        removeAll();
        
        for(Card c : cards)
            add(c);
    }
    
    public int cardCount() { return cards.size(); }
    public int getRandomIndex() { return new Random().nextInt(0, cards.size()); }
    
    public Card getCard(int index) { return cards.get(index); }
    public void addCard(Card card) { 
        cards.add(0, card);
        displayCards();
    }
    
    public void moveCard(int index, Deck deck) {
        deck.addCard(getCard(index));
        cards.remove(index);
        displayCards();
    }
    
    public void moveRanks(int rank, Deck deck) {
        for (int i = cards.size() - 1; i >= 0; i--)
            if (cards.get(i).getRank() == rank)
                moveCard(i, deck);
        displayCards();
    }
    
    public void removeRanks(int rank) {
        for (int i = cards.size() - 1; i >= 0; i--)
            if (cards.get(i).getRank() == rank)
                cards.remove(i);
        displayCards();
    }
    
    public int getRankGroupCount(int rank) {
        int count = 0;
        for (Card c : cards)
            if (c.getRank() == rank)
                count++;
        return count;
    }
    
    public boolean hasRank(int rank) {
        for (Card c : cards)
            if (c.getRank() == rank)
                return true;
        return false;
    }
    
    public ArrayList<Integer> getRankList() {
        ArrayList<Integer> options = new ArrayList<Integer>();
        
        for (Card c : cards)
            if (!options.contains(c.getRank()))
                options.add(c.getRank());
        
        return options;
    }
    
    public String toString() {
        String deckString = "";
        for (Card c : cards)
            deckString += c + " ";
        return deckString;
    }
}