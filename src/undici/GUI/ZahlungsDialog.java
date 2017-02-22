package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ZahlungsDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	public ZahlungsDialog(PizzaFrame pizzaFrame) {
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
		JPanel panelNorth = new JPanel();
		JPanel panelCenter = new JPanel();
		JPanel panelSouth = new JPanel();

		panelNorth.setPreferredSize(new Dimension(350, 50));
		panelSouth.setPreferredSize(new Dimension(350, 40));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));

		panelNorth.setBackground(Color.WHITE);
		panelSouth.setBackground(Color.WHITE);

		//JLabel
		JLabel titel = new JLabel("Zahlungsart");
		
		// Combobox
		String[] bezahlen = { "-", "Barzahlung", "Kreditkarte" };
		JComboBox zahlungsArt = new JComboBox(bezahlen);
		zahlungsArt.setBackground(Color.white);
		zahlungsArt.setPreferredSize(new Dimension(170, 30));
	
		
		// Button
		JButton buttonExit = new JButton("Abbrechen");
		JButton buttonBestellen = new JButton("Bestellen");

		buttonExit.setVisible(true);
		buttonBestellen.setVisible(true);

		buttonExit.addActionListener(e -> {
			setVisible(false);
		});

		buttonExit.setBackground(Color.white);
		buttonBestellen.setBackground(Color.white);

		
		panelNorth.add(titel, BorderLayout.CENTER);
		panelCenter.add(zahlungsArt, BorderLayout.CENTER);
		panelSouth.add(buttonBestellen, BorderLayout.CENTER);
		panelSouth.add(buttonExit);
		
		// Panel zu Frame hinzufügen
		add(panelNorth, BorderLayout.NORTH);
		add(panelCenter, BorderLayout.CENTER);
		add(panelSouth, BorderLayout.SOUTH);

		// Rest
		pack();
		setVisible(true);
	}

}
