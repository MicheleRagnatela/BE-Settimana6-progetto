package it.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String UTENTE = "postgres";
	private static final String PASSWORD = "Brambilla95";
	private static final String CONNECTION_STRING = "jdbc:postgresql://localhost:5432/banca";
	
	public static Connection getConnection() {
		Connection conn = null;
		
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, UTENTE, PASSWORD);
			System.out.println("**** Connessione effettuata correttamente ****");
		} catch (SQLException e) {
			System.out.println("**** Errore di connessione ****");
			e.printStackTrace();
		}
		
		return conn;
	}
}
