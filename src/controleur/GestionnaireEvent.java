package controleur;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import modele.*;
import vue.Connexion;
import vue.GestionAlbums;
import vue.GestionArtistes;
import vue.Menu;

public class GestionnaireEvent implements ActionListener, DocumentListener, MouseListener {

	private JFrame frame = null;
	private Controleur control = new Controleur();

	public GestionnaireEvent( JFrame frame ) {
		this.frame = frame;
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		if ( frame instanceof Connexion ) {
			Connexion conn = (Connexion) frame;
			if ( e.getSource() == conn.getBtnValider() ) {
				if ( true ) { // TODO changer la condition

					switch ( JOptionPane.showConfirmDialog( conn, "Bienvenue, " + conn.getTxtUser().getText() + "!",
							"Connexion à l'application", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE ) ) {
					case JOptionPane.OK_OPTION:
						conn.setVisible( false );
						conn.dispose();
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
			if(e.getSource() == artistes.getBtnNouveau()) {
				artistes.nouvelArtiste(artistes.getTableArtistes().getRowCount()+1);
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
				Object[] row = control.obtenirUnArtiste( artistes.getTableArtistes().getSelectedRow()+1 );
				artistes.setArtisteCourrant( row );
			}
			if ( e.getSource() == artistes.getListAlbum() ) {
				ImageIcon img = control.obtenirUnAlbum( artistes.getListAlbum().getSelectedIndex()+1 );
				artistes.setAlbumCourrant( img );
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