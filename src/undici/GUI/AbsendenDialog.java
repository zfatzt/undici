package undici.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class AbsendenDialog extends JDialog {
	private static final long serialVersionUID = 2L;

	public AbsendenDialog(PizzaFrame pizzaFrame) {
		Dimension d = new Dimension(350, 180);
		// JWindow
		setTitle("Absenden");
		setPreferredSize(d);
		setLocation(800, 400);
		setResizable(false);
		setBackground(Color.WHITE);
		setUndecorated(true);

		// JPanel
		JPanel panelHaupt = new JPanel();
		JPanel panelAnmelden = new JPanel();
		JPanel panelRegistrieren = new JPanel();
		JPanel panelAbbrechen = new JPanel();

		panelHaupt.setBackground(Color.WHITE);
		panelAnmelden.setBackground(Color.WHITE);
		panelRegistrieren.setBackground(Color.WHITE);
		panelAbbrechen.setBackground(Color.WHITE);

		panelHaupt.setPreferredSize(new Dimension(350, 177));
		panelAnmelden.setPreferredSize(new Dimension(350, 35));
		panelRegistrieren.setPreferredSize(new Dimension(350, 35));
		panelAbbrechen.setPreferredSize(new Dimension(350, 35));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));
		
		// JLabel
		JLabel labelAbsenden = new JLabel("Absenden");
		labelAbsenden.setFont(new Font("Arial", 1, 30));

		// Button
		JButton buttonAbbrechen = new JButton("Abbrechen");
		JButton buttonRegistrieren = new JButton("Registrieren");
		JButton buttonAnmelden = new JButton("Anmelden");

		buttonAbbrechen.setBackground(Color.WHITE);
		buttonRegistrieren.setBackground(Color.WHITE);
		buttonAnmelden.setBackground(Color.WHITE);

		buttonAbbrechen.setPreferredSize(new Dimension(150, 30));
		buttonRegistrieren.setPreferredSize(new Dimension(150, 30));
		buttonAnmelden.setPreferredSize(new Dimension(150, 30));

		// ActionListener
		buttonAbbrechen.addActionListener(e -> {
			setVisible(false);
		});
		buttonAnmelden.addActionListener(e -> {
			JDialog ad = new AnmeldeDialog(pizzaFrame);
			ad.pack();
			setVisible(false);
		});
		buttonRegistrieren.addActionListener(e -> {
			JDialog rd = new RegistrierenDialog();
			rd.pack();
			setVisible(false);
		});

		// Panel hinzufügen
		panelAnmelden.add(buttonAnmelden);
		panelRegistrieren.add(buttonRegistrieren);
		panelAbbrechen.add(buttonAbbrechen);

		// panelHaupt hinzufügen
		panelHaupt.add(labelAbsenden);
		panelHaupt.add(panelAnmelden);
		panelHaupt.add(panelRegistrieren);
		panelHaupt.add(panelAbbrechen);

		// Panel zu Frame hinzufügen
		add(panelHaupt, BorderLayout.NORTH);

		// Rest
		pack();
		setVisible(true);

	}
}
