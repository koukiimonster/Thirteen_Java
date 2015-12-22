import java.util.ArrayList;


public class NewHand {
	private int[] amount;
	private ArrayList<Card> hand;
	
	public NewHand() {
		amount = new int[13];
		for(int i = 0; i < amount.length; i++) {
			amount[i] = 0;
		}
		hand = new ArrayList<Card>(13);
	}
	
	public void sortHand() {
		for (int i = 0; i < 13; i++) {
			Card temp = hand.get(i);
			
			if(hand.get(i).getRank() == i) {
				amount[i] += 1;
			}
		}
	}
	

}
