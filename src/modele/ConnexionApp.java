package modele;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.DefaultListModel;
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
				Object[] row = { results.getString( "Numero" ), results.getString( "Nom_Artiste" ),
						results.getBoolean( "Membre" ) };
				tabArtistes.addRow( row );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return tabArtistes;
	}

	public Object[] getArtiste( int artisteId ) {
		connUp();
		ResultSet results = null;
		PreparedStatement statement;
		Object[] row = new Object[4];
		try {
			statement = conn.prepareStatement( "SELECT * FROM Artiste WHERE Numero = ?" );
			statement.setString( 1, String.valueOf( artisteId ) );
			results = statement.executeQuery();
			while ( results.next() ) {
				row[0] = results.getString( "Numero" );
				row[1] = results.getString( "Nom_Artiste" );
				row[2] = results.getBoolean( "Membre" );
				row[3] = results.getBytes( "Photo" );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return row;
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

	public DefaultListModel<String> getAlbums( int artisteId ) {
		connUp();
		ResultSet results = null;
		PreparedStatement statement;
		DefaultListModel<String> tabAlbums = new DefaultListModel<String>();
		try {
			statement = conn
					.prepareStatement( "SELECT * FROM Album WHERE Numero_Artiste_Principal = ? ORDER BY Annee" );
			statement.setString( 1, String.valueOf( artisteId ) );
			results = statement.executeQuery();
			while ( results.next() ) {
				String row =  results.getString( "Annee" ) + " - " + results.getString( "Titre" );
				tabAlbums.addElement( row );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return tabAlbums;
	}

	public byte[] getAlbum( int idAlbum ) {
		connUp();
		ResultSet results = null;
		PreparedStatement statement;
		byte[] photo = null;
		try {
			statement = conn
					.prepareStatement( "SELECT Couverture FROM Album WHERE Numero_Artiste_Principal = ?" );
			statement.setString( 1, String.valueOf( idAlbum ) );
			results = statement.executeQuery();
			while ( results.next() ) {
				photo =  results.getBytes( "Couverture" );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return photo;
	}
}