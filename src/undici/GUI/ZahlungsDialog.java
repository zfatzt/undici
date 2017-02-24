package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import undici.kunde.Kunde;

public class ZahlungsDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public ZahlungsDialog(PizzaFrame pizzaFrame, Kunde kunde, JTextArea textAreaTotal, JTextArea textAreaBestellung,
			JTextPane textAreaAngemeldet) {
		Dimension d = new Dimension(350, 180);
		// public boolean istEingelogt = true;

		// JDialog
		setTitle("Zahlungsart");
		setPreferredSize(d);
		setLocation(800, 400);
		setResizable(false);
		setBackground(Color.WHITE);
		setUndecorated(true);

		// JPanel
		JPanel panelNorden = new JPanel();
		JPanel panelMitte = new JPanel();
		JPanel panelSueden = new JPanel();
		JOptionPane panelBestaetigung = new JOptionPane();
		JFileChooser bestellungsFile = new JFileChooser();

		panelNorden.setPreferredSize(new Dimension(350, 50));
		panelSueden.setPreferredSize(new Dimension(350, 40));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		panelNorden.setBackground(Color.WHITE);
		panelSueden.setBackground(Color.WHITE);
		panelMitte.setBackground(Color.WHITE);

		// JLabel
		JLabel titel = new JLabel("Zahlungsart");
		titel.setFont(new Font("Arial", 1, 30));

		// Combobox
		String[] bezahlen = { "Barzahlung", "Kreditkarte" };
		JComboBox zahlungsArt = new JComboBox(bezahlen);
		zahlungsArt.setBackground(Color.white);
		zahlungsArt.setPreferredSize(new Dimension(170, 30));
		zahlungsArt.setVisible(true);

		// Button
		JButton buttonAbbrechen = new JButton("Abbrechen");
		JButton buttonBestellen = new JButton("Bestellen");

		buttonAbbrechen.setVisible(true);
		buttonBestellen.setVisible(true);

		//ActionListener
		buttonAbbrechen.addActionListener(e -> {
			setVisible(false);
		});
		buttonBestellen.addActionListener(e -> {
			if (zahlungsArt.getSelectedIndex() == 0) {
				kunde.setZahlungsArt("Barzahlung");

			} else if (zahlungsArt.getSelectedIndex() == 1) {
				kunde.setZahlungsArt("Kreditkarte");
			}
			// Textdoukument
			Quitung quittung = new Quitung(pizzaFrame, textAreaTotal, textAreaBestellung, this, kunde,
					textAreaAngemeldet);

			// Bestellbestaetigung
			JOptionPane.showMessageDialog(panelBestaetigung, "Ihre Bestellung wurde Erfolgreich gespeichert.");
			setVisible(false);

		});

		buttonAbbrechen.setBackground(Color.WHITE);
		buttonBestellen.setBackground(Color.WHITE);

		panelNorden.add(titel, BorderLayout.CENTER);
		panelMitte.add(zahlungsArt, BorderLayout.CENTER);
		panelSueden.add(buttonBestellen, BorderLayout.CENTER);
		panelSueden.add(buttonAbbrechen);

		// Panel zu Frame hinzufügen
		add(panelNorden, BorderLayout.NORTH);
		add(panelMitte, BorderLayout.CENTER);
		add(panelSueden, BorderLayout.SOUTH);

		// Rest
		pack();
		setVisible(true);
	}

}
