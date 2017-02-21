package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PizzaFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public PizzaFrame() throws IOException {
		Dimension d = new Dimension(800, 1000);

		// JFrame
		setTitle("Undici");
		setPreferredSize(d);
		setLocation(600, 000);
		setBackground(Color.WHITE);

		// Logo
		BufferedImage myPicture = ImageIO.read(new File("src/undici/GUI/Bilder/undici_logo.png"));

		// TitledBorder
		TitledBorder anmeldenBorder = BorderFactory.createTitledBorder("Anmelden");
		anmeldenBorder.setTitleJustification(TitledBorder.LEFT);

		TitledBorder bestellungBorder = BorderFactory.createTitledBorder("Bestellung");
		bestellungBorder.setTitleJustification(TitledBorder.LEFT);

		TitledBorder totalBorder = BorderFactory.createTitledBorder("Total");
		totalBorder.setTitleJustification(TitledBorder.LEFT);

		// Jpanel erstellen
		JPanel panelNorth = new JPanel(new BorderLayout());
		JPanel panelCenter = new JPanel();
		JPanel panelLeft = new JPanel();
		JPanel panelAnmeldung = new JPanel();
		JPanel panelAnmeldenButton = new JPanel();
		JPanel panelRegistrierenButton = new JPanel();
		JPanel panelLogo = new JPanel();
		JPanel panelBestellung = new JPanel();
		JPanel panelGetraenke = new JPanel();

		panelNorth.setBackground(Color.WHITE);
		panelCenter.setBackground(Color.WHITE);
		panelLeft.setBackground(Color.WHITE);
		panelAnmeldung.setBackground(Color.WHITE);
		panelAnmeldenButton.setBackground(Color.WHITE);
		panelRegistrierenButton.setBackground(Color.WHITE);
		panelLogo.setBackground(Color.WHITE);
		panelBestellung.setBackground(Color.WHITE);
		panelGetraenke.setBackground(Color.WHITE);

		// groesse setzen
		panelNorth.setPreferredSize(new Dimension(550, 150));
		panelCenter.setPreferredSize(new Dimension(550, 850));
		panelLeft.setPreferredSize(new Dimension(220, 1000));

		panelAnmeldung.setPreferredSize(new Dimension(220, 150));
		panelAnmeldenButton.setPreferredSize(new Dimension(210, 50));
		panelBestellung.setPreferredSize(new Dimension(220, 650));

		panelGetraenke.setPreferredSize(new Dimension(550, 785));
		panelAnmeldung.setBorder(anmeldenBorder);
		panelBestellung.setBorder(bestellungBorder);

		// BestellungsTextArea
		String textBestellung = "";
		JTextArea textAreaBestellung = new JTextArea(textBestellung);
		textAreaBestellung.setEditable(false);
		textAreaBestellung.setPreferredSize(new Dimension(210, 620));
		panelBestellung.add(textAreaBestellung);

		// TotalPreisTextArea
		String total = "";
		JTextArea textAreaTotal = new JTextArea(total);
		textAreaTotal.setEditable(false);
		textAreaTotal.setPreferredSize(new Dimension(210, 630));
		textAreaTotal.setPreferredSize(new Dimension(220, 150));
		textAreaTotal.setBorder(totalBorder);

		// JLabel
		JLabel labelLogo = new JLabel(new ImageIcon(myPicture));

		// Button
		JButton buttonRegistrieren = new JButton("Registrieren");
		JButton buttonAnmelden = new JButton("Anmelden");

		buttonAnmelden.setPreferredSize(new Dimension(150, 40));
		buttonRegistrieren.setPreferredSize(new Dimension(150, 40));

		// ActionListener
		buttonAnmelden.addActionListener(e -> {
			JDialog ad = new AnmeldeDialog();
			ad.pack();
		});
		buttonRegistrieren.addActionListener(e -> {
			JDialog rd = new RegistrierenDialog();
			rd.pack();
		});

		// HintergrundFarbe setzen
		panelNorth.setBackground(Color.WHITE);
		buttonAnmelden.setBackground(Color.WHITE);
		buttonRegistrieren.setBackground(Color.WHITE);

		// TabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Pizza
		PizzaBoxScrollPane pizzaBox = new PizzaBoxScrollPane(textAreaBestellung, textAreaTotal);

		tabbedPane.addTab("Pizza", pizzaBox);
		tabbedPane.addTab("Getränke", panelGetraenke);

		// Panel hinzufuegen
		panelLogo.add(labelLogo);

		panelAnmeldenButton.add(buttonAnmelden);

		panelRegistrierenButton.add(buttonRegistrieren);

		panelAnmeldung.add(panelAnmeldenButton);
		panelAnmeldung.add(panelRegistrierenButton);

		panelLeft.add(panelBestellung);
		panelLeft.add(textAreaTotal);

		panelCenter.add(tabbedPane);

		panelNorth.add(panelAnmeldung, BorderLayout.WEST);
		panelNorth.add(panelLogo);

		// Panel zu Frame hinzufuegen
		add(panelLeft, BorderLayout.WEST);
		add(panelNorth, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);

		// Rest
		pack();
		setVisible(true);
	}

}
