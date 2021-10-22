package TetrisGUI;

import java.awt.EventQueue;


import Game.Juego;
import Game.Reloj;

public class mainTetris {

	public static void main(String[] args) {
		
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					GUI1 frame = new GUI1();
					frame.setVisible(true);
					frame.setFocusable(true);
				    Juego tetris = new Juego(frame);
				    Reloj r = new Reloj(tetris);
				    Thread d= new Thread(r);
					d.start();	
					
				} });
			
	}
}
	


