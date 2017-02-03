package undici.kunde;

import java.sql.SQLException;

public interface KundeDao {
	public void insertKunde(Kunde k) throws SQLException;
	public Kunde findKundeById(int id) throws SQLException;
	



}
