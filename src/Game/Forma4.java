package Game;

public class Forma4 extends Tetrimino {

	//"Cuadrado".
	
	public Forma4(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 1);
		setCubo(bloques[1], 0, 2);
		setCubo(bloques[2], 1, 1);
		setCubo(bloques[3], 1, 2);
	}

	
	
}
