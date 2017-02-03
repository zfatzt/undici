package undici.bestellung;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Bestellung {
	private String pizza;
	private double preis;
	private String getraenke;
	private String zahlung;
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPizza() {
		return pizza;
	}
	public void setPizza(String pizza) {
		this.pizza = pizza;
	}
	public double getPreis() {
		return preis;
	}
	public void setPreis(double preis) {
		this.preis = preis;
	}
	public String getGetraenke() {
		return getraenke;
	}
	public void setGetraenke(String getraenke) {
		this.getraenke = getraenke;
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

		String s = this.getPizza() + "\n" + this.getraenke + "\n"  + this.getZahlung() + "\n" + this.gesamtpreis() + "\n";
		return s;
	}
}
