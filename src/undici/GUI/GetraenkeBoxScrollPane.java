package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.io.IOException;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import undici.getraenke.Getraenke;
import undici.getraenke.GetraenkeJDBCDao;
import undici.pizza.Pizza;
import undici.pizza.PizzaJDBCDao;

public class GetraenkeBoxScrollPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane vertical;
	private JPanel content = new JPanel();

	public GetraenkeBoxScrollPane(JTextArea area, JTextArea total) throws IOException {
		super();
		
		//höhe, breite und Anzahl Pizzen sichtbar auf einer seite
		int numberOfVisibleRows = 5;
		int WidthOfGetraenkeBox = 540;
		int HightOfGetraenkeBox = 155;
		
		BoxLayout boxLayout = new BoxLayout(content, BoxLayout.Y_AXIS);
		content.setLayout(boxLayout);
	
		GetraenkeJDBCDao db = new GetraenkeJDBCDao();

		
		//Getraenke wird von der Datenbank ausgelesen
		try {
			for (Getraenke getraenk : db.getAllGetraenke()) {
				ProductBox getraenkeBox = new ProductBox(getraenk.getGetraenk(), getraenk.getPreis(),getraenk.getEmpty() , getraenk.getBild(), area, total);
				content.add(getraenkeBox);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//ScrollPane
		vertical = new JScrollPane(content);
		vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		vertical.setPreferredSize(new Dimension(WidthOfGetraenkeBox, (HightOfGetraenkeBox * numberOfVisibleRows) ));

		add(vertical);
		setPreferredSize(new Dimension(550, 785));
		setBackground(Color.WHITE);

		updateUI();
		invalidate();
		repaint();

	}
}