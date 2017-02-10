package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import undici.pizza.Pizza;
import undici.pizza.PizzaJDBCDao;

public class ProductBox extends JPanel {
	@SuppressWarnings("rawtypes")
	public ProductBox(String name, double preis, List<String> zutaten, String pfad) throws IOException, SQLException {
		// JLabel
		JLabel labelPreis = new JLabel("" + preis + " Fr.");

		// Buttons
		JButton buttonBestellen = new JButton("Bestellen");

		// Border
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleJustification(TitledBorder.LEFT);

		// Bild
		BufferedImage myPicture = ImageIO.read(new File(pfad));
		JLabel labelBild = new JLabel(new ImageIcon(myPicture));

		// Beschreibung

		String[] zutatenArr = new String[zutaten.size()];
		zutatenArr = zutaten.toArray(zutatenArr);
		JList zutaten2 = new JList(zutatenArr);

		// Combobox
		String[] anzahl = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		JComboBox comboBoxAnzahl = new JComboBox(anzahl);
		comboBoxAnzahl.setBackground(Color.white);
		comboBoxAnzahl.setPreferredSize(new Dimension(50, 30));

		// JPanel
		setBackground(Color.WHITE);
		setMaximumSize(new Dimension(540, 140));
		setBorder(border);
		setVisible(true);
		add(labelBild);
		add(zutaten2);
		add(labelPreis);
		add(comboBoxAnzahl);
		add(buttonBestellen);

	}

}
