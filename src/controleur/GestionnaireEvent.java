package controleur;

import java.awt.Desktop;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modele.*;
import sun.awt.image.ToolkitImage;
import vue.*;

public class GestionnaireEvent implements ActionListener, DocumentListener, MouseListener {

	private JFrame frame;
	private Controleur control = new Controleur();
	private ConnexionDB modele = new ConnexionDB();

	public GestionnaireEvent( JFrame frame ) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed( ActionEvent e ) {

		if ( frame instanceof Connexion ) {
			Connexion conn = (Connexion) frame;
			if ( e.getSource() == conn.getBtnValider() ) {
				if ( ConnexionApp.verificationConn( conn.getTxtUser().getText(), conn.getTxtMDP().getText() ) ) {

					switch ( JOptionPane.showConfirmDialog( conn, "Bienvenue, " + conn.getTxtUser().getText() + "!",
							"Connexion � l'application", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE ) ) {
					case JOptionPane.YES_OPTION:

						frame.dispose();
						new Menu().setVisible( true );
						break;

					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog( conn,
							"Le mot de passe ou le nom d'utilisateur entr�s sont incorrects.",
							"Mauvais identifiants", JOptionPane.ERROR_MESSAGE );
				}

			} else if ( e.getSource() == conn.getBtnQuitter() ) {
				System.exit( 0 );

			} else if ( e.getSource() == conn.getBtnAide() ) {

				try {
					File fileAide = new File( Paths.get( "./src/ressources/aide.chm" ).toString() );
					Desktop.getDesktop().open( fileAide );

				} catch ( IOException msg ) {
					System.out.println( msg );

				}

			}
		} else if ( frame instanceof Menu ) {
			Menu menu = (Menu) frame;
			if ( e.getSource() == menu.getBtnQuitter() ) {
				System.exit( 0 );
			} else if ( e.getSource() == menu.getBtnArtistes() ) {
				menu.dispose();
				new GestionArtistes().setVisible( true );
			} else if ( e.getSource() == menu.getBtnAlbums() ) {
				menu.dispose();
				new GestionAlbums().setVisible( true );
			} else if ( e.getSource() == menu.getBtnAide() ) {

				try {
					File fileAide = new File( Paths.get( "./src/ressources/aide.chm" ).toString() );
					Desktop.getDesktop().open( fileAide );

				} catch ( IOException msg ) {
					System.out.println( msg );

				}
			}
		} else if ( frame instanceof GestionArtistes ) {
			GestionArtistes artiste = (GestionArtistes) frame;
			if ( e.getSource() == artiste.getBtnQuitter() ) {
				artiste.dispose();
				new Menu().setVisible( true );
			} else if ( e.getSource() == artiste.getBtnAide() ) {

				try {
					File fileAide = new File( Paths.get( "./src/ressources/aide.chm" ).toString() );
					Desktop.getDesktop().open( fileAide );

				} catch ( IOException msg ) {
					System.out.println( msg );

				}
			} else if ( e.getSource() == artiste.getBtnNouveau() ) {
				artiste.nouvelArtiste( artiste.getTabModel().getRowCount() + 1 );
			} else if ( e.getSource() == artiste.getBtnRemplacer() ) {
				modele.remplacerImage( control.obtenirImage( artiste ), artiste );
				artiste.getPanelArtiste().repaint();
			} else if ( e.getSource() == artiste.getBtnRecherche() ) {
				artiste.getTableArtistes().setModel( control.ajouterImageMembre( modele
						.obtenirArtistesRecherche( artiste.getTxtArtiste().getText(), artiste.getTabModel() ) ) );
			}
		} else if ( frame instanceof GestionAlbums ) {

			GestionAlbums album = (GestionAlbums) frame;

			if ( e.getSource() == album.getBtnAide() ) {

				try {
					File fileAide = new File( Paths.get( "./src/ressources/aide.chm" ).toString() );
					Desktop.getDesktop().open( fileAide );

				} catch ( IOException msg ) {
					System.out.println( msg );

				}
			}
		}
	}

	@Override
	public void changedUpdate( DocumentEvent e ) {
		if ( frame instanceof Connexion ) {
			Connexion conn = (Connexion) frame;
			if ( e.getDocument() == conn.getTxtUser().getDocument() ) {
				if ( conn.getTxtUser().getText().isEmpty() || conn.getTxtMDP().getText().isEmpty() ) {
					conn.getBtnValider().setEnabled( false );
				} else {
					conn.getBtnValider().setEnabled( true );
				}

			} else if ( e.getDocument() == conn.getTxtMDP().getDocument() ) {
				if ( conn.getTxtMDP().getText().isEmpty() || conn.getTxtUser().getText().isEmpty() ) {
					conn.getBtnValider().setEnabled( false );
				} else {
					conn.getBtnValider().setEnabled( true );
				}
			}
		} else if ( frame instanceof Menu ) {
			Menu menu = (Menu) frame;

		} else if ( frame instanceof GestionArtistes ) {
			GestionArtistes artistes = (GestionArtistes) frame;

		} else if ( frame instanceof GestionAlbums ) {
			GestionAlbums album = (GestionAlbums) frame;

		}
	}

	@Override
	public void insertUpdate( DocumentEvent e ) {
		changedUpdate( e );

	}

	@Override
	public void removeUpdate( DocumentEvent e ) {
		changedUpdate( e );

	}

	@Override
	public void mouseClicked( MouseEvent e ) {
		if ( frame instanceof GestionArtistes ) {
			GestionArtistes artistes = (GestionArtistes) frame;
			if ( e.getSource() == artistes.getTableArtistes() ) {
				Object[] row = control.obtenirUnArtiste( Integer.parseInt( (String) artistes.getTabModel()
						.getValueAt( artistes.getTableArtistes().getSelectedRow(), 0 ) ) );
				artistes.setArtisteCourrant( row );
			} else if ( e.getSource() == artistes.getListAlbum() ) {
				Image img = artistes.getListAlbum().getSelectedValue().getImg();
				if ( img != null ) {
					artistes.setAlbumCourrant( modele.resiseImage( img, 35, 35 ) );
				}
				artistes.getPanelAlbum().repaint();
				// TODO fix le wierd bug de loading d'image
			}
		} else if ( frame instanceof GestionAlbums ) {
			GestionAlbums album = (GestionAlbums) frame;
		}
	}

	@Override
	public void mouseEntered( MouseEvent e ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited( MouseEvent e ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed( MouseEvent e ) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased( MouseEvent e ) {
		// TODO Auto-generated method stub

	}

}