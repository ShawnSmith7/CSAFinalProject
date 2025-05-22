package csafinalproject;

import java.util.*;

public class Computer extends Player {
    
    public Computer(String _name, Deck _deck) {
        super(_name, _deck);
    }

    // Main decision function
    public Card playCard(Card topCard) {
        // Step 1: Play number card
        for (Card card : hand.getHand()) {
            if (card.getNum() != null && card.canPlayOn(topCard)) {
                hand.remove(card);
                return card;
            }
        }

        // Step 2: Play action card (excluding wild)
        for (Card card : hand) {
            if (card.getAction() != null &&
                card.getAction() != Card.Action.wild &&
                card.getAction() != Card.Action.wilddraw4 &&
                card.canPlayOn(topCard)) {
                hand.remove(card);
                return card;
            }
        }

        // Step 3: Play wild card
        for (Card card : hand) {
            if (card.getAction() == Card.Action.wild || card.getAction() == Card.Action.wilddraw4) {
                hand.remove(card);
                Card chosen = chooseColor(card);
                return chosen;
            }
        }

        // Step 4: No card to play
        return null;
    }

    // Pick the color with the most cards in hand
    private Card chooseColor(Card wildCard) {
        Map<Card.Suit, Integer> suitCount = new HashMap<>();
        for (Card c : hand) {
            if (c.getColor() != null) {
                suitCount.put(c.getColor(), suitCount.getOrDefault(c.getColor(), 0) + 1);
            }
        }

        // Default color if nothing found
        Card.Suit chosenColor = Card.Suit.red;
        int max = 0;
        for (Map.Entry<Card.Suit, Integer> entry : suitCount.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                chosenColor = entry.getKey();
            }
        }

        return new Card(wildCard.getAction(), chosenColor);
    }

    // Draw a card
    public void drawCard(Card drawnCard) {
        hand.add(drawnCard);
    }
}
