package modele;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
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
import javax.swing.table.TableModel;

import vue.*;

public class ConnexionDB {

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
			statement.execute( "SELECT * FROM Artiste ORDER BY Numero ASC" );
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
				Album album = ( results.getBytes( "Couverture" ) == null ? new Album( results.getInt( "Numero" ),
						results.getString( "Titre" ), results.getString( "Genre" ), results.getInt( "Annee" ),
						results.getInt( "Numero_Artiste_Principal" ) )
						: new Album( results.getInt( "Numero" ), results.getString( "Titre" ),
								results.getString( "Genre" ), results.getInt( "Annee" ),
								results.getBytes( "Couverture" ), results.getInt( "Numero_Artiste_Principal" ) ) );
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
		artiste.setImageArtiste( image );
		artiste.getPanelArtiste().removeAll();
		artiste.getPanelArtiste().add( new JLabel( new ImageIcon( resiseImage( image, 35, 35 ) ) ) );
		artiste.getPanelArtiste().repaint();
		connUp();
		PreparedStatement statement;

		try {
			statement = conn.prepareStatement( "UPDATE Artiste SET Photo = ? WHERE Numero = ?" );
			statement.setBytes( 1, photo );
			statement.setLong( 2, ( Integer.parseInt(
					(String) artiste.getTabModel().getValueAt( artiste.getTableArtistes().getSelectedRow(), 0 ) ) ) );
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
		// "borrowed" directly from :
		// https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4848028
		byte[] imageByte;
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ImageIO.write( i, "png", baos );
			imageByte = baos.toByteArray();
		} catch ( IOException ioe ) {
			imageByte = null;
		} catch ( IllegalArgumentException iae ) {
			imageByte = null;
		}
		return imageByte;
	}

	public DefaultTableModel obtenirArtistesRecherche( String txtRecherche, TableModel tabModel ) {
		connUp();
		ResultSet results = null;
		PreparedStatement statement;
		DefaultTableModel tabArtistes = new DefaultTableModel();
		tabArtistes.addColumn( "Numero" );
		tabArtistes.addColumn( "Nom_Artiste" );
		tabArtistes.addColumn( "Membre" );
		try {
			statement = conn.prepareStatement( "SELECT * FROM Artiste WHERE Nom_Artiste LIKE ?" );
			statement.setString( 1, "%" + txtRecherche + "%" );
			statement.execute();
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

	public void ajoutArtiste( int num, String nom, boolean membre, BufferedImage photo ) {
		byte[] photoBytes = imageToByte( photo );
		connUp();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement( "INSERT INTO Artiste VALUES (?, ?, ?, ?);" );
			statement.setInt( 1, num );
			statement.setString( 2, nom );
			statement.setBoolean( 3, membre );
			statement.setBytes( 4, photoBytes );
			statement.execute();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
	}

	public void deleteArtiste( int num ) {
		connUp();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement( "DELETE FROM Artiste WHERE Numero = ?" );
			statement.setInt( 1, num );
			statement.execute();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
	}


	public boolean modifierArtiste( int num, String nom, boolean membre, BufferedImage photo ) {
		boolean retour;
		if ( idArtisteExiste( num ) ) {
			byte[] photoBytes = imageToByte( photo );
			connUp();
			PreparedStatement statement;
			try {
				statement = conn.prepareStatement(
						"UPDATE Artiste SET Nom_Artiste = ?, Membre = ?, Photo = ? WHERE Numero = ?;" );
				statement.setString( 1, nom );
				statement.setBoolean( 2, membre );
				statement.setBytes( 3, photoBytes );
				statement.setInt( 4, num );
				statement.execute();
				retour = true;
			} catch ( SQLException e ) {
				e.printStackTrace();
				retour = false;
			}
			connDown();
		} else {
			retour = false;
		}
		return retour;
	}

	public boolean idArtisteExiste( int id ) {
		connUp();
		PreparedStatement statement;
		ResultSet result = null;
		try {
			statement = conn.prepareStatement( "SELECT * FROM Artiste WHERE Numero = ?;" );
			statement.setInt( 1, id );
			statement.execute();
			result = statement.getResultSet();
		} catch ( SQLException e ) {
			e.printStackTrace();
		}
		connDown();
		try {
			return result.next();
		} catch ( SQLException e ) {
			return false;
		}
	}
}