package undici.getraenke;

import java.sql.SQLException;

public interface GetraenkeDao{
	
	public Getraenke findGetraenkById(int id ) throws SQLException;
}

