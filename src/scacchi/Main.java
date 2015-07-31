package scacchi;
import java.awt.*;
import javax.swing.*;
/**
 * @version 1.1 2015-07
 * @author Ricki
 *
 */
public class Main {
	
	public static void main(String[] args){
		
		EventQueue.invokeLater(new Runnable(){
			public void run(){
				ChessFrame frame = new ChessFrame();	
				frame.setSize(480,480);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
	
	
	
	

}
