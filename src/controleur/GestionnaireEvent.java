package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modele.*;
import vue.Connexion;
import vue.GestionAlbums;
import vue.GestionArtistes;
import vue.Menu;

public class GestionnaireEvent implements ActionListener, DocumentListener {

	private JFrame frame = null;

	public GestionnaireEvent( JFrame frame ) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		if ( frame instanceof Connexion ) {
			Connexion conn = (Connexion) frame;
			if ( e.getSource() == conn.getBtnValider() ) {
				if ( false ) {
					// TODO faire la methode dans le modele pour vérifier le mdp
					// et username
				} else {
					JOptionPane.showMessageDialog( conn,
							"Le mot de passe ou le nom d'utilisateur entrés sont incorrects.", "Mauvais identifiants",
							JOptionPane.ERROR_MESSAGE );
				}

			} else if ( e.getSource() == conn.getBtnQuitter() ) {
				System.exit( 0 );
			}
		} else if ( frame instanceof Menu ) {
			Menu menu = (Menu) frame;
			if ( e.getSource() == menu.getBtnQuitter() ) {
				System.exit( 0 );
			}
			if ( e.getSource() == menu.getBtnArtistes() ) {
				menu.dispose();
				new GestionArtistes().setVisible( true );
			}
			if ( e.getSource() == menu.getBtnAlbums() ) {
				menu.dispose();
				new GestionAlbums().setVisible( true );
			}
		} else if ( frame instanceof GestionArtistes ) {
			GestionArtistes artistes = (GestionArtistes) frame;
			if ( e.getSource() == artistes.getBtnQuitter() ) {
				artistes.dispose();
				new Menu().setVisible( true );
			}
		} else if ( frame instanceof GestionAlbums ) {
			GestionAlbums album = (GestionAlbums) frame;
		}

	}

	@Override
	public void changedUpdate( DocumentEvent e ) {
		if ( frame instanceof Connexion ) {
			Connexion conn = (Connexion) frame;
			if ( e.getDocument() == conn.getTxtUser().getDocument() ) {

			} else if ( e.getDocument() == conn.getTxtMDP().getDocument() ) {
				// TODO event champ texte mot de passe
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
		// TODO Auto-generated method stub

	}

	@Override
	public void removeUpdate( DocumentEvent e ) {
		// TODO Auto-generated method stub

	}

}