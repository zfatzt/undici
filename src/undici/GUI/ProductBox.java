package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ProductBox extends JPanel {
	public ProductBox(String name, Double preis, String beschreibung, String pfad) throws IOException {

		// Buttons
		JButton buttonBestellen = new JButton("Bestellen");

		// Border
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleJustification(TitledBorder.LEFT);

		// Bild
		BufferedImage myPicture = ImageIO.read(new File(pfad));
		JLabel labelBild = new JLabel(new ImageIcon(myPicture));

		// Beschreibung
		JTextArea textBeschreibung = new JTextArea(beschreibung);
		textBeschreibung.setEditable(false);

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
		add(textBeschreibung);
		add(comboBoxAnzahl);
		add(buttonBestellen);

	}

}
