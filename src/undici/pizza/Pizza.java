package undici.pizza;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
	private String pizza;
	private double preis;
	private int id;
	
	private List<String> zutaten = new ArrayList<String>();
	
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

		String s = "Pizza > " + this.getPizza() + "\n Preis > "  + this.getPreis() + "\n" + this.getZutaten();
		return s;
	}
	public List<String> getZutaten() {
		return zutaten;
	}
	public void setZutat(String zutat) {
		this.zutaten.add(zutat);
	}
	@Override
	public boolean equals(Object obj) {
		
		if (obj instanceof Integer) {
			return this.id == (int)obj;
		}
		
		return super.equals(obj);
	}

}
