
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class HandTest {
    public static void main(String[] args) {
        Deck deck = new Deck();
        Hand hand = new Hand();
        Scanner console = new Scanner(System.in);
        Card card;
        int index1, index2, index3, index4, choice, length = 0;
        ArrayList<Integer> indices = new ArrayList<Integer>(12);
        char d;
        
        while(hand.getHandSize() != 13) {
            hand.addToHand(deck.drawFromDeck());
        }
        
        for(int i = 0; i < 13; i++) {
            System.out.println(hand.getCard(i));
        }
        
        hand.sortHand();
        System.out.println("\nAfter sorting: \n-------------------------");
        for(int i = 0; i < 13; i++) {
            System.out.println(hand.getCard(i));
        }
        while(hand.getHandSize() > 0) {
            System.out.println("\n" + hand.viewHand());
        System.out.println("What would you like to play?:\n-------------------------");
        System.out.println("1. Play single");
        System.out.println("2. Play double");
        System.out.println("3. Play Triple");
        System.out.println("4. Play bomb");
        System.out.println("5 Play run");
        choice = console.nextInt();
        switch (choice) {
            case 1: {
                index1 = console.nextInt();
                hand.playCard(index1);
            }
                break;
            case 2: {
                index1 = console.nextInt();
                index2 = console.nextInt();
                hand.playDouble(index1, index2);
            }
                break;
            case 3: {
                index1 = console.nextInt();
                index2 = console.nextInt();
                index3 = console.nextInt();
                hand.playTriple(index1, index2, index3);
            }
                break;
            case 4: {
                index1 = console.nextInt();
                index2 = console.nextInt();
                index3 = console.nextInt();
                index4 = console.nextInt();
                //hand.playBomb();
            }
                break;
            case 5: {
                while(indices.size() < 12) {
                    index1 = console.nextInt();
                    if(indices.contains((Integer)index1)) {
                        indices.add((Integer)index1);
                    }
                    
                }
                
            }
        }

        }
        //System.out.println("Number of cards in hand: " + hand.getHandSize());
        //System.out.println("Cards in the hand: \n" + hand.viewHand());
        
        
        //System.out.println(hand.viewHand());
    }
    
    
    
    
}
