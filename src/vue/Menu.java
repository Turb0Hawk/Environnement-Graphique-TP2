package vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.GestionnaireEvent;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Toolkit;

public class Menu extends JFrame{
	private static final long serialVersionUID = 4L;
	private GestionnaireEvent event;

	/**
	 * Launch the application.
	 */
	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					Menu window = new Menu();
					window.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the application.
	 */
	public Menu() {
		event = new GestionnaireEvent(this);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/Ressources/icon.png")));
		setBounds( 100, 100, 728, 541 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 245, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 79, 54, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		getContentPane().setLayout(gridBagLayout);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_1.gridx = 1;
		gbc_horizontalStrut_1.gridy = 1;
		getContentPane().add(horizontalStrut_1, gbc_horizontalStrut_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 0;
		gbc_horizontalStrut.gridy = 2;
		getContentPane().add(horizontalStrut, gbc_horizontalStrut);
		
		JPanel panelLogo = new JPanel();
		GridBagConstraints gbc_panelLogo = new GridBagConstraints();
		gbc_panelLogo.gridheight = 6;
		gbc_panelLogo.insets = new Insets(0, 0, 5, 5);
		gbc_panelLogo.fill = GridBagConstraints.BOTH;
		gbc_panelLogo.gridx = 2;
		gbc_panelLogo.gridy = 3;
		getContentPane().add(panelLogo, gbc_panelLogo);
		
		JButton btnAlbums = new JButton("Albums");
		btnAlbums.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAlbums = new GridBagConstraints();
		gbc_btnAlbums.gridwidth = 2;
		gbc_btnAlbums.fill = GridBagConstraints.BOTH;
		gbc_btnAlbums.insets = new Insets(0, 0, 5, 5);
		gbc_btnAlbums.gridx = 4;
		gbc_btnAlbums.gridy = 7;
		getContentPane().add(btnAlbums, gbc_btnAlbums);
		
		JLabel lblBienvenue = new JLabel("Bienvenue  \u00E0 la Gestion des albums");
		lblBienvenue.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		GridBagConstraints gbc_lblBienvenue = new GridBagConstraints();
		gbc_lblBienvenue.anchor = GridBagConstraints.WEST;
		gbc_lblBienvenue.gridwidth = 4;
		gbc_lblBienvenue.gridheight = 2;
		gbc_lblBienvenue.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenue.gridx = 2;
		gbc_lblBienvenue.gridy = 10;
		getContentPane().add(lblBienvenue, gbc_lblBienvenue);
		
		JButton btnArtistes = new JButton("Gestion des Artistes");
		btnArtistes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnArtistes = new GridBagConstraints();
		gbc_btnArtistes.gridwidth = 2;
		gbc_btnArtistes.insets = new Insets(0, 0, 5, 5);
		gbc_btnArtistes.fill = GridBagConstraints.BOTH;
		gbc_btnArtistes.gridx = 4;
		gbc_btnArtistes.gridy = 9;
		getContentPane().add(btnArtistes, gbc_btnArtistes);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.fill = GridBagConstraints.BOTH;
		gbc_btnQuitter.gridwidth = 5;
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 5);
		gbc_btnQuitter.gridx = 7;
		gbc_btnQuitter.gridy = 11;
		getContentPane().add(btnQuitter, gbc_btnQuitter);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_2 = new GridBagConstraints();
		gbc_horizontalStrut_2.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut_2.gridx = 12;
		gbc_horizontalStrut_2.gridy = 11;
		getContentPane().add(horizontalStrut_2, gbc_horizontalStrut_2);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut_3 = new GridBagConstraints();
		gbc_horizontalStrut_3.insets = new Insets(0, 0, 5, 0);
		gbc_horizontalStrut_3.gridx = 13;
		gbc_horizontalStrut_3.gridy = 11;
		getContentPane().add(horizontalStrut_3, gbc_horizontalStrut_3);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 0, 5);
		gbc_verticalStrut.gridx = 9;
		gbc_verticalStrut.gridy = 12;
		getContentPane().add(verticalStrut, gbc_verticalStrut);
	}

}
