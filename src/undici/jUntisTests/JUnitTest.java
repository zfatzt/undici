package undici.jUntisTests;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Test;

import undici.kunde.KundeJBDBCDao;
import undici.undici.ConnectionFactory;


public class JUnitTest {
	KundeJBDBCDao kunde = new KundeJBDBCDao();
	
	@Test
	public void testDBVerbindung() {
		java.sql.Connection con = null;
		try {
			con = ConnectionFactory.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void testKannEinloggen() {

		String email = "tobias.fatzer@bluewin.ch";
		String passwort = "Toby1234";
		
		Assert.assertEquals(true, kunde.kannEinloggen(email, passwort));
		//true = noch nicht vorhanden
		//false = schon vorhanden
		
		
		
	}
	public void testEmailVerwendet() {
		String email = "tobias.fatzer@bbcag.ch";
		
		
		//wenn Rückgabe false: email Adresse bereits verhanden.
		//wenn Rückgabe true: email Adresse noch nicht verhanden.
		Assert.assertEquals(true, kunde.EmailSchonVorhanden(email));
	}

}
