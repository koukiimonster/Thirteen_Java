/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Card {
    private int rank, suit;
    
    public enum rank {
    	THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE, TWO
    }
    
    public enum suit {
    	SPADES, CLUBS, DIAMONDS, HEARTS
    }
    // Suits and ranks are in order in terms of value.
    private static String suits[] = {"spades", "clubs", "diamonds", "hearts"};
    private static String ranks[] = {"3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace", "2"};
    
    Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
    
    public int getRank() {
        return rank;
    }
    
    public int getSuit() {
        return suit;
    }
}
