package undici.bestellung;

import undici.adresse.Adresse;
import undici.kunde.*;

public class Bestellung {
	private int pizza_id;
	private double preis;
	private int getraenk_id;
	private String zahlung;
	private int id;
	private int anzahlpizza;
	
	public int getAnzahlpizza() {
		return anzahlpizza;
	}
	public void setAnzahlpizza(int anzahlpizza) {
		this.anzahlpizza = anzahlpizza;
	}

	private int kunde_id;
	private Kunde kunde = new Kunde();
	
	public Kunde getKunde() {
		return kunde;
	}
	public void setKunde(Kunde kunde) {
		this.kunde = kunde;
	}
	public int getKunde_id() {
		return kunde_id;
	}
	public void setKunde_id(int kunde_id) {
		this.kunde_id = kunde_id;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}


	public int getPizza_id() {
		return pizza_id;
	}
	public void setPizza_id(int pizza_id) {
		this.pizza_id = pizza_id;
	}
	public int getGetraenk_id() {
		return getraenk_id;
	}
	public void setGetraenk_id(int getraenk_id) {
		this.getraenk_id = getraenk_id;
	}
	public String getZahlung() {
		return zahlung;
	}
	public void setZahlung(String zahlung) {
		this.zahlung = zahlung;
	}
	
	public double gesamtpreis() {
		return preis;
	}

	public String toString() {

		String s = "\nPizza id > " + this.getPizza_id() + "\n" + "Getränk id > " + this.getraenk_id + "\n"  + "Zahlungsmethode > " + this.getZahlung() + "\n" + "Gesamtpreis > " + this.gesamtpreis() + "\n" + "Kunde > \n"+ getKunde().toString();
		return s;
	}
}
