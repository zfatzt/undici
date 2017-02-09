package undici.auslese;

import java.sql.SQLException;

public class PizzaTester {
	public static void main(String[] args) {
	
	PizzaJDBCDao bd = new PizzaJDBCDao();

	try {
			
		
	for(Pizza pizza : bd.getAllpizzen()){
	System.out.println(pizza.toString());
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}
