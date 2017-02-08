package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JPanel;

public class PizzaBox extends JPanel {
	public PizzaBox() throws IOException {

		ProductBox pizzaMargharita = new ProductBox("Margharita", 2.5,
				"Tomatensauce \r\n" + "Mozzarella  \r\n" + "Basilikum \r\n", "src/undici/GUI/Bilder/margharita.jpg");
		ProductBox pizzaHawaii = new ProductBox("Hawaii", 2.5, "ganz toole sache",
				"src/undici/GUI/Bilder/margharita.jpg");
		ProductBox pizzaFunghi = new ProductBox("Funghi", 2.5, "ganz toole sache",
				"src/undici/GUI/Bilder/margharita.jpg");

		pizzaMargharita.setPreferredSize(new Dimension(540, 140));
		pizzaHawaii.setPreferredSize(new Dimension(540, 140));
		pizzaFunghi.setPreferredSize(new Dimension(540, 140));
		
		//JPanel
		add(pizzaMargharita);
		add(pizzaHawaii);
		add(pizzaFunghi);
		
		setBackground(Color.WHITE);

	}
}