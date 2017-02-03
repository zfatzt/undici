package undici.GUI;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class ProductBox extends JPanel {
	public ProductBox(String name, Double preis,String beschreibung){
		
		//Border
		TitledBorder border = BorderFactory.createTitledBorder(name);
		border.setTitleJustification(TitledBorder.LEFT);
		
		//JPanel
		
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(540, 140));
		setBorder(border);
		setVisible(true);


		

	}

}
