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
	private Kunde k = new Kunde();
	
	public Kunde getK() {
		return k;
	}
	public void setK(Kunde k) {
		this.k = k;
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
		double preis = 96.90 + 96.35;
		return preis;
	}

	public String toString() {

		String s = this.getPizza_id() + "\n" + this.getraenk_id + "\n"  + this.getZahlung() + "\n" + this.gesamtpreis() + "\n" + getK().toString();
		return s;
	}
}
