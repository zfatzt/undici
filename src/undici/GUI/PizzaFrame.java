package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

public class PizzaFrame extends JDialog {
	private static final long serialVersionUID = 1L;

	public PizzaFrame() throws IOException {
		Dimension d = new Dimension(800, 1000);

		// JDialog
		setTitle("Undici");
		setPreferredSize(d);
		setLocation(600, 000);
		setResizable(false);
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

		// Jpanel
		JPanel panelNorth = new JPanel(new BorderLayout());
		JPanel panelCenter = new JPanel();
		JPanel panelLeft = new JPanel();
		JPanel panelAnmeldung = new JPanel();
		JPanel panelAnmeldenButton = new JPanel();
		JPanel panelRegistrierenButton = new JPanel();
		JPanel panelLogo = new JPanel();
		JPanel panelTotal = new JPanel();
		JPanel panelBestellung = new JPanel();
		JPanel panelPizza = new JPanel();
		panelPizza.setLayout(new BoxLayout(panelPizza, BoxLayout.Y_AXIS));

		JPanel panelSonderpizza = new JPanel();
		JPanel panelGetraenke = new JPanel();

		panelNorth.setBackground(Color.BLUE);
		panelCenter.setBackground(Color.WHITE);
		panelLeft.setBackground(Color.WHITE);
		panelAnmeldung.setBackground(Color.WHITE);
		panelAnmeldenButton.setBackground(Color.WHITE);
		panelRegistrierenButton.setBackground(Color.WHITE);
		panelLogo.setBackground(Color.WHITE);
		panelTotal.setBackground(Color.WHITE);
		panelBestellung.setBackground(Color.WHITE);
		panelPizza.setBackground(Color.WHITE);
		panelSonderpizza.setBackground(Color.WHITE);
		panelGetraenke.setBackground(Color.WHITE);

		panelNorth.setPreferredSize(new Dimension(550, 150));
		panelCenter.setPreferredSize(new Dimension(550, 850));
		panelLeft.setPreferredSize(new Dimension(220, 1000));
		panelAnmeldung.setPreferredSize(new Dimension(220, 150));
		panelAnmeldenButton.setPreferredSize(new Dimension(210, 50));
		panelBestellung.setPreferredSize(new Dimension(220, 660));
		panelTotal.setPreferredSize(new Dimension(220, 150));
		panelPizza.setPreferredSize(new Dimension(550, 785));
		panelSonderpizza.setPreferredSize(new Dimension(550, 785));
		panelGetraenke.setPreferredSize(new Dimension(550, 785));

		panelAnmeldung.setBorder(anmeldenBorder);
		panelBestellung.setBorder(bestellungBorder);
		panelTotal.setBorder(totalBorder);

		// TextArea
		String textBestellung = "Hallo \r\n" + "Tobias  \r\n" + "wie gehts \r\n"; // Bestellung
																					// hier
																					// einfügen
																					// mit
																					// toString
		JTextArea textFieldBestellung = new JTextArea(textBestellung);
		textFieldBestellung.setEditable(false);
		textFieldBestellung.setBackground(Color.WHITE);
		textFieldBestellung.setPreferredSize(new Dimension(210, 630));

		// JLabel
		JLabel labelLogo = new JLabel(new ImageIcon(myPicture));

		// Button
		JButton buttonRegistrieren = new JButton("Registrieren");
		JButton buttonAnmelden = new JButton("Anmelden");

		buttonAnmelden.setVisible(true);
		buttonRegistrieren.setVisible(true);

		buttonAnmelden.setBackground(Color.white);
		buttonRegistrieren.setBackground(Color.white);

		buttonAnmelden.setPreferredSize(new Dimension(150, 40));
		buttonRegistrieren.setPreferredSize(new Dimension(150, 40));

		buttonAnmelden.addActionListener(e -> {
			JDialog ad = new AnmeldeDialog();
			ad.pack();
		});
		buttonRegistrieren.addActionListener(e -> {
			JDialog rd = new RegistrierenDialog();
			rd.pack();
		});

		// TabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Pizza", panelPizza);
		tabbedPane.addTab("Sonderpizza", panelSonderpizza);
		tabbedPane.addTab("Getränke", panelGetraenke);

		// Pizza
		PizzaBox pizzaBox = new PizzaBox();

		// Panel hinzufuegen
		panelLogo.add(labelLogo);

		panelBestellung.add(textFieldBestellung);

		panelAnmeldenButton.add(buttonAnmelden);

		panelRegistrierenButton.add(buttonRegistrieren);

		panelAnmeldung.add(panelAnmeldenButton);
		panelAnmeldung.add(panelRegistrierenButton);

		panelLeft.add(panelBestellung);
		panelLeft.add(panelTotal);

		panelPizza.add(pizzaBox);

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