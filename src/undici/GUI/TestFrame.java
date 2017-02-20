package undici.GUI;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class TestFrame extends JFrame{

	public static void main(String[] args) throws IOException {
		JFrame testFrame = new TestFrame();
		Dimension d = new Dimension(800, 1000);

		testFrame.setTitle("Undici");
		testFrame.setPreferredSize(d);
		testFrame.setLocation(600, 000);
		testFrame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		
		testFrame.getContentPane().add(new PizzaBoxScrollPane());
		
		testFrame.pack();
		testFrame.setVisible(true);
	}
	
}
