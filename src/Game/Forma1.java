package Game;

public class Forma1 extends Tetrimino {
	
	// "Pirámide".
	
	public Forma1(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 2);
		setCubo(bloques[1], 1, 1);
		setCubo(bloques[2], 1, 2);
		setCubo(bloques[3], 1, 3);
	}

	
	
}
