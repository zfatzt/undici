package undici.GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import undici.kunde.Kunde;

public class writingFile {

	public writingFile(PizzaFrame pizzaFrame, JTextArea textAreaTotal, JTextArea textAreaBestellung,
			ZahlungsDialog zahlungsDialog, Kunde user, JTextPane textAreaAngemeldet) {

		BufferedWriter bw = null;
		FileWriter fw = null;
	
		
		String fileName = "Bestellung";
		fileName = fileName + user.getId();

		File f = new File("src/undici/bestellungen/" + fileName);

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			String s;
			s = "****************************** \n";
			s = "            UNDICI             \n";
			s = "****************************** \n";
			s = "                               \n";
			
					
			s = user.getAnrede() + "\n" + user.getVorname() + " " + user.getName() + "\n"
					+ user.getWohnAdresse().toString();
			s += textAreaTotal.getText();
			s += textAreaBestellung.getText();
			fw.write(s + "\n");

			fw.flush();
			bw.close();
			fileName = fileName + 1;
		} catch (IOException e1) {

		}
	}
}
