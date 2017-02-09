package undici.auslese;

import java.sql.SQLException;

public interface PizzaDao{
	
	public Pizza findPizzaById(int id ) throws SQLException;
}

