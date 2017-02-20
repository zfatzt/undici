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
	private JPanel content = new JPanel();

	public PizzaBoxScrollPane(JTextArea area, JTextArea total) throws IOException {
		super();

		int numberOfVisibleRows = 5;
		int WidthOfPizzaBox = 540;
		int HightOfPizzaBox = 140;
		
		BoxLayout boxLayout = new BoxLayout(content, BoxLayout.Y_AXIS);
		content.setLayout(boxLayout);
		
		PizzaJDBCDao db = new PizzaJDBCDao();

		

		try {
			for (Pizza pizza : db.getAllpizzen()) {
				ProductBox pizzaBox = new ProductBox(pizza.getPizza(), pizza.getPreis(), pizza.getZutaten(), pizza.getBild(), area, total);
				content.add(pizzaBox);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		vertical = new JScrollPane(content);
		vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		vertical.setPreferredSize(new Dimension(WidthOfPizzaBox, (HightOfPizzaBox * numberOfVisibleRows) ));

		add(vertical);
		setPreferredSize(new Dimension(550, 785));
		setBackground(Color.WHITE);

		updateUI();
		invalidate();
		repaint();

	}
}