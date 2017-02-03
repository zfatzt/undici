package undici.adresse;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Scanner;

import undici.excepitons.PlzException;


public class AdresseTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Adresse a = new Adresse();
		AdresseJDBCDao pd = new AdresseJDBCDao();

		try {
			
			for(int i=0; i < 1; i++){
				
				System.out.println("Bitte geben Sie ihre strasse ein > ");
				String strasse = sc.nextLine();
				a.setStrasse(strasse);
				System.out.println("nun ihre Hausnummer > ");
				int hausnr = sc.nextInt();
				sc.nextLine();
				a.setHausnummer(hausnr);
				try {
					System.out.println("nun ihre plz > ");
					String plz = sc.nextLine();
					a.setPlz(plz);
				} catch (PlzException e) {
				}
				System.out.println("nun ihren Ort > ");
				String ort = sc.nextLine();
				a.setOrt(ort);
				pd.insertAdresse(a);
			}
		
			for(Adresse person : pd.getAllAdressen()){
			System.out.println(person.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}


