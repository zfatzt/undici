package undici.GUI;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTextArea;
import javax.swing.JTextPane;

import undici.kunde.Kunde;

public class writingFile {
	private int bestellungsNummerZaehler = 0;
	
	
public writingFile(PizzaFrame pizzaFrame, JTextArea textAreaTotal, JTextArea textAreaBestellung, Kunde user, JTextPane textAreaAngemeldet){
	
	
	pizzaFrame.bestellungAbschicken.addActionListener(e -> {

		FileReader fr = null;
		BufferedWriter bw = null;
		FileWriter fw = null;
		String fileName = "Bestellung";
		bestellungsNummerZaehler += 1;
		fileName = fileName + bestellungsNummerZaehler;

		File f = new File("src/undici/bestellungen/" + fileName);

		try {
			fw = new FileWriter(f);
			bw = new BufferedWriter(fw);
			String s;
			s = user.getAnrede() + "\n" + user.getVorname() + " " + user.getName() + "\n" + user.getWohnAdresse().toString();
			s += textAreaTotal.getText();
			s += textAreaBestellung.getText();
			fw.write(s + "\n");

			fw.flush();
			bw.close();
			fileName = fileName + 1;
		} catch (IOException e1) {
		

		}

	});
}
}
