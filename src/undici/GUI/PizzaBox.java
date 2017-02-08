package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

public class PizzaBox extends JPanel {
	public PizzaBox() throws IOException {

		ProductBox pizzaMargharita = new ProductBox("Margherita", 16,
				"Tomaten \r\n" + "Mozzarella  \r\n" + "Oregano \r\n", "src/undici/GUI/Bilder/margherita.jpg");
		ProductBox pizzaHawaii = new ProductBox("Hawaii", 21,
				"Tomaten \r\n" + "Mozzarella  \r\n" + "Hinterschinken \r\n" + "Ananas  \r\n" + "Oregano \r\n",
				"src/undici/GUI/Bilder/hawaii.jpg");
		ProductBox pizzaFunghi = new ProductBox("Funghi", 25,
				"Tomaten \r\n" + "Mozzarella  \r\n" + "Champignons \r\n" + "Oregano \r\n",
				"src/undici/GUI/Bilder/funghi.jpg");

		pizzaMargharita.setPreferredSize(new Dimension(540, 140));
		pizzaHawaii.setPreferredSize(new Dimension(540, 140));
		pizzaFunghi.setPreferredSize(new Dimension(540, 140));

		// JPanel
		add(pizzaMargharita);
		add(pizzaHawaii);
		add(pizzaFunghi);

		setBackground(Color.WHITE);

	}
}