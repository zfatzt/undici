package undici.jUntisTests;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
import undici.kunde.KundeJBDBCDao;

public class KannDerNutzerEinloggenTest {

	@Test
	public void test() {
		KundeJBDBCDao kunde = new KundeJBDBCDao();
		String email = "tobias.fatzer@bluewin.ch";
		String passwort = "Toby1234";
		
		Assert.assertEquals(true, kunde.kannEinloggen(email, passwort));
		
	}

}
