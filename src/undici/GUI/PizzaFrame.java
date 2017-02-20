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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;
import javax.swing.border.TitledBorder;

public class PizzaFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	public PizzaFrame() throws IOException {
		Dimension d = new Dimension(800, 1000);

		// JDialog
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

		// Jpanel
		JPanel panelNorth = new JPanel(new BorderLayout());
		JPanel panelCenter = new JPanel();
		JPanel panelLeft = new JPanel();
		JPanel panelAnmeldung = new JPanel();
		JPanel panelAnmeldenButton = new JPanel();
		JPanel panelRegistrierenButton = new JPanel();
		JPanel panelLogo = new JPanel();
		
		JPanel panelBestellung = new JPanel();
		//JPanel panelSonderpizza = new JPanel();
		JPanel panelGetraenke = new JPanel();

		panelNorth.setBackground(Color.BLUE);
		panelCenter.setBackground(Color.WHITE);
		panelLeft.setBackground(Color.WHITE);
		panelAnmeldung.setBackground(Color.WHITE);
		panelAnmeldenButton.setBackground(Color.WHITE);
		panelRegistrierenButton.setBackground(Color.WHITE);
		panelLogo.setBackground(Color.WHITE);
	
		panelBestellung.setBackground(Color.WHITE);
		panelGetraenke.setBackground(Color.WHITE);

		panelNorth.setPreferredSize(new Dimension(550, 150));
		panelCenter.setPreferredSize(new Dimension(550, 850));
		panelLeft.setPreferredSize(new Dimension(220, 1000));

		panelAnmeldung.setPreferredSize(new Dimension(220, 150));
		panelAnmeldenButton.setPreferredSize(new Dimension(210, 50));
		panelBestellung.setPreferredSize(new Dimension(220, 660));
		
		
		//panelSonderpizza.setPreferredSize(new Dimension(550, 785));
		panelGetraenke.setPreferredSize(new Dimension(550, 785));
		panelAnmeldung.setBorder(anmeldenBorder); 
		panelBestellung.setBorder(bestellungBorder);
		
		
		
		
		//bestellungsfeld
		String textBestellung = "";
		
		
		//Jtextarea
		JTextArea textFieldBestellung = new JTextArea(textBestellung);
		textFieldBestellung.setEditable(false);
		textFieldBestellung.setBackground(Color.WHITE);
		textFieldBestellung.setPreferredSize(new Dimension(210, 630));
		panelBestellung.add(textFieldBestellung);
		
	
		
		//Preis
		String total = "";
		JTextArea panelTotal = new JTextArea(total);
		panelTotal.setEditable(false);
		panelTotal.setBackground(Color.WHITE);
		panelTotal.setPreferredSize(new Dimension(210, 630));
		panelTotal.setPreferredSize(new Dimension(220, 150));
		panelTotal.setBorder(totalBorder);
		panelLeft.add(panelTotal);
		
		
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

		// Pizza
		PizzaBoxScrollPane pizzaBox = new PizzaBoxScrollPane(textFieldBestellung, panelTotal);

		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.addTab("Pizza", pizzaBox);
		//tabbedPane.addTab("Sonderpizza", panelSonderpizza); Hier müssen wir noch schauen ob wir es hinkriegen.
		tabbedPane.addTab("Getränke", panelGetraenke);

		// Panel hinzufuegen
		panelLogo.add(labelLogo);

		
		
		

		panelAnmeldenButton.add(buttonAnmelden);

		panelRegistrierenButton.add(buttonRegistrieren);

		panelAnmeldung.add(panelAnmeldenButton);
		panelAnmeldung.add(panelRegistrierenButton);

		panelLeft.add(panelBestellung);
		
		

		
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
