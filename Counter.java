/* AE3 - Fruit Machine - Counter
 * Wen Hui Chen  2456203C*/

import javax.swing.*;
import java.awt.*;

public class Counter {
	private JLabel status, status2, result;
	// two status (status and status 2) for specific condition
	// for example: two same cards + a "Joker" (show two status on balance counting)
	private String content1, content2, content3; // cards content
	private int balance; // balance value

	public Counter(Board gui) {
		this.balance = gui.getBalance();
		this.status = gui.getStatus();
		this.status2 = gui.getStatus2();
		this.result = gui.getResult();
	}

// count balance
	// 0 <= balance < 150
	public void countBalance(int balance) {
		if (balance < 150 && balance >= 0) {
			if (sameThreeCards()) { // if there are three same cards
			} else if (sameTwoCards()) { // if there are two same cards
			} else {
				noSameCard(); // if there is no same card
			}
		}
		currentBalance(); // check if the player win or lose
	}

// reset balance value
	public void resetBalance() {
		balance = 100;
	}

// check balance, win if balance >= 150, lose if balance <0
	public void currentBalance() {
		if (balance >= 150) {
			result.setText("You win!"); // show win information
		}
		if (balance < 0) {
			result.setText("You lose."); // show lose information
		}
	}

// check card contents
	// if there are three same cards
	public Boolean sameThreeCards() {
		// three contents are the same
		if (content1.equals(content2) && content2.equals(content3)) {
			// if content1 is "Joker", content2 and content3 will also be "Joker"
			if (content1.equals("Joker")) {
				balance = balance - 75; //lose 75 points for three Joker
				status.setText("3 jokers: you lose 75 points"); // show status
			} else {
				balance = balance + 50; // win 50 points for three same cards
				status.setText("Three of a kind - you win 50 points"); // show status
			}
			return true; // return true if three cards are the same
		}
		return false; // return false if three cards are not the same
	}

	// if there are two same cards
	public Boolean sameTwoCards() {
		
		if (content1.equals(content2)) { // if card1 and card2 are the same
			if (content1.equals("Joker")) { // if card1 and card2 are "Joker"
				balance = balance - 50; // lose 50 points for two Jokers
				status.setText("2 jokers: you lose 50 points"); // show status
			} else {
				// if card1 and card2 are not "Joker"
				balance = balance + 20; // win 20 points for two same cards
				status.setText("Two of a kind - you win 20 points"); // show status
			}

			if (content3.equals("Joker")) { // if card3 is "joker"
				balance = balance - 25; // lose 25 points for one Joker
				status2.setText("1 joker: you lose 25 points"); // show status
			}
			return true; // return true while finding two same cards
		}
		if (content2.equals(content3)) { // if card2 and card3 are the same
			if (content1.equals("Joker")) { // if card1 is "Joker"
				balance = balance - 25; //lose 25 points for one Joker
				status2.setText("1 joker: you lose 25 points"); // show status
			}
			if (content2.equals("Joker")) { // if card2 and card3 are "Joker"
				balance = balance - 50; // lose 50 points for two Jokers
				status.setText("2 jokers: you lose 50 points"); // show status
			} else {
				// if card2 and card3 are not "Joker"
				balance = balance + 20; // win 20 points for two same cards
				status.setText("Two of a kind - you win 20 points"); // show status
			}
			return true; // return true while finding two same cards
		}
		if (content3.equals(content1)) { // if card3 and card1 are the same
			if (content1.equals("Joker")) { // if card3 and card1 are "Joker"
				balance = balance - 50; // lose 50 points for two Jokers
				status.setText("2 jokers: you lose 50 points"); // show status
			} else {
				// if card3 and card1 are not "Joker"
				balance = balance + 20; // win 20 points for two same cards
				status.setText("Two of a kind - you win 20 points"); // show status
			}
			if (content2.equals("Joker")) { // if card2 is Joker
				balance = balance - 25; // lose 25 points for one Joker
				status2.setText("1 joker: you lose 25 points"); // show status
			}
			return true; // return true while finding two same cards
		}
		return false; // return false if not finding two same cards
	}

	// if there is no same card
	public void noSameCard() {
		if (content1.equals("Joker") || content2.equals("Joker") || content3.equals("Joker")) {
			// if any of the cards is "Joker"
			balance = balance - 25; // lose 25 points for one Joker
			status.setText("1 joker: you lose 25 points"); // show status
		} else {
			// no Joker in all three cards
			status.setText("Three cards are different: balance unchanged"); 
			// show status - balance unchanged
		}
	}

// Getters and Setters
	public void setContent1(String content1) {
		this.content1 = content1;
	}

	public void setContent2(String content2) {
		this.content2 = content2;
	}

	public void setContent3(String content3) {
		this.content3 = content3;
	}

	public int getBalance() {
		return balance;
	}

}
