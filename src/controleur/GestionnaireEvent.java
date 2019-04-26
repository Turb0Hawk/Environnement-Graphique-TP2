package controleur;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

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
							"Le mot de passe ou le nom d'utilisateur entr�s sont incorrects.", "Mauvais identifiants",
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
			if(e.getSource() == artistes.getBtnRemplacer()) {
				modele.remplacerImage(new ImageIcon(control.obtenirImage(artistes)), artistes);
				artistes.getPanelArtiste().repaint();
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
				Image img = control.obtenirUnAlbum( artistes.getListAlbum().getSelectedIndex()+1 );
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