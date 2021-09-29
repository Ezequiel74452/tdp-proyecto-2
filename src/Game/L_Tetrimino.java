package Game;

public class L_Tetrimino extends Tetrimino {

	//"L" invertida,
	
	public L_Tetrimino(int rndm) {
		super(rndm);
		acomodarCubos();
	}
	
	protected void acomodarCubos() {
		setCubo(bloques[0], 0, 1);
		setCubo(bloques[1], 0, 2);
		setCubo(bloques[2], 0, 3);
		setCubo(bloques[3], 1, 3);
		ejeDeRotacion = 1;
	}
}