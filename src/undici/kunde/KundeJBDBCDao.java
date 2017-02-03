package undici.kunde;

import undici.undici.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.adresse.Adresse;
import undici.excepitons.PlzException;
import undici.undici.ConnectionFactory;


public class KundeJBDBCDao implements KundeDao {
	
	
		private Connection con = null;

		public void insertKunde(Kunde k) throws SQLException {
			//Querry bereit machen:	
			String sql = "INSERT INTO undici.kunde ( adresse_id, anrede, vorname, name, email, telefon, passwort, kreditkartenNr) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			con = ConnectionFactory.getInstance().getConnection();	
			PreparedStatement ps = con.prepareStatement(sql);		
			
			
			ps.setInt(1, k.getAdresse_id());	
			ps.setString(2, k.getAnrede());
			ps.setString(3, k.getVorname());
			ps.setString(4, k.getName());
			ps.setString(5, k.getEmail());
			ps.setString(6, k.getTelefon());
			ps.setString(7, k.getPasswort());
			ps.setString(8, k.getKreditkartenNr());
			ps.executeUpdate();
		}
		

		public Kunde findKundeById(int id) throws SQLException {
			Kunde k = null;
			//Querry bereit machen:		
			String sql = "SELECT id, anrede, vorname, name, adresse_id, email, telefon, passwort, kreditkartenNr FROM undici.kunde WHERE id = ?";
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
				k.setAdresse_id(rs.getInt("adresse_id"));
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
			String sql = "SELECT undici.kunde.id, undici.kunde.adresse_id, undici.adresse.strasse, undici.adresse.hausnummer, undici.adresse.plz, undici.adresse.ort, anrede, vorname, name, email, telefon, passwort, kreditkartenNr FROM undici.kunde join undici.adresse on undici.adresse.id = undici.kunde.adresse_id";
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
				k.setAdresse_id(rs.getInt("adresse_id"));
				k.setAnrede(rs.getString("anrede"));
				k.setVorname(rs.getString("vorname"));
				k.setName(rs.getString("name"));
				k.setEmail(rs.getString("email"));
				k.setTelefon(rs.getString("telefon"));
				k.setPasswort(rs.getString("passwort"));
				k.setKreditkartenNr(rs.getString("kreditkartenNr"));
				Adresse x = new Adresse();
				x.setStrasse(rs.getString("strasse"));
				x.setHausnummer(rs.getInt("hausnummer"));
				x.setOrt(rs.getString("ort"));
				try {
					x.setPlz(rs.getString("plz"));
				} catch (PlzException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				k.setWohnAdresse(x);
				kunde.add(k);
			} // ps und rs schliessen
			
			return kunde;
		}
	}

