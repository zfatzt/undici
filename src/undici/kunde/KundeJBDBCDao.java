package undici.kunde;

import undici.undici.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.excepitons.PlzException;
import undici.undici.ConnectionFactory;


public class KundeJBDBCDao implements KundeDao {
	
	
		private Connection con = null;

		public void insertKunde(Kunde k) throws SQLException {
			//Querry bereit machen:	
			String sql = "INSERT INTO undici.kunde (id, anrede, vorname, name, email, telefon, passwort, kreditkartenNr) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			//Zur DB verbinden (Verbindung holen):
			con = ConnectionFactory.getInstance().getConnection();
			//Querry Information erstellen		
			PreparedStatement ps = con.prepareStatement(sql);
			//Daten in die Querry Info abfüllen ps.set...		
			ps.setInt(1, k.getId());
			ps.setString(2, k.getAnrede());
			ps.setString(3, k.getVorname());
			ps.setString(4, k.getName());
			ps.setString(5, k.getEmail());
			ps.setString(6, k.getTelefon());
			ps.setString(7, k.getPasswort());
			ps.setString(8, k.getKreditkartenNr());
			ps.executeUpdate(); // ps schliessen
		}
		

		public Kunde findKundeById(int id) throws SQLException {
			Kunde k = null;
			//Querry bereit machen:		
			String sql = "SELECT id, anrede, vorname, name, email, telefon, passwort, kreditkartenNr FROM undici.kunde WHERE id = ?";
			//Zur DB verbinden (Verbindung holen):
			con = ConnectionFactory.getInstance().getConnection();
			//Querry Information erstellen
			PreparedStatement ps = con.prepareStatement(sql);
			//Daten in die Querry Info abfüllen ps.set...
			ps.setInt(1, id);
			//Querry ausführen:		
			ResultSet rs = ps.executeQuery();
			//Daten aus Query Resultat verarbeiten:
			while (rs.next()) {
				k = new Kunde();
				k.setId(rs.getInt("id"));
				k.setAnrede(rs.getString("anrede"));
				k.setVorname("vorname");
				k.setName("name");
				k.setEmail("email");
				k.setTelefon("telefon");
				k.setPasswort("passwort");
				k.setKreditkartenNr("kreditkartenNr");
				break;
			} // ps und rs schliessen
			return k;
		}
		
		
		public ArrayList<Kunde> getAllKunden() throws SQLException {
			ArrayList<Kunde> kunde = new ArrayList<Kunde>();
			Kunde k= null;
			String sql = "SELECT id, anrede, vorname, name, email, telefon, passwort, kreditkartenNr FROM undici.kunde";
			//Zur DB verbinden (Verbindung holen):
			con = ConnectionFactory.getInstance().getConnection();
			//Daten in die Querry Info abfüllen ps.set...		
			PreparedStatement ps = con.prepareStatement(sql);
			//Querry ausführen:
			ResultSet rs = ps.executeQuery();
			//Daten aus Query Resultat verarbeiten:		
			while (rs.next()) {
				k = new Kunde();
				k.setId(rs.getInt("id"));
				k.setAnrede(rs.getString("anrede"));
				k.setVorname(rs.getString("vorname"));
				k.setName(rs.getString("name"));
				k.setEmail(rs.getString("email"));
				k.setTelefon(rs.getString("telefon"));
				k.setPasswort(rs.getString("passwort"));
				k.setKreditkartenNr(rs.getString("kreditkartenNr"));
				kunde.add(k);
			} // ps und rs schliessen
			
			return kunde;
		}
	}

