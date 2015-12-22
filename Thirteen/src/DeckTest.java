/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class DeckTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        
        for(int i = 0; i < 52; i++) {
            System.out.println("Card drawn: " + deck.drawFromDeck().toString() + "\n");
            System.out.println("Cards remaining: " + deck.getTotalCards());
        }
    }
    
    
}
