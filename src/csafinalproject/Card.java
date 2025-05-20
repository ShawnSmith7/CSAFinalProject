package csafinalproject;

public class Card {
    
    public int num;
    public enum Suit{red, green, blue, yellow, };
    public enum Action{wild, reverse, skip, draw2, wilddraw4};
    public Suit currentSuit;
    public Action currentAction;
    
    public Card(int n, Suit s) {
        
        num = n;
        currentSuit = s;
    }
    
    public Card(Action a, Suit s) {
        
        currentAction = a;
        currentSuit = s;
    }
    
    public Card(Action a) {
        
        currentAction = a;
    }
    
    public int getNum() {
        
        return num;
    }
    
    public Suit getColor() {
        
        return currentSuit;
    }
    
    public Action getAction() {
        
        return currentAction;
    }
    
    public boolean compare(Card card) {
        
        if(card.getColor() == getColor()) {
            
            return true;
        }
        
        else if(card.getNum() == getNum()) {
            
            return true;
        }
        
        else {
            
            return false;
        }
    }
    
    public String toString() {
        
        return getColor() + " " + getNum();
    }
    
}
