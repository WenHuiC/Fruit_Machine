/* AE3 - Fruit Machine - Board
 * Wen Hui Chen  2456203C*/

import javax.swing.JFrame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.BorderFactory;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Board extends JFrame {
// Divide the fruit machine game board into three parts
	// block 1 - for showing balance, balance counting status and win/lose
	// block 2 - for cards
	// block 3 - for buttons (spin and new game)
	private JPanel block1, block2, block3;
	private JLabel balanceLabel, status, status2, result;
	// two status (status and status 2) for specific condition
	// for example: two same cards + a "Joker" (show two status on balance counting)
	private int balance = 100; // points
	private JButton spin, newGame;
	private CardPanel card1, card2, card3;
	// CardPanel -> JPanel for card with set black line and yellow background
	private JLabel cardLabel1, cardLabel2, cardLabel3;
	private String cardContent1, cardContent2, cardContent3;
	// Card content shows "Joker", "King", "Queen", "Jack" or "Ace"

	public Board() {
		this.setTitle("Fruit Machine");
		this.setSize(400, 280); // set board size
		this.setLocation(500, 150); // set board location
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set default behavior for closing JFrame when the X button is pressed

		// Add a JPanel (putEmptyBorder) to JFrame to contain empty border
		JPanel putEmptyBorder = new JPanel();
		putEmptyBorder.setBorder(BorderFactory.createEmptyBorder(10, 5, 5, 5));
		// Add another JPanel (blockPanel) into empty border to contain border layout
		// this is place for block 1
		JPanel blockPanel = new JPanel(new BorderLayout());
		putEmptyBorder.add(blockPanel);
		// centerPanel contain grid layout. This is place for block 2 and block 3
		JPanel centerPanel = new JPanel(new GridLayout(1, 2));
		blockPanel.add(centerPanel, BorderLayout.SOUTH);
		this.add(putEmptyBorder);

// Create 3 blocks (JPanel) and insert to each grid
		block1 = new JPanel(new GridLayout(4, 1)); // A grid layout is first added to block 1
		block2 = new JPanel(new BorderLayout()); // A border layout is first added to block 2
		block3 = new JPanel(new BorderLayout()); // A border layout is first added to block 3
		blockPanel.add(block1, BorderLayout.NORTH);
		block1.setBorder(BorderFactory.createEmptyBorder(10, 12, 5, 20));
		block1.setPreferredSize(new Dimension(280, 100)); // set size of block 1 panel
		centerPanel.add(block2);
		centerPanel.add(block3);

// block1
		// Add labels to block1
		balanceLabel = new JLabel("balance is " + balance + ".");
		status = new JLabel("welcome!");
		status2 = new JLabel();
		result = new JLabel();
		block1.add(balanceLabel);
		block1.add(status);
		block1.add(status2);
		block1.add(result);

// block 2
		// A JPanel (B2Center) is added to the center of the border layout
		// containing an empty border with another JPanel (B2Inner) in it
		JPanel B2Center = new JPanel();
		B2Center.setBorder(BorderFactory.createEmptyBorder(10, 0, 20, 0));
		JPanel B2Inner = new JPanel(new GridLayout(1, 3)); // three grids for three cards
		B2Center.add(B2Inner); // Add B2Inner to B2Center
		B2Inner.setPreferredSize(new Dimension(150, 90)); // set B2Inner panel size
		block2.add(B2Center, BorderLayout.CENTER);
		// Add B2Center to the center of block 2 borderLayout
		// Add cards (CardPanel) to B2Inner
		card1 = new CardPanel(); // create card 1
		cardContent1 = "King"; // set card 1 initial card content "King"
		cardLabel1 = new JLabel(cardContent1); // set card 1 label with initialized content
		card1.getCard().add(cardLabel1); // Add label to card 1
		card2 = new CardPanel(); // create card 2
		cardContent2 = "Queen"; // set card 2 initial card content "Queen"
		cardLabel2 = new JLabel(cardContent2); // set card 2 label with initialized content
		card2.getCard().add(cardLabel2); // Add label to card 2
		card3 = new CardPanel(); // create card 3
		cardContent3 = "Jack"; // set card 3 initial card content "Jack"
		cardLabel3 = new JLabel(cardContent3); // set card 3 label with initialized content
		card3.getCard().add(cardLabel3); // Add label to card 3
		// Add all cards to B2Inner
		B2Inner.add(card1);
		B2Inner.add(card2);
		B2Inner.add(card3);

// block 3
		// A JPanel (B3Center) is added to the center of the border layout
		// containing an empty border with another JPanel (B3Inner) in it
		JPanel B3Center = new JPanel();
		B3Center.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 20));
		JPanel B3Inner = new JPanel(new GridLayout(2, 1)); // two grids for two buttons
		B3Center.add(B3Inner); // Add B3Inner to B3Center
		B3Inner.setPreferredSize(new Dimension(100, 60)); // set B3Inner panel size
		block3.add(B3Center, BorderLayout.CENTER);
		// Add B3Center to the center of block 3 borderLayout
		// Add buttons to B3Inner
		spin = new JButton("Spin");
		newGame = new JButton("New Game");
		B3Inner.add(spin);
		B3Inner.add(newGame);

// set JFrame visible
		this.setVisible(true);
	}

// Getters and Setters
	public JButton getSpin() {
		return spin;
	}

	public JLabel getCardLabel1() {
		return cardLabel1;
	}

	public JLabel getCardLabel2() {
		return cardLabel2;
	}

	public JLabel getCardLabel3() {
		return cardLabel3;
	}

	public String getCardContent1() {
		return cardContent1;
	}

	public String getCardContent2() {
		return cardContent2;
	}

	public String getCardContent3() {
		return cardContent3;
	}

	public JLabel getBalanceLabel() {
		return balanceLabel;
	}

	public JLabel getStatus() {
		return status;
	}

	public JLabel getStatus2() {
		return status2;
	}

	public JLabel getResult() {
		return result;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public JButton getNewGame() {
		return newGame;
	}

}
