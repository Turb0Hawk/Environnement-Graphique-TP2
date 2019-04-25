package controleur;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import modele.*;
import vue.Menu;

public class Controleur {

	ConnexionDB modele = new ConnexionDB();

	public Controleur() {

	}

	public DefaultTableModel initialiserArtistes( DefaultTableModel tabArtistes ) {
		ImageIcon image;
		ImageIcon imageFalse = createImageIcon( "/Ressources/iconFalse.png", "non");
		ImageIcon imageTrue =  createImageIcon("/Ressources/iconTrue.png", "oui" );
		tabArtistes = modele.getArtistes();
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
	
	public Object[] obtenirUnArtiste(int idArtiste) {
		Object[] row = modele.getArtiste( idArtiste );
		if ( row[3] != null ) {
			try {
				ByteArrayInputStream bis = new ByteArrayInputStream( (byte[]) row[3] );
				BufferedImage bImage = ImageIO.read( bis );
				row[3] = bImage.getScaledInstance( 50, 50, Image.SCALE_SMOOTH );
			} catch ( IOException e ) {
				e.printStackTrace();
			} 
		}
		return row;
	}
	
	public DefaultListModel<String> obtenirAlbumsArtiste( int artisteId ) {
		return modele.getAlbums( artisteId );
	}
	
	public ImageIcon obtenirUnAlbum(int idAlbum) {
		byte[] photo = modele.getAlbum( idAlbum );
		ImageIcon couverture = null;
		if ( photo != null ) {//redo
			try {
				ByteArrayInputStream bis = new ByteArrayInputStream( photo );
				BufferedImage bImage = ImageIO.read( bis );
			    couverture = new ImageIcon(bImage.getScaledInstance( 50, 50, Image.SCALE_SMOOTH ));
			} catch ( IOException e ) {
				e.printStackTrace();
			} 
		}
		return couverture;
	}
	
	protected ImageIcon createImageIcon(String path,
	                                           String description) {
	    java.net.URL imgURL = getClass().getResource(path);
	    if (imgURL != null) {
	    	Image Image = null;
	    	   Image = Toolkit.getDefaultToolkit().getImage( Menu.class.getResource( path ) )
			.getScaledInstance( 15, 15, Image.SCALE_SMOOTH );
	        return new ImageIcon(Image, description);
	    } else {
	        System.err.println("Couldn't find file: " + path);
	        return null;
	    }
	}
}
