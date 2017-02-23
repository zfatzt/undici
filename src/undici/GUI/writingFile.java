package undici.GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import undici.kunde.Kunde;

public class writingFile {

	public writingFile(PizzaFrame pizzaFrame, JTextArea textAreaTotal, JTextArea textAreaBestellung,
			ZahlungsDialog zahlungsDialog, Kunde user, JTextPane textAreaAngemeldet) {

		BufferedWriter bw = null;
		FileWriter fw = null;
		Date dat = new Date();

		String fileName = "Bestellung";
		fileName = fileName + user.getId();

		File f = new File("src/undici/bestellungen/" + fileName);

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			String s;
			s =  "****************************** \n";
			s += "            UNDICI             \n";
			s += "****************************** \n";
			s += " " + dat.getHours() + ":" + dat.getMinutes() + " / " + dat.getDay() + "." + dat.getMonth() + dat.getYear() + "\n";
			s += " KundenNr: " + user.getId() + "\n";
			s += " " + user.getZahlungsArt() + "\n";
			s += "                               \n";
			s += " " + user.getAnrede() + "\n";
			s += " " + user.getVorname() + " " + user.getName() + "\n";
			s += " " + user.getWohnAdresse() + "\n";
			s += "                               \n";
			s += textAreaBestellung.getText() + "\n";
			s += "                               \n";
			s += "****************************** \n";
			s += "Total: " + textAreaTotal.getText();
			s += "****************************** \n";
			
			
			fw.write(s + "\n");

			fw.flush();
			bw.close();
			fileName = fileName + 1;
		} catch (IOException e1) {

		}
	}
}
