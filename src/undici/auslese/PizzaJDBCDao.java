package undici.auslese;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.undici.ConnectionFactory;

public class PizzaJDBCDao {

	private Connection con = null;

	public Pizza findPizzaById(int id) throws SQLException {
		Pizza pizza = null;
		String sql = "select undici.pizza.id, undici.pizza.pizza, undici.pizza.preis from undici.pizza;";
		con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			pizza = new Pizza();
			pizza.setId(rs.getInt("id"));
			pizza.setPizza(rs.getString("pizza"));
			pizza.setPreis(rs.getDouble("preis"));
			break;
		}
		return pizza;
	}

	public ArrayList<Pizza> getAllpizzen() throws SQLException {
		ArrayList<Pizza> pizza = new ArrayList<Pizza>();
		Pizza p = null;
		String sql = "SELECT undici.pizza.id, undici.pizza.pizza, undici.pizza.preis from undici.pizza;";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Daten in die Querry Info abfüllen ps.set...
		PreparedStatement ps = con.prepareStatement(sql);
		// Querry ausführen:
		ResultSet rs = ps.executeQuery();
		// Daten aus Query Resultat verarbeiten:
		while (rs.next()) {
			p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setPizza(rs.getString("pizza"));
			p.setPreis(rs.getDouble("preis"));
			
			pizza.add(p);
		} // ps und rs schliessen

		return pizza;
	}
}
