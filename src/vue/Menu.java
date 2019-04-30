package vue;

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
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.Image;

public class Menu extends JFrame {
	private static final long serialVersionUID = 4L;
	private GestionnaireEvent event;
	private JButton btnAlbums;
	private JButton btnQuitter;
	private JButton btnArtistes;
	private JButton btnAide;

	/**
	 * Create the application.
	 */
	public Menu() {
		setResizable( false );
		setTitle( "Gestion des Albums" );
		event = new GestionnaireEvent( this );
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setIconImage( Toolkit.getDefaultToolkit().getImage( Menu.class.getResource( "/ressources/icon.png" ) ) );
		setBounds( 100, 100, 665, 384 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 245, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 30, 0, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		getContentPane().setLayout( gridBagLayout );

		Component horizontalStrut_1 = Box.createHorizontalStrut( 20 );
		GridBagConstraints gbc_horizontalStrut_1 = new GridBagConstraints();
		gbc_horizontalStrut_1.insets = new Insets( 0, 0, 5, 5 );
		gbc_horizontalStrut_1.gridx = 0;
		gbc_horizontalStrut_1.gridy = 0;
		getContentPane().add( horizontalStrut_1, gbc_horizontalStrut_1 );
		
		btnAide = new JButton("Aide en ligne");
		btnAide.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_btnAide = new GridBagConstraints();
		gbc_btnAide.insets = new Insets(0, 0, 0, 5);
		gbc_btnAide.gridx = 3;
		gbc_btnAide.gridy = 1;
		getContentPane().add(btnAide, gbc_btnAide);
		btnAide.addActionListener( event );

		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.insets = new Insets( 0, 15, 5, 30 );
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		JLabel reee = new JLabel( new ImageIcon(
				( Toolkit.getDefaultToolkit().getImage( Menu.class.getResource( "/Ressources/icon.png" ) ) )
						.getScaledInstance( 250, 250, Image.SCALE_SMOOTH ) ) );
		panel.add( reee );
		getContentPane().add( panel, gbc_panel );

		btnAlbums = new JButton( "Gestion des albums" );
		btnAlbums.setEnabled( false );
		btnAlbums.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		btnAlbums.addActionListener( event );
		GridBagConstraints gbc_btnAlbums = new GridBagConstraints();
		gbc_btnAlbums.fill = GridBagConstraints.BOTH;
		gbc_btnAlbums.insets = new Insets( 15, 0, 15, 5 );
		gbc_btnAlbums.gridx = 2;
		gbc_btnAlbums.gridy = 2;
		getContentPane().add( btnAlbums, gbc_btnAlbums );

		btnArtistes = new JButton( "Gestion des artistes" );
		btnArtistes.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		btnArtistes.addActionListener( event );
		GridBagConstraints gbc_btnArtistes = new GridBagConstraints();
		gbc_btnArtistes.insets = new Insets( 15, 0, 15, 5 );
		gbc_btnArtistes.fill = GridBagConstraints.BOTH;
		gbc_btnArtistes.gridx = 2;
		gbc_btnArtistes.gridy = 3;
		getContentPane().add( btnArtistes, gbc_btnArtistes );

		JLabel lblBienvenue = new JLabel( "Bienvenue \u00E0 la gestion des albums" );
		lblBienvenue.setFont( new Font( "Times New Roman", Font.PLAIN, 30 ) );
		GridBagConstraints gbc_lblBienvenue = new GridBagConstraints();
		gbc_lblBienvenue.anchor = GridBagConstraints.WEST;
		gbc_lblBienvenue.gridwidth = 2;
		gbc_lblBienvenue.insets = new Insets( 0, 0, 0, 5 );
		gbc_lblBienvenue.gridx = 1;
		gbc_lblBienvenue.gridy = 5;
		getContentPane().add( lblBienvenue, gbc_lblBienvenue );

		btnQuitter = new JButton( "Quitter" );
		btnQuitter.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		btnQuitter.addActionListener( event );
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.anchor = GridBagConstraints.SOUTH;
		gbc_btnQuitter.insets = new Insets( 5, 5, 10, 10 );
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.gridx = 3;
		gbc_btnQuitter.gridy = 5;
		getContentPane().add( btnQuitter, gbc_btnQuitter );
	}

	public JButton getBtnAlbums() {
		return btnAlbums;
	}

	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	public JButton getBtnArtistes() {
		return btnArtistes;
	}
	
	public JButton getBtnAide() {
		return btnAide;
	}
}
