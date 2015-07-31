package scacchi;
import java.awt.Color;

import javax.swing.JButton;


public class Casella extends JButton {
	 private Pezzo pezzo;
	 private boolean color;
	 private int x;
	 private int y;
	 
	 public Casella(int x, int y, Pezzo pezzo){
		 this.pezzo = pezzo;
		 this.x = x;
		 this.y = y;
		 setColor(x+y);
	 }
	 
	 public void setColor(int c){
		 if (c%2 == 0) {
			 color=true;
			 this.setBackground(Color.WHITE);
		 }	
		 else{
			 color=false;
			 this.setBackground(Color.GRAY);
		 }
	 }
	 
	 public void setPezzo(Pezzo pezzo){
		 this.pezzo = pezzo;
		 this.setIcon(pezzo.getImmagine());
	 }
	 
	 public Pezzo getPezzo(){
		 return pezzo;
	 }
	 public int getRow(){
		 return x;
	 }
	 public int getColumn(){
		 return y;
	 }
	 public void eliminaPezzo(){
		 this.setIcon(null);
		 this.pezzo = null;
		 
	 }
}

