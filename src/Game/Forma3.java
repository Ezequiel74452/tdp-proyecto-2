package Game;

public class Forma3 extends Tetrimino {

	//"L" invertida,
	
	public Forma3(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 1);
		setCubo(bloques[1], 0, 2);
		setCubo(bloques[2], 0, 3);
		setCubo(bloques[3], 1, 3);
	}
}