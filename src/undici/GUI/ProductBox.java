package undici.GUI;

import java.awt.Color;
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
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ProductBox extends JPanel {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("rawtypes")
	public ProductBox(String name, double preis, List<String> zutaten, String pfad, JTextArea area, JTextArea total)
			throws IOException, SQLException {

		// PreisLabel
		JLabel labelPreis = new JLabel("" + preis + " Fr.");

		// AnzahlPizzen
		String[] anzahl = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		@SuppressWarnings("unchecked")
		JComboBox comboBoxAnzahl = new JComboBox(anzahl);
		comboBoxAnzahl.setBackground(Color.white);

		// BestellButton
		JButton buttonBestellen = new JButton("Bestellen");

		// ActionListener
		buttonBestellen.addActionListener(e -> {

			// BestellungTextArea erstellt
			int anzahlPizzen = (comboBoxAnzahl.getSelectedIndex() + 1);
			System.out.println(name + " " + anzahlPizzen + " " + preis);
			area.append(name + "\t" + anzahlPizzen + "\t" + preis + "\n");

			// TotalTextArea erstellt
			if (total.getText().equals(""))
				total.setText(" \t0.0");
			double gesamtPreis = Double.parseDouble(total.getText().substring(4));
			gesamtPreis = gesamtPreis + (anzahlPizzen * preis);
			total.setText("Fr. \t" + gesamtPreis + "\n");

		});

		// Grenze
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleJustification(TitledBorder.LEFT);

		// PizzaBilder
		BufferedImage myPicture = ImageIO.read(new File(pfad));
		JLabel labelBild = new JLabel(new ImageIcon(myPicture));

		// ZutatenListe
		String[] zutatenArr = new String[zutaten.size()];
		zutatenArr = zutaten.toArray(zutatenArr);
		@SuppressWarnings("unchecked")
		JList zutaten2 = new JList(zutatenArr);

		// Alles zu JPanel Hinzuf�gen
		setBackground(Color.WHITE);
		setBorder(border);
		setVisible(true);
		add(labelBild);
		add(zutaten2);
		add(labelPreis);
		add(comboBoxAnzahl);
		add(buttonBestellen);

	}

}
