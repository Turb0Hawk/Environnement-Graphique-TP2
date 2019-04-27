package controleur;

import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modele.*;
import vue.*;

public class GestionnaireEvent implements ActionListener, DocumentListener {

	private JFrame frame;

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
							"Connexion à l'application", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE ) ) {
					case JOptionPane.YES_OPTION:

						frame.dispose();
						new Menu().setVisible( true );
						break;

					default:
						break;
					}
				} else {
					JOptionPane.showMessageDialog( conn,
							"Le mot de passe ou le nom d'utilisateur entrés sont incorrects.", "Mauvais identifiants",
							JOptionPane.ERROR_MESSAGE );
				}

			} else if ( e.getSource() == conn.getBtnQuitter() ) {
				System.exit( 0 );

			} else if ( e.getSource() == conn.getBtnAide() ) {

				try {
					File fileAide = new File( Paths.get( "./src/ressources/aide.chm" ).toString() ); //TODO finir le fichier d'aide (placeholder)
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

}