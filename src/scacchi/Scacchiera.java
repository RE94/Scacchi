package scacchi;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.image.BufferedImage;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class Scacchiera {

    private Casella[][] squares = new Casella[8][8];
    private JPanel chessBoard;
    private final JPanel gui = new JPanel(new BorderLayout());
    private MoveController controller = new MoveController(squares);
	public Scacchiera() {
		
		chessBoard = new JPanel(new GridLayout(8, 8));
	    chessBoard.setBorder(new LineBorder(Color.BLACK));
	    gui.add(chessBoard);
	    
	    //Insets buttonMargin = new Insets(0,0,0,0);
	    inizializza();
	    for(int i = 0; i < 8; i++){
	    	for(int j = 0; j < 8; j++){
	    		chessBoard.add(squares[i][j]);
	    		
	    		
	    	}
	    	
	    }

	}
	private void setActionListener(int i, int j){
		squares[i][j].addActionListener(event -> {
			controller.onClick(squares[i][j]);
		});
	}
	
	public void inizializza(){
		for(int i=0; i < 8; i++){
			for(int j=0; j < 8; j++){
				squares[i][j] = new Casella(i, j, null);
				if(i==1 )
					squares[i][j].setPezzo(new Pezzo("Pedone", new ImageIcon("img/NPedone.gif"), false));
				
				if(i==6 )
					squares[i][j].setPezzo(new Pezzo("Pedone", new ImageIcon("img/BPedone.gif"), true));
				
				if(i==0 && (j==0 || j == 7))
					squares[i][j].setPezzo(new Pezzo("Torre", new ImageIcon("img/NTorre.gif"), false));
				if(i==7 && (j==0 || j == 7))
					squares[i][j].setPezzo(new Pezzo("Torre", new ImageIcon("img/BTorre.gif"), true));
				if(i==0 && (j==1 || j == 6))
					squares[i][j].setPezzo(new Pezzo("Cavallo", new ImageIcon("img/NCavallo.gif"), false));
				if(i==7 && (j==1 || j == 6))
					squares[i][j].setPezzo(new Pezzo("Cavallo", new ImageIcon("img/BCavallo.gif"), true));	
				if(i==0 && (j==2 || j == 5))
					squares[i][j].setPezzo(new Pezzo("Alfiere", new ImageIcon("img/NAlfiere.gif"), false));
				if(i==7 && (j==2 || j == 5))
					squares[i][j].setPezzo(new Pezzo("Alfiere", new ImageIcon("img/BAlfiere.gif"), true));
				if(i==0 && (j==3))
					squares[i][j].setPezzo(new Pezzo("Regina", new ImageIcon("img/NRegina.gif"), false));
				if(i==7 && (j==3))
					squares[i][j].setPezzo(new Pezzo("Regina", new ImageIcon("img/BRegina.gif"), true));
				if(i==0 && (j==4))
					squares[i][j].setPezzo(new Pezzo("Re", new ImageIcon("img/NRe.gif"), false));
				if(i==7 && (j==4))
					squares[i][j].setPezzo(new Pezzo("Re", new ImageIcon("img/BRe.gif"), true));
				setActionListener(i,j);
			}
		}
	}
	
    public final JComponent getScacchiera() {
        return chessBoard;
    }

    public final JComponent getPanello() {
        return gui;
    }

}


