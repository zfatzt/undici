package undici.pizza;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import undici.undici.ConnectionFactory;

public class PizzaJDBCDao {

	private Connection con = null;

	public Pizza findPizzaById(int id) throws SQLException {
		Pizza pizza = null;
		String sql = "select undici.zutat.zutat, undici.pizza.id, undici.pizza.pizza, undici.pizza.preis from undici.pizza_zutat join undici.pizza on undici.pizza.id = undici.pizza_zutat.pizza_id join undici.zutat on undici.zutat.id = undici.pizza_zutat.zutat_id where undici.pizza.id = 1;";
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
		ArrayList<Pizza> pizzen = new ArrayList<Pizza>();
		Pizza p = null;
		String sql = "select undici.zutat.zutat, undici.pizza.id, undici.pizza.pizza, undici.pizza.preis  from undici.pizza_zutat join undici.pizza on undici.pizza.id = undici.pizza_zutat.pizza_id join undici.zutat on undici.zutat.id = undici.pizza_zutat.zutat_id;";
		// Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		// Daten in die Querry Info abfüllen ps.set...
		PreparedStatement ps = con.prepareStatement(sql);
		// Querry ausführen:
		ResultSet rs = ps.executeQuery();
		// Daten aus Query Resultat verarbeiten:

		while (rs.next()) {

			int id = rs.getInt("id");
			if (containPizza(id, pizzen)) {
				Pizza pizza = getPizzaById(id, pizzen);
				p.setZutat(rs.getString("zutat"));
			} else {
				p = new Pizza();
				p.setZutat(rs.getString("zutat"));
				p.setId(rs.getInt("id"));
				p.setPizza(rs.getString("pizza"));
				p.setPreis(rs.getDouble("preis"));

				pizzen.add(p);
			}
		} // ps und rs schliessen

		return pizzen;
	}

	private boolean containPizza(int id, List<Pizza> pizzen) {
		for (Pizza pizza : pizzen) {
			if (pizza.getId() == id) {
				return true;
			}
		}

		return false;
	}

	private Pizza getPizzaById(int id, List<Pizza> pizzen) {
		for (Pizza pizza : pizzen) {
			if (pizza.getId() == id) {
				return pizza;
			}
		}

		throw new RuntimeException("Pizza with id: " + id + " not found!");
	}
}
