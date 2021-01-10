import java.util.Random;
import java.awt.*;
import javax.swing.*;

public class Spinner {
	private String newText;
	
	public Spinner() {
		newText = CreateNewText(); // create random content
	}
	
	public String CreateNewText() {
		Random r = new Random();
		int ranNum = r.nextInt(4);
		// 0-Joker, 1-Ace, 2-King, 3-Queen, 4-Jack
		String randomContent = "";
		if(ranNum == 0) {
			randomContent = "Joker";
		}
		if(ranNum == 1) {
			randomContent = "Ace";
		}
		if(ranNum == 2) {
			randomContent = "King";
		}
		if(ranNum == 3) {
			randomContent = "Queen";
		}
		if(ranNum == 4) {
			randomContent = "Jack";
		}
		return randomContent;

	}

	public String getNewText() {
		return newText;
	}
	
	

}
