package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modele.*;

public class controleur {
	
	ConnexionApp modele = new ConnexionApp();
	public controleur() {
		
	}
	
	public void initialiserArtistes(DefaultTableModel tabArtistes) {
		ResultSet artistes = modele.getArtistes();
		tabArtistes = new DefaultTableModel();
		tabArtistes.addColumn( "Numéro" );
		tabArtistes.addColumn( "Nom de l'artiste" );
		tabArtistes.addColumn( "Membre" );
		try {
			while(artistes.next()) {
				Object[] row = new Object[3];
				row[0] = artistes.getString( "Numero" );
				row[1] = artistes.getString( "Nom_Artiste" );
				row[2] = artistes.getBoolean( "Membre" );
				tabArtistes.addRow( row );;
			}
		} catch ( SQLException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
