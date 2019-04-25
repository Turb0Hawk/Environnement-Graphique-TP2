package controleur;

import java.awt.Image;
import java.awt.Toolkit;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modele.*;
import vue.Menu;

public class controleur {

	ConnexionApp modele = new ConnexionApp();

	public controleur() {

	}

	public DefaultTableModel initialiserArtistes( DefaultTableModel tabArtistes ) {
		ImageIcon image;
		ImageIcon imageFalse = createImageIcon( "/Ressources/iconFalse.png", "not member");
		ImageIcon imageTrue =  createImageIcon("/Ressources/iconTrue.png", "is member" );
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
	
	/** Returns an ImageIcon, or null if the path was invalid. */
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
