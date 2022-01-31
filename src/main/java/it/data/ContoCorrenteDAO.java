package it.data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ContoCorrenteDAO {

	private static final String SELECT_CONTO = "SELECT * FROM contocorrente WHERE numero= ";
	private static final String PRELIEVO_CONTO = "UPDATE contocorrente SET saldo = saldo - ? WHERE numero= ?;";
	private static final String VERSAMENTO_CONTO = "UPDATE contocorrente SET saldo = saldo + ? WHERE numero= ?;";


	public ContoCorrente getContoCorrente(int numero) {
		Connection conn = ConnectionFactory.getConnection();

		Statement st = null;
		ResultSet rs = null;
		ContoCorrente cc = new ContoCorrente();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(SELECT_CONTO + numero);
			if(rs.next()) {
				
				cc.setNumero(rs.getInt("numero"));
				cc.setIntestatario(rs.getString("intestatario"));
				cc.setSaldo(rs.getFloat("saldo"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			rs.close();
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return cc;
	
	}
	
	public boolean versa(int numero, float quantita) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		int i = 0;
		try {
			ps = conn.prepareStatement(VERSAMENTO_CONTO);
				
				ps.setInt(2, numero);
				ps.setFloat(1, quantita);
			    i = ps.executeUpdate();
			System.out.println("**** Versamento effettuato ****");
		} catch (SQLException e) {
			System.out.println("**** Errore versamento ****");
			e.printStackTrace();
		}
		
		try {ps.close();}catch(Exception e) {}
		try {conn.close();}catch(Exception e) {}
		
		return(i>0);
	}
	
	public boolean preleva(int numero, float quantita) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement ps = null;
		
		int i = 0;
		
		try {
			ps = conn.prepareStatement(PRELIEVO_CONTO);
			ps.setInt(2, numero);
			ps.setFloat(1, quantita);
			
			
			i = ps.executeUpdate();
			System.out.println("**** Prelievo effettuato ****");
		} 
		catch (SQLException e) {
			System.out.println("**** Errore prelievo ****");
			e.printStackTrace();
		}
		
		try {ps.close();}catch(Exception e) {}
		try {conn.close();}catch(Exception e) {}
		
		return(i>0);
	}
	
	public boolean esiste(int numero) {
		ContoCorrente conto = new ContoCorrente();
		if(numero == conto.getNumero())
			return true;
			else
				return false;
	}
	
	
}