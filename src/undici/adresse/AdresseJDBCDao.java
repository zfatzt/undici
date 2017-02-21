package undici.adresse;

import undici.undici.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.Statement;

import undici.excepitons.PlzException;
import undici.undici.ConnectionFactory;

public class AdresseJDBCDao implements AdresseDao {

	private Connection con = null;

	public int insertAdresse(Adresse a) throws SQLException {
		// Querry bereit machen:
		String sql = "INSERT INTO undici.adresse (strasse, hausnummer, plz, ort) VALUES (?, ?, ?, ?)";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Querry Information erstellen
		PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		// Daten in die Querry Info abfüllen ps.set...
		ps.setString(1, a.getStrasse());
		ps.setString(2, a.getHausnummer());
		ps.setString(3, a.getPlz());
		ps.setString(4, a.getOrt());
		ps.executeUpdate(); // ps schliessen

		ResultSet set = ps.getGeneratedKeys();
		while (set.next() == true) {
			int id = set.getInt(1);
			System.out.println("Key: " + id);
			set.close();
			return id;
			}
		throw new SQLException("diese ID Funktioniert nicht, bitte versuchen Sie es erneut");
	}

	public Adresse findAdresseById(int id) throws SQLException {
		Adresse a = null;
		// Querry bereit machen:
		String sql = "SELECT id, strasse, plz, ort FROM undici.person WHERE id = ?";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Querry Information erstellen
		PreparedStatement ps = con.prepareStatement(sql);
		// Daten in die Querry Info abfüllen ps.set...
		ps.setInt(1, id);
		// Querry ausführen:
		ResultSet rs = ps.executeQuery();
		// Daten aus Query Resultat verarbeiten:
		while (rs.next()) {
			a = new Adresse();
			a.setId(rs.getInt("id"));
			a.setStrasse(rs.getString("strasse"));
			a.setHausnummer(rs.getString("hausnummer"));
			try {
				a.setPlz(rs.getString("plz"));
			} catch (PlzException e) {
			}
			a.setOrt(rs.getString("ort"));
			break;
		} // ps und rs schliessen
		return a;
	}

	public ArrayList<Adresse> getAllAdressen() throws SQLException {
		ArrayList<Adresse> adresse = new ArrayList<Adresse>();
		Adresse a = null;
		String sql = "SELECT id, strasse, hausnummer, plz, ort FROM undici.adresse";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Daten in die Querry Info abfüllen ps.set...
		PreparedStatement ps = con.prepareStatement(sql);
		// Querry ausführen:
		ResultSet rs = ps.executeQuery();
		// Daten aus Query Resultat verarbeiten:
		while (rs.next()) {
			a = new Adresse();
			a.setId(rs.getInt("id"));
			a.setStrasse(rs.getString("strasse"));
			a.setHausnummer(rs.getString("hausnummer"));
			try {
				a.setPlz(rs.getString("plz"));
			} catch (PlzException e) {
			}
			a.setOrt(rs.getString("ort"));
			adresse.add(a);
		} // ps und rs schliessen

		return adresse;
	}
}
