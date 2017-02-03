package undici;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

public class AnmeldeDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public AnmeldeDialog() {
		Dimension d = new Dimension(350, 180);

		// JDialog
		setTitle("Anmeldung");
		setPreferredSize(d);
		setLocation(800, 400);
		setResizable(false);
		setBackground(Color.WHITE);
		setUndecorated(true);

		// JPanel
		JPanel panelNorth = new JPanel();
		JPanel panelSouth = new JPanel();
		JPanel panelEmail = new JPanel();
		JPanel panelPasswort = new JPanel();
		JPanel panelMain = new JPanel();

		panelEmail.setBackground(Color.WHITE);
		panelPasswort.setBackground(Color.WHITE);
		panelNorth.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);
		panelMain.setBackground(Color.WHITE);

		panelNorth.setPreferredSize(new Dimension(350, 130));
		panelSouth.setPreferredSize(new Dimension(350, 50));
		panelEmail.setPreferredSize(new Dimension(350, 40));
		panelPasswort.setPreferredSize(new Dimension(350, 40));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		// JLabel
		JLabel label = new JLabel("Anmeldung");
		label.setFont(new Font("Titillium", 1, 30));

		JLabel labelEmail = new JLabel("      Email");
		labelEmail.setFont(new Font("Titillium", 1, 12));

		JLabel labelPasswort = new JLabel("Passwort");
		labelPasswort.setFont(new Font("Titillium", 1, 12));

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

		buttonExit.addActionListener(e -> System.exit(0));

		buttonExit.setBackground(Color.white);
		buttonEinloggen.setBackground(Color.white);

		// panelNorth hinzufügen
		panelEmail.add(labelEmail);
		panelEmail.add(eingabeEmail);

		panelPasswort.add(labelPasswort);
		panelPasswort.add(eingabePasswort);

		panelNorth.add(label);
		panelNorth.add(panelEmail);
		panelNorth.add(panelPasswort);

		panelSouth.add(buttonEinloggen);
		panelSouth.add(buttonExit);

		// panelMain hinzufügen
		panelMain.add(panelNorth, BorderLayout.NORTH);
		panelMain.add(panelSouth, BorderLayout.SOUTH);

		// Panel zu Frame hinzufügen
		add(panelMain);

		// Rest
		pack();
		setVisible(true);
	}

}
