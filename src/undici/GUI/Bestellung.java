package undici.GUI;

import java.util.ArrayList;

public class Bestellung extends ArrayList<BestellItem>{
	
	private static final long serialVersionUID = 1L;


	@Override
	public boolean add(BestellItem item) {
		
		if (this.contains(item))
		{
			int index = this.indexOf(item);
			this.get(index).setMenge( this.get(index).getMenge() + item.getMenge());
			return true;
		}
		
		return super.add(item);
	}



	public double getTotalPreis() {
		
		double totalPreis = 0;
		
		for (BestellItem bestellItem : this) {
			totalPreis += bestellItem.getPrice() *  bestellItem.getMenge();
		}
		
		return totalPreis;
	}
}
