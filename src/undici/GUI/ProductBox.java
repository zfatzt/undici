package undici.GUI;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class ProductBox extends JPanel {
	@SuppressWarnings("rawtypes")
	public ProductBox(String name, double preis, List<String> zutaten, String pfad, JTextArea area, JTextArea total) throws IOException, SQLException {
		
		// JLabel
		JLabel labelPreis = new JLabel("" + preis + " Fr.");

		// Combobox
		String[] anzahl = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
		JComboBox comboBoxAnzahl = new JComboBox(anzahl);
		comboBoxAnzahl.setBackground(Color.white);
		
		// Buttons
		JButton buttonBestellen = new JButton("Bestellen");

		buttonBestellen.addActionListener(e -> {
			int anzahlPizzen = (comboBoxAnzahl.getSelectedIndex() + 1);
			System.out.println(name + " " + anzahlPizzen + " " + preis);
			area.append(name + "\t" + anzahlPizzen + "\t" + preis + "\n");
			if(total.getText().equals("")) total.setText("total > \t0.0");
			double gesamtPreis = Double.parseDouble(total.getText().substring(8));
			gesamtPreis = gesamtPreis + (anzahlPizzen * preis);
			total.setText( "total > \t" + gesamtPreis + "\n");			
			
		});
																												

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

		// comboBoxAnzahl.setPreferredSize(new Dimension(50, 30));

		// JPanel
		setBackground(Color.WHITE);
		// setMaximumSize(new Dimension(540, 140));
		setBorder(border);
		setVisible(true);
		add(labelBild);
		add(zutaten2);
		add(labelPreis);
		add(comboBoxAnzahl);
		add(buttonBestellen);
		

	}

}
