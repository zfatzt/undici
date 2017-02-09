package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class RegistrierenDialog extends JDialog {
	private static final long serialVersionUID = 3L;

	public RegistrierenDialog() {

		// JWindow
		setTitle("Registrierung");
		setPreferredSize(new Dimension(350, 550));
		setLocation(800, 100);
		setResizable(false);
		setBackground(Color.white);
		setUndecorated(true);

		// JPanel
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelGeschlecht = new JPanel();
		JPanel panelVorname = new JPanel();
		JPanel panelName = new JPanel();
		JPanel panelStrasse = new JPanel();
		JPanel panelOrt = new JPanel();
		JPanel panelTelefon = new JPanel();
		JPanel panelEmail = new JPanel();
		JPanel panelEmailWiederholen = new JPanel();
		JPanel panelPasswort = new JPanel();
		JPanel panelPasswortWiederholen = new JPanel();

		panelNorth.setBackground(Color.white);
		panelSouth.setBackground(Color.white);
		panelGeschlecht.setBackground(Color.white);
		panelVorname.setBackground(Color.white);
		panelName.setBackground(Color.white);
		panelStrasse.setBackground(Color.white);
		panelOrt.setBackground(Color.white);
		panelTelefon.setBackground(Color.white);
		panelEmail.setBackground(Color.white);
		panelEmailWiederholen.setBackground(Color.white);
		panelPasswort.setBackground(Color.white);
		panelPasswortWiederholen.setBackground(Color.white);

		panelNorth.setPreferredSize(new Dimension(350, 490));
		panelSouth.setPreferredSize(new Dimension(350, 60));
		panelGeschlecht.setPreferredSize(new Dimension(350, 40));
		panelVorname.setPreferredSize(new Dimension(350, 40));
		panelName.setPreferredSize(new Dimension(350, 40));
		panelStrasse.setPreferredSize(new Dimension(350, 40));
		panelOrt.setPreferredSize(new Dimension(350, 40));
		panelTelefon.setPreferredSize(new Dimension(350, 40));
		panelEmail.setPreferredSize(new Dimension(350, 40));
		panelEmailWiederholen.setPreferredSize(new Dimension(350, 40));
		panelPasswort.setPreferredSize(new Dimension(350, 40));
		panelPasswortWiederholen.setPreferredSize(new Dimension(350, 40));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		// JLabel
		JLabel label = new                    JLabel("Registrierung");
		JLabel labelGeschlecht = new 		  JLabel("                          Anrede");
		JLabel labelVorname = new             JLabel("                       Vorname");
		JLabel labelName = new                JLabel("                            Name");
		JLabel labelStrasse = new             JLabel("       Strasse");
		JLabel labelHausnummer = new          JLabel("HausNr");
		JLabel labelOrt = new                 JLabel("               Ort");
		JLabel labelPLZ = new                 JLabel("     PLZ");
		JLabel labelTelefon = new 			  JLabel("           Telefonnummer");
		JLabel labelEmail =               new JLabel("                            Email");
		JLabel labelEmailWiederholen =    new JLabel("      Email wiederholen");
		JLabel labelPasswort = new            JLabel("                     Passwort");
		JLabel labelPasswortWiederholen = new JLabel("Passwort wiederholen");

		label.setFont(new Font("Titillium", 1, 30));
		labelGeschlecht.setFont(new Font("Titillium", 1, 12));
		labelVorname.setFont(new Font("Titillium", 1, 12));
		labelName.setFont(new Font("Titillium", 1, 12));
		labelStrasse.setFont(new Font("Titillium", 1, 12));
		labelHausnummer.setFont(new Font("Titillium", 1, 12));
		labelOrt.setFont(new Font("Titillium", 1, 12));
		labelPLZ.setFont(new Font("Titillium", 1, 12));
		labelTelefon.setFont(new Font("Titillium", 1, 12));
		labelEmail.setFont(new Font("Titillium", 1, 12));
		labelEmailWiederholen.setFont(new Font("Titillium", 1, 12));
		labelPasswort.setFont(new Font("Titillium", 1, 12));
		labelPasswortWiederholen.setFont(new Font("Titillium", 1, 12));

		// Combobox
		String[] geschlechtStrings = { "Herr", "Frau" };
		JComboBox geschlecht = new JComboBox(geschlechtStrings);
		geschlecht.setBackground(Color.white);
		geschlecht.setPreferredSize(new Dimension(170, 30));

		// Eingabe
		JTextField eingabeVorname = new JTextField("", 15);
		JTextField eingabeName = new JTextField("", 15);
		JTextField eingabeStrasse = new JTextField("", 10);
		JTextField eingabeHausnummer = new JTextField("", 5);
		JTextField eingabeOrt = new JTextField("", 10);
		JTextField eingabePLZ = new JTextField("", 5);
		JTextField eingabeTelefon = new JTextField("", 15);
		JTextField eingabeEmail = new JTextField("", 15);
		JTextField eingabeEmailWiederholen = new JTextField("", 15);
		JPasswordField eingabePasswort = new JPasswordField("", 15);
		JPasswordField eingabePasswortWiederholen = new JPasswordField("", 15);

		eingabeEmail.setBackground(Color.white);
		eingabePasswort.setBackground(Color.white);

		eingabeVorname.setPreferredSize(new Dimension(100, 30));
		eingabeName.setPreferredSize(new Dimension(100, 30));
		eingabeStrasse.setPreferredSize(new Dimension(100, 30));
		eingabeHausnummer.setPreferredSize(new Dimension(60, 30));
		eingabeOrt.setPreferredSize(new Dimension(60, 30));
		eingabePLZ.setPreferredSize(new Dimension(60, 30));
		eingabeTelefon.setPreferredSize(new Dimension(100, 30));
		eingabeEmail.setPreferredSize(new Dimension(100, 30));
		eingabeEmailWiederholen.setPreferredSize(new Dimension(100, 30));
		eingabePasswort.setPreferredSize(new Dimension(100, 30));
		eingabePasswortWiederholen.setPreferredSize(new Dimension(100, 30));

		// Button
		JButton buttonAbbrechen = new JButton("Abbrechen");
		JButton buttonEinloggen = new JButton("Registrieren");

		buttonAbbrechen.setBackground(Color.white);
		buttonEinloggen.setBackground(Color.white);

		buttonAbbrechen.addActionListener(e -> {
			setVisible(false);
		});

		// Panel kombinieren
		panelGeschlecht.add(labelGeschlecht);
		panelGeschlecht.add(geschlecht);
		
		panelVorname.add(labelVorname);
		panelVorname.add(eingabeVorname);

		panelName.add(labelName);
		panelName.add(eingabeName);

		panelStrasse.add(labelStrasse);
		panelStrasse.add(eingabeStrasse);
		panelStrasse.add(labelHausnummer);
		panelStrasse.add(eingabeHausnummer);

		panelOrt.add(labelOrt);
		panelOrt.add(eingabeOrt);
		panelOrt.add(labelPLZ);
		panelOrt.add(eingabePLZ);
		
		panelTelefon.add(labelTelefon);
		panelTelefon.add(eingabeTelefon);

		panelEmail.add(labelEmail);
		panelEmail.add(eingabeEmail);

		panelEmailWiederholen.add(labelEmailWiederholen);
		panelEmailWiederholen.add(eingabeEmailWiederholen);

		panelPasswort.add(labelPasswort);
		panelPasswort.add(eingabePasswort);

		panelPasswortWiederholen.add(labelPasswortWiederholen);
		panelPasswortWiederholen.add(eingabePasswortWiederholen);

		// panelNorth hinzufuegen
		panelNorth.add(label);
		panelNorth.add(panelGeschlecht);
		panelNorth.add(panelVorname);
		panelNorth.add(panelName);
		panelNorth.add(panelStrasse);
		panelNorth.add(panelOrt);
		panelNorth.add(panelTelefon);
		panelNorth.add(panelEmail);
		panelNorth.add(panelEmailWiederholen);
		panelNorth.add(panelPasswort);
		panelNorth.add(panelPasswortWiederholen);

		// panelSouth hinzufuegen
		panelSouth.add(buttonEinloggen);
		panelSouth.add(buttonAbbrechen);

		// Panel zu Frame hinzufuegen
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);

		// Rest
		pack();
		setVisible(true);

	}
}