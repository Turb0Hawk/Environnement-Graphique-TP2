package controleur;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modele.*;
import vue.GestionArtistes;
import vue.Menu;

public class Controleur {

	ConnexionDB modele = new ConnexionDB();

	public Controleur() {

	}

	public DefaultTableModel initialiserArtistes( DefaultTableModel tabArtistes ) {
		return ajouterImageMembre( tabArtistes = modele.getArtistes() );
	}

	public DefaultTableModel ajouterImageMembre( DefaultTableModel tabArtistes ) {
		ImageIcon image;
		ImageIcon imageFalse = createImageIcon( "/Ressources/iconFalse.png", "non" );
		ImageIcon imageTrue = createImageIcon( "/Ressources/iconTrue.png", "oui" );
		for ( int i = 0; i < tabArtistes.getRowCount(); ++i ) {

			if ( (boolean) ( (Vector) tabArtistes.getDataVector().elementAt( i ) ).elementAt( 2 ) ) {

				image = imageTrue;
			} else {

				image = imageFalse;
			}
			tabArtistes.setValueAt( image, i, 2 );
		}

		return tabArtistes;
	}

	public Object[] obtenirUnArtiste( int idArtiste, GestionArtistes artiste ) {
		Object[] row = modele.getArtiste( idArtiste );
		if ( row[3] != null ) {
			try {
				ByteArrayInputStream bis = new ByteArrayInputStream( (byte[]) row[3] );
				BufferedImage bImage = ImageIO.read( bis );
				row[3] = bImage.getScaledInstance( 75,
						75, Image.SCALE_SMOOTH );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
		return row;
	}

	public DefaultListModel<Album> obtenirAlbumsArtiste( int artisteId ) {
		return modele.getAlbums( artisteId );
	}

	public Image obtenirUnAlbum( int idAlbum ) {
		byte[] photo = modele.getAlbum( idAlbum );
		Image couverture = null;
		if ( photo != null ) {// redo
			try {
				ByteArrayInputStream bis = new ByteArrayInputStream( photo );
				BufferedImage bImage = ImageIO.read( bis );
				couverture = modele.resiseImage( bImage, 50, 50 );
			} catch ( IOException e ) {
				e.printStackTrace();
			}
		}
		return couverture;
	}

	protected ImageIcon createImageIcon( String path, String description ) {
		java.net.URL imgURL = getClass().getResource( path );
		if ( imgURL != null ) {
			Image Image = null;
			Image = modele.resiseImage( Toolkit.getDefaultToolkit().getImage( Menu.class.getResource( path ) ), 15,
					15 );
			return new ImageIcon( Image, description );
		} else {
			System.err.println( "Couldn't find file: " + path );
			return null;
		}
	}

	public BufferedImage obtenirImage( JFrame parent ) {
		JFileChooser imageChooser = new JFileChooser();
		BufferedImage image = null;
		imageChooser.setFileFilter( new FileNameExtensionFilter( "Images (*.png, *.bmp)", "jpg", "png", "bmp" ) );
		if ( imageChooser.showOpenDialog( parent ) == JFileChooser.APPROVE_OPTION ) {
			if ( imageChooser.getSelectedFile().exists() ) {
				try {

					image = ImageIO.read( imageChooser.getSelectedFile() );
				} catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}
		return image;
	}

	public void ajouterArtiste( GestionArtistes artiste ) {
		int num = Integer.parseInt(artiste.getTxtNumero().getText());
		String nom = artiste.getTxtNom().getText();
		boolean membre = artiste.getMembre().isSelected();
		BufferedImage photo = artiste.getImageArtiste();
		modele.ajoutArtiste(num, nom, membre, photo);
		artiste.getTableArtistes().setModel( initialiserArtistes( artiste.getTabModel() ) );
		artiste.getTableArtistes().setRowSelectionInterval( num-1, num-1 );
		
	}
}
