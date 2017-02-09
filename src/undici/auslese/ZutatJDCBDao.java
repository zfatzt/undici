package undici.auslese;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.adresse.Adresse;
import undici.bestellung.Bestellung;
import undici.excepitons.PlzException;
import undici.kunde.Kunde;
import undici.undici.ConnectionFactory;

public class ZutatJDCBDao {

	
	private Connection con = null;
	
	public Bestellung findBestellungById(int id) throws SQLException {
		Bestellung b = null;
		String sql = "select undici.zutat.id undici.zutat.zutat undici.zutat.preis from undici.zutat;";
		con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			b = new Bestellung();
			b.setId(rs.getInt("id"));
			b.setKunde_id(rs.getInt("kunde_id"));
			b.setGetraenk_id(rs.getInt("getraenk_id"));
			b.setPizza_id(rs.getInt("pizza_id"));
			b.setAnzahlpizza(rs.getInt("anzahlpizza"));
			b.setZahlung(rs.getString("zahlung"));
			b.gesamtpreis();
			break;
		}
		return b;
	}

	public ArrayList<Bestellung> getAllBestellungen() throws SQLException {
		ArrayList<Bestellung> bestellung = new ArrayList<Bestellung>();
		Bestellung b = null;
		String sql = "select undici.zutat.id undici.zutat.zutat undici.zutat.preis from undici.zutat;";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Daten in die Querry Info abfüllen ps.set...
		PreparedStatement ps = con.prepareStatement(sql);
		// Querry ausführen:
		ResultSet rs = ps.executeQuery();
		// Daten aus Query Resultat verarbeiten:
		while (rs.next()) {
			b = new Bestellung();
			b.setId(rs.getInt("id"));
			b.setGetraenk_id(rs.getInt("getraenk_id"));
			b.setPizza_id(rs.getInt("pizza_id"));
			b.setAnzahlpizza(rs.getInt("anzahlpizza"));
			b.setZahlung(rs.getString("zahlung"));
			b.gesamtpreis();
			Kunde k = new Kunde();
			k.setId(rs.getInt("id"));
			k.setAdresse_id(rs.getInt("adresse_id"));
			k.setAnrede(rs.getString("anrede"));
			k.setVorname(rs.getString("vorname"));
			k.setName(rs.getString("name"));
			k.setEmail(rs.getString("email"));
			k.setTelefon(rs.getString("telefon"));
			k.setPasswort(rs.getString("passwort"));
			k.setKreditkartenNr(rs.getString("kreditkartenNr"));
			Adresse a = new Adresse();
			a.setStrasse(rs.getString("strasse"));
			a.setHausnummer(rs.getInt("hausnummer"));
			a.setOrt(rs.getString("ort"));
			try {
				a.setPlz(rs.getString("plz"));
			} catch (PlzException e) {
				e.printStackTrace();
			}
			k.setWohnAdresse(a);
			b.setKunde(k);
			bestellung.add(b);
		} // ps und rs schliessen

		return bestellung;
	}
}

}
