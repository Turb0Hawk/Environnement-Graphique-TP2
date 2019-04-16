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

public class GestionArtistes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
		setFont(new Font("Times New Roman", Font.PLAIN, 14));
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setBounds( 100, 100, 714, 421 );
		contentPane = new JPanel();
		contentPane.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		contentPane.setLayout( new BorderLayout( 0, 0 ) );
		setContentPane( contentPane );
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblRechercherUnArtiste = new JLabel("Rechercher un artiste");
		lblRechercherUnArtiste.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblRechercherUnArtiste = new GridBagConstraints();
		gbc_lblRechercherUnArtiste.insets = new Insets(0, 0, 5, 5);
		gbc_lblRechercherUnArtiste.gridx = 0;
		gbc_lblRechercherUnArtiste.gridy = 0;
		panel.add(lblRechercherUnArtiste, gbc_lblRechercherUnArtiste);
		
		textField = new JTextField();
		textField.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.gridwidth = 2;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 1;
		panel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnRecherche = new GridBagConstraints();
		gbc_btnRecherche.insets = new Insets(0, 0, 5, 5);
		gbc_btnRecherche.gridx = 2;
		gbc_btnRecherche.gridy = 1;
		panel.add(btnRecherche, gbc_btnRecherche);
		
		JButton btnQuitter = new JButton("Quitter");
		btnQuitter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnQuitter = new GridBagConstraints();
		gbc_btnQuitter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuitter.insets = new Insets(0, 0, 5, 0);
		gbc_btnQuitter.gridx = 4;
		gbc_btnQuitter.gridy = 1;
		panel.add(btnQuitter, gbc_btnQuitter);
		
		JLabel lblArtistes = new JLabel("Artistes");
		lblArtistes.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblArtistes = new GridBagConstraints();
		gbc_lblArtistes.anchor = GridBagConstraints.WEST;
		gbc_lblArtistes.insets = new Insets(0, 0, 5, 5);
		gbc_lblArtistes.gridx = 0;
		gbc_lblArtistes.gridy = 2;
		panel.add(lblArtistes, gbc_lblArtistes);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.gridheight = 4;
		gbc_table.gridwidth = 3;
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 1;
		gbc_table.gridy = 3;
		panel.add(table, gbc_table);
		
		JButton btnNouveau = new JButton("Nouveau");
		btnNouveau.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnNouveau = new GridBagConstraints();
		gbc_btnNouveau.fill = GridBagConstraints.BOTH;
		gbc_btnNouveau.insets = new Insets(0, 0, 5, 0);
		gbc_btnNouveau.gridx = 4;
		gbc_btnNouveau.gridy = 3;
		panel.add(btnNouveau, gbc_btnNouveau);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnAjouter = new GridBagConstraints();
		gbc_btnAjouter.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAjouter.insets = new Insets(0, 0, 5, 0);
		gbc_btnAjouter.gridx = 4;
		gbc_btnAjouter.gridy = 4;
		panel.add(btnAjouter, gbc_btnAjouter);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnModifier = new GridBagConstraints();
		gbc_btnModifier.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModifier.insets = new Insets(0, 0, 5, 0);
		gbc_btnModifier.gridx = 4;
		gbc_btnModifier.gridy = 5;
		panel.add(btnModifier, gbc_btnModifier);
		
		JButton btnSupprimer = new JButton("Supprimer");
		btnSupprimer.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_btnSupprimer = new GridBagConstraints();
		gbc_btnSupprimer.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSupprimer.insets = new Insets(0, 0, 5, 0);
		gbc_btnSupprimer.gridx = 4;
		gbc_btnSupprimer.gridy = 6;
		panel.add(btnSupprimer, gbc_btnSupprimer);
		
		JLabel lblInformations = new JLabel("Informations");
		lblInformations.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblInformations = new GridBagConstraints();
		gbc_lblInformations.anchor = GridBagConstraints.WEST;
		gbc_lblInformations.insets = new Insets(0, 0, 5, 5);
		gbc_lblInformations.gridx = 0;
		gbc_lblInformations.gridy = 7;
		panel.add(lblInformations, gbc_lblInformations);
	}

}
