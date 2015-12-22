
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;



/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tony
 */
public class Game {
    private Deck deck;
    private LinkedList<Hand> players;
    private Stack<Card> pile;
    
    /**
     * 
     */
    Game() {
        deck = new Deck();
        pile = new Stack<Card>();
        players = new LinkedList<Hand>();
        
        // FOR TEST PURPOSES
        // Have 2 players in the game
        // I would like for the host to choose the amount of players, which 
        // would add that many players to the list
        players.add(new Hand());
        players.add(new Hand());
          
    }
    
    //TODO
    /**
     * 
     */
    public void dealDeck() {
        for(int i = 0 ; i < players.size() * 13; i++) {
            // High coupling?
            players.get(i % players.size()).getHand().add(deck.drawFromDeck());      
        } 
    }
    
    // Main game loop
    public void play() {
        //Begin by finding hand with the lowest card value(3 of spades).
        // They begin the game and circle from there. Player plays a card that
        // must be a higher value than the face card on pile, or if they cannot
        // they can choose to skip, but they are out of that round until the 
        // next round starts. Keep looping through rounds until the first player
        // plays all cards in their hands.
        
        
        //Search for the player with the 3 of spades
        for(int i = 0; i < players.size(); i++) {
            Hand temp;
            temp = players.get(i);
            if (temp.getHand().contains(new Card(0, 0))) {
                temp = players.remove(i);
                players.push(temp);
                break;
            }   
        }
        int playerTurn = 0;
        int index = 0;
        int round = 1;
        List<Card> cardPlayed; 
        
        Hand currentTurn = players.get(playerTurn);
            
            // View the hand of the current turn
        System.out.println(currentTurn.viewHand());
              
        index = 0;                              //Player would actually choose this value. Placeholder for now.

        // Must rework this logic
        cardPlayed = currentTurn.playCard(index);

        if(cardPlayed.getRank() >= pile.peek().getRank()) {
            if(cardPlayed.getSuit() > pile.peek().getSuit()) {
                pile.push(cardPlayed);
            } else {
                pile.push(cardPlayed);
            }
        } else {
            // Invalid card played. Must be higher.
        }
        
        // Game loop can only be entered after first player plays 3 of spades.
        while(true) {
            
            currentTurn = players.get(playerTurn);
            
            // View the hand of the current turn
            System.out.println(currentTurn.viewHand());
            
            
            index = 0;                              //Player would actually choose this value. Placeholder for now.
            
            cardPlayed = currentTurn.playCard(index);
            
            
            if(cardPlayed.getRank() >= pile.peek().getRank()) {
                if(cardPlayed.getSuit() > pile.peek().getSuit()) {
                    pile.push(cardPlayed);
                } else {
                    pile.push(cardPlayed);
                }
            } else {
                // Invalid card played. Must be higher.
            }
            
            if(currentTurn.getHand().isEmpty()) {
                //Player wins and game ends
                break;
            } else {
                //Move to the next turn
                playerTurn = playerTurn % players.size();
            }
            
            // Checks to see if all but 1 player has skipped. If so, a new round
            // begins where the player that did not skip gets to play any card
            // regardless of suit and value and type.
            //if()
            round++;
            
        }   
    }
        
    
    
    
}
