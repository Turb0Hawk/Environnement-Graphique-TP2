package vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.GestionnaireEvent;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class GestionAlbums extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtAlbum;
	private JTable tableAlbums;
	private JTextField txtNumero;
	private JTextField txtTitre;
	private JTextField txtAnnee;
	private JButton btnRecherche;
	private JButton btnQuitter;
	private JButton btnNouveau;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnRemplacer;
	private JButton btnSupprimer;
	private JButton btnAide;
	private GestionnaireEvent event;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public GestionAlbums() {
		event = new GestionnaireEvent( this );
		setTitle( "Gestion des Albums" );
		setResizable( false );
		setIconImage(
				Toolkit.getDefaultToolkit().getImage( GestionArtistes.class.getResource( "/Ressources/icon.png" ) ) );
		setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 613, 463 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );
		setContentPane( contentPane );

		JPanel panel = new JPanel();
		contentPane.add( panel, BorderLayout.CENTER );
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 89, 50, 0, 75, 79, 71, 50, 0, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, Double.MIN_VALUE };
		panel.setLayout( gbl_panel );

		btnAide = new JButton( "Aide en ligne" );
		btnAide.setFont( new Font( "Times New Roman", Font.PLAIN, 11 ) );
		GridBagConstraints gbc_btnAide = new GridBagConstraints();
		gbc_btnAide.insets = new Insets( 5, 0, 0, 0 );
		gbc_btnAide.gridx = 7;
		gbc_btnAide.gridy = 0;
		panel.add( btnAide, gbc_btnAide );

		JLabel lblRechercherUnAlbum = new JLabel( "Rechercher un album" );
		lblRechercherUnAlbum.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblRechercherUnAlbum = new GridBagConstraints();
		gbc_lblRechercherUnAlbum.anchor = GridBagConstraints.WEST;
		gbc_lblRechercherUnAlbum.gridwidth = 3;
		gbc_lblRechercherUnAlbum.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblRechercherUnAlbum.gridx = 0;
		gbc_lblRechercherUnAlbum.gridy = 1;
		panel.add( lblRechercherUnAlbum, gbc_lblRechercherUnAlbum );

		txtAlbum = new JTextField();
		txtAlbum.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_txtAlbum = new GridBagConstraints();
		gbc_txtAlbum.gridwidth = 5;
		gbc_txtAlbum.insets = new Insets( 0, 25, 5, 5 );
		gbc_txtAlbum.fill = GridBagConstraints.BOTH;
		gbc_txtAlbum.gridx = 0;
		gbc_txtAlbum.gridy = 2;
		panel.add( txtAlbum, gbc_txtAlbum );
		txtAlbum.setColumns( 10 );

		btnRecherche = new JButton( "Recherche" );
		btnRecherche.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnRecherche.gridx = 5;
		gbc_btnRecherche.gridy = 2;
		panel.add( btnRecherche, gbc_btnRecherche );

		JButton btnQuitter = new JButton( "Retour" );
		btnQuitter.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnQuitter.gridx = 7;
		gbc_btnQuitter.gridy = 2;
		panel.add( btnQuitter, gbc_btnQuitter );

		JLabel lblAlbums = new JLabel( "Albums" );
		lblAlbums.setFont( new Font( "Times New Roman", Font.PLAIN, 20 ) );
		GridBagConstraints gbc_lblAlbums = new GridBagConstraints();
		gbc_lblAlbums.gridwidth = 3;
		gbc_lblAlbums.anchor = GridBagConstraints.WEST;
		gbc_lblAlbums.insets = new Insets( 0, 25, 10, 5 );
		gbc_lblAlbums.gridx = 0;
		gbc_lblAlbums.gridy = 3;
		panel.add( lblAlbums, gbc_lblAlbums );

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets( 0, 25, 5, 25 );
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add( panel_1, gbc_panel_1 );

		tableAlbums = new JTable();
		tableAlbums.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_tableAlbums = new GridBagConstraints();
		gbc_tableAlbums.gridheight = 4;
		gbc_tableAlbums.gridwidth = 5;
		gbc_tableAlbums.insets = new Insets( 0, 0, 5, 25 );
		gbc_tableAlbums.fill = GridBagConstraints.BOTH;
		gbc_tableAlbums.gridx = 2;
		gbc_tableAlbums.gridy = 4;
		panel.add( tableAlbums, gbc_tableAlbums );

		btnNouveau = new JButton( "Nouveau" );
		btnNouveau.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnNouveau = new GridBagConstraints();
		gbc_btnNouveau.fill = GridBagConstraints.BOTH;
		gbc_btnNouveau.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnNouveau.gridx = 7;
		gbc_btnNouveau.gridy = 4;
		panel.add( btnNouveau, gbc_btnNouveau );

		btnAjouter = new JButton( "Ajouter" );
		btnAjouter.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnAjouter.gridx = 7;
		gbc_btnAjouter.gridy = 5;
		panel.add( btnAjouter, gbc_btnAjouter );

		btnModifier = new JButton( "Modifier" );
		btnModifier.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnModifier.gridx = 7;
		gbc_btnModifier.gridy = 6;
		panel.add( btnModifier, gbc_btnModifier );

		btnRemplacer = new JButton( "Remplacer" );
		btnRemplacer.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnRemplacer = new GridBagConstraints();
		gbc_btnRemplacer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRemplacer.gridwidth = 2;
		gbc_btnRemplacer.insets = new Insets( 0, 25, 5, 25 );
		gbc_btnRemplacer.gridx = 0;
		gbc_btnRemplacer.gridy = 7;
		panel.add( btnRemplacer, gbc_btnRemplacer );

		btnSupprimer = new JButton( "Supprimer" );
		btnSupprimer.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnSupprimer.gridx = 7;
		gbc_btnSupprimer.gridy = 7;
		panel.add( btnSupprimer, gbc_btnSupprimer );

		JLabel lblInformations = new JLabel( "Informations" );
		lblInformations.setFont( new Font( "Times New Roman", Font.PLAIN, 20 ) );
		GridBagConstraints gbc_lblInformations = new GridBagConstraints();
		gbc_lblInformations.gridwidth = 3;
		gbc_lblInformations.anchor = GridBagConstraints.WEST;
		gbc_lblInformations.insets = new Insets( 0, 25, 10, 5 );
		gbc_lblInformations.gridx = 0;
		gbc_lblInformations.gridy = 8;
		panel.add( lblInformations, gbc_lblInformations );

		JLabel lblNumero = new JLabel( "Num\u00E9ro" );
		lblNumero.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.WEST;
		gbc_lblNumero.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblNumero.gridx = 0;
		gbc_lblNumero.gridy = 9;
		panel.add( lblNumero, gbc_lblNumero );

		txtNumero = new JTextField();
		txtNumero.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.gridwidth = 3;
		gbc_txtNumero.insets = new Insets( 0, 0, 5, 10 );
		gbc_txtNumero.fill = GridBagConstraints.BOTH;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 9;
		panel.add( txtNumero, gbc_txtNumero );
		txtNumero.setColumns( 10 );

		JList listAlbums = new JList();
		listAlbums.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_listAlbums = new GridBagConstraints();
		gbc_listAlbums.gridwidth = 2;
		gbc_listAlbums.gridheight = 6;
		gbc_listAlbums.insets = new Insets( 0, 0, 25, 5 );
		gbc_listAlbums.fill = GridBagConstraints.BOTH;
		gbc_listAlbums.gridx = 4;
		gbc_listAlbums.gridy = 9;
		panel.add( listAlbums, gbc_listAlbums );

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 4;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets( 0, 5, 5, 10 );
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 6;
		gbc_panel_2.gridy = 9;
		panel.add( panel_2, gbc_panel_2 );

		JLabel lblTitre = new JLabel( "Titre" );
		lblTitre.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblTitre = new GridBagConstraints();
		gbc_lblTitre.anchor = GridBagConstraints.WEST;
		gbc_lblTitre.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblTitre.gridx = 0;
		gbc_lblTitre.gridy = 10;
		panel.add( lblTitre, gbc_lblTitre );

		txtTitre = new JTextField();
		txtTitre.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_txtTitre = new GridBagConstraints();
		gbc_txtTitre.gridwidth = 3;
		gbc_txtTitre.insets = new Insets( 0, 0, 5, 10 );
		gbc_txtTitre.fill = GridBagConstraints.BOTH;
		gbc_txtTitre.gridx = 1;
		gbc_txtTitre.gridy = 10;
		panel.add( txtTitre, gbc_txtTitre );
		txtTitre.setColumns( 10 );

		JLabel lblGenre = new JLabel( "Genre" );
		lblGenre.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblGenre = new GridBagConstraints();
		gbc_lblGenre.anchor = GridBagConstraints.WEST;
		gbc_lblGenre.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblGenre.gridx = 0;
		gbc_lblGenre.gridy = 11;
		panel.add( lblGenre, gbc_lblGenre );

		JComboBox comboBoxGenre = new JComboBox();
		comboBoxGenre.setModel(
				new DefaultComboBoxModel( new String[] { "Folk", "Jazz", "Classique", "Alternatif", "Rock" } ) );
		comboBoxGenre.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_comboBoxGenre = new GridBagConstraints();
		gbc_comboBoxGenre.gridwidth = 3;
		gbc_comboBoxGenre.insets = new Insets( 0, 0, 5, 10 );
		gbc_comboBoxGenre.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxGenre.gridx = 1;
		gbc_comboBoxGenre.gridy = 11;
		panel.add( comboBoxGenre, gbc_comboBoxGenre );

		JLabel lblArtistePrinc = new JLabel( "Artiste princ." );
		lblArtistePrinc.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblArtistePrinc = new GridBagConstraints();
		gbc_lblArtistePrinc.anchor = GridBagConstraints.EAST;
		gbc_lblArtistePrinc.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblArtistePrinc.gridx = 0;
		gbc_lblArtistePrinc.gridy = 12;
		panel.add( lblArtistePrinc, gbc_lblArtistePrinc );

		JComboBox<?> comboBoxArtistePrinc = new JComboBox<>();
		comboBoxArtistePrinc.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_comboBoxArtistePrinc = new GridBagConstraints();
		gbc_comboBoxArtistePrinc.gridwidth = 3;
		gbc_comboBoxArtistePrinc.insets = new Insets( 0, 0, 5, 10 );
		gbc_comboBoxArtistePrinc.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxArtistePrinc.gridx = 1;
		gbc_comboBoxArtistePrinc.gridy = 12;
		panel.add( comboBoxArtistePrinc, gbc_comboBoxArtistePrinc );

		JLabel lblAnnee = new JLabel( "Ann\u00E9e" );
		lblAnnee.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblAnnee = new GridBagConstraints();
		gbc_lblAnnee.anchor = GridBagConstraints.WEST;
		gbc_lblAnnee.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblAnnee.gridx = 0;
		gbc_lblAnnee.gridy = 13;
		panel.add( lblAnnee, gbc_lblAnnee );

		txtAnnee = new JTextField();
		txtAnnee.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_txtAnnee = new GridBagConstraints();
		gbc_txtAnnee.gridwidth = 2;
		gbc_txtAnnee.insets = new Insets( 0, 0, 5, 10 );
		gbc_txtAnnee.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAnnee.gridx = 1;
		gbc_txtAnnee.gridy = 13;
		panel.add( txtAnnee, gbc_txtAnnee );
		txtAnnee.setColumns( 10 );

		btnAjouter.addActionListener( event );
		btnModifier.addActionListener( event );
		btnNouveau.addActionListener( event );
		btnQuitter.addActionListener( event );
		btnRecherche.addActionListener( event );
		btnRemplacer.addActionListener( event );
		btnSupprimer.addActionListener( event );
	}

	public JButton getBtnRecherche() {
		return btnRecherche;
	}

	public JButton getBtnQuitter() {
		return btnQuitter;
	}

	public JButton getBtnNouveau() {
		return btnNouveau;
	}

	public JButton getBtnAjouter() {
		return btnAjouter;
	}

	public JButton getBtnModifier() {
		return btnModifier;
	}

	public JButton getBtnRemplacer() {
		return btnRemplacer;
	}

	public JButton getBtnSupprimer() {
		return btnSupprimer;
	}

	public JButton getBtnAide() {
		return btnAide;
	}

}
