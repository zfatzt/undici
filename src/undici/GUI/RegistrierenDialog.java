package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import undici.adresse.Adresse;
import undici.adresse.AdresseJDBCDao;
import undici.excepitons.EmailException;
import undici.excepitons.PlzException;
import undici.kunde.Kunde;
import undici.kunde.KundeJBDBCDao;

public class RegistrierenDialog extends JDialog {
	private static final long serialVersionUID = 3L;

	public RegistrierenDialog() {

		// JWindow
		setTitle("Registrierung");
		setPreferredSize(new Dimension(350, 550));
		setLocation(800, 100);
		setResizable(false);
		setUndecorated(true);

		// JPanels werden erstellt
		JPanel panelNorden = new JPanel();
		JPanel panelSueden = new JPanel();
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
		JPanel panelFehler = new JPanel();

		panelNorden.setPreferredSize(new Dimension(350, 490));
		panelSueden.setPreferredSize(new Dimension(350, 60));
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

		panelNorden.setBackground(Color.WHITE);
		panelSueden.setBackground(Color.WHITE);
		panelGeschlecht.setBackground(Color.WHITE);
		panelVorname.setBackground(Color.WHITE);
		panelName.setBackground(Color.WHITE);
		panelStrasse.setBackground(Color.WHITE);
		panelOrt.setBackground(Color.WHITE);
		panelTelefon.setBackground(Color.WHITE);
		panelEmail.setBackground(Color.WHITE);
		panelEmailWiederholen.setBackground(Color.WHITE);
		panelPasswort.setBackground(Color.WHITE);
		panelPasswortWiederholen.setBackground(Color.WHITE);
		panelFehler.setBackground(Color.WHITE);

		// Border
		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		// JLabels werden erstellt
		JLabel labelTitel = new JLabel("Registrierung");
		JLabel labelGeschlecht = new JLabel("                          Anrede");
		JLabel labelVorname = new JLabel("                       Vorname");
		JLabel labelName = new JLabel("                            Name");
		JLabel labelStrasse = new JLabel("       Strasse");
		JLabel labelHausnummer = new JLabel("HausNr");
		JLabel labelOrt = new JLabel("               Ort");
		JLabel labelPLZ = new JLabel("     PLZ");
		JLabel labelTelefon = new JLabel("           Telefonnummer");
		JLabel labelEmail = new JLabel("                            Email");
		JLabel labelEmailWiederholen = new JLabel("      Email wiederholen");
		JLabel labelPasswort = new JLabel("                     Passwort");
		JLabel labelPasswortWiederholen = new JLabel("Passwort wiederholen");

		labelTitel.setFont(new Font("Arial", 1, 30));

		// Combobox
		String[] AnredeArray = { "-", "Herr", "Frau" };
		JComboBox geschlecht = new JComboBox(AnredeArray);
		geschlecht.setBackground(Color.WHITE);
		geschlecht.setPreferredSize(new Dimension(170, 30));

		// Eingabe
		JTextField eingabeVorname = new JTextField("", 15);
		JTextField eingabeName = new JTextField("", 15);
		JTextField eingabeStrasse = new JTextField("", 10);
		JTextField eingabeHausnummer = new JTextField("", 5);
		JTextField eingabeOrt = new JTextField("", 10);
		JTextField eingabePLZ = new JTextField("", 4);
		JTextField eingabeTelefon = new JTextField("", 15);
		JTextField eingabeEmail = new JTextField("", 15);
		JTextField eingabeEmailWiederholen = new JTextField("", 15);
		JPasswordField eingabePasswort = new JPasswordField("", 15);
		JPasswordField eingabePasswortWiederholen = new JPasswordField("", 15);

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
		JButton buttonRegristrieren = new JButton("Registrieren");

		buttonAbbrechen.setBackground(Color.WHITE);
		buttonRegristrieren.setBackground(Color.WHITE);

		// actionListener
		buttonAbbrechen.addActionListener(e -> {
			setVisible(false);
		});

		buttonRegristrieren.addActionListener(e -> {

			// eischreiben in die Datenbank
			Adresse adresse = new Adresse();
			Kunde kunde = new Kunde();
			KundeJBDBCDao dbKunde = new KundeJBDBCDao();
			AdresseJDBCDao dbAdresse = new AdresseJDBCDao();

			try {
				if (geschlecht.getSelectedIndex() == 1) {
					kunde.setAnrede("Herr");
				} else if (geschlecht.getSelectedIndex() == 2) {
					kunde.setAnrede("Frau");
				} else {
					kunde.setAnrede("none");
				}
				kunde.setVorname(eingabeVorname.getText());
				kunde.setName(eingabeName.getText());
				adresse.setStrasse(eingabeStrasse.getText());
				adresse.setHausnummer(eingabeHausnummer.getText());
				adresse.setOrt(eingabeOrt.getText());
				try {
					adresse.setPlz(eingabePLZ.getText());
				} catch (PlzException e1) {
					JOptionPane.showMessageDialog(panelFehler, e1, "ungültige PLZ", JOptionPane.ERROR_MESSAGE);
				}
				kunde.setTelefon(eingabeTelefon.getText());
				try {
					kunde.setEmail(eingabeEmail.getText());
				} catch (EmailException e1) {
					JOptionPane.showMessageDialog(panelFehler, e1, "ungültige E-Mail adresse",
							JOptionPane.ERROR_MESSAGE);
				}

				if ((eingabeEmail.getText().equals(eingabeEmailWiederholen.getText())
						&& (new String(eingabePasswort.getPassword())
								.equals(new String(eingabePasswortWiederholen.getPassword()))))) {

					if (dbKunde.EmailSchonVorhanden(eingabeEmail.getText())) {
						kunde.setWohnAdresse(adresse);
						kunde.setPasswort(new String(eingabePasswort.getPassword()));
						int primaryKeyOfAdress = dbAdresse.insertAdresse(adresse);
						kunde.setAdresse_id(primaryKeyOfAdress);
						dbKunde.insertKunde(kunde);
						setVisible(false);
					} else {
						JOptionPane.showMessageDialog(panelFehler, "Diese Email Adresse existiert bereits.",
								"übereinstimmung fehlgeschlagen", JOptionPane.ERROR_MESSAGE);

					}
				} else {
					JOptionPane.showMessageDialog(panelFehler, "Passwort oder E-Mail adresse stimmen nicht überein.",
							"übereinstimmung fehlgeschlagen", JOptionPane.ERROR_MESSAGE);
				}

			} catch (SQLException e1) {

			}

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

		panelNorden.add(labelTitel);
		panelNorden.add(panelGeschlecht);
		panelNorden.add(panelVorname);
		panelNorden.add(panelName);
		panelNorden.add(panelStrasse);
		panelNorden.add(panelOrt);
		panelNorden.add(panelTelefon);
		panelNorden.add(panelEmail);
		panelNorden.add(panelEmailWiederholen);
		panelNorden.add(panelPasswort);
		panelNorden.add(panelPasswortWiederholen);

		panelSueden.add(buttonRegristrieren);
		panelSueden.add(buttonAbbrechen);

		// Panel zu Frame hinzufuegen
		add(panelNorden, BorderLayout.NORTH);
		add(panelSueden, BorderLayout.SOUTH);

		// Rest
		pack();
		setVisible(true);

	}
}
