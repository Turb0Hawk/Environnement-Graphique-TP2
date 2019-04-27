package modele;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class Album {
	
	int numero, annee, numArtiste;
	String titre,  genre;
	byte[] couverture;
	Image img;
	BufferedImage bImage;
	
	public Album(int numero, String titre, String genre, int annee, byte[] couverture, int numArtiste) {
		this.numero = numero;
		this.titre = titre;
		this.genre = genre;
		this.annee = annee;
		this.couverture = couverture;
		this.numArtiste = numArtiste;
		this.img =  new ImageIcon(couverture).getImage();
	}
	
	@Override
	public String toString() {
		return annee + " - " + titre;
	}
	public byte[] toBytes()
	{
		//taken directly from : https://bugs.java.com/bugdatabase/view_bug.do?bug_id=4848028
		byte[] imageByte;
	  try
	  {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(bImage, "png", baos);
		imageByte = baos.toByteArray();
	  } catch (IOException ioe)
	  {
	    imageByte = null;
	  }
	  return imageByte;
	}


	public int getNumero() {
		return numero;
	}


	public void setNumero( int numero ) {
		this.numero = numero;
	}


	public int getAnnee() {
		return annee;
	}


	public void setAnnee( int annee ) {
		this.annee = annee;
	}


	public int getNumArtiste() {
		return numArtiste;
	}


	public void setNumArtiste( int numArtiste ) {
		this.numArtiste = numArtiste;
	}


	public String getTitre() {
		return titre;
	}


	public void setTitre( String titre ) {
		this.titre = titre;
	}


	public String getGenre() {
		return genre;
	}


	public void setGenre( String genre ) {
		this.genre = genre;
	}


	public byte[] getCouverture() {
		return couverture;
	}


	public void setCouverture( byte[] couverture ) {
		this.couverture = couverture;
	}


	public BufferedImage getBimage() {
		return bImage;
	}


	public Image getImg() {
		return img;
	}


	public void setImg( Image img ) {
		this.img = img;
	}


	public BufferedImage getbImage() {
		return bImage;
	}


	public void setImg( BufferedImage img ) {
		this.img = img;
		this.bImage = img;
	}

}
