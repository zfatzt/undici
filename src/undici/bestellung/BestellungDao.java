package undici.bestellung;

import java.sql.SQLException;

public interface BestellungDao {
	public void insertBestellung(Bestellung b) throws SQLException;
	public Bestellung findBestellungById(int id) throws SQLException;

}
