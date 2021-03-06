package vue;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import controleur.*;
import modele.Album;
import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.image.BufferedImage;
import javax.swing.ListSelectionModel;

public class GestionArtistes extends JFrame {

	private static final long serialVersionUID = 2L;
	private JPanel contentPane;
	private JTextField txtArtiste;
	private JTable tableArtistes;
	private JTextField txtNumero;
	private JTextField txtNom;
	private JButton btnRecherche;
	private JButton btnQuitter;
	private JButton btnNouveau;
	private JButton btnAjouter;
	private JButton btnModifier;
	private JButton btnRemplacer;
	private JButton btnSupprimer;
	private JButton btnAide;
	private GestionnaireEvent event;
	private DefaultTableModel tabArtiste;
	private JScrollPane scrollPane;
	private JCheckBox chckbxMembre;
	private JPanel panel_1;
	private JList<Album> listArtiste;
	private DefaultListModel<Album> tabAlbums;
	private JPanel panel_2;
	private BufferedImage imgArtiste = null;

	/**
	 * Create the frame.
	 */
	public GestionArtistes() {
		event = new GestionnaireEvent( this );
		setTitle( "Gestion des Albums" );
		setResizable( false );
		setIconImage(
				Toolkit.getDefaultToolkit().getImage( GestionArtistes.class.getResource( "/Ressources/icon.png" ) ) );
		setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 723, 485 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );
		setContentPane( contentPane );

