package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import undici.pizza.Pizza;
import undici.pizza.PizzaJDBCDao;

public class PizzaBoxScrollPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane vertical;
	private JPanel paneInhalt = new JPanel();

	public PizzaBoxScrollPane(Bestellung bestellung, JTextArea area, JTextArea total, double gesamtPreis)
			throws IOException {
		super();

		// Hoehe, Breite und Anzahl Pizzen sichtbar auf einer Seite
		int numberOfVisibleRows = 5;
		int WidthOfPizzaBox = 540;
		int HightOfPizzaBox = 155;

		BoxLayout boxLayout = new BoxLayout(paneInhalt, BoxLayout.Y_AXIS);
		paneInhalt.setLayout(boxLayout);

		PizzaJDBCDao db = new PizzaJDBCDao();

		// Pizzas werden von der Datenbank ausgelesen
		try {
			for (Pizza pizza : db.getAllpizzen()) {
				ProductBox pizzaBox = new ProductBox(bestellung, pizza.getPizza(), pizza.getPreis(), pizza.getZutaten(),
						pizza.getBild(), area, total, gesamtPreis);
				paneInhalt.add(pizzaBox);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ScrollPane
		vertical = new JScrollPane(paneInhalt);
		vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		vertical.setPreferredSize(new Dimension(WidthOfPizzaBox, (HightOfPizzaBox * numberOfVisibleRows)));

		add(vertical);
		setPreferredSize(new Dimension(550, 785));
		setBackground(Color.WHITE);

		updateUI();
		invalidate();
		repaint();

	}
}