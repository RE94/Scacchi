package scacchi;
import javax.swing.ImageIcon;


public class Pezzo {
	//immagine
	//int i = 0;
	private String nome;
	private ImageIcon immagine;
	private boolean colore; //false=Nero true=Bianco
	
	public Pezzo(String nome, ImageIcon immagine, boolean colore){
		this.nome = nome;
		this.immagine = immagine;
		this.colore = colore;
	}
	public ImageIcon getImmagine(){
		return immagine;		
	}
	
	public String getNome(){
		return nome;
	}
	public boolean getColore(){
		return colore;
	}
}