		JPanel panel = new JPanel();
		contentPane.add( panel, BorderLayout.CENTER );
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 82, 98, 0, 79, 71, 64, 81, 0 };
		gbl_panel.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel.setLayout( gbl_panel );
		
		btnAide = new JButton("Aide en ligne");
		btnAide.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(5, 0, 0, 5);
		gbc_button.gridx = 6;
		gbc_button.gridy = 0;
		panel.add(btnAide, gbc_button);
		btnAide.addActionListener( event );

		JLabel lblRechercherUnArtiste = new JLabel( "Rechercher un artiste" );
		lblRechercherUnArtiste.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblRechercherUnArtiste = new GridBagConstraints();
		gbc_lblRechercherUnArtiste.anchor = GridBagConstraints.WEST;
		gbc_lblRechercherUnArtiste.gridwidth = 5;
		gbc_lblRechercherUnArtiste.insets = new Insets(0, 25, 5, 5);
		gbc_lblRechercherUnArtiste.gridx = 0;
		gbc_lblRechercherUnArtiste.gridy = 1;
		panel.add( lblRechercherUnArtiste, gbc_lblRechercherUnArtiste );

		txtArtiste = new JTextField();
		txtArtiste.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_txtArtiste = new GridBagConstraints();
		gbc_txtArtiste.gridwidth = 4;
		gbc_txtArtiste.insets = new Insets( 0, 25, 5, 5 );
		gbc_txtArtiste.fill = GridBagConstraints.BOTH;
		gbc_txtArtiste.gridx = 0;
		gbc_txtArtiste.gridy = 2;
		panel.add( txtArtiste, gbc_txtArtiste );
		txtArtiste.setColumns( 10 );

		btnRecherche = new JButton( "Recherche" );
		btnRecherche.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.insets = new Insets( 0, 0, 5, 5 );
		gbc_btnRecherche.gridx = 4;
		gbc_btnRecherche.gridy = 2;
		panel.add( btnRecherche, gbc_btnRecherche );
		btnQuitter = new JButton( "Retour" );
		btnQuitter.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnQuitter.gridx = 6;
		gbc_btnQuitter.gridy = 2;
		panel.add( btnQuitter, gbc_btnQuitter );

		JLabel lblArtistes = new JLabel( "Artistes" );
		lblArtistes.setFont( new Font( "Times New Roman", Font.PLAIN, 20 ) );
		GridBagConstraints gbc_lblArtistes = new GridBagConstraints();
		gbc_lblArtistes.gridwidth = 3;
		gbc_lblArtistes.anchor = GridBagConstraints.WEST;
		gbc_lblArtistes.insets = new Insets( 0, 25, 10, 5 );
		gbc_lblArtistes.gridx = 0;
		gbc_lblArtistes.gridy = 3;
		panel.add( lblArtistes, gbc_lblArtistes );

		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridheight = 3;
		gbc_panel_1.gridwidth = 2;
		gbc_panel_1.insets = new Insets(0, 25, 5, 5);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 4;
		panel.add( panel_1, gbc_panel_1 );

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridheight = 4;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets( 0, 0, 5, 5 );
		gbc_scrollPane.gridx = 2;
		gbc_scrollPane.gridy = 4;
		panel.add( scrollPane, gbc_scrollPane );
		tabArtiste = event.initialiserArtistes( tabArtiste );
		tableArtistes = new JTable( tabArtiste ) {
			private static final long serialVersionUID = 1L;

			public Class<?> getColumnClass( int column ) {
				return ( column == 2 ) ? ImageIcon.class : Object.class;
			}
		};
		tableArtistes.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableArtistes.addMouseListener( event );
		scrollPane.setViewportView( tableArtistes );
		tableArtistes.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );

		btnNouveau = new JButton( "Nouveau" );
		btnNouveau.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnNouveau = new GridBagConstraints();
		gbc_btnNouveau.fill = GridBagConstraints.BOTH;
		gbc_btnNouveau.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnNouveau.gridx = 6;
		gbc_btnNouveau.gridy = 4;
		panel.add( btnNouveau, gbc_btnNouveau );

		btnAjouter = new JButton( "Ajouter" );
		btnAjouter.setEnabled(false);
		btnAjouter.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnAjouter.gridx = 6;
		gbc_btnAjouter.gridy = 5;
		panel.add( btnAjouter, gbc_btnAjouter );

		btnModifier = new JButton( "Modifier" );
		btnModifier.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.insets = new Insets( 0, 0, 5, 10 );
		gbc_btnModifier.gridx = 6;
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
		gbc_btnSupprimer.gridx = 6;
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
		gbc_txtNumero.gridwidth = 2;
		gbc_txtNumero.insets = new Insets( 0, 0, 5, 10 );
		gbc_txtNumero.fill = GridBagConstraints.BOTH;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 9;
		panel.add( txtNumero, gbc_txtNumero );
		txtNumero.setColumns( 10 );
		txtNumero.getDocument().addDocumentListener( event );

		listArtiste = new JList<Album>();
		listArtiste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listArtiste.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		listArtiste.addMouseListener( event );
		GridBagConstraints gbc_listArtiste = new GridBagConstraints();
		gbc_listArtiste.gridwidth = 2;
		gbc_listArtiste.gridheight = 3;
		gbc_listArtiste.insets = new Insets( 0, 0, 25, 5 );
		gbc_listArtiste.fill = GridBagConstraints.BOTH;
		gbc_listArtiste.gridx = 3;
		gbc_listArtiste.gridy = 9;
		panel.add( listArtiste, gbc_listArtiste );

		panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 3;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets( 0, 5, 25, 10 );
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 5;
		gbc_panel_2.gridy = 9;
		panel.add( panel_2, gbc_panel_2 );

		JLabel lblNom = new JLabel( "Nom" );
		lblNom.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets( 0, 25, 5, 5 );
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 10;
		panel.add( lblNom, gbc_lblNom );

		txtNom = new JTextField();
		txtNom.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 2;
		gbc_txtNom.insets = new Insets( 0, 0, 5, 10 );
		gbc_txtNom.fill = GridBagConstraints.BOTH;
		gbc_txtNom.gridx = 1;
		gbc_txtNom.gridy = 10;
		panel.add( txtNom, gbc_txtNom );
		txtNom.setColumns( 10 );

		JLabel lblMembre = new JLabel( "Membre" );
		lblMembre.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_lblMembre = new GridBagConstraints();
		gbc_lblMembre.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMembre.insets = new Insets( 4, 25, 25, 5 );
		gbc_lblMembre.gridx = 0;
		gbc_lblMembre.gridy = 11;
		panel.add( lblMembre, gbc_lblMembre );

		chckbxMembre = new JCheckBox( "" );
		chckbxMembre.setFont( new Font( "Times New Roman", Font.PLAIN, 14 ) );
		GridBagConstraints gbc_chckbxMembre = new GridBagConstraints();
		gbc_chckbxMembre.fill = GridBagConstraints.HORIZONTAL;
		gbc_chckbxMembre.anchor = GridBagConstraints.NORTH;
		gbc_chckbxMembre.insets = new Insets( 3, 0, 25, 10 );
		gbc_chckbxMembre.gridx = 1;
		gbc_chckbxMembre.gridy = 11;
		panel.add( chckbxMembre, gbc_chckbxMembre );

		btnAjouter.addActionListener( event );
		btnModifier.addActionListener( event );
		btnNouveau.addActionListener( event );
		btnQuitter.addActionListener( event );
		btnRecherche.addActionListener( event );
		btnRemplacer.addActionListener( event );
		btnSupprimer.addActionListener( event );
	}

	

	public void setAlbumCourrant( Image img ) {
		panel_2.removeAll();
		if ( img != null ) {
			panel_2.add( new JLabel( new ImageIcon( img ) ) );
		}
		panel_2.repaint();
	}

	public void nouvelArtiste( int nb ) {
		chckbxMembre.setSelected( false );
		txtNumero.setText( String.valueOf( nb ) );
		txtNom.setText( "" );
		if ( tabAlbums != null ) {
			if ( !tabAlbums.isEmpty() ) {
				tabAlbums.clear();
			} 
		}
		panel_1.removeAll();
		panel_2.removeAll();
	}

	public DefaultTableModel getTabModel() {
		return tabArtiste;
	}

	public void setTableModel( DefaultTableModel tab ) {
		tabArtiste = tab;
	}
	
	public void setImageArtiste( BufferedImage image ) {
		imgArtiste = image;
		
	}
	
	public BufferedImage getImageArtiste() {
		return imgArtiste;
	}
	
	public JTextField getTxtArtiste() {
		return txtArtiste;
	}
	
	public JTextField getTxtNom() {
		return txtNom;
	}
	
	public JCheckBox getMembre() {
		return chckbxMembre;
	}
	
	public JTextField getTxtNumero() {
		return txtNumero;
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

	public JTable getTableArtistes() {
		return tableArtistes;
	}

	public JList<Album> getListAlbum() {
		return listArtiste;
	}
	
	public JPanel getPanelArtiste() {
		return panel_1;
	}
	
	public JPanel getPanelAlbum() {
		return panel_2;
	}

	public JButton getBtnAide() {
		return btnAide;
	}
}
