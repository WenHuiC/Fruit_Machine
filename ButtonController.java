/* AE3 - Fruit Machine - ButtonController
 * Wen Hui Chen  2456203C*/

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonController implements ActionListener {
	// attributes
	private JButton spinButton, newGameButton;
	private String newContent; // store random content
	private JLabel label1, label2, label3;
	private String content1, content2, content3; // cards current content
	private Counter c; // count balance
	private int balance; // balance value
	private JLabel balanceLabel, status, status2, result;
	// two status (status and status 2) for specific condition
	// for example: two same cards + a "Joker" (show two status on balance counting)
	private Spinner spinner; // random content

	public ButtonController(Board gui) {
		this.spinButton = gui.getSpin();
		this.newGameButton = gui.getNewGame();
		this.label1 = gui.getCardLabel1();
		this.label2 = gui.getCardLabel2();
		this.label3 = gui.getCardLabel3();
		this.balance = gui.getBalance();
		this.balanceLabel = gui.getBalanceLabel();
		this.status = gui.getStatus();
		this.status2 = gui.getStatus2();
		this.result = gui.getResult();
// Add action listener
		spinButton.addActionListener(this);
		newGameButton.addActionListener(this);
		c = new Counter(gui); // Create a counter
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		newGameButton.setEnabled(false); // set newGameButton not activated
		// set spin button behavior
		if (e.getSource() == spinButton) {
			status2.setText(""); // reset status2 content
			setNewTextToLabel(label1); // create new content of card 1
			content1 = newContent; // replace new content to current card 1 content
			setNewTextToLabel(label2); // create new content of card 2
			content2 = newContent; // replace new content to current card 2 content
			setNewTextToLabel(label3); // create new content of card 3
			content3 = newContent; // replace new content to current card 3 content
			counting(); // count balance
			this.balance = c.getBalance(); // set count balance result to this.balance
			balanceLabel.setText("balance is " + balance + "."); // renew balanceLabel text showed on game board
			// check win / lose - end game
			if (winLose()) {
				spinButton.setEnabled(false); // set spinButton not activated
				newGameButton.setEnabled(true); // set newGameButton enable
			}
		}
		// set spin button behavior
		if (e.getSource() == newGameButton) {
			resetBoard(); // reset board status while newGameButton is pressed
			spinButton.setEnabled(true); // reset spinButton enable when a new game start
		}
	}

// reset board status
	public void resetBoard() {
		balanceLabel.setText("balance is " + balance + ".");
		status.setText("welcome!");
		status2.setText("");
		result.setText("");
		label1.setText("King");
		label2.setText("Queen");
		label3.setText("Jack");
		c.resetBalance(); // reset balance value
	}

// count balance
	public void counting() {
		// pass current contents to counter
		c.setContent1(this.content1);
		c.setContent2(this.content2);
		c.setContent3(this.content3);
		// count balance
		c.countBalance(balance);
	}

// win / lose
	public Boolean winLose() {
		if (balance >= 150 || balance < 0) {
			balance = 100; // reset balance
			return true;
		}
		return false;
	}

// random card content
	public void spinText() {
		spinner = new Spinner(); // create new spinner
		newContent = spinner.getNewText();
	}

// set new content to label in card
	public void setNewTextToLabel(JLabel label) {
		spinText(); // create random content
		label.setText(newContent); // set new content to card label
	}

// Getters
	public String getContent1() {
		return content1;
	}

	public String getContent2() {
		return content2;
	}

	public String getContent3() {
		return content3;
	}

}
