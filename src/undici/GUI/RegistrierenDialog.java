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

	@SuppressWarnings("deprecation")
	public RegistrierenDialog() {

		// JWindow
		setTitle("Registrierung");
		setPreferredSize(new Dimension(350, 550));
		setLocation(800, 100);
		setResizable(false);
		setUndecorated(true);

		// JPanels werden erstellt
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
		JPanel panelError = new JPanel();

		// gr�ssen werden definiert
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

		panelNorth.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
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
		panelError.setBackground(Color.WHITE);

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		// JLabels werden erstellt
		JLabel label = new JLabel("Registrierung");
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

		// Schriftart und gr�sse des Titels setzen
		label.setFont(new Font("Arial", 1, 30));

		// Combobox
		String[] AnredeArray = { "-", "Herr", "Frau" };
		JComboBox geschlecht = new JComboBox(AnredeArray);
		geschlecht.setBackground(Color.white);
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

		// gr�ssen Definiert
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

		buttonAbbrechen.setBackground(Color.white);
		buttonRegristrieren.setBackground(Color.white);

		buttonAbbrechen.addActionListener(e -> {
			setVisible(false);
		});

		// actionListener
		buttonRegristrieren.addActionListener(e -> {

			// einsetzen id db
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
					JOptionPane.showMessageDialog(panelError, e1, "ung�ltige E-Mail adresse",
							JOptionPane.ERROR_MESSAGE);
				}
				kunde.setWohnAdresse(adresse);
				kunde.setTelefon(eingabeTelefon.getText());
				try {
					kunde.setEmail(eingabeEmail.getText());
				} catch (EmailException e1) {
					JOptionPane.showMessageDialog(panelError, e1, "ungültige E-Mail adresse",
							JOptionPane.ERROR_MESSAGE);
					e1.printStackTrace();
				}
				if ((eingabeEmail.getText().equals(eingabeEmailWiederholen.getText())
						&& (new String(eingabePasswort.getPassword())
								.equals(new String(eingabePasswortWiederholen.getPassword()))))) {

					kunde.setPasswort(new String(eingabePasswort.getPassword()));
					int primaryKeyOfAdress = dbAdresse.insertAdresse(adresse);
					kunde.setAdresse_id(primaryKeyOfAdress);
					dbKunde.insertKunde(kunde);
					setVisible(false);

				} else {
					JOptionPane.showMessageDialog(panelError, "Passwort oder E-Mail adresse stimmen nicht �berein.",
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
		panelSouth.add(buttonRegristrieren);
		panelSouth.add(buttonAbbrechen);

		// Panel zu Frame hinzufuegen
		add(panelNorth, BorderLayout.NORTH);
		add(panelSouth, BorderLayout.SOUTH);

		// Rest
		pack();
		setVisible(true);

	}
}
