package scacchi;
import static org.junit.Assert.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestScacchi {
	private Casella[][] squares = new Casella[8][8];
	private MoveController controller;
	
	@Before
	public void inizializzazione(){
		controller = new MoveController(squares);
				    		
		for(int i=0; i < 8; i++)
			for(int j=0; j < 8; j++)
				squares[i][j] = new Casella(i, j, null);
	
	}
	@Test
	public void muoviPedoneNeroTest(){
		controller.turno = false;
		squares[3][3].setPezzo(new Pezzo("Pedone", new ImageIcon("img/NPedone.gif"), false));
		controller.onClick(squares[3][3]);
		controller.onClick(squares[4][3]);
		Assert.assertEquals("Pedone", squares[4][3].getPezzo().getNome());
		Assert.assertEquals(null, squares[3][3].getPezzo());
		
		}	
	@Test
		public void nonMuoviPedoneBiancoTest(){
			controller.turno = true;
			squares[6][3].setPezzo(new Pezzo("Pedone", new ImageIcon("img/BPedone.gif"), true));
			controller.onClick(squares[6][3]);
			controller.onClick(squares[3][0]);
			Assert.assertEquals(null, squares[3][0].getPezzo());
			
			}
	
	@Test
	public void muoviTorreBiancaTest(){
		controller.turno = true;
		squares[0][1].setPezzo(new Pezzo("Torre", new ImageIcon("img/BTorre.gif"), true));
		controller.onClick(squares[0][1]);
		controller.onClick(squares[0][5]);
		Assert.assertEquals("Torre", squares[0][5].getPezzo().getNome());
		
		}	
	
	
	@Test
	public void nonMuoviTorreNeraTest(){
		controller.turno = false;
		squares[7][6].setPezzo(new Pezzo("Torre", new ImageIcon("img/NTorre.gif"), false));

		squares[4][6].setPezzo(new Pezzo("Cavallo", new ImageIcon("img/BCavallo.gif"), true));
		controller.onClick(squares[7][6]);
		controller.onClick(squares[1][6]);
		Assert.assertEquals(null, squares[1][6].getPezzo());
		
		}
	
	@Test
	public void muoviReginaBiancaDiagonaleTest(){
		controller.turno = true;
		squares[7][1].setPezzo(new Pezzo("Regina", new ImageIcon("img/BRegina.gif"), true));
		controller.onClick(squares[7][1]);
		controller.onClick(squares[5][3]);
		Assert.assertEquals("Regina", squares[5][3].getPezzo().getNome());
		
		}	
	@Test
	public void muoviReginaBiancaVerticaleTest(){
		controller.turno = true;
		squares[7][1].setPezzo(new Pezzo("Regina", new ImageIcon("img/BRegina.gif"), true));
		controller.onClick(squares[7][1]);
		controller.onClick(squares[1][1]);
		Assert.assertEquals("Regina", squares[1][1].getPezzo().getNome());
		
		
		}	
	@Test
	public void muoviAlfiereNeroTest(){
		controller.turno = false;
		squares[7][1].setPezzo(new Pezzo("Alfiere", new ImageIcon("img/NAlfiere.gif"),false));
		controller.onClick(squares[7][1]);
		controller.onClick(squares[5][3]);
		Assert.assertEquals("Alfiere", squares[5][3].getPezzo().getNome());
		
		}	
	@Test
	public void muoviCavalloBiancoTest(){
		controller.turno = true;
		squares[0][0].setPezzo(new Pezzo("Cavallo", new ImageIcon("img/BCavallo.gif"), true));
		controller.onClick(squares[0][0]);
		controller.onClick(squares[1][2]);
		Assert.assertEquals("Cavallo", squares[1][2].getPezzo().getNome());
		
		}		
	@Test
	public void nonMuoviCavalloBiancoTest(){
			controller.turno = true;
			squares[0][0].setPezzo(new Pezzo("Cavallo", new ImageIcon("img/BCavallo.gif"), true));
			controller.onClick(squares[0][0]);
			controller.onClick(squares[1][4]);
			Assert.assertEquals(null, squares[1][4].getPezzo());
			
			}	

	@Test
	public void cambioTurnoTest(){
		controller.turno = false;
		squares[3][3].setPezzo(new Pezzo("Pedone", new ImageIcon("img/NPedone.gif"), false));
		controller.onClick(squares[3][3]);
		controller.onClick(squares[4][3]);
		Assert.assertEquals(true, controller.turno);
		
		
		}	
	@Test
	public void nonMuoviAlfiereNeroTest(){
		controller.turno = false;
		squares[7][6].setPezzo(new Pezzo("Alfiere", new ImageIcon("img/NAlfiere.gif"), false));

		squares[6][5].setPezzo(new Pezzo("Cavallo", new ImageIcon("img/BCavallo.gif"), true));
		controller.onClick(squares[7][6]);
		controller.onClick(squares[5][4]);
		Assert.assertEquals(null, squares[5][4].getPezzo());
	}
}
