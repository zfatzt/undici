package undici.bestellung;

import undici.undici.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.adresse.Adresse;
import undici.excepitons.PlzException;
import undici.undici.ConnectionFactory;

public class BestellungJDBCDao {

	private Connection con = null;
	
	public void insertBestellung(Bestellung b) throws SQLException {
		String sql = "INSERT INTO undici.bestellung (getraenke, pizza, zahlung, gesamtpreis) VALUES (?, ?, ?, ?)";
		con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, b.getGetraenke());
		ps.setString(2, b.getPizza());
		ps.setString(3, b.getZahlung());
		ps.setDouble(4, b.gesamtpreis());
		ps.executeUpdate();
	}
	

	public Bestellung findBestellungById(int id) throws SQLException {
		Bestellung b = null;
		String sql = "SELECT id, getraenke, pizza, zahlung, gesamtpreis FROM undici.bestellung WHERE id = ?";
		con = ConnectionFactory.getInstance().getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);	
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			b = new Bestellung();
			b.setId(rs.getInt("id"));
			b.setGetraenke(rs.getString("getraenke"));
			b.setPizza(rs.getString("pizza"));
			b.setZahlung(rs.getString("zahlung"));
			b.gesamtpreis();
			break;
		} 
		return b;
	}
	
	
	public ArrayList<Bestellung> getAllBestellungen() throws SQLException {
		ArrayList<Bestellung> bestellung = new ArrayList<Bestellung>();
		Bestellung b = null;
		String sql = "SELECT id, getraenke, pizza, zahlung, gesamtpreis FROM undici.bestellung";
		//Zur DB verbinden (Verbindung holen):
		con = ConnectionFactory.getInstance().getConnection();
		//Daten in die Querry Info abfüllen ps.set...		
		PreparedStatement ps = con.prepareStatement(sql);
		//Querry ausführen:
		ResultSet rs = ps.executeQuery();
		//Daten aus Query Resultat verarbeiten:		
		while (rs.next()) {
			b = new Bestellung();
			b.setId(rs.getInt("id"));
			b.setGetraenke(rs.getString("getraenke"));
			b.setPizza(rs.getString("pizza"));
			b.setZahlung(rs.getString("zahlung"));
			b.gesamtpreis();
			bestellung.add(b);
		} // ps und rs schliessen
		
		return bestellung;
	}
}



