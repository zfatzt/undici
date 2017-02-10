package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JPanel;

import undici.pizza.Pizza;
import undici.pizza.PizzaJDBCDao;

public class PizzaBox extends JPanel {
	public PizzaBox() throws IOException {
		PizzaJDBCDao db = new PizzaJDBCDao();

		try {
			for (Pizza pizza : db.getAllpizzen()) {
				ProductBox pizzaBox = new ProductBox(pizza.getPizza(), pizza.getPreis(), pizza.getZutaten(),
						"src/undici/GUI/Bilder/margherita.jpg");
				add(pizzaBox);
				pizzaBox.setPreferredSize(new Dimension(540, 140));
			}

		} catch (SQLException e) {
			e.getMessage();

		}

		setBackground(Color.WHITE);

	}
}