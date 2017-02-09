package undici.pizza;

import java.sql.SQLException;
import java.util.List;

public class PizzaTester {
	public static void main(String[] args) {
	
	PizzaJDBCDao bd = new PizzaJDBCDao();

	try {
			
	List<Pizza> pizzen = bd.getAllpizzen();
	for(Pizza pizza : pizzen){
		System.out.println(pizza.toString());
	}
	
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
}}
