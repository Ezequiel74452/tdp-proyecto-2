package TetrisGUI;

import java.awt.EventQueue;


import Game.Juego;
import Game.Reloj;

public class mainTetris {

	public static void main(String[] args) {
		Juego tetris = new Juego();
		Reloj r = new Reloj(tetris);
			
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					GUI1 frame = new GUI1(tetris,r);
					frame.setVisible(true);
					frame.setFocusable(true);
				    
				} });
	}
}
	


