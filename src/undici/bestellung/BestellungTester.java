package undici.bestellung;

import java.sql.SQLException;
import java.util.Scanner;


public class BestellungTester {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Bestellung b = new Bestellung();
		BestellungJDBCDao bd = new BestellungJDBCDao();

		try {
			
			for(int i=0; i < 1; i++){
				
//				System.out.println("Anrede");
//				String anrede = sc.nextLine();
				b.setGetraenke("Fanta");
				
//				System.out.println("Vorname> ");
//				String vorname = sc.nextLine();
				b.setPizza("Margherita");
				
//				System.out.println("name> ");
//				String name = sc.nextLine();
				b.setZahlung("Barzahlung");
				
//				System.out.println("email > ");
//				String email = sc.nextLine();
				b.gesamtpreis();
				
				bd.insertBestellung(b);
			}
		
			for(Bestellung bestellung : bd.getAllBestellungen()){
			System.out.println(bestellung.toString());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
