package undici.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import undici.kunde.Kunde;

public class Quitung {
	JDialog bestellBestaetigung = new JDialog();
	JTextPane bestellBestaetigungText = new JTextPane();

	public Quitung(PizzaFrame pizzaFrame, JTextArea textAreaTotal, JTextArea textAreaBestellung,
			ZahlungsDialog zahlungsDialog, Kunde user, JTextPane textAreaAngemeldet) {

		
		BufferedWriter bufferedWriter = null;
		FileWriter fileWriter = null;

		String nameDerBestellung = "Bestellung ";
		nameDerBestellung = nameDerBestellung + user.getId();

		File f = new File(System.getProperty("user.home"), "Desktop/" + nameDerBestellung); // File wird auf Desktop gespeichert 
		
		try {
			fileWriter = new FileWriter(f);

			bufferedWriter = new BufferedWriter(fileWriter);
			String bestellung;

			bestellung = "************************************ \r\n";
			bestellung += "*                                   UNDICI                                   * \r\n";
			bestellung += "************************************\r\n";
			bestellung += "KundenNr: " + user.getId() + "\r\n";
			bestellung += "" + user.getZahlungsArt() + "\r\n";
			bestellung += "                               \r\n";
			bestellung += "" + user.toString() + "\r\n";
			bestellung += "                               \r\n";
			bestellung += textAreaBestellung.getText() + "\r\n";
			bestellung += "************************************\r\n";
			bestellung += "Total: \t" + textAreaTotal.getText() + "\r\n";

			fileWriter.write(bestellung + "\n");

			bestellBestaetigungText.setText(bestellung);

			fileWriter.flush();
			bufferedWriter.close();
		} catch (IOException e1) {

		}
		bestellBestaetigungText.setEditable(false);
		bestellBestaetigungText.setFont(new Font("Calibri", Font.PLAIN, 10));
		bestellBestaetigung.setTitle(nameDerBestellung);
		bestellBestaetigung.add(bestellBestaetigungText);
		bestellBestaetigung.setLocation(600, 50);
		bestellBestaetigung.setVisible(true);
		bestellBestaetigung.setPreferredSize(new Dimension(250, 500));
		bestellBestaetigung.pack();

	}
}
