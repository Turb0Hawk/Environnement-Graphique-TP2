package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionApp {
	
	private static final String urlConnection = "jdbc:mysql://localhost/BibliothequeDeMusique";
	private static final String user = "BiblioAdmin";
	private static final String password = "MusiqueAdmin";
	
	public Connection conn = null;
	
	public ConnexionApp() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");
			
		} catch ( ClassNotFoundException e1  ) {
			e1.printStackTrace();
		}
	}
	
	private void connUp() {
		
		try {
			conn = DriverManager.getConnection(urlConnection, user, password);
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