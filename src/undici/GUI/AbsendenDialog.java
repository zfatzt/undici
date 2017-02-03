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

	public AbsendenDialog() {
		Dimension d = new Dimension(350, 180);
		// JWindow
		setTitle("Absenden");
		setPreferredSize(d);
		setLocation(800, 400);
		setResizable(false);
		setBackground(Color.WHITE);
		setUndecorated(true);

		// JPanel
		JPanel panelMain = new JPanel();
		JPanel panelAnmelden = new JPanel();
		JPanel panelRegistrieren = new JPanel();
		JPanel panelAbbrechen = new JPanel();

		panelMain.setBackground(Color.WHITE);
		panelAnmelden.setBackground(Color.WHITE);
		panelRegistrieren.setBackground(Color.WHITE);
		panelAbbrechen.setBackground(Color.WHITE);

		panelMain.setPreferredSize(new Dimension(350, 177));
		panelAnmelden.setPreferredSize(new Dimension(350, 35));
		panelRegistrieren.setPreferredSize(new Dimension(350, 35));
		panelAbbrechen.setPreferredSize(new Dimension(350, 35));

		((JComponent) super.getContentPane()).setBorder(new LineBorder(Color.BLACK));
		// JLabel
		JLabel label = new JLabel("Absenden");
		label.setFont(new Font("Titillium", 1, 30));

		// Button
		JButton buttonExit = new JButton("Abbrechen");
		JButton buttonRegistrieren = new JButton("Registrieren");
		JButton buttonAnmelden = new JButton("Anmelden");

		buttonExit.setBackground(Color.white);
		buttonRegistrieren.setBackground(Color.white);
		buttonAnmelden.setBackground(Color.white);

		buttonExit.setPreferredSize(new Dimension(150, 30));
		buttonRegistrieren.setPreferredSize(new Dimension(150, 30));
		buttonAnmelden.setPreferredSize(new Dimension(150, 30));

		buttonExit.addActionListener(e -> {
			setVisible(false);
		});
		buttonAnmelden.addActionListener(e -> {
			JDialog ad = new AnmeldeDialog();
			ad.pack();
		});
		buttonRegistrieren.addActionListener(e -> {
			JDialog rd = new RegistrierenDialog();
			rd.pack();
		});

		// Panel hinzufügen
		panelAnmelden.add(buttonAnmelden);
		panelRegistrieren.add(buttonRegistrieren);
		panelAbbrechen.add(buttonExit);

		// panelMain hinzufügen
		panelMain.add(label);
		panelMain.add(panelAnmelden);
		panelMain.add(panelRegistrieren);
		panelMain.add(panelAbbrechen);

		// Panel zu Frame hinzufügen
		add(panelMain, BorderLayout.NORTH);

		if (buttonAnmelden.getModel().isPressed()) {
			System.out.println("button is pressed");
		}
		// Rest
		pack();
		setVisible(true);

	}
}
