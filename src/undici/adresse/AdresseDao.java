package undici.adresse;

import java.sql.SQLException;

public interface AdresseDao {
	public int insertAdresse(Adresse a) throws SQLException;
	public Adresse findAdresseById(int id) throws SQLException;
	
}
