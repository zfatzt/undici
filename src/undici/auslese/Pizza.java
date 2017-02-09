package undici.auslese;

public class Pizza {
	private String pizza;
	private double preis;
	private int id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {

		String s = "Pizza > " + this.getPizza() + "\n Preis > "  + this.getPreis();
		return s;
	}

}
