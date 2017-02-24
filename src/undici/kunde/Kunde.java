package undici.kunde;

import org.apache.commons.validator.EmailValidator;

import undici.adresse.Adresse;
import undici.excepitons.EmailException;

public class Kunde {

	private int id;
	private int adresse_id;
	private String anrede;
	private String name;
	private String vorname;
	private String email;
	private String passwort;
	private String telefon;
	private String kreditkartenNr;
	private String zahlungsArt;

	public int getAdresse_id() {
		return adresse_id;
	}

	public void setAdresse_id(int adresse_id) {
		this.adresse_id = adresse_id;
	}

	private Adresse wohnAdresse = new Adresse();

	public String getName() {
		return this.name;
	}

	public String getVorname() {
		return this.vorname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAnrede() {
		return anrede;
	}

	public void setAnrede(String anrede) {
		this.anrede = anrede;
	}

	public String getEmail() {
		return email;
	}

	// Email wird auf g�ltigketi Ueberpr�ft.
	@SuppressWarnings("deprecation")
	public void setEmail(String email) throws EmailException {
		if (EmailValidator.getInstance().isValid(email)) {
			this.email = email;
		} else {
			throw new EmailException("Diese Email ist ung�ltig: " + email);
		}
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getTelefon() {
		return telefon;
	}

	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}

	public String getKreditkartenNr() {
		return kreditkartenNr;
	}

	public void setKreditkartenNr(String kreditkartenNr) {
		this.kreditkartenNr = kreditkartenNr;
	}

	public void setWohnAdresse(Adresse wohnAdresse) {
		this.wohnAdresse = wohnAdresse;
	}

	public Adresse getWohnAdresse() {
		return this.wohnAdresse;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String toString() {
		// toString methode wird spaeter fuer die Bestellbestaetigung verwendet.
		String s = this.getAnrede() + " \r\n" + this.getVorname() + " " + this.getName() + "\r\n"
				+ this.getWohnAdresse() + " \r\n" + "Email: " + this.getEmail() + "\r\n" + "TelefonNr: "
				+ this.getTelefon() + "\r\n";
		return s;
	}

	public String getZahlungsArt() {
		return zahlungsArt;
	}

	public void setZahlungsArt(String zahlungsArt) {
		this.zahlungsArt = zahlungsArt;
	}
}
