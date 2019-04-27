package modele;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableModel;

import com.sun.xml.internal.messaging.saaj.util.Base64;

import vue.*;

public class ConnexionDB {

	private static final String user = "BiblioAdmin";
	private static final String password = "MusiqueAdmin";
	private static final String urlConnection = "jdbc:mysql://localhost/BibliothequeDeMusique?user=" + user
			+ "&password=" + password + "&serverTimezone=UTC";
	private static final String UrlSqlLite = "jdbc:sqlite:" + Paths.get( "./src/BibliothequeMusique.db" ).toString();

	public Connection conn = null;

	public ConnexionDB() {
		try {
			Class.forName( "com.mysql.cj.jdbc.Driver" ).newInstance();

		} catch ( ClassNotFoundException | InstantiationException | IllegalAccessException e1 ) {
			e1.printStackTrace();
		}
	}

	private void connUp() {

		try {
			conn = DriverManager.getConnection( UrlSqlLite );
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

	public DefaultListModel<Album> getAlbums( int artisteId ) {
		connUp();
		ResultSet results = null;
		PreparedStatement statement;
		DefaultListModel<Album> tabAlbums = new DefaultListModel<Album>();
		try {
			statement = conn
					.prepareStatement( "SELECT * FROM Album WHERE Numero_Artiste_Principal = ? ORDER BY Annee" );
			statement.setString( 1, String.valueOf( artisteId ) );
			results = statement.executeQuery();
			while ( results.next() ) {
				Album album = new Album( results.getInt( "Numero" ), results.getString( "Titre" ),
						results.getString( "Genre" ), results.getInt( "Annee" ), results.getBytes( "Couverture" ),
						results.getInt( "Numero_Artiste_Principal" ) );
				tabAlbums.addElement( album );
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
			statement = conn.prepareStatement( "SELECT Couverture FROM Album WHERE Numero_Artiste_Principal = ?" );
			statement.setString( 1, String.valueOf( idAlbum ) );
			results = statement.executeQuery();
			while ( results.next() ) {
				photo = results.getBytes( "Couverture" );
			}
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		return photo;
	}

	public void remplacerImage( BufferedImage image, GestionArtistes artiste ) {
		byte[] photo = imageToByte( image );
		artiste.getPanelArtiste().removeAll();
		artiste.getPanelArtiste().add( new JLabel( new ImageIcon( resiseImage( image, 35, 35 ) ) ) );
		artiste.getPanelArtiste().repaint();
		// TODO ins�rer l'image dans la db
		connUp();
		PreparedStatement statement;

		try {
			statement = conn.prepareStatement( "UPDATE Artiste SET Photo = ? WHERE Numero = ?" );
			statement.setBytes( 1, photo );
			statement.setLong( 2, ( artiste.getTableArtistes().getSelectedRow() + 1 ) );
			statement.executeUpdate();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();

	}

	public Image resiseImage( Image image, int i, int j ) {
		return image.getScaledInstance( i, j, Image.SCALE_SMOOTH );
	}

	public Image resiseImage( BufferedImage image, int i, int j ) {
		return image.getScaledInstance( i, j, Image.SCALE_SMOOTH );
	}

	public static byte[] imageToByte( BufferedImage i ) {
		// taken directly from :
		// https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4848028
		byte[] imageByte;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( i, "png", baos );
			imageByte = baos.toByteArray();
		} catch ( IOException ioe ) {
			imageByte = null;
		}
		return imageByte;
	}
}