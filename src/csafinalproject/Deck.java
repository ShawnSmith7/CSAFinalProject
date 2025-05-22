package csafinalproject;

import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JComponent;

public class Deck extends JComponent {
    private ArrayList<Card> cards;
    
    public Deck() {
        setLayout(new FlowLayout());
        cards = new ArrayList<Card>();
    }
    
    public void addCard(Card card) {
        cards.add(0, card);
        repaint();
    }
    
    public Card getCard(int index) {
        return cards.get(index);
    }
    
    public void moveCard(int index, Deck deck) {
        deck.addCard(getCard(index));
        cards.remove(index);
        repaint();
    }
    
    public int getCardCount() {
        return cards.size();
    }

    public void repaint() {
        super.repaint();
        
        removeAll();
        for (Card c : cards) {
            add(c);
        }
    }
}
