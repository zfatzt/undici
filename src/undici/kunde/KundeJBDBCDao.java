package undici.kunde;

import undici.undici.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import undici.adresse.Adresse;
import undici.excepitons.EmailException;
import undici.excepitons.PlzException;
import undici.undici.ConnectionFactory;


public class KundeJBDBCDao implements KundeDao {
	
	
		private Connection con = null;

		public void insertKunde(Kunde k) throws SQLException {
			//Querry bereit machen:	
			String sql = "INSERT INTO undici.kunde ( adresse_id, anrede, vorname, name, email, telefon, passwort) VALUES (?, ?, ?, ?, ?, ?, ?)";
			con = ConnectionFactory.getInstance().getConnection();	
			PreparedStatement ps = con.prepareStatement(sql);		
			
			
			ps.setInt(1, k.getAdresse_id());	
			ps.setString(2, k.getAnrede());
			ps.setString(3, k.getVorname());
			ps.setString(4, k.getName());
			ps.setString(5, k.getEmail());
			ps.setString(6, k.getTelefon());
			ps.setString(7, k.getPasswort());
			ps.executeUpdate();
		}
		

		public Kunde findKundeById(int id) throws SQLException {
			Kunde k = null;
			//Querry bereit machen:		
			String sql = "SELECT id, anrede, vorname, name, adresse_id, email, telefon, passwort  FROM undici.kunde WHERE id = ?";
			//Zur DB verbinden (Verbindung holen):
			con = ConnectionFactory.getInstance().getConnection();
			//Querry Information erstellen
			PreparedStatement ps = con.prepareStatement(sql);
			//Daten in die Querry Info abf�llen ps.set...
			ps.setInt(1, id);
			//Querry ausf�hren:		
			ResultSet rs = ps.executeQuery();
			//Daten aus Query Resultat verarbeiten:
			while (rs.next()) {
				k = new Kunde();
				k.setId(rs.getInt("id"));
				k.setAdresse_id(rs.getInt("adresse_id"));
				k.setAnrede(rs.getString("anrede"));
				k.setVorname("vorname");
				k.setName("name");
				try {
					k.setEmail("email");
				} catch (EmailException e) {
					e.printStackTrace();
				}
				k.setTelefon("telefon");
				k.setPasswort("passwort");
				break;
			} // ps und rs schliessen
			return k;
		}
		
		
		public ArrayList<Kunde> getAllKunden() throws SQLException {
			ArrayList<Kunde> kunde = new ArrayList<Kunde>();
			Kunde kunde1= null;
			String sql = "SELECT undici.kunde.id, undici.kunde.adresse_id, undici.adresse.strasse, undici.adresse.hausnummer, undici.adresse.plz, undici.adresse.ort, anrede, vorname, name, email, telefon, passwort  FROM undici.kunde join undici.adresse on undici.adresse.id = undici.kunde.adresse_id";
			//Zur DB verbinden (Verbindung holen):
			con = ConnectionFactory.getInstance().getConnection();
			//Daten in die Querry Info abf�llen ps.set...		
			PreparedStatement ps = con.prepareStatement(sql);
			//Querry ausf�hren:
			ResultSet rs = ps.executeQuery();
			//Daten aus Query Resultat verarbeiten:		
			while (rs.next()) {
				kunde1 = new Kunde();
				kunde1.setId(rs.getInt("id"));
				kunde1.setAdresse_id(rs.getInt("adresse_id"));
				kunde1.setAnrede(rs.getString("anrede"));
				kunde1.setVorname(rs.getString("vorname"));
				kunde1.setName(rs.getString("name"));
				try {
					kunde1.setEmail(rs.getString("email"));
				} catch (EmailException e1) {
					e1.printStackTrace();
				}
				kunde1.setTelefon(rs.getString("telefon"));
				kunde1.setPasswort(rs.getString("passwort"));
				Adresse adresse = new Adresse();
				adresse.setStrasse(rs.getString("strasse"));
				adresse.setHausnummer(rs.getString("hausnummer"));
				adresse.setOrt(rs.getString("ort"));
				try {
					adresse.setPlz(rs.getString("plz"));
				} catch (PlzException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				kunde1.setWohnAdresse(adresse);
				kunde.add(kunde1);
			} // ps und rs schliessen
			
			return kunde;
		}
		
        public boolean kannEinloggen(String email, String passwort) {

            try {
                        String sql = "select undici.kunde.email, undici.kunde.passwort from undici.kunde where email=? and passwort=?";
                        con = ConnectionFactory.getInstance().getConnection();
                        PreparedStatement ps = con.prepareStatement(sql);
                        ps.setString(1, email);
                        ps.setString(2, passwort);
                        ResultSet rs = ps.executeQuery();
                        rs.getFetchSize();
                        if (rs.next()) {
                                   return true;
                        }
            } catch (SQLException e) {
                        throw new RuntimeException(e);
            }
            return false;
}
        public Kunde findKundeByEmailAndPassword(String email, String passwort) throws SQLException {
			Kunde k = null;
			//Querry bereit machen:		
			String sql = "SELECT id, anrede, vorname, name, adresse_id, email, telefon, passwort  FROM undici.kunde WHERE email = ? and passwort = ?";
			//Zur DB verbinden (Verbindung holen):
			con = ConnectionFactory.getInstance().getConnection();
			//Querry Information erstellen
			PreparedStatement ps = con.prepareStatement(sql);
			//Daten in die Querry Info abf�llen ps.set...
			ps.setString(1, email);
			ps.setString(2, passwort);
			//Querry ausf�hren:		
			ResultSet rs = ps.executeQuery();
			//Daten aus Query Resultat verarbeiten:
			while (rs.next()) {
				k = new Kunde();
				k.setId(rs.getInt("id"));
				k.setAdresse_id(rs.getInt("adresse_id"));
				k.setAnrede(rs.getString("anrede"));
				k.setVorname(rs.getString("vorname"));
				k.setName(rs.getString("name"));
				try {
					k.setEmail(rs.getString("email"));
				} catch (EmailException e) {
					e.printStackTrace();
				}
				k.setTelefon(rs.getString("telefon"));
				k.setPasswort(rs.getString("passwort"));
				break;
			} // ps und rs schliessen
			return k;
		}
        
        
	}

