package undici.GUI;

public class BestellItem {

	private int menge;
	private String name;
	private double price;
	
	public BestellItem(int menge, double preis, String name) {
		this.menge = menge;
		this.price = preis;
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
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {

		return name.equals(((BestellItem)obj).name);
	}
}
