import javax.swing.*;
import java.awt.*;

public class CardPanel extends JPanel {
//	private String initialText = "";
	private JPanel card;
	
	public CardPanel() {
		card = new JPanel();
		card.setBackground(Color.yellow); // set card color
		this.add(card);
		card.setPreferredSize(new Dimension(46, 82)); // set card size
		card.setBorder(BorderFactory.createLineBorder(Color.black)); // set card border line
		card.setLayout(new GridBagLayout()); // set label to panel center
	}
	
// Getter
	public JPanel getCard() {
		return card;
	}	
}
