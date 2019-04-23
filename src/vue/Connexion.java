package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Toolkit;

public class Connexion {

	private JFrame frmGestionDesAlbums;
	private JTextField txtUser;
	private JTextField txtMDP;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					Connexion window = new Connexion();
					window.frmGestionDesAlbums.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGestionDesAlbums = new JFrame();
		frmGestionDesAlbums.setIconImage(Toolkit.getDefaultToolkit().getImage(Connexion.class.getResource("/Ressources/icon.png")));
		frmGestionDesAlbums.setResizable(false);
		frmGestionDesAlbums.setTitle("Gestion des Albums");
		frmGestionDesAlbums.setBounds( 100, 100, 424, 218 );
		frmGestionDesAlbums.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
		JPanel panel = new JPanel();
		frmGestionDesAlbums.getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 44, 49, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblConnexion = new JLabel("Connexion \u00E0 l'application");
		lblConnexion.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		GridBagConstraints gbc_lblConnexion = new GridBagConstraints();
		gbc_lblConnexion.anchor = GridBagConstraints.WEST;
		gbc_lblConnexion.insets = new Insets(25, 25, 5, 0);
		gbc_lblConnexion.gridwidth = 5;
		gbc_lblConnexion.gridx = 0;
		gbc_lblConnexion.gridy = 0;
		panel.add(lblConnexion, gbc_lblConnexion);
		
		JLabel lblNomDutilisateur = new JLabel("Nom d'utilisateur");
		lblNomDutilisateur.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNomDutilisateur = new GridBagConstraints();
		gbc_lblNomDutilisateur.insets = new Insets(0, 0, 0, 5);
		gbc_lblNomDutilisateur.anchor = GridBagConstraints.EAST;
		gbc_lblNomDutilisateur.gridx = 2;
		gbc_lblNomDutilisateur.gridy = 1;
		panel.add(lblNomDutilisateur, gbc_lblNomDutilisateur);
		
		txtUser = new JTextField();
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_txtUser = new GridBagConstraints();
		gbc_txtUser.gridwidth = 2;
		gbc_txtUser.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUser.insets = new Insets(10, 5, 5, 50);
		gbc_txtUser.gridx = 3;
		gbc_txtUser.gridy = 1;
		panel.add(txtUser, gbc_txtUser);
		txtUser.setColumns(10);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMotDePasse = new GridBagConstraints();
		gbc_lblMotDePasse.insets = new Insets(0, 0, 0, 5);
		gbc_lblMotDePasse.anchor = GridBagConstraints.WEST;
		gbc_lblMotDePasse.gridx = 2;
		gbc_lblMotDePasse.gridy = 2;
		panel.add(lblMotDePasse, gbc_lblMotDePasse);
		
		txtMDP = new JTextField();
		txtMDP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		txtMDP.setColumns(10);
		GridBagConstraints gbc_txtMDP = new GridBagConstraints();
		gbc_txtMDP.gridwidth = 2;
		gbc_txtMDP.insets = new Insets(0, 5, 0, 50);
		gbc_txtMDP.fill = GridBagConstraints.BOTH;
		gbc_txtMDP.gridx = 3;
		gbc_txtMDP.gridy = 2;
		panel.add(txtMDP, gbc_txtMDP);
		
		JPanel panel_1 = new JPanel();
		frmGestionDesAlbums.getContentPane().add(panel_1, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JButton btnValider = new JButton("Valider");
		btnValider.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_btnValider = new GridBagConstraints();
		gbc_btnValider.anchor = GridBagConstraints.EAST;
		gbc_btnValider.insets = new Insets(10, 0, 15, 5);
		gbc_btnValider.gridx = 0;
		gbc_btnValider.gridy = 0;
		panel_1.add(btnValider, gbc_btnValider);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.insets = new Insets(10, 5, 15, 0);
		gbc_btnQuitter.anchor = GridBagConstraints.WEST;
		gbc_btnQuitter.gridx = 1;
		gbc_btnQuitter.gridy = 0;
		panel_1.add(btnQuitter, gbc_btnQuitter);
	}

}
