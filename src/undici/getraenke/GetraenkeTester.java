package undici.getraenke;

import java.sql.SQLException;
import java.util.List;

public class GetraenkeTester {
	public static void main(String[] args) {

		GetraenkeJDBCDao bd = new GetraenkeJDBCDao();

		try {

			List<Getraenke> getraenke = bd.getAllGetraenke();
			for (Getraenke getraenk : getraenke) {
				System.out.println(getraenk.toString());
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
