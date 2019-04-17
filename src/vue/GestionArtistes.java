package vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Toolkit;
import javax.swing.JCheckBox;
import javax.swing.JList;

public class GestionArtistes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable tableArtistes;
	private JTextField txtNumero;
	private JTextField txtNom;

	/**
	 * Launch the application. TODO à deleter.
	 */
	public static void main( String[] args ) {
		EventQueue.invokeLater( new Runnable() {
			public void run() {
				try {
					GestionArtistes frame = new GestionArtistes();
					frame.setVisible( true );
				} catch ( Exception e ) {
					e.printStackTrace();
				}
			}
		} );
	}

	/**
	 * Create the frame.
	 */
	public GestionArtistes() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(GestionArtistes.class.getResource("/vue/icon.png")));
		setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 614, 427 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );
		setContentPane( contentPane );
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{89, 50, 0, 75, 79, 71, 50, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRechercherUnArtiste = new GridBagConstraints();
		gbc_lblRechercherUnArtiste.anchor = GridBagConstraints.WEST;
		gbc_lblRechercherUnArtiste.gridwidth = 3;
		gbc_lblRechercherUnArtiste.insets = new Insets(25, 25, 5, 5);
		gbc_lblRechercherUnArtiste.gridx = 0;
		gbc_lblRechercherUnArtiste.gridy = 0;
		panel.add(lblRechercherUnArtiste, gbc_lblRechercherUnArtiste);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 5;
		gbc_textField.insets = new Insets(0, 25, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecherche.gridx = 5;
		gbc_btnRecherche.gridy = 1;
		panel.add(btnRecherche, gbc_btnRecherche);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 10);
		gbc_btnQuitter.gridx = 7;
		gbc_btnQuitter.gridy = 1;
		panel.add(btnQuitter, gbc_btnQuitter);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblArtistes = new GridBagConstraints();
		gbc_lblArtistes.gridwidth = 3;
		gbc_lblArtistes.anchor = GridBagConstraints.WEST;
		gbc_lblArtistes.insets = new Insets(0, 25, 10, 5);
		gbc_lblArtistes.gridx = 0;
		gbc_lblArtistes.gridy = 2;
		panel.add(lblArtistes, gbc_lblArtistes);
		
		tableArtistes = new JTable();
		tableArtistes.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_tableArtistes = new GridBagConstraints();
		gbc_tableArtistes.gridheight = 4;
		gbc_tableArtistes.gridwidth = 5;
		gbc_tableArtistes.insets = new Insets(0, 0, 5, 25);
		gbc_tableArtistes.fill = GridBagConstraints.BOTH;
		gbc_tableArtistes.gridx = 2;
		gbc_tableArtistes.gridy = 3;
		panel.add(tableArtistes, gbc_tableArtistes);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNouveau = new GridBagConstraints();
		gbc_btnNouveau.fill = GridBagConstraints.BOTH;
		gbc_btnNouveau.insets = new Insets(0, 0, 5, 10);
		gbc_btnNouveau.gridx = 7;
		gbc_btnNouveau.gridy = 3;
		panel.add(btnNouveau, gbc_btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 10);
		gbc_btnAjouter.gridx = 7;
		gbc_btnAjouter.gridy = 4;
		panel.add(btnAjouter, gbc_btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 10);
		gbc_btnModifier.gridx = 7;
		gbc_btnModifier.gridy = 5;
		panel.add(btnModifier, gbc_btnModifier);
		
		JButton btnRemplacer = new JButton("Remplacer");
		btnRemplacer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnRemplacer = new GridBagConstraints();
		gbc_btnRemplacer.anchor = GridBagConstraints.WEST;
		gbc_btnRemplacer.gridwidth = 2;
		gbc_btnRemplacer.insets = new Insets(0, 25, 5, 5);
		gbc_btnRemplacer.gridx = 0;
		gbc_btnRemplacer.gridy = 6;
		panel.add(btnRemplacer, gbc_btnRemplacer);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 10);
		gbc_btnSupprimer.gridx = 7;
		gbc_btnSupprimer.gridy = 6;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblInformations = new GridBagConstraints();
		gbc_lblInformations.gridwidth = 3;
		gbc_lblInformations.anchor = GridBagConstraints.WEST;
		gbc_lblInformations.insets = new Insets(0, 25, 10, 5);
		gbc_lblInformations.gridx = 0;
		gbc_lblInformations.gridy = 7;
		panel.add(lblInformations, gbc_lblInformations);
		
		JLabel lblNumero = new JLabel("Num\u00E9ro");
		lblNumero.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNumero = new GridBagConstraints();
		gbc_lblNumero.anchor = GridBagConstraints.WEST;
		gbc_lblNumero.insets = new Insets(0, 25, 5, 5);
		gbc_lblNumero.gridx = 0;
		gbc_lblNumero.gridy = 8;
		panel.add(lblNumero, gbc_lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_txtNumero = new GridBagConstraints();
		gbc_txtNumero.gridwidth = 3;
		gbc_txtNumero.insets = new Insets(0, 0, 5, 10);
		gbc_txtNumero.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNumero.gridx = 1;
		gbc_txtNumero.gridy = 8;
		panel.add(txtNumero, gbc_txtNumero);
		txtNumero.setColumns(10);
		
		JList listAlbums = new JList();
		listAlbums.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_listAlbums = new GridBagConstraints();
		gbc_listAlbums.gridwidth = 2;
		gbc_listAlbums.gridheight = 3;
		gbc_listAlbums.insets = new Insets(0, 0, 25, 5);
		gbc_listAlbums.fill = GridBagConstraints.BOTH;
		gbc_listAlbums.gridx = 4;
		gbc_listAlbums.gridy = 8;
		panel.add(listAlbums, gbc_listAlbums);
		
		JLabel lblNom = new JLabel("Nom");
		lblNom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNom = new GridBagConstraints();
		gbc_lblNom.anchor = GridBagConstraints.WEST;
		gbc_lblNom.insets = new Insets(0, 25, 5, 5);
		gbc_lblNom.gridx = 0;
		gbc_lblNom.gridy = 9;
		panel.add(lblNom, gbc_lblNom);
		
		txtNom = new JTextField();
		txtNom.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_txtNom = new GridBagConstraints();
		gbc_txtNom.gridwidth = 3;
		gbc_txtNom.insets = new Insets(0, 0, 5, 10);
		gbc_txtNom.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNom.gridx = 1;
		gbc_txtNom.gridy = 9;
		panel.add(txtNom, gbc_txtNom);
		txtNom.setColumns(10);
		
		JLabel lblMembre = new JLabel("Membre");
		lblMembre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblMembre = new GridBagConstraints();
		gbc_lblMembre.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMembre.insets = new Insets(0, 25, 25, 5);
		gbc_lblMembre.gridx = 0;
		gbc_lblMembre.gridy = 10;
		panel.add(lblMembre, gbc_lblMembre);
		
		JCheckBox chckbxMembre = new JCheckBox("");
		chckbxMembre.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_chckbxMembre = new GridBagConstraints();
		gbc_chckbxMembre.anchor = GridBagConstraints.NORTHWEST;
		gbc_chckbxMembre.insets = new Insets(0, 0, 25, 10);
		gbc_chckbxMembre.gridx = 1;
		gbc_chckbxMembre.gridy = 10;
		panel.add(chckbxMembre, gbc_chckbxMembre);
	}

}
