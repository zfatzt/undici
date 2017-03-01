package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.image.BufferedImage;
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
import javax.swing.JTextPane;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import undici.kunde.Kunde;

public class PizzaFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	// Button
	JButton buttonRegistrieren = new JButton("Registrieren");
	JButton buttonAnmelden = new JButton("Anmelden");
	JButton buttonBestellungAbschicken = new JButton("Bestellung Abschicken");
	JButton buttonBestellungLoeschen = new JButton("Bestellung Löschen");

	private Kunde kunde;
	private Bestellung bestellung = new Bestellung();

	// Jpanel erstellen
	JPanel panelNorden = new JPanel(new BorderLayout());
	JPanel panelMitte = new JPanel();
	JPanel panelLinks = new JPanel();
	JPanel panelAnmeldung = new JPanel();
	JPanel panelAnmeldenButton = new JPanel();
	JPanel panelRegistrierenButton = new JPanel();
	JPanel panelLogo = new JPanel();
	JPanel panelBestellung = new JPanel();
	JPanel panelGetraenke = new JPanel();

	JTextPane textAreaAngemeldet = new JTextPane();

	public PizzaFrame() throws IOException {
		// JFrame
		setTitle("Undici");
		setPreferredSize(new Dimension(800, 1000));
		setLocation(600, 000);
		setBackground(Color.WHITE);
		setResizable(false);
  
		// Logo
		BufferedImage logo = ImageIO.read(this.getClass().getResourceAsStream("/undici/GUI/Bilder/undici_logo.png"));

		// TitledBorder
		TitledBorder anmeldenBorder = BorderFactory.createTitledBorder("Anmelden");
		anmeldenBorder.setTitleJustification(TitledBorder.LEFT);

		TitledBorder bestellungBorder = BorderFactory.createTitledBorder("Bestellung");
		bestellungBorder.setTitleJustification(TitledBorder.LEFT);

		TitledBorder totalBorder = BorderFactory.createTitledBorder("Total");
		totalBorder.setTitleJustification(TitledBorder.LEFT);

		// groesse setzen
		panelNorden.setPreferredSize(new Dimension(550, 150));
		panelMitte.setPreferredSize(new Dimension(550, 850));
		panelLinks.setPreferredSize(new Dimension(220, 1000));

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
		textAreaBestellung.setPreferredSize(new Dimension(210, 575));

		// TotalPreisTextArea
		String total = "";
		JTextArea textAreaTotal = new JTextArea(total);
		textAreaTotal.setEditable(false);
		textAreaTotal.setPreferredSize(new Dimension(220, 100));
		textAreaTotal.setBorder(totalBorder);
		double gesamtPreis = 0;
		if (!textAreaTotal.getText().equals("")) {
			gesamtPreis = Double.parseDouble(textAreaTotal.getText().substring(4));
		}
		
		// JLabel
		JLabel labelLogo = new JLabel(new ImageIcon(logo));

		// labelAngemeldet
		textAreaAngemeldet.setVisible(false);
		StyledDocument doc = textAreaAngemeldet.getStyledDocument();

		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);

		// Buttons
		buttonAnmelden.setPreferredSize(new Dimension(150, 40));
		buttonRegistrieren.setPreferredSize(new Dimension(150, 40));
		buttonBestellungAbschicken.setPreferredSize(new Dimension(220, 40));
		buttonBestellungLoeschen.setPreferredSize(new Dimension(210, 40));

		// ActionListener
		buttonAnmelden.addActionListener(e -> {
			JDialog ad = new AnmeldeDialog(this);
			ad.pack();

		});
		buttonRegistrieren.addActionListener(e -> {
			JDialog rd = new RegistrierenDialog();
			rd.pack();
		});

		buttonBestellungAbschicken.addActionListener(e -> {
			if (kunde == null) {
				JDialog abd = new AbsendenDialog(this);
				abd.pack();
			} else {
				JDialog abd = new ZahlungsDialog(this, kunde, textAreaTotal, textAreaBestellung, textAreaAngemeldet);
				abd.pack();
			}
		});
		buttonBestellungLoeschen.addActionListener(e -> {
			textAreaBestellung.setText("");
			textAreaTotal.setText("Fr. \t" + 0.00 + "\n");
			bestellung.clear();
		});

		// HintergrundFarbe setzen
		panelNorden.setBackground(Color.WHITE);
		buttonAnmelden.setBackground(Color.WHITE);
		buttonRegistrieren.setBackground(Color.WHITE);
		buttonBestellungAbschicken.setBackground(Color.WHITE);
		buttonBestellungLoeschen.setBackground(Color.WHITE);
		panelNorden.setBackground(Color.WHITE);
		panelMitte.setBackground(Color.WHITE);
		panelLinks.setBackground(Color.WHITE);
		panelAnmeldung.setBackground(Color.WHITE);
		panelAnmeldenButton.setBackground(Color.WHITE);
		panelRegistrierenButton.setBackground(Color.WHITE);
		panelLogo.setBackground(Color.WHITE);
		panelBestellung.setBackground(Color.WHITE);
		panelGetraenke.setBackground(Color.WHITE);

		// TabbedPane
		JTabbedPane tabbedPane = new JTabbedPane();

		// ScrollPanes
		PizzaBoxScrollPane pizzaBox = new PizzaBoxScrollPane(bestellung, textAreaBestellung, textAreaTotal,
				gesamtPreis);
		GetraenkeBoxScrollPane getraenkeBox = new GetraenkeBoxScrollPane(bestellung, textAreaBestellung, textAreaTotal,
				gesamtPreis);

		tabbedPane.addTab("Pizza", pizzaBox);
		tabbedPane.addTab("Getränke", getraenkeBox);

		// Panel hinzufuegen
		panelLogo.add(labelLogo);

		panelAnmeldenButton.add(buttonAnmelden);

		panelRegistrierenButton.add(buttonRegistrieren);

		panelAnmeldung.add(panelAnmeldenButton);
		panelAnmeldung.add(panelRegistrierenButton);
		panelAnmeldung.add(textAreaAngemeldet);

		panelLinks.add(panelBestellung);
		panelLinks.add(textAreaTotal);
		panelLinks.add(buttonBestellungAbschicken);

		panelBestellung.add(textAreaBestellung);
		panelBestellung.add(buttonBestellungLoeschen);

		panelMitte.add(tabbedPane);

		panelNorden.add(panelAnmeldung, BorderLayout.WEST);
		panelNorden.add(panelLogo);

		// Panel zu Frame hinzufuegen
		add(panelLinks, BorderLayout.WEST);
		add(panelNorden, BorderLayout.NORTH);
		add(panelMitte, BorderLayout.CENTER);

		// Rest
		pack();
		setVisible(true);
	}

	public void angemeldet(Kunde kunde) {
		this.kunde = kunde;
		buttonAnmelden.setVisible(false);
		buttonRegistrieren.setVisible(false);

		textAreaAngemeldet.setVisible(true);
		textAreaAngemeldet.setText("Guten Tag, Sie sind angemeldet als: \n" + kunde.getAnrede() + " "
				+ kunde.getVorname() + " " + kunde.getName());
		textAreaAngemeldet.setFont(new Font("Arial", 1, 12));
		textAreaAngemeldet.setEditable(false);

	}

}
