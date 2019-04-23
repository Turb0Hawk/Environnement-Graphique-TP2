package controleur;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import vue.Connexion;

public class GestionnaireEvent implements ActionListener, DocumentListener {

	private Connexion pageConn;

	public GestionnaireEvent( JFrame frame ) {
		pageConn = (Connexion) frame;
	}

	@Override
	public void actionPerformed( ActionEvent e ) {
		if ( e.getSource() == pageConn.getBtnValider() ) {
			if ( false ) {
				// TODO faire la methode dans le modele pour vérifier  le mdp et username
			} else {
				JOptionPane.showMessageDialog( pageConn,
						"Le mot de passe ou le nom d'utilisateur entrés sont incorrects.", "Mauvais identifiants",
						JOptionPane.ERROR_MESSAGE );
			}
			
		} else if ( e.getSource() == pageConn.getBtnQuitter() ) {
			System.exit( 0 );
		}

	}

	@Override
	public void changedUpdate( DocumentEvent e ) {
		if ( e.getDocument() == pageConn.getTxtUser().getDocument() ) {

		} else if ( e.getDocument() == pageConn.getTxtMDP().getDocument() ) {
			// TODO event champ texte mot de passe
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