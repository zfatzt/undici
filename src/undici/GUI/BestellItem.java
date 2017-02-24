package undici.GUI;

public class BestellItem {

	private int menge;
	private String name;
	private double preis;
	
	public BestellItem(int menge, double preis, String name) {
		this.menge = menge;
		this.preis = preis;
		this.name = name;
	}
	
	public int getMenge() {
		return menge;
	}
	public void setMenge(int menge) {
		this.menge = menge;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return preis;
	}
	public void setPrice(double preis) {
		this.preis = preis;
	}
	public boolean equals(Object obj) {

		return name.equals(((BestellItem)obj).name);
	}
}
