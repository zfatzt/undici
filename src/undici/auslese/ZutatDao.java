package undici.auslese;

import java.sql.SQLException;

public interface ZutatDao {

	public Zutat findZutatById(int id) throws SQLException;

}

