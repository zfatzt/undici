package undici.getraenke;

import java.util.ArrayList;
import java.util.List;

public class Getraenke {
	private String getraenk;
	private double preis;
	private int id;
	private String bild;
	private List<String> empty = new ArrayList<String>();

	public String getBild() {
		return bild;
	}

	public void setBild(String bild) {
		this.bild = bild;
	}

	public String getGetraenk() {
		return getraenk;
	}

	public void setGetraenk(String getraenk) {
		this.getraenk = getraenk;
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

		String s = "Getraenk > " + this.getGetraenk() + "\n Preis > " + this.getPreis() + "\n";
		return s;
	}

	@Override
	public boolean equals(Object obj) {

		if (obj instanceof Integer) {
			return this.id == (int) obj;
		}

		return super.equals(obj);
	}

	public List<String> getEmpty() {
		return empty;
	}

	public void setEmpty(List<String> empty) {
		this.empty = empty;
	}

}
