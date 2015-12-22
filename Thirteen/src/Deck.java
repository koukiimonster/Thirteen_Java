
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Deck {
    private ArrayList<Card> cards;
    
    Deck() {
        cards = new ArrayList<Card>(52);
        int index_1, index_2;
        Random generator = new Random();
        Card temp;
        
        // Build the deck
        for(int a = 0; a < 4; a++) {
            for(int b = 0; b < 13; b++) {
                cards.add(new Card(a, b));
            }
        }
        
        // Shuffle the deck
        
        for (int i = 0; i < 100; i++) {
            index_1 = generator.nextInt(cards.size() - 1);
            index_2 = generator.nextInt(cards.size() - 1);
            temp = (Card) cards.get(index_2);
            cards.set(index_2 , cards.get(index_1));
            cards.set(index_1, temp);
        }
        
    }
    
    //
    public Card drawFromDeck() {
        return cards.remove(0);
    }
    
    public int getTotalCards() {
        return cards.size();
    }
    
}
