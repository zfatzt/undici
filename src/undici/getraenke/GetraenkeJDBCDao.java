package undici.getraenke;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import undici.undici.ConnectionFactory;

public class GetraenkeJDBCDao {

	private Connection con = null;

	public Getraenke findPizzaById(int id) throws SQLException {
		Getraenke getraenk = null;
		String sql = "select undici.getraenk.id, undici.getraenk.preis, undici.getraenk.getraenk, undici.getraenk.bild from undici.getraenk ;";
		con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			getraenk = new Getraenke();
			getraenk.setId(rs.getInt("id"));
			getraenk.setGetraenk(rs.getString("pizza"));
			getraenk.setPreis(rs.getDouble("preis"));
			getraenk.setBild(rs.getString("bild"));
			break;
		}
		return getraenk;
	}

	public ArrayList<Getraenke> getAllGetraenke() throws SQLException {
		ArrayList<Getraenke> getraenke = new ArrayList<Getraenke>();
		Getraenke p = null;
		String sql = "select undici.getraenk.id, undici.getraenk.preis, undici.getraenk.getraenk, undici.getraenk.bild from undici.getraenk ;";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Daten in die Querry Info abfüllen ps.set...
		PreparedStatement ps = con.prepareStatement(sql);
		// Querry ausführen:
		ResultSet rs = ps.executeQuery();
		// Daten aus Query Resultat verarbeiten:

		while (rs.next()) {
			p = new Getraenke();
			p.setId(rs.getInt("id"));
			p.setGetraenk(rs.getString("getraenk"));
			p.setPreis(rs.getDouble("preis"));
			p.setBild(rs.getString("bild"));

			getraenke.add(p);
		}
		return getraenke;
	}

	private boolean containGetraenk(int id, List<Getraenke> getraenkes) {
		for (Getraenke getraenk : getraenkes) {
			if (getraenk.getId() == id) {
				return true;
			}
		}

		return false;
	}

	private Getraenke getGetraenkById(int id, List<Getraenke> getraenkes) {
		for (Getraenke getraenk : getraenkes) {
			if (getraenk.getId() == id) {
				return getraenk;
			}
		}

		throw new RuntimeException("Getraenk with id: " + id + " not found!");
	}
}
