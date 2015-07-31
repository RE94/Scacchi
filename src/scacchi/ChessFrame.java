package scacchi;
import javax.swing.*;


public class ChessFrame extends JFrame {

	public ChessFrame(){
		setTitle("Scacchi");
		Scacchiera scacchiera = new Scacchiera();
		this.add(scacchiera.getPanello());
		pack();
	}

}
