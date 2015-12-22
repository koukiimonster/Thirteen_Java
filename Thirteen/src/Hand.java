
import java.util.ArrayList;
import java.util.List;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Hand {
    
	private ArrayList cards;
    private ArrayList<Card> hand;
    
    public Hand() {
        hand = new ArrayList<Card>(13);
        cards = new ArrayList<Integer>(13);
    }
    
    // Play a single card.
    public Card playCard(int index) {
        Card card = hand.remove(index);
        return card;
    }
    
    // View the cards in the hand.
    public String viewHand() {
    	
        String card;
        String currentHand = hand.get(0).toString();
        for(int i = 1; i < hand.size(); i++) {
            card = hand.get(i).toString();
            currentHand = currentHand + "\n" + card;
        }
        return currentHand;
    }
    
    // Returns the hand
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    // Sort hand from lowest to highest, in terms of rank and suit
    public void sortHand() {
        ArrayList<Card> sortedHand = new ArrayList<Card>(13);
        int i;
        int position;
        Card low, high;
               
        // If the ranks are equal, then we check to see which is the higher 
        // of the two.
        while(hand.size() > 0) {
            position = 0;
            low = hand.get(0);
            for(i = 1; i < hand.size(); i++) {
                high = hand.get(i);               
                if(high.getRank() < low.getRank()) {
                    position = i;
                    low = high;
                } else if(high.getRank() == low.getRank()) {
                    if(high.getSuit() < low.getSuit()) {
                        position = i;
                        low = high;
                    }
                }   
            }
            hand.remove(position);
            sortedHand.add(low);
        }   
        hand = sortedHand;       
    }
    
    // Play a double. 
    public ArrayList<Card> playDouble(int index1, int index2) {
        ArrayList<Card> deuce = new ArrayList<Card>(2);
        while(deuce.size() < 2) {
            Card one, two;
            one = hand.get(index1);
            two = hand.get(index2);
            if(one.getRank() == two.getRank()) {
                deuce.add(hand.remove(index1));
                deuce.add(hand.remove(index2-1));
            } else {
                System.out.println("Invalid double.");
            }
        }
        return deuce;
    }
    
    // Maybe a do while is better...Search for equal ranks while counter <= 3.
    public List<Card> playTriple(int index1, int index2, int index3) {
        
        ArrayList<Card> triple = new ArrayList<Card>(3);
        while(triple.size() < 3) {
            Card one, two, three;
            one = hand.get(index1);
            two = hand.get(index2);
            three = hand.get(index3);
            if(one.getRank() == two.getRank() && one.getRank() == three.getRank()) {
                triple.add(hand.remove(index1));
                triple.add(hand.remove(index2-1));
                triple.add(hand.remove(index3-2));
            } else {
                System.out.println("Invalid triple.");
            }
        }
        return triple;
    }
    
    // Play 4 of a kind
    public ArrayList<Card> playBomb(int index1, int index2, int index3, int index4) {
        ArrayList<Card> bomb = new ArrayList<Card>(4);
        Card one, two, three, four;
        one = hand.get(index1);
        two = hand.get(index2);
        three = hand.get(index3);
        four = hand.get(index4);
        while(bomb.size() < 4) {
            if(one.getRank() == two.getRank() && one.getRank() == three.getRank() && one.getRank() == four.getRank()) {
                bomb.add(hand.remove(index1));
                bomb.add(hand.remove(index2-1));
                bomb.add(hand.remove(index3-2));
                bomb.add(hand.remove(index4-3));
            }
        }
        return bomb;
    }
    
    public ArrayList<Card> playRun(int length, int[] indices) {
        ArrayList<Card> run = new ArrayList<Card>(length);
        ArrayList<Card> cards = new ArrayList<Card>(2);
        int counter = 0;
        for(int i = 0; i < length - 1; i++) {
            if(hand.get(indices[i]).getRank() < hand.get(indices[i+1]).getRank()) {
                run.add(hand.remove(indices[i] - counter));
                counter++;
            }
        }
        
        return run;
        
    }
    // Play a run of doubles. Must be consecutive in rank and a pair for each
    // rank.
    public List<Card> playKiller(int length, Card card) {
        return null;
        
    }
    
    // Play a run of singles. Must be consecutive in rank.
    /*public List<Card> playRun(int length, Card card) {
        List<Card> run = null;
        int index = 0;
        
        while(run.size() <= length) {
            if(card.getRank())
        } 
        return run;
    }*/
    
    public void chooseCards() {
        
    }
    
    public void addToHand(Card card) {
        hand.add(card);
    }
    
    public int getHandSize() {
        return hand.size();
    }
    
    public Card getCard(int index) {
        return hand.get(index);
    }
}
