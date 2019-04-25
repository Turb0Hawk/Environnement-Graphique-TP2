package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class ConnexionApp {

	private static final String user = "BiblioAdmin";
	private static final String password = "test1";
	private static final String urlConnection = "jdbc:mysql://localhost/BibliothequeDeMusique?user=" + user
			+ "&password=" + password + "&serverTimezone=UTC";

	public Connection conn = null;

	public ConnexionApp() {
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();

		} catch ( ClassNotFoundException | InstantiationException | IllegalAccessException e1 ) {
			e1.printStackTrace();
		}
	}

	private void connUp() {

		try {
			conn = DriverManager.getConnection( urlConnection );
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	private void connDown() {
		try {
			if ( conn != null ) {
				conn.close();
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
	}

	public DefaultTableModel getArtistes() {
		connUp();
		ResultSet results = null;
		Statement statement;
		DefaultTableModel tabArtistes = new DefaultTableModel();
		tabArtistes.addColumn( "Numero" );
		tabArtistes.addColumn( "Nom_Artiste" );
		tabArtistes.addColumn( "Membre" );
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Artiste" );
			results = statement.getResultSet();
			while ( results.next() ) {
				Object[] row = {results.getString( "Numero" ), results.getString( "Nom_Artiste" ), results.getBoolean("Membre")};
				 tabArtistes.addRow( row );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return tabArtistes;
	}

	public ResultSet getArtiste( int artisteId ) {
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Artiste WHERE Numero = " + artisteId );
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}

	public ResultSet getAlbums() {
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Album" );
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}

	public ResultSet getAlbums( int albumId ) {
		connUp();
		ResultSet results = null;
		Statement statement;
		try {
			statement = conn.createStatement();
			statement.execute( "SELECT * FROM Album WHERE Numero = " + albumId );
			results = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return results;
	}
}