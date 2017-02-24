package undici.adresse;

import org.apache.commons.lang3.StringUtils;

import undici.excepitons.*;



public class Adresse {
	private String strasse;
	private String plz;
	private String ort;
	private int id;
	private String hausnummer; 
	
	public String getHausnummer() {
		return hausnummer;
	}

	public void setHausnummer(String hausnummer) {
		this.hausnummer = hausnummer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public static void main(String[] args) {

	}

	public String getStrasse() {
		return strasse;
	}

	public void setStrasse(String strasse) {
		this.strasse = strasse;
	}

	public String getPlz() {
		return plz;

	}

	public void setPlz(String plz) throws PlzException {
		if (StringUtils.isNotBlank(plz) && StringUtils.isNoneBlank(plz) && plz.length() == 4) {
			this.plz = plz;
		} else {
			throw new PlzException("PLZ muss vier Zahlen sein! Fehlerhafte Eingabe: " + plz);
		}
	}

	public String getOrt() {
		return ort;
	}

	public void setOrt(String ort) {
		this.ort = ort;
	}


	@Override
	public String toString() {
		String s = getStrasse() + " " + getHausnummer() + "\n" + getPlz() + "  " + getOrt();
		return s;
	}
}



