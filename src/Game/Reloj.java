package Game;

import java.util.Timer;
import java.util.TimerTask;
import Game.*;




public class Reloj implements Runnable {

	private double aceleracion;
	private double tiempo;
	private Juego Tet;
	
	public Reloj(Juego Tetris){
		
		aceleracion=1000;
		tiempo=0;
		Tet=Tetris;
		
		
	}
	
	public void run() {
		while(!Tet.getGameOver())
		{
			try {
				Thread.sleep((long)aceleracion);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tiempo += ((double)aceleracion/1000);
			System.out.println(tiempo);
			System.out.println(aceleracion);
			if(aceleracion>200)
				aceleracion= aceleracion+ (-1)* Math.log(tiempo);
			this.Tet.descender();
			
		}
	}
	
}
