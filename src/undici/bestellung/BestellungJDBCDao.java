package undici.bestellung;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.adresse.Adresse;
import undici.excepitons.PlzException;
import undici.kunde.Kunde;
import undici.undici.ConnectionFactory;

public class BestellungJDBCDao {

	private Connection con = null;

	public void insertBestellung(Bestellung b) throws SQLException {
		String sql = "INSERT INTO undici.bestellung (undici.bestellung.kunde_id, undici.bestellung.getraenk_id, undici.bestellung.anzahlpizza, undici.bestellung.pizza_id, zahlung, gesamtpreis) VALUES (?, ?, ?, ?, ?, ?)";
		con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, b.getKunde_id());
		ps.setInt(2, b.getGetraenk_id());
		ps.setInt(3, b.getPizza_id());
		ps.setInt(4, b.getAnzahlpizza());
		ps.setString(5, b.getZahlung());
		ps.setDouble(6, b.gesamtpreis());
		ps.executeUpdate();
	}

	public Bestellung findBestellungById(int id) throws SQLException {
		Bestellung b = null;
		String sql = "SELECT undici.bestellung.id, undici.bestellung.getraenk_id, undici.bestellung.pizza_id, undici.bestellung.anzahlpizza, undici.bestellung.gesamtpreis,undici.kunde.adresse_id, undici.bestellung.zahlung, undici.kunde.anrede, undici.kunde.vorname, undici.kunde.name, undici.kunde.email, undici.kunde.telefon, undici.kunde.passwort, undici.kunde.kreditkartenNr, undici.adresse.strasse, undici.adresse.hausnummer, undici.adresse.plz, undici.adresse.ort from undici.bestellung join undici.kunde on undici.kunde.id=undici.bestellung.kunde_id join undici.adresse on undici.adresse.id = undici.kunde.adresse_id FROM undici.bestellung WHERE undici.bestellung.id = ?";
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
		String sql = "select undici.bestellung.id," + "undici.bestellung.getraenk_id," + ""
				+ "			undici.bestellung.pizza_id," + "				undici.bestellung.gesamtpreis,"
				+ "				undici.kunde.adresse_id," + "				undici.bestellung.zahlung,"
				+ "				undici.kunde.anrede," + "				undici.kunde.vorname,"
				+ "				undici.kunde.name," + "				undici.kunde.email,"
				+ "				undici.kunde.telefon," + "				undici.kunde.passwort,"
				+ "				undici.kunde.kreditkartenNr," + "				undici.adresse.strasse,"
				+ "				undici.adresse.hausnummer," + "				undici.adresse.plz,"
				+ "				undici.adresse.ort,"
				+ "				undici.bestellung.anzahlpizza from undici.bestellung join undici.kunde on undici.kunde.id=undici.bestellung.kunde_id join undici.adresse on undici.adresse.id = undici.kunde.adresse_id join undici.pizza on undici.pizza.id=undici.bestellung.pizza_id join undici.getraenk on undici.getraenk.id=undici.bestellung.getraenk_id;";
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
			a.setHausnummer(rs.getString("hausnummer"));
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
