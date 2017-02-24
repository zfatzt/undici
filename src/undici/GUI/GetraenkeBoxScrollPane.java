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

public class GetraenkeBoxScrollPane extends JPanel {

	private static final long serialVersionUID = 1L;
	private JScrollPane vertical;
	private JPanel paneInhalt = new JPanel();

	public GetraenkeBoxScrollPane(Bestellung bestellung, JTextArea area, JTextArea total, double gesamtPreis)
			throws IOException {
		super();

		// Höhe, Breite und Anzahl Pizzen sichtbar auf einer Seite
		int numberOfVisibleRows = 5;
		int WidthOfGetraenkeBox = 540;
		int HightOfGetraenkeBox = 155;

		BoxLayout boxLayout = new BoxLayout(paneInhalt, BoxLayout.Y_AXIS);
		paneInhalt.setLayout(boxLayout);

		GetraenkeJDBCDao db = new GetraenkeJDBCDao();

		// Getraenke werden von der Datenbank ausgelesen
		try {
			for (Getraenke getraenk : db.getAllGetraenke()) {
				ProductBox getraenkeBox = new ProductBox(bestellung, getraenk.getGetraenk(), getraenk.getPreis(),
						getraenk.getEmpty(), getraenk.getBild(), area, total, gesamtPreis);
				paneInhalt.add(getraenkeBox);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// ScrollPane
		vertical = new JScrollPane(paneInhalt);
		vertical.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		vertical.setPreferredSize(new Dimension(WidthOfGetraenkeBox, (HightOfGetraenkeBox * numberOfVisibleRows)));

		add(vertical);
		setPreferredSize(new Dimension(550, 785));
		setBackground(Color.WHITE);

		updateUI();
		invalidate();
		repaint();

	}

}