package Game;


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
				e.printStackTrace();
			}
			tiempo += ((double)aceleracion/1000);
			if(aceleracion>300)
				aceleracion= aceleracion+ (-1)* Math.log(tiempo);
			this.Tet.operarJuego(3);
			Tet.actualizarTiempo((int)tiempo);
		}
	}
	
}
