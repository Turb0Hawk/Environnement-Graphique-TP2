package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionApp {
	
	private static String urlConnection = "jdbc:mysql://localhost/BibliothequeDeMusique";
	
	public Connection conn = null;
	
	public ConnexionApp() {
		
		
	}
	
	private void connUp() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			
		} catch ( ClassNotFoundException e1  ) {
			e1.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(urlConnection,"BiblioAdmin","MusiqueAdmin");
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}
	
	private void connDown() {
		try {
			if(conn != null) {
				conn.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ResultSet getArtistes(){
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Artiste");
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}
	
	public ResultSet getArtiste(int artisteId){
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Artiste WHERE Numero = " + artisteId);
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}
	
	public ResultSet getAlbums(){
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Album");
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}
	
	public ResultSet getAlbums(int albumId){
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Album WHERE Numero = " + albumId);
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}
}