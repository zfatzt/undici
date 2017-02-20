package undici.GUI;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class Hauptprogramm {

	public static void main(String[] args) throws IOException {
		JFrame abd = new PizzaFrame();
		abd.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		abd.pack();

	}

}
