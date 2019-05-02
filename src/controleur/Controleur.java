package controleur;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Vector;
import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import modele.*;
import vue.Connexion;
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
				row[3] = bImage.getScaledInstance( 75, 75, Image.SCALE_SMOOTH );
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
		int num = Integer.parseInt( artiste.getTxtNumero().getText() );
		String nom = artiste.getTxtNom().getText();
		boolean membre = artiste.getMembre().isSelected();
		BufferedImage photo = artiste.getImageArtiste();
		Object[] row = { String.valueOf( num ), nom, membre };

		if ( (boolean) row[2] ) {
			row[2] = createImageIcon( "/ressources/iconTrue.png", "oui" );
		} else {
			row[2] = createImageIcon( "/ressources/iconTrue.png", "non" );
		}
		modele.ajoutArtiste( num, nom, membre, photo );
		artiste.getTabModel().addRow( row );
		artiste.getTabModel().fireTableRowsInserted( artiste.getTabModel().getRowCount() - 1,
				artiste.getTableArtistes().getModel().getRowCount() - 1 );
		artiste.getTableArtistes().setRowSelectionInterval( artiste.getTableArtistes().getModel().getRowCount() - 1,
				artiste.getTableArtistes().getModel().getRowCount() - 1 );
	}

	public void supprimerArtiste( GestionArtistes artiste ) {
		int selected = artiste.getTableArtistes().getSelectedRow();
		int num = Integer.parseInt( (String) artiste.getTableArtistes().getValueAt( selected, 0 ) );
		modele.deleteArtiste( num );
		// artiste.getTableArtistes().setModel( initialiserArtistes(
		// artiste.getTabModel() ) );
		artiste.getTabModel().removeRow( selected );
		artiste.getTabModel().fireTableDataChanged();
		artiste.getTabModel().fireTableRowsDeleted( selected, selected );
	}

	public void setArtisteCourrant( GestionArtistes artiste, Object[] row ) {
		setArtisteCourrant( artiste, row, obtenirAlbumsArtiste( Integer.parseInt( (String) row[0] ) ) );

	}

	public void modifierArtiste( GestionArtistes artiste ) {
		int num = Integer.parseInt( artiste.getTxtNumero().getText() );
		String nom = artiste.getTxtNom().getText();
		boolean membre = artiste.getMembre().isSelected();
		BufferedImage photo = artiste.getImageArtiste();
		Object[] row = { String.valueOf( num ), nom, membre };
		if ( (boolean) row[2] ) {
			row[2] = createImageIcon( "/ressources/iconTrue.png", "oui" );
		} else {
			row[2] = createImageIcon( "/ressources/iconFalse.png", "non" );
		}
		if ( !modele.modifierArtiste( num, nom, membre, photo ) ) {
			JOptionPane.showMessageDialog( artiste,
					"Erreur lors de la modification de l'artiste " + num + ".\nL'artiste n'existe pas", "Erreur",
					JOptionPane.OK_OPTION );
		}
		// TODO pull les nouveaux data de la base de données
		artiste.getTabModel().setValueAt( row[0], artiste.getTableArtistes().getSelectedRow(), 0 );
		artiste.getTabModel().setValueAt( row[1], artiste.getTableArtistes().getSelectedRow(), 1 );
		artiste.getTabModel().setValueAt( row[2], artiste.getTableArtistes().getSelectedRow(), 2 );
		artiste.getTabModel().fireTableDataChanged();
		artiste.getTabModel().fireTableRowsUpdated( 1, artiste.getTableArtistes().getRowCount() );
		// TODO updater les vues
	}

	public void setArtisteCourrant( GestionArtistes artiste, Object[] donneesArtiste,
			DefaultListModel<Album> albums ) {
		artiste.getTxtNumero().setText( (String) donneesArtiste[0] );
		artiste.getTxtNom().setText( (String) donneesArtiste[1] );
		artiste.getMembre().setSelected( (boolean) donneesArtiste[2] );
		if ( donneesArtiste[3] != null ) {
			artiste.getPanelArtiste().removeAll();
			artiste.getPanelArtiste().add( new JLabel( new ImageIcon( (Image) donneesArtiste[3] ) ) );
			artiste.getPanelArtiste().repaint();
		} else {
			artiste.getPanelArtiste().removeAll();
			artiste.getPanelArtiste().add( new JLabel( new ImageIcon( modele.resiseImage(
					Toolkit.getDefaultToolkit().getImage( Menu.class.getResource( "/ressources/default.jpg" ) ), 75,
					75 ) ) ) );
			artiste.getPanelArtiste().repaint();
		}
		artiste.getListAlbum().setModel( albums );
		artiste.getListAlbum().setSelectedIndex( 1 );
	}
}
