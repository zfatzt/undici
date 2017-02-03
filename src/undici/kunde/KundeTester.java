package undici.kunde;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import undici.excepitons.PlzException;


public class KundeTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Kunde k = new Kunde();
		KundeJBDBCDao pd = new KundeJBDBCDao();

		try {
			
			for(int i=0; i < 1; i++){
				
//				System.out.println("Anrede");
//				String anrede = sc.nextLine();
				k.setAnrede("Herr");
				
//				System.out.println("Vorname> ");
//				String vorname = sc.nextLine();
				k.setVorname("Tobias");
				
//				System.out.println("name> ");
//				String name = sc.nextLine();
				k.setName("Fatzer");
				
				k.setAdresse_id(1);
				
				
//				System.out.println("email > ");
//				String email = sc.nextLine();
				k.setEmail("tobias.fatzer@bluewin.ch");
				
//				System.out.println("telefon > ");
//				String telefon = sc.nextLine();
				k.setTelefon("+41 76 682 68 89");
				
//				System.out.println("passwort > ");
//				String passwort = sc.nextLine();
				k.setPasswort("Toby1234");
				
//				System.out.println("kreditkartenNr > ");
//				String kreditkartenNr = sc.nextLine();
				k.setKreditkartenNr("561313033");
				
				pd.insertKunde(k);
			}
		
			for(Kunde person : pd.getAllKunden()){
			System.out.println(person.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


