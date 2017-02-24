package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import undici.kunde.Kunde;
import undici.kunde.KundeJBDBCDao;

public class AnmeldeDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AnmeldeDialog(PizzaFrame pizzaFrame) {

		// JDialog
		setTitle("Anmeldung");
		setPreferredSize(new Dimension(350, 180));
		setLocation(800, 400);
		setResizable(false);
		setBackground(Color.WHITE);
		setUndecorated(true);

		// JPanel
		JPanel panelNorden = new JPanel();
		JPanel panelSueden = new JPanel();
		JPanel panelEmail = new JPanel();
		JPanel panelPasswort = new JPanel();
		JPanel panelHaupt = new JPanel();
		JPanel panelError = new JPanel();

		panelNorden.setPreferredSize(new Dimension(350, 130));
		panelSueden.setPreferredSize(new Dimension(350, 50));
		panelEmail.setPreferredSize(new Dimension(350, 40));
		panelPasswort.setPreferredSize(new Dimension(350, 40));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		panelHaupt.setBackground(Color.WHITE);
		panelNorden.setBackground(Color.WHITE);
		panelSueden.setBackground(Color.WHITE);
		panelEmail.setBackground(Color.WHITE);
		panelPasswort.setBackground(Color.WHITE);

		// JLabel
		JLabel label = new JLabel("Anmeldung");
		label.setFont(new Font("Arial", 1, 30));
		label.setBackground(Color.WHITE);

		JLabel labelEmail = new JLabel("      Email");
		labelEmail.setFont(new Font("Arial", 1, 12));
		labelEmail.setBackground(Color.WHITE);

		JLabel labelPasswort = new JLabel("Passwort");
		labelPasswort.setFont(new Font("Arial", 1, 12));
		labelPasswort.setBackground(Color.WHITE);

		// Eingabe Email
		JTextField eingabeEmail = new JTextField("", 20);
		eingabeEmail.setBackground(Color.white);
		eingabeEmail.setPreferredSize(new Dimension(160, 30));

		// Eingabe Passwort
		JPasswordField eingabePasswort = new JPasswordField("", 20);
		eingabePasswort.setBackground(Color.white);
		eingabePasswort.setPreferredSize(new Dimension(160, 30));

		// Button
		JButton buttonExit = new JButton("Abbrechen");
		JButton buttonEinloggen = new JButton("Einloggen");

		buttonExit.setVisible(true);
		buttonEinloggen.setVisible(true);

		buttonExit.setBackground(Color.white);
		buttonEinloggen.setBackground(Color.white);
		
		//ActionListener
		buttonExit.addActionListener(e -> {
			setVisible(false);
		});

		buttonEinloggen.addActionListener(e -> {
			KundeJBDBCDao kunde = new KundeJBDBCDao();
			if (kunde.kannEinloggen(eingabeEmail.getText(), new String(eingabePasswort.getPassword()))) {
				setVisible(false);
				Kunde user;
				try {
					user = kunde.findKundeByEmailAndPassword(eingabeEmail.getText(),
							new String(eingabePasswort.getPassword()));
					pizzaFrame.angemeldet(user);
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			} else {
				JOptionPane.showMessageDialog(panelError,
						"Email oder Passwort falsch. Falls Sie sich noch nicht Regristriert haben bitte tun Sie das jetzt.",
						"Anmeldefehler", JOptionPane.ERROR_MESSAGE);
			}
		});

		// Panel hinzufuegen
		panelEmail.add(labelEmail);
		panelEmail.add(eingabeEmail);

		panelPasswort.add(labelPasswort);
		panelPasswort.add(eingabePasswort);

		panelNorden.add(label);
		panelNorden.add(panelEmail);
		panelNorden.add(panelPasswort);

		panelSueden.add(buttonEinloggen);
		panelSueden.add(buttonExit);

		// panelHaupt hinzufuegen
		panelHaupt.add(panelNorden, BorderLayout.NORTH);
		panelHaupt.add(panelSueden, BorderLayout.SOUTH);

		// Panel zu Frame hinzufuegen
		add(panelHaupt);

		// Rest
		pack();
		setVisible(true);
	}

}
