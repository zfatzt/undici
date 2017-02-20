package undici.undici;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
		private static ConnectionFactory connectionFactory = null;
		private String dbURL;
		private String dbUser;
		private String dbPwd;
		
		private ConnectionFactory() {
			setDbURL("jdbc:mysql://192.168.3.155:3306/?useSSL=false");
			setDbUser("root");
			setDbPwd("1234");
		}

		public Connection getConnection() throws SQLException {
			Connection conn = null;
			//Verbingung herstellen: URL, USER, PW
			conn = DriverManager.getConnection(getDbURL(), getDbUser(), getDbPwd());
			//Die Verbindung zur Verfügung stellen
			return conn;
		}

		public static ConnectionFactory getInstance() {
			if (connectionFactory == null) {
				connectionFactory = new ConnectionFactory();
			}
			return connectionFactory;
		}

		private String getDbURL() {
			return dbURL;
		}

		private void setDbURL(String dbURL) {
			this.dbURL = dbURL;
		}

		private String getDbUser() {
			return dbUser;
		}

		private void setDbUser(String dbUser) {
			this.dbUser = dbUser;
		}

		private String getDbPwd() {
			return dbPwd;
		}

		private void setDbPwd(String dbPwd) {
			this.dbPwd = dbPwd;
		}
	}
	

